package balade;

public class Utilitaire extends Vehicules {


	public Utilitaire(NombredePortes nbportes,Immatriculation immatriculation,Constructeur constructeur,String modele,double kilometrage,double prixachat) {
		super(TypeVehicule.UTILITAIRE,nbportes,immatriculation,constructeur,modele,kilometrage,prixachat);
	}

	@Override
	public String toString() {
		return "Utilitaire :" +
				"\n\tPortes: " + nbportes.getNbPortes() +
				"\n\tImmatriculation: " + immatriculation.getIdentification() +
				"\n\tConstructeur: " + constructeur.getMarque() +
				"\n\tModèle: " + getModele() +
				"\n\tKilométrage: " + getKilometrage() +
				"\n\tPrix: " + getPrixAchat() + "\n";


	}
	
	
}



