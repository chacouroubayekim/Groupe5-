import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String nom;
    private String telephone;
    private String email;

    public Contact(String nom, String telephone, String email) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Téléphone: " + telephone + ", Email: " + email;
    }
}

public class GestionContacts {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;
        do {
            System.out.println("\n=== MENU GESTION DE CONTACTS ===");
            System.out.println("1. Ajouter un contact");
            System.out.println("2. Modifier un contact");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Lister tous les contacts");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1:
                    ajouterContact();
                    break;
                case 2:
                    modifierContact();
                    break;
                case 3:
                    supprimerContact();
                    break;
                case 4:
                    listerContacts();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        } while (choix != 5);
    }

    private static void ajouterContact () {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();

        contacts.add(new Contact(nom, telephone, email));
        System.out.println("✅ Contact ajouté avec succès !");
    }

    private static void modifierContact() {
        System.out.print("Entrez le nom du contact à modifier : ");
        String nom = scanner.nextLine();
        for (Contact c : contacts) {
            if (c.getNom().equalsIgnoreCase(nom)) {
                System.out.print("Nouveau téléphone : ");
                c.setTelephone(scanner.nextLine());
                System.out.print("Nouvel email : ");
                c.setEmail(scanner.nextLine());
                System.out.println("✅ Contact modifié avec succès !");
                return;
            }
        }
        System.out.println("❌ Contact non trouvé !");
    }

    private static void supprimerContact() {
        System.out.print("Entrez le nom du contact à supprimer : ");
        String nom = scanner.nextLine();
        for (Contact c : contacts) {
            if (c.getNom().equalsIgnoreCase(nom)) {
                contacts.remove(c);
                System.out.println("✅ Contact supprimé avec succès !");
                return;
            }
        }
        System.out.println("❌ Contact non trouvé !");
    }

    private static void listerContacts() {
        if (contacts.isEmpty()) {
            System.out.println("📭 Aucun contact dans la liste.");
        } else {
            System.out.println("\n📋 Liste des contacts :");
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }
}
