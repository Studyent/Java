package balade;


 
public class Break extends Vehicules{

	public Break(NombredePortes nbportes,Immatriculation immatriculation,Constructeur constructeur,String modele,double kilometrage,double prixachat) {
		super(TypeVehicule.BREAK,nbportes,immatriculation,constructeur,modele,kilometrage,prixachat);
	}

	
	@Override
	public String toString() {
		return "Break :" +
				"\n\tPortes: " + nbportes.getNbPortes() +
				"\n\tImmatriculation: " + immatriculation.getIdentification() +
				"\n\tConstructeur: " + constructeur.getMarque() +
				"\n\tModèle: " + getModele() +
				"\n\tKilométrage: " + getKilometrage() +
				"\n\tPrix: " + getPrixAchat() + "\n";


	}
	
	
}
