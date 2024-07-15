package location;

import java.io.Serializable;

import balade.*;
import lasauvegarde.GestionAutomobileVehiculesVenteException;
import projet.*;

public class GestionVente implements Serializable{

	private Gestion gestion;

	
    private double kilometrageMaximumPourUneVente;
	
	public GestionVente(double kiloMax,Gestion gestion) {
		this.gestion = gestion;
		this.kilometrageMaximumPourUneVente = kiloMax;
	}
	
	
	
	/*
	 * 
	 * 4) Dans le cas d’une vente dans la classe GestionVente, 
	 * la méthode getTarif retournera le prix du véhicule calculé comme suit : 
	 * prixDachat x kilometrageDuVehicule / kilometrageMaximumPourUneVente (Gestion). 
	 * Vous ajouterez à la classe GestionVente la méthode demandeDeVente qui utilisera la méthode getTarif
	 *  pour retourner le prix du véhicule et mettra à jour les collections de la classe Gestion et de la classe Vehicules.
	 * 
	 * 
	 * 
	 * */
	
	
	
	public double getTarif(Vehicules a) {
		double prixvente = 0;
		int prixDachat = (int)a.getPrixAchat();
		int kilometrageDuVehicule = (int) a.getKilometrage();
		int kilometrageMaximumPourUneVente = (int) gestion.getMax();
	
		return prixvente = ( (prixDachat*kilometrageDuVehicule)/(kilometrageMaximumPourUneVente) ) ;
	}
	
	public double demandeDeVente(Vehicules v) throws GestionAutomobileVehiculesVenteException {
		if(v.getKilometrage() > kilometrageMaximumPourUneVente) {
			throw new GestionAutomobileVehiculesVenteException();
		}
		double prix = getTarif(v);
		
		gestion.addVente(v);;
		
		return prix;
	}
	
	
}
