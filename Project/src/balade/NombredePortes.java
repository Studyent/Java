package balade;


/*
 * 
 *  1) Écrire une structure NombreDePortes (enum) permettant de caractériser diférents types de véhicules
 *   (deux, trois, quatre ou cinq portes). 
 *  Chacune des ces valeurs sera associée à un nombre (nombre de portes) et à une description
 *   (par exemple « polyvalente et compact » pour les véhicules comportant trois portes). 
 *  Ajoutez des getters permettant de récupérer les éléments descriptifs de chaque type de voiture.
 * 
 * */

public enum NombredePortes {

	DEUX(2,"Etrange"),
	TROIS(3,"Polyvalente est compact"),
	QUATRE(4,"Normale"),
	CINQ(5,"Extravagante");

	private final int nbportes;
	private final String description;

	NombredePortes(int nb,String desc) {
		this.nbportes = nb;
		this.description = desc;
	}


	public String getDescription(){
		return description;
	}

	public int getNbPortes() {
		return nbportes;
	}


}
