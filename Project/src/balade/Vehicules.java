package balade;
import java.util.Vector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projet.*;
public class Vehicules extends Vector<Vehicules> implements Serializable {

	private static Vehicules instance;
	private double kilometrageFin;
	private GestionDates datefin;
	protected TypeVehicule type;
	protected NombredePortes nbportes;
	protected Immatriculation immatriculation;
	protected Constructeur constructeur;
	private String modele;
	private double kilometrage;
	private double prixachat;
	
    private List<Vehicules> vehicules = new ArrayList<>();


	public Vehicules(TypeVehicule type,NombredePortes nbportes,Immatriculation immatriculation,Constructeur constructeur,String modele,
			double kilome,double prix) {

		this.type = type;
		this.nbportes = nbportes;
		this.immatriculation = immatriculation;
		this.constructeur = constructeur;
		this.modele = modele;
		this.kilometrage = kilome;
		this.prixachat = prix;

	}

	private Vehicules() {
		super();
	}

	public GestionDates getDateFin() {
		return datefin;
	}

	public void setFinLoc(double kilom,GestionDates dates) {
		this.kilometrageFin = kilom;
		if(kilometrageFin < 0) {
			throw new IllegalArgumentException("Kilometrage de Fin ne peut etre inférieur à 0");
		}
		if(datefin == null) {
			throw new IllegalArgumentException("La date de fin de location ne peut etre nulle !");
		}
		this.datefin = dates;
		
	}

	public double getKilometrageFin() {
		return kilometrageFin;
	}




	public static Vehicules getInstance() {
		if(instance == null) {
			instance = new Vehicules();
		}
		return instance;
	}
	
	public static void setInstance(Vehicules ins) {
		if(instance != null) {
			throw new IllegalStateException("L'instance de véhicule a déjà était faite");
		}else {
		instance = ins;
		}
		
	}
	

	public void ajoutVehicules(TypeVehicule type, NombredePortes nbportes, Immatriculation immatriculation, Constructeur constructeur, String modele,
	        double kilome, double prix) {

	    Vehicules.verif(type, nbportes, immatriculation, constructeur, modele, kilome, prix);

	    Vehicules vehicule = new Vehicules(type, nbportes, immatriculation, constructeur, modele, kilome, prix);
	    vehicules.add(vehicule); // Ajouter le véhicule à la liste statique

	    switch (type) {

	        case BERLINE:
	            Berline berlin = new Berline(nbportes, immatriculation, constructeur, modele, kilome, prix);
	            this.add(berlin);
	            break;

	        case BREAK:
	            Break breaks = new Break(nbportes, immatriculation, constructeur, modele, kilome, prix);
	            this.add(breaks);
	            break;

	        case UTILITAIRE:
	            Utilitaire utilitaire = new Utilitaire(nbportes, immatriculation, constructeur, modele, kilome, prix);
	            this.add(utilitaire);
	            break;

	        default:
	            throw new IllegalArgumentException("Type non pris en charge !");

	    }
	}



	public void getAllVehicules() {
		for(Vehicules vehicule: this) {
			System.out.println(vehicule.toString());
		}
	}
	
	public List<Vehicules> getVehicules() {
		   List<Vehicules> vehiculesList = new ArrayList<>(this);
		return vehiculesList;
	}

	

	public static void verif(TypeVehicule type, NombredePortes nbportes, Immatriculation immatriculation,
			Constructeur constructeur, String modele, double kilometrage, double prix) {

		if(type == null ) {
			throw new IllegalArgumentException("Aucun type fournis");

		}else if( !(type == type.BERLINE || type == type.BREAK || type == type.UTILITAIRE) ) {
			throw new IllegalArgumentException("Type non pris en charge !");

		}

		if(nbportes.getNbPortes() < 0) {
			throw new IllegalArgumentException("Une voiture a besoin de portes !");
		}else if(nbportes.getNbPortes() > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Trop de portes!");
		}

		if(immatriculation == null) {
			throw new IllegalArgumentException("Immatriculation null!");
		}else if(immatriculation.getIdentification().isEmpty()) {
			throw new IllegalArgumentException("Une voiture ne peut légalement rouler sans immatriculation !");
		}

		if(constructeur == null ) {
			throw new IllegalArgumentException("Un construteur doit etre fournis");

		}else if( !(constructeur == constructeur.BMW || constructeur == constructeur.CITROEN || constructeur == constructeur.MERCEDES ||
				constructeur == constructeur.PEUGEOT || constructeur == constructeur.RENAULT || constructeur == constructeur.VOLKSWAGEN) ) {
			throw new IllegalArgumentException("Constructeur inconnu !");

		}

		if (kilometrage < 0) {
			if(kilometrage > Double.MAX_VALUE) {
				throw new IllegalArgumentException("Double dépassé !");
			}
			throw new IllegalArgumentException("Le kilometrage doit être un nombre positif.");
		}

		if (prix < 0) {
			if(prix > Double.MAX_VALUE) {
				throw new IllegalArgumentException("Double dépassé !");
			}
			throw new IllegalArgumentException("Le prix se doit etre positif.");
		}




	}





	public TypeVehicule getType() {
		return type;
	}

	public void setType(TypeVehicule type) {
		this.type = type;
	}

	public NombredePortes getNbportes() {
		return nbportes;
	}

	public void setNbportes(NombredePortes nbportes) {
		this.nbportes = nbportes;
	}

	public Immatriculation getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(Immatriculation immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public double getPrixAchat() {
		return prixachat;
	}

	public void setPrixAchat(double prixachat) {
		this.prixachat = prixachat;
	}






}
