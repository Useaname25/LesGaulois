package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		if (force<0) {
			System.out.println("force doit etre positive");
		}
		this.force = force;
	}
	
	
	public String getNom() {
		return nom;
	}

	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
		
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	 
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
		parler("Aïe");
		} else {
		parler("J'abandonne...");
		}
		
		
	}
	
	public class Main {
	    public static void main(String[] args) {
	        try {
	            // Essayer de créer un Romain avec une force négative
	            Romain minus = new Romain("Minus", -6);
	        } catch (IllegalArgumentException e) {
	            // Capturer l'exception et afficher le message
	            System.out.println("Erreur : " + e.getMessage());
	        }

	        // Autres tests peuvent être ajoutés ici si nécessaire
	        // Par exemple, créer un Romain avec une force valide
	        Romain romainValide = new Romain("Obélix", 25);
	        romainValide.recevoirCoup(10); // Cela devrait afficher "Obélix : Aïe !"
	    }
	}


}
