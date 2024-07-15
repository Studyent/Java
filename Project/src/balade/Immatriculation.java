package balade;

import java.io.Serializable;
import java.util.Objects;

/*
 * Ajoutez une classe Immatriculation contenant un champs identifcation (String). 
 * Il faut que l’on soit capable d’évaluer si deux immatriculations sont identiques 
 * et donc deux véhicules.
 * 
 * */

public class Immatriculation  implements Serializable{

	private final String identification;



	public Immatriculation(String identification) {

		this.identification = identification;

	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) {
			return true;
		}
		if( (obj == null) || (getClass() != obj.getClass() ) ) {
			return false;
		}
			Immatriculation voiture = (Immatriculation) obj;
			return Objects.equals(this.identification,voiture.identification);
		

	}

	public String getIdentification() {
		return identification;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identification);
	}


}
