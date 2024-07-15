	package balade;
	
	public enum TypeVehicule {
	
		BERLINE("Berline",10,"Opulence"),
		BREAK("Break",20,"Famille"),
		UTILITAIRE("Utilitaire",40,"Pratique");
	
		private final String nom;
		private final int prix;
		private final String description;
	
	
		TypeVehicule(String nom,int prix,String desc){
			this.nom = nom;
			this.prix = prix;
			this.description = desc;
		}
	
		public String getNom() {
			return nom;
		}
	
		public int getPrix() {
			return prix;
		}
	
		public String getDescriptif() {
			return description;
		}
	
	
	
	
	}
