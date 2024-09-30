package personnages;

public class Village {
    private String nom;
    private Chef chef;
    private Gaulois[] villageois; 
    private int nbVillageois; 
    private int nbVillageoisMaximum; 

    public Village(String nom, int nbVillageoisMaximum) {
        this.nom = nom;
        this.nbVillageoisMaximum = nbVillageoisMaximum;
        this.villageois = new Gaulois[nbVillageoisMaximum]; // 
        this.nbVillageois = 0;
    }

    
    public void ajouterHabitant(Gaulois gaulois) {
        if (nbVillageois < nbVillageoisMaximum) {
            villageois[nbVillageois] = gaulois; 
            nbVillageois++; 
        } else {
            System.out.println("Le village est plein, impossible d'ajouter un nouvel habitant.");
        }
    }

    
    public Gaulois trouverHabitant(int index) {
        if (index < 0 || index >= nbVillageois) {
            throw new IndexOutOfBoundsException("Index invalide : " + index); 
        }
        return villageois[index]; 
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public String getNom() {
        return nom;
    }
    
    public class Main {
        public static void main(String[] args) {
           
            Village village = new Village("Village des Irréductibles", 30);

            // Gaulois gaulois = village.trouverHabitant(30); 
            // Explication : Le village n'a pas encore d'habitants, donc l'index 30 est hors des limites (0-29).

            
            Chef abracourcix = new Chef("Abraracourcix", 6);
            village.setChef(abracourcix);

            
            Gaulois asterix = new Gaulois("Astérix", 8);
            village.ajouterHabitant(asterix);          
                      
            Gaulois gaulois = village.trouverHabitant(0); 
            System.out.println(gaulois); 
        }
    }
    
    public void afficherVillageois() {
        if (chef != null) {
            System.out.println("Chef du village : " + chef.getNom());
        } else {
            System.out.println("Aucun chef dans le village.");
        }
 
        System.out.println("Villageois :");
        for (int i = 0; i < nbVillageois; i++) {
            if (villageois[i] != null) {
                System.out.println("- " + villageois[i].getNom());
            }
        }
    }

}

