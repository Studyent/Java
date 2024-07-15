	package projet;
	import java.io.Serializable;
import java.text.ParseException;
	import java.util.ArrayList;
import java.util.List;

import balade.Vehicules;
	import lasauvegarde.*;
	
	
	/*
	 * 
	 * Ici Pour la classe Clients étendant la classe ArrayList j'ai fait le choix,
	 * de créer une "Super" classe Client me permettant ainsi plus tard de faire le choix entre
	 * un client professionnel ou particulier.
	 * 
	 * */
	
	public class Clients extends ArrayList<SuperClient> implements Serializable {
	
		private static final String Throw = null;
		private static Clients instance;
		protected int nblocations;
		
		
		private Clients() {
	
	
		}
	
		public static Clients getInstance() {
			if(instance == null) {
				instance = new Clients();
			}
			return instance;
		}
	
		public static void setInstance(Clients ins) {
			if(instance != null) {
				throw new IllegalStateException("L'instance de CLients a déjà était faite");
			}else {
			instance = ins;
			}
			
		}
		public void affiche() {
	
			for(SuperClient client: this) {
				System.out.println(client.toString());
			}
	
		}
	
		public void ajoutClient(String nom,String prenom,int age,String adresse,TypeClient type,GestionDates dates,int nblocations,Double taux) throws GestionAutomobileException {
			//----- Partie D, Vérification nom du client
			//Ici je fais une vérification en itérant dans mon Array de SuperClient si j'ai déjà ce client avec son type
			// this ici est ma List dans lequel chaque élément client est de type SuperClient
			
			for(SuperClient client: this) {
				
				if(client.getNom().equals(nom) && client.getType().equals(type)){
					
					throw new GestionAutomobileClientsException("\n\t Client:"+ type + "\n\t Nom: " + nom + "\n\t Prénom" + prenom + "\n\tExiste déjà dans la classe !");
					
				}
			
				//------------
				
			}
			
			if(age < 0 || age > Integer.MAX_VALUE) {
				if(nblocations > Integer.MAX_VALUE) {
					throw new IllegalArgumentException("Int dépassé !"); // prémunit contre l'overflow
				}
				throw new GestionAutomobileClientsParticuliersException("Age impossible !"); // Rajouté à la partie D
			}
			
			
			if(nblocations < 0 || nblocations > Integer.MAX_VALUE) {
				if(nblocations > Integer.MAX_VALUE) {
					throw new IllegalArgumentException("Int dépassé !"); // prémunit contre l'overflow
				}
				throw new NbLocationsVideException();
			}
	
			if (taux < 0) {
				if(taux > Double.MAX_VALUE) {
					throw new IllegalArgumentException("Double dépassé !"); // prémunit contre l'overflow
				}
				throw new IllegalArgumentException("Le taux doit être un nombre positif.");
			}
	
			if(adresse.isEmpty()) {
				throw new IllegalArgumentException("Une addresse ne peut-etre vide !");
			}
	
	
			if(type == TypeClient.Particulier) {
				ClientParticulier clientpart = new ClientParticulier(nom,prenom,age,adresse,type,dates,nblocations);
	
				this.add(clientpart);
			}else if(type == TypeClient.Professionnel){
	
				ClientProfessionnel clientpro = new ClientProfessionnel(nom,type,dates,taux);
				this.add(clientpro);
			}else{
				throw new IllegalArgumentException("Type de client non reconnu !");
			}
	
	
		}
		
		
		public int getNombreLocations() {
			return nblocations;
		}
	
		public void setNombreLocations(int nombreLocations) {
			this.nblocations = nombreLocations;
		}
	
		public List<SuperClient> getAllClients() {
	        List<SuperClient> allClients = new ArrayList<>(this);
	        return allClients;
	    }



		
		
		
	}
