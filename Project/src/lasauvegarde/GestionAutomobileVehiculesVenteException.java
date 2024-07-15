package lasauvegarde;

public class GestionAutomobileVehiculesVenteException extends GestionAutomobileVehiculesException{
	
	public GestionAutomobileVehiculesVenteException() {
		super("Ce véhicule n’est plus disponible à la vente");
	}
	
}
