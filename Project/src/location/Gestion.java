package location;
import projet.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.*;
import java.util.Map.Entry;

import balade.*;
import lasauvegarde.GestionAutomobileException;


/*
 * 1) Avant de procéder à l’implémentation des classes de gestion de la location/vente des véhicules,
 *  vous allez ajouter une classe de structuration des informations Gestion qu’il n’est pas possible d’instancier, 
 *  ayant pour rôle de sauvegarder toutes les données permettant de gérer les locations/ventes : 
 *  les véhicules disponibles à la location (HashSet) et disponibles à la vente (LinkedList) ainsi que les véhicules en cours de location
 *   (HashMap) sous forme d’un tableau associant un client à une automobile. 
 *   La classe Gestion disposera également des attributs indiquant le kilométrage à partir duquel 
 *   un véhicule est disposé à la vente (double) 
 *   ainsi que le kilométrage maximum à pattir duquel un véhicule ne peut plus être proposé à la vente (double).
 * */

/*
 * Mes attributs sont déclarés avec les interfaces cela me permet de choisir plus tard
 * dans l'initialision si je souhaite changer l'implémentation de ces derniers sans avoir à changer
 * tout mon code
 */


public final class Gestion implements Serializable{
	private static Gestion instance = null;
	private Set<Vehicules> locationdevehicules = new HashSet<>();
	private static List<Vehicules> ventedevehicules = new LinkedList<>(); 
	private static Map<SuperClient,Vehicules> clientvehi = new HashMap<>();

	private final double minkilome = 0.0;
	private final double maxkilome = 10000;


	private Gestion() {


	}

	public static Gestion getInstance() {
		if(instance == null) {
			instance = new Gestion();
		}
		return instance;
	}


	public static void setInstance(Gestion ins) {
		if(instance != null) {
			throw new IllegalStateException("L'instance de véhicule a déjà était faite");
		}else {
			instance = ins;
		}

	}
	public Set<Vehicules> getLocationdevehicules(){
		return Collections.unmodifiableSet(locationdevehicules);


	}

	public void addVehicule(Vehicules e){
		locationdevehicules.add(e);

	}
	public void delVehicule(Vehicules e){
		locationdevehicules.remove(e);


	}


	public List<Vehicules> getVentes(){
		return ventedevehicules;
	}

	public static void afficherlesventes() {
		System.out.println("Véhicules disponibles à la vente : {\n\t");
		if(ventedevehicules.isEmpty()) {
			System.out.println("aucun vehicule disponible à la vente");
		}
		for (Vehicules vehicule : ventedevehicules) {
			vehicule.getAllVehicules();
		}
		System.out.println("\n\t}");

	}



	public void addVente(Vehicules e){
		ventedevehicules.add(e);
	}
	public void delVente(Vehicules e){
		ventedevehicules.remove(e);
	}


	public Map<SuperClient, Vehicules> getLocations(){
		return new HashMap<>(clientvehi);
	}

	public void addclientvehi(SuperClient client,Vehicules b) {
		clientvehi.put(client, b);
	}
	public void remclientvehi(Clients a) {
		clientvehi.remove(a);
	}


	public double getMin() {
		return minkilome;
	}

	public double getMax() {
		return maxkilome;
	}

	/*
	 *  qui permettra de retourner le prix de la location et sera égale à : reduction x 
			 (prixParKilometrePourCeTypeDeVehicule x kilometrageEffectue + prixParuourPourCeTypeDeVehicule x nombreDeuour x (1 + nombreDePortes/10) )
	 * 
	 * */

	public double prixLocation(Vehicules vehicule, double kilometrageFin) {
		double reduction = 1.0;
		SuperClient client = null;
		double kilometrageEffectue = kilometrageFin - vehicule.getKilometrage();
		double prixParKilometrePourCeTypeDeVehicule = vehicule.getType().getPrix();
		double nombreDeRoues = 4;
		int nombreDePortes = vehicule.getNbportes().getNbPortes();
		for (Entry<SuperClient, Vehicules> entry : clientvehi.entrySet()) {
			if (entry.getValue().equals(vehicule)) {
				client = entry.getKey();
			}
		}

		if(clientvehi.containsKey(client) && clientvehi.get(client).equals(vehicule)) {

			if(client instanceof ClientParticulier) {
				ClientParticulier clientparticulier = (ClientParticulier) client;
				reduction = 1.0 - 0.005 * clientparticulier.getNombreLocations();
			} else if(client instanceof ClientProfessionnel) {
				ClientProfessionnel professionnel = (ClientProfessionnel) client;
				reduction = professionnel.getTaux();
			}
		}



		double prixLocation = reduction*(prixParKilometrePourCeTypeDeVehicule*kilometrageEffectue+prixParKilometrePourCeTypeDeVehicule*nombreDeRoues*(1+nombreDePortes/10));

		return prixLocation;
	}





}
