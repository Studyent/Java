	package balade;
	
	public enum Constructeur {
	
		PEUGEOT("Peugeot"),
		RENAULT("Renault"),
		CITROEN("Citroën"),
		VOLKSWAGEN("Volkswagen"),
		BMW("BMW"),
		MERCEDES("Mercedes-Benz");
	
	
		private final String marque;
	
		Constructeur(String marque){
			this.marque = marque;
		}
	
		public String getMarque() {
			return marque;
		}
	
	
	
	}
