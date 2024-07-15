	package projet;

import java.io.Serializable;

public abstract class SuperClient implements Serializable{
		protected String nom;
		protected TypeClient type;
		protected GestionDates datelocation;
		protected int nblocations;
		
		public SuperClient(String nom,TypeClient type,GestionDates dates) {
			this.nom = nom;
			this.type = type; 
			this.datelocation = dates;
		}
	
		public abstract void afficherNom();
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
	
		public TypeClient getType() {
		    return type;
		}

		public void setType(TypeClient type) {
			this.type = type;
		}
	
		public GestionDates getDate() {
			return datelocation;
		}
	
		public void setDate(GestionDates date) {
			this.datelocation = date;
		}
		
		
		public int getNombreLocations() {
			return nblocations;
		}
	
		public void setNombreLocations(int nombreLocations) {
			this.nblocations = nombreLocations;
		}
	
	}
