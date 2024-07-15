	package location;
	
	import projet.*;

import java.io.Serializable;
import java.util.*;
	import java.util.Set;
	import java.util.Date;
	
	import balade.*;
	import lasauvegarde.GestionAutomobileVehiculesLocationException;
	
	
	/*
	 * 2) Écrivez ensuite une classe GestionLocation qui sera composée des méthodes demandeDeLocation 
	 * et getTarif qui prendront en paramètre une voiture et un client et de la méthode finDeLocation qui elle 
	 * aura comme argument, en plus des deux précédents, la date et le kilométrage de fin de location. 
	 * Ajoutez aux véhicules les attributs kilometrageFin et dateFin nécessaire à l’estimation du tarif de location. 
	 * demandeDeLocation permettra d’ajouter le véhicule dans les collections adéquats de Gestion 
	 * (fin de location, disponible à la vente au vu du nouveau kilométrage ?, mise-à-jour de la date de début de location pour le client, etc.)
	 *  et d’incrémenter le nombre de locations déjà effectuées par le client particulier 
	 *  (retourne true si tout c’est bien passé). 
	 *  Cette méthode vérifera si le véhicule est contenu dans la liste des véhicules disponibles (HashSet) 
	 *  de la classe Gestion à l’aide de la méthode contains. Modifez votre code pour permettre cela. 
	 *  finDeLocation mettra à jour les collections 
	 * de la classe Gestion et retournera la facture à l’aide de la méthode getTarif explicitée ci-après.
	 * */
	
	public class GestionLocation implements Serializable{
	
		private Gestion gestion;
	
		private int kilometragefin;
		public GestionLocation() {
			gestion = Gestion.getInstance();
		}
	
		/*
		 * Demande de location:
		 *1er if) vérifie que le véhicule est disponible
		 *2eme if)  vérification du kilométrage avant 
		 * 3ème if)Vérifie si le client a déjà loué un véhicule 
		 * 
		 * Maintenant itère dans la MAP à la recherche du véhicule pour le client b
		 * une fois trouvé, cherche pour ce client le nombre de locations
		 * 
		 * sinon
		 * le client n'a rien loué
		 * on ajoute le véhicule associé au client
		 * et on lui attribue +1 location
		 * Sinon
		 * Le kilometrage est en dehors de notre seuil
		 * Sinon
		 * 
		 * */
		public boolean demandeDeLocation(Vehicules vehicule, SuperClient client) throws GestionAutomobileVehiculesLocationException {
		    // Vérifie si le véhicule est déjà en location pour un autre client
		    if (gestion.getLocations().containsValue(vehicule)) {
		    	System.out.println("Location déjà occupé !");
		        return false; // Le véhicule est déjà en location
		    }
		    
		    // Vérifie si le véhicule est disponible à la location
		    if (!gestion.getLocationdevehicules().contains(vehicule)) {
		        throw new GestionAutomobileVehiculesLocationException("Véhicule ne figurant pas dans la liste des locations !");
		    }
		    
		    // Le véhicule est disponible à la location
		    // Incrémentation du nombre de locations
		    int nbLocations = client.getNombreLocations();
		    nbLocations++;
		    client.setNombreLocations(nbLocations);

		    // Ajouter le véhicule dans les collections adéquates de Gestion
		    gestion.addclientvehi(client, vehicule);
		    gestion.delVehicule(vehicule);

		    return true;
		}











	
	
	
	
		/*
		 * 
		 * 3) La méthode getTarif dans la classe GestionLocation, retournera le prix de la location dans le cas d’un client particulier ou un professionnel 
		 * et dans la classe GestionVente le prix de vente. 
		 * Dans le cas de la location, elle fera appel à la méthode prixLocation de la classe Gestion (à implémenter) 
		 * qui permettra de retourner le prix de la location et sera égale à :
		 *  reduction x (prixParKilometrePourCeTypeDeVehicule x kilometrageEffectue + prixParuourPourCeTypeDeVehicule x nombreDeuour x (1 + nombreDePortes/10) ).
		 *   La réduction ne peut être négative.
	Pour un client particulier, la réduction sera égale à : 1.0 – 0.005 x nbLocations, et pour un client professionnel, la réduction sera égale au taux. 
	Pour la réalisation de ce calcul du prix de la location,
	 faites en sorte de ne pas avoir à tester le type de l’instance du client. 
	 De plus, la méthode prixLocation ne prend pas en paramètre de client.
		 * 
		 * 
		 * 
		 * */
	
	
		/*
		 * Nous itérons ici dans notre Set b dont les élements sont de type SuperClient
		 * Nous castons en fonction du type du client la réduction appropriée.
		 * */
	
		public double getTarif(Vehicules a,Clients b) {
			double reduc = 0;
			for(SuperClient client: b) {
				if(client.getType() == TypeClient.Particulier) {
					int nbLocations = ((ClientParticulier) client).getNombreLocations();
					reduc = (1.0 - 0.005)*nbLocations;
				}else if(client.getType() == TypeClient.Professionnel){
					reduc = ((ClientProfessionnel) client).getTaux();
				}else {
					throw new IllegalArgumentException("Type de client inconnu !");
				}
	
			}
	
			return reduc;
	
		}
	
	
	
		public double finDeLocation(Vehicules a,Clients b,GestionDates dates,int kilometragefin) {
			double tarifacture;
	
			gestion.remclientvehi(b);
			a.setFinLoc(kilometragefin, dates);
	
			tarifacture = getTarif(a,b);
			return tarifacture;
		}
	
	
	
	
	}
