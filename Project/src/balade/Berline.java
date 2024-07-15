package balade;

public class Berline extends Vehicules{


	public Berline(NombredePortes nbportes,Immatriculation immatriculation,Constructeur constructeur,String modele,double kilometrage,double prixachat) {
		super(TypeVehicule.BERLINE,nbportes,immatriculation,constructeur,modele,kilometrage,prixachat);
	}

	@Override
	public String toString() {
		return "Berline :" +
				"\n\tPortes: " + nbportes.getNbPortes() +
				"\n\tImmatriculation: " + immatriculation.getIdentification() +
				"\n\tConstructeur: " + constructeur.getMarque() +
				"\n\tModèle: " + getModele() +
				"\n\tKilométrage: " + getKilometrage() +
				"\n\tPrix: " + getPrixAchat() + "\n";


	}

	
	
}