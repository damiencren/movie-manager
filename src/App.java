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
            System.out.println(String.format(
                                "     ____________________________________________________________________\n\n"+
                                "%-15sBienvenue dans l'application de gestion de films\n"+
                                "     ____________________________________________________________________\n\n"+
                                "%-10sQue souhaitez vous faire ?\n"+
                                "%-15s[1] Afficher la liste\n" +
                                "%-15s[2] Filtrer la liste\n" +
                                "%-15s[3] Trier la liste\n" +
                                "%-15s[4] Rechercher un film\n" +
                                "%-15s[5] Reinitialiser la liste de films\n"+
                                "%-15s[6] Quitter l'application\n"+
                                "     ____________________________________________________________________\n", "","", "", "", "", "", "", ""));
            
            try {
                System.out.print(String.format("%-10sVotre choix : ", ""));
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
                    case 6:
                        status = false;
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
            System.out.println(String.format("     ____________________________________________________________________\n\n"+
                                            "%-10sEn fonction de quel attribut souhaitez vous filtrer la liste ?\n"+
                                            "%-15s[1] Titre\n" +
                                            "%-15s[2] Année\n" +
                                            "%-15s[3] Genre\n" +
                                            "%-15s[4] Durée\n" +
                                            "%-15s[5] Pays\n" +
                                            "%-15s[6] Langue\n" +
                                            "%-15s[7] Réalisateur\n" +
                                            "%-15s[8] Auteur\n" +
                                            "%-15s[9] Acteurs\n"+
                                            "%-15s[10] Description\n" +
                                            "%-15s[11] Nombre de votes\n"+
                                            "%-15s[12] Note moyenne\n"+
                                            "     ____________________________________________________________________\n", "", "", "", "", "", "", "", "", "", "", "", "",""));

            try {
                System.out.print(String.format("%-10sVotre choix : ", ""));
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

        System.out.print(String.format("%-10sVeuillez entrer la valeur de l'attribut avec laquelle vous souhaitez trier : ", ""));
        value = sc.nextLine();

        input = null;
        while(input == null){
            System.out.println(String.format("     ____________________________________________________________________\n\n"+
                                            "%-10sQuel type de filtre souhaitez vous utiliser\n"+
                                            "%-15s[1] Filtre Linéaire\n" +
                                            "%-15s[2] Filtre Java\n"+
                                            "     ____________________________________________________________________\n", "", "", ""));
            
            try {   
                System.out.print(String.format("%-10sVotre choix : ", ""));
                input = Integer.parseInt(sc.nextLine());
                
                switch(input) {
                    case 1:
                        db.linearFilter(attribute, value);
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
            System.out.println(String.format("     ____________________________________________________________________\n\n"+
                                            "%-10sEn fonction de quel attribut souhaitez vous trier la liste ?\n"+
                                            "%-15s[1] Titre\n"+
                                            "%-15s[2] Année\n" +
                                            "%-15s[3] Genre\n" +
                                            "%-15s[4] Durée\n" +
                                            "%-15s[5] Pays\n" +
                                            "%-15s[6] Langue\n" +
                                            "%-15s[7] Description\n" +
                                            "%-15s[8] Nombre de votes\n" +
                                            "%-15s[9] Note moyenne\n", "", "", "", "", "", "", "", "", "", ""));


            try {
                System.out.print(String.format("%-10sVotre choix : ", ""));
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
            System.out.println(String.format("     ____________________________________________________________________\n\n"+
                                            "%-10sQuel type de tri souhaitez vous utiliser\n"+
                                            "%-15s[1] Tri par selection\n" +
                                            "%-15s[2] Tri fusion\n" +
                                            "%-15s[3] Tri Java\n", "", "", "",""));
            
            try {   
                System.out.print(String.format("%-10sVotre choix : ", ""));
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
            System.out.println(String.format("     ____________________________________________________________________\n\n"+
                                            "%-10sEn fonction de quel attribut souhaitez vous effectuer une recherche ?\n"+
                                            "%-15s[1] Titre\n" +
                                            "%-15s[2] Année\n" +
                                            "%-15s[3] Genre\n" +
                                            "%-15s[4] Durée\n" +
                                            "%-15s[5] Pays\n" +
                                            "%-15s[6] Langue\n" +
                                            "%-15s[7] Réalisateur\n" +
                                            "%-15s[8] Auteur\n" +
                                            "%-15s[9] Acteurs\n"+
                                            "%-15s[10] Description\n" +
                                            "%-15s[11] Nombre de votes\n"+
                                            "%-15s[12] Note moyenne\n"+
                                            "     ____________________________________________________________________\n",  "", "", "", "", "", "", "", "", "", "", "", "","",""));

            try {
                System.out.print(String.format("%-10sVotre choix : ", ""));
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

        System.out.print(String.format("     ____________________________________________________________________\n\n"+
                                        "%-10sVeuillez entrer la valeur de l'attribut que vous souhaitez rechercher\n"+
                                        "     ____________________________________________________________________\n\n"+
                                        "%-10sVotre choix : ", "",""));
        value = sc.nextLine();

        input = null;
        while(input == null){
            System.out.println(String.format("     ____________________________________________________________________\n\n"+
                                            "%-10sQuel type de cherche souhaitez vous effectuer\n"+
                                            "%-15s[1] Recherche Linéaire\n" +
                                            "%-15s[2] Recherche dichotomique\n", "", "", ""));
            
            try {   
                System.out.print(String.format("%-10sVotre choix : ", ""));
                input = Integer.parseInt(sc.nextLine());
                switch(input) {
                    case 1:

                        db.linearSearch(attribute, value);
                        break;
                    case 2:
                        try {
                        long startTime = System.nanoTime();
                        
                        Database db_copy = new Database();
                        db_copy.copyData(db);
                        db_copy.javaSort(Film.compareTitle);
                        db.dichotomicalSearch(attribute, value, db_copy);

                        long endTime = System.nanoTime();
                        long elapsedTime = endTime - startTime;
                        System.out.println("Elapsed time: " + elapsedTime/1000000.00000 + " milliseconds");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
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
