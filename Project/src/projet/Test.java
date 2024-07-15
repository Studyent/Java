package projet;
import balade.*;
import location.*;
import lasauvegarde.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import balade.Berline;
public class Test {

	public static void main(String[] args) throws GestionAutomobileException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub


		/*
		 * test effectué avant la partie Epilogue 
		 * 
							GestionDates ladate = new GestionDates("10/06/2024");
							Clients clients = Clients.getInstance();

							clients.ajoutClient("Jean", "Marie", 20, "J'habite ici", TypeClient.Particulier, ladate, 1, 0.4);
							clients.ajoutClient("Jean", "Neymar", 52, "J'habite là", TypeClient.Professionnel, ladate, 1, 0.4);
							clients.ajoutClient("Ber", "Trand", 43, "J'habite par là", TypeClient.Professionnel, ladate, 1, 0.5);

							clients.affiche();

							Vehicules vehicules = Vehicules.getInstance();

							vehicules.ajoutVehicules(TypeVehicule.BERLINE, NombredePortes.DEUX, new Immatriculation("1234AB"), Constructeur.PEUGEOT, "208", 20000, 15000);
							vehicules.ajoutVehicules(TypeVehicule.BREAK, NombredePortes.QUATRE, new Immatriculation("5678CD"), Constructeur.RENAULT, "Clio", 30000, 12000);


							vehicules.getAllVehicules();


				testExceptions();


					Vehicules vehicules = Vehicules.getInstance();
					vehicules.getVehicules();
		 */	


		// Test effectué après la partie Epilogue

		Gestion gestion = Gestion.getInstance();
		Clients clients = Clients.getInstance();
		clients.ajoutClient("Jean", "Neymar", 20, "j'habite ici", TypeClient.Particulier, new GestionDates("21/06/2006"), 20, 0.2);
		clients.ajoutClient("Gas", "Ton", 20, "j'habite vers là-bas", TypeClient.Professionnel, new GestionDates("15/07/2006"), 10, 0.8);
		clients.ajoutClient("Thoma", "ToKetchup", 20, "j'habite vers là-bas", TypeClient.Professionnel, new GestionDates("21/07/2006"), 10, 0.8);


		Vehicules vehicules = Vehicules.getInstance();

		vehicules.ajoutVehicules(TypeVehicule.UTILITAIRE, NombredePortes.DEUX, new Immatriculation("1234AB"), Constructeur.PEUGEOT, "208", 20000, 15000);
		vehicules.ajoutVehicules(TypeVehicule.BREAK, NombredePortes.QUATRE, new Immatriculation("5678CD"), Constructeur.RENAULT, "Clio", 30000, 12000);
		vehicules.ajoutVehicules(TypeVehicule.BREAK, NombredePortes.QUATRE, new Immatriculation("5678CF"), Constructeur.RENAULT, "Kangoo", 30000, 12000);
		vehicules.ajoutVehicules(TypeVehicule.BERLINE, NombredePortes.DEUX, new Immatriculation("4584DA"), Constructeur.RENAULT, "Twingo", 30000, 12000);
		vehicules.ajoutVehicules(TypeVehicule.UTILITAIRE, NombredePortes.TROIS, new Immatriculation("2543DE"), Constructeur.MERCEDES, "Benz", 30000, 12000);
		//vehicules.getVehicules();        	
		testLocation(gestion,vehicules,clients);

		clients.affiche();
		//vehicules.getAllVehicules();
		Vehicules voitureavendre = new Berline(NombredePortes.QUATRE, new Immatriculation("EDT512"), Constructeur.VOLKSWAGEN, "DAS AUTO", 85000.0, 20000.0);

		gestion.addVente(voitureavendre);
		testVente(gestion, voitureavendre);
		testException(gestion);

		//test.getLocationdevehicules();

	}





	// Création des véhicules
	// Modification des collections



	public static void testLocation(Gestion gestion,Vehicules vehicules,Clients clients) throws GestionAutomobileException, ParseException {
		// Création des clients



		System.out.println("|-------------------------------------------------------|");
		for (Vehicules vehicule : vehicules.getVehicules()) {
			gestion.addVehicule(vehicule);
			System.out.println("Véhicule ajouté : " + vehicule);
		}
		// Maintenant, vous appelez getLocationdevehicules après l'ajout des véhicules

		System.out.println("|-------------------------------------------------------|");
		System.out.println("Véhicules disponibles à la location : ");
		for (Vehicules v : gestion.getLocationdevehicules()) {
			System.out.println(v);
		}
		System.out.println("|-------------------------------------------------------|");
		// Test de la demande de location pour chaque client et chaque véhicule
		GestionLocation gestionLocation = new GestionLocation();



		for (SuperClient client : clients.getAllClients()) {
			for (Vehicules vehicule : gestion.getLocationdevehicules()) {
				boolean locationDemandee = gestionLocation.demandeDeLocation(vehicule, client);
				if (locationDemandee) {
					System.out.println("Location octroyée pour le client " + client.getNom() + " : " + vehicule.getModele());
					System.out.println("|-------------------------------------------------------|");
					// Sérialisation des données
					Sauvegarde.sauvegardeDonnees("C:\\save");
				} else {
					System.out.println("La demande de location pour le client " + client.getNom() + " : " + vehicule.getModele() + " a échoué.");

				}
			}
		}






	}




	/*
	 * Pour cette méthode, je charge les données, Affiche les 
	 * 
	 * 
	 * */


	public static void testVente(Gestion gestion,Vehicules vehicule) throws GestionAutomobileVehiculesVenteException {

		GestionVente gestionVente = new GestionVente(0, gestion);
		try {
			Sauvegarde.chargementDonnees("C:\\");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!gestion.getVentes().isEmpty()) {
			Vehicules vehiculeVendu = gestion.getVentes().get(0);
			double prixVente = gestionVente.demandeDeVente(vehiculeVendu);

			System.out.println("Le prix de vente du véhicule est de " + prixVente);

			gestion.getVentes().remove(vehiculeVendu);
			// Sauvegarde.sauvegardeDonnees("C:\\save");
		} else {
			System.out.println("Aucun véhicule disponible pour la vente.");
		}
	}


	public static void testException(Gestion gestion) throws GestionAutomobileException, ParseException {

		ClientParticulier ClientPart = new ClientParticulier("Jean", "Francois", 15, "Le Havre", TypeClient.Particulier, new GestionDates("21/0581415"), 0);
		ClientParticulier ClientPart2 = new ClientParticulier("Jean", "Marie", -56, "Sydney", TypeClient.Particulier, new GestionDates("05/14/-3"), 0);
		ClientProfessionnel ClientPro = new ClientProfessionnel("Jacques",TypeClient.Particulier, new GestionDates("05/14/-3"), -5.0);

		try {
			Vehicules vehiculeTest = new Break(NombredePortes.QUATRE, new Immatriculation("WF57D6"), Constructeur.PEUGEOT, "G5", 854123, 85214);

			gestion.getLocationdevehicules().add(vehiculeTest);
			testVente(gestion, vehiculeTest);
		} catch (GestionAutomobileVehiculesVenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Vehicules vehiculeTest = new Utilitaire(NombredePortes.DEUX, new Immatriculation("ZED512"), Constructeur.BMW, "208", 10000.0, 152000);

			gestion.getVentes().add(vehiculeTest);
			testVente(gestion, vehiculeTest);
		} catch (GestionAutomobileVehiculesVenteException e) {
			System.out.println(e.getMessage());
		}
	}






}


