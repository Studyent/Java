package lasauvegarde;

public class GestionAutomobileException extends Exception {
    public GestionAutomobileException(String message) {
        super(message);
    }
}



class TauxNegatifException extends GestionAutomobileException {
    public TauxNegatifException() {
        super("Un Taux ne peut etre négatif !");
    }
}

class AdresseVideException extends GestionAutomobileException {
    public AdresseVideException() {
        super("Aucune adresse n'a été fournit !");
    }
}

class TypeClientInconnuException extends GestionAutomobileException {
    public TypeClientInconnuException() {
        super("Type client inconnu, merci d'indiquer un type valable !");
    }
}

class FormatDeDateException extends GestionAutomobileException {
    public FormatDeDateException() {
        super("Format de Date non reconnu, merci d'indiquer une date dont le format est: DD/MM/YYYY !");
    }
}

class InstanceDejaFaiteException extends GestionAutomobileException {
    public InstanceDejaFaiteException(String message) {
        super(message);
    }
}
