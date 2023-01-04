import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Database db = new Database();
        db.initialisation();

        Scanner sc=new Scanner(System.in);
        Boolean status = true;
        
        while(status)
        {
            System.out.println("Que souhaitez vous faire ?\n"+
                                "1. Afficher la liste\n" +
                                "2. Filtrer la liste\n" +
                                "3. Trier la liste\n" +
                                "4. Rechercher un film\n" +
                                "5. Reinitialiser la liste de films\n");
            
            try {
                int input = Integer.parseInt(sc.nextLine());
                switch (input){
                    case 1:
                        db.display();
                        break;
                    case 2:
                        filter(db);
                        break;
                    case 3:
                        sort(db);
                        break;
                    case 4:
                        search(db);
                        break;
                    case 5:
                        db.initialisation();
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 5");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 5");
            }
           
        }

        sc.close();
    }

    public static void filter(Database db) {
        Integer input = null;
        Scanner sc=new Scanner(System.in);
        Integer attribute = null;
        String value = null;

        while(input==null){
            System.out.println("En fonction de quel attribut souhaitez vous filtrer la liste ?\n"+
            "1. Titre\n" +
            "2. Année\n" +
            "3. Genre\n" +
            "4. Durée\n" +
            "5. Pays\n" +
            "6. Langue\n" +
            "7. Réalisateur\n" +
            "8. Auteur\n" +
            "9. Acteurs\n"+
            "10. Description\n" +
            "11. Nombre de votes\n"+
            "12. Note moyenne");

            try {
                input = Integer.parseInt(sc.nextLine());
                if (input > 0 && input <= 12) {
                    attribute = input;
                } else {
                    input = null;
                    System.out.println("Veuillez entrer un nombre entre 1 et 12");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 12");
            }

        }
        
        input = null;

        System.out.println("Entrez votre chaine de caracteres\n");
        value = sc.nextLine();

        input = null;
        while(input == null){
            System.out.println("Quel type de filtre souhaitez vous utiliser\n"+
            "1. Filtre Linéaire\n" +
            "2. Filtre Java\n");
            
            try {   
                input = Integer.parseInt(sc.nextLine());
                switch(input) {
                    case 1:
                        //sortType
                        break;
                    case 2:
                        db.javaFilter(attribute, value);
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 2");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 2");
            }
        }
    }

    public static void sort(Database db) {
        Integer input = null;
        Scanner sc=new Scanner(System.in);
        Comparator<Film> comparator = null;

        while(input==null){
            System.out.println("En fonction de quel attribut souhaitez vous trier la liste ?\n"+
            "1. Titre\n"+
            "2. Année\n" +
            "3. Genre\n" +
            "4. Durée\n" +
            "5. Pays\n" +
            "6. Langue\n" +
            "7. Description\n" +
            "8. Nombre de votes\n" +
            "9. Note moyenne\n");


            try {
                input = Integer.parseInt(sc.nextLine());
                switch(input) {
                    case 1:
                        comparator = Film.compareTitle;
                        break;
                    case 2:
                        comparator = Film.compareYear;
                        break;
                    case 3:
                        comparator = Film.compareGenre;
                        break;
                    case 4:
                        comparator = Film.compareDuration;
                        break;
                    case 5:
                        comparator = Film.compareCountry;
                        break;
                    case 6:
                        comparator = Film.compareLanguage;
                        break;
                    case 7:
                        comparator = Film.compareDescription;
                        break;
                    case 8:
                        comparator = Film.compareVoteCount;
                        break;
                    case 9:
                        comparator = Film.compareVoteAverage;
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 9");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 8");
            }
        }

        input = null;
        while(input == null){
            System.out.println("Quel type de tri souhaitez vous utiliser\n"+
            "1. Tri par selection\n" +
            "2. Tri fusion\n" +
            "3. Tri Java\n");
            
            try {   
                input = Integer.parseInt(sc.nextLine());
                switch(input) {
                    case 1:
                        db.selectionSort(comparator);
                        break;
                    case 2:
                        db.fusionSort(comparator);
                        break;
                    case 3:
                        db.javaSort(comparator);
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 3");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 3");
            }
        }
    }

    public static void search(Database db){
        Integer input = null;
        Scanner sc=new Scanner(System.in);
        Integer attribute = null;
        String value = null;

        while(input==null){
            System.out.println("En fonction de quel attribut souhaitez vous effectuer une recherche ?\n"+
            "1. Titre\n" +
            "2. Année\n" +
            "3. Genre\n" +
            "4. Durée\n" +
            "5. Pays\n" +
            "6. Langue\n" +
            "7. Réalisateur\n" +
            "8. Auteur\n" +
            "9. Acteurs\n"+
            "10. Description\n" +
            "11. Nombre de votes\n"+
            "12. Note moyenne");

            try {
                input = Integer.parseInt(sc.nextLine());
                if (input > 0 && input <= 12) {
                    attribute = input;
                } else {
                    input = null;
                    System.out.println("Veuillez entrer un nombre entre 1 et 12");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 12");
            }

        }
        
        input = null;

        System.out.println("Entrez votre chaine de caracteres\n");
        value = sc.nextLine();

        input = null;
        while(input == null){
            System.out.println("Quel type de cherche souhaitez vous effectuer\n"+
            "1. Recherche Linéaire\n" +
            "2. Recherche dichotomique\n");
            
            try {   
                input = Integer.parseInt(sc.nextLine());
                switch(input) {
                    case 1:
                        db.linearSearch(attribute, value);
                        break;
                    case 2:
                        // DichotomicalSearch
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 2");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 2");
            }
        }
    }

}
