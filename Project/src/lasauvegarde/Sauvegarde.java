package lasauvegarde;
import projet.*;
import balade.*;
import location.*;
import java.io.*;
import java.util.*;


public class Sauvegarde {


	public Sauvegarde() {

	}
	//Serialization des données couplé à la fonction FileOutputStream
	public static void sauvegardeDonnees(String repertoire){
		try {
			ObjectOutputStream pourclients = new ObjectOutputStream(new FileOutputStream(repertoire + "\\clients.ser"));
			pourclients.writeObject(Clients.getInstance());
			pourclients.close();

			ObjectOutputStream pourvehicules = new ObjectOutputStream(new FileOutputStream(repertoire + "\\vehicules.ser"));
			pourvehicules.writeObject(Vehicules.getInstance());
			pourvehicules.close();

			ObjectOutputStream pourlagestion = new ObjectOutputStream(new FileOutputStream(repertoire + "\\collectionsgestion.ser"));
			pourlagestion.writeObject(Gestion.getInstance());
			pourlagestion.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}


	}



	public static void chargementDonnees(String repertoire) throws ClassNotFoundException {
		try {
			// Chargement deserialization Clients
			if (Clients.getInstance() == null) { // Vérifie si une instance de Clients existe déjà
				ObjectInputStream pourclients = new ObjectInputStream(new FileInputStream(repertoire + "\\clients.ser"));
				Clients.setInstance((Clients) pourclients.readObject());
				pourclients.close();
			}

			// Chargement deserialization Vehicules
			if(Vehicules.getInstance() == null) {
				ObjectInputStream pourvehicules = new ObjectInputStream(new FileInputStream(repertoire + "\\vehicules.ser"));
				Vehicules.setInstance((Vehicules) pourvehicules.readObject());
				pourvehicules.close();
			}
			// Chargement deserialization Gestion
			if(Gestion.getInstance() == null) {
				ObjectInputStream pourgestion = new ObjectInputStream(new FileInputStream(repertoire + "\\collectionsgestion.ser"));
				Gestion.setInstance((Gestion) pourgestion.readObject());
				pourgestion.close();
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}





}
