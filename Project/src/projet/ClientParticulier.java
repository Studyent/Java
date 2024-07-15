package projet;

import java.io.Serializable;

public class ClientParticulier extends SuperClient implements Serializable {
	private String prenom;
	private String adresse;
	private int age;


	public ClientParticulier(String nom,String prenom,int age,String adresse,TypeClient type,GestionDates datelocation,int nblocations) {
		super(nom,type,datelocation);
		this.prenom = prenom;
		this.age = age;	
		this.adresse = adresse;
		
	
	}
	
	
	

	@Override
	public void afficherNom() {
		System.out.println("Client Particulier: " + nom + " " + prenom);

	}


	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	@Override
	public String toString() {
		return "ClientParticulier:"
				+ "Nom: " + prenom
				+ "\n\tPrenom:" + nom
				+ "\n\tAge:" + age
				+ "\n\tAdresse:" + adresse
				+ "\n\tType:" + type
				+ "\n\tDate: " + datelocation
				+ "\n\tNombre de locations:" + nblocations;
	}

	@Override
	public TypeClient getType() {
		return TypeClient.Particulier;
	}
	
	
	
}
