package projet;

import java.io.Serializable;

public class ClientProfessionnel extends SuperClient implements Serializable{

	private double taux;
	public ClientProfessionnel(String nom, TypeClient type, GestionDates dates,double taux) {
		super(nom, type, dates);
		this.taux = taux;
		// TODO Auto-generated constructor stub
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	@Override
	public void afficherNom() {
		System.out.println("Client Professionnel: " + nom);
	}

	@Override
	public String toString() {
		return "Client Professionnel: \n\t" + nom + ", \n\tTaux: " + taux + ", \n\tDate: " + getDate();
	}

	@Override
	public TypeClient getType() {
		return TypeClient.Professionnel;
	}


	
}
