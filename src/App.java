import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Film> movieList = new ArrayList<Film>();
        initialisation(movieList);

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
                        displayList(movieList);
                        break;
                    case 2:
                        break;
                    case 3:
                        sortList(movieList);
                        break;
                    case 4:
                        break;
                    case 5:
                        initialisation(movieList);
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


    public static void initialisation(ArrayList<Film> movieList) throws Exception{
        while (!movieList.isEmpty()){
            movieList.remove(0);
        }

        String fileName = null;
        Scanner sc=new Scanner(System.in);

        while(fileName == null){
            System.out.println("Quel fichier souhaitez vous ouvrir?\n"+
                                        "1. IMDbmoviesCUT100.tsv\n" +
                                        "2. IMDbmoviesCUT1000.tsv\n" +
                                        "3. IMDbmoviesCUT10000.tsv\n" +
                                        "4. IMDbmoviesCUT40000.tsv\n" +
                                        "5. IMDbmoviesFULL.tsv\n");

            try {
                int input = Integer.parseInt(sc.nextLine());
                switch(input) {
                    case 1:
                        fileName = "IMDbmoviesCUT100.tsv";
                        break;
                    case 2:
                        fileName = "IMDbmoviesCUT1000.tsv";
                        break;
                    case 3:
                        fileName = "IMDbmoviesCUT10000.tsv";
                        break;
                    case 4:
                        fileName = "IMDbmoviesCUT40000.tsv";
                        break;
                    case 5:
                        fileName = "IMDbmoviesFULL.tsv";
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 5");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 5");
            }
        }


        Reader tsvReader = new BufferedReader(new FileReader("src/data/"+fileName));

        Path path = Paths.get("src/data/"+fileName);
        long lines = Files.lines(path).count();

        ((BufferedReader) tsvReader).readLine();

        for (int i = 1; i < lines; i++) {
            String row = ((BufferedReader) tsvReader).readLine();
            String[] data = row.split("\t");
            Film film = new Film(data[1], Integer.parseInt(data[3]), data[5], Integer.parseInt(data[6]), data[7], data[8],data[9], data[10], data[12],data[13],Integer.parseInt(data[15]),Float.parseFloat(data[14]));
            movieList.add(film);
        }

        tsvReader.close();
    }


    public static void displayList(ArrayList<Film> movieList) {
        for (int i = 0; i < movieList.size(); i++) {
            String prefix = Integer.toString(i+1) + ") ";
            System.out.println(String.format("%1$-6s %2$s", prefix, movieList.get(i)));
        }
    }



    // TODO
    public static void filterList(ArrayList<Film> movieList) {

    }





    // TODO
    public static void sortList(ArrayList<Film> movieList) {
        Integer input = null;
        Scanner sc=new Scanner(System.in);

        while(input == null){
            System.out.println("Quel type de tri souhaitez vous utiliser\n"+
            "1. Tri par selection\n" +
            "2. Tri fusion\n" +
            "3. Tri Java\n");
            
            try {   
                input = Integer.parseInt(sc.nextLine());
                switch(input) {
                    case 1:
                        //SelectionSort(movieList);
                        break;
                    case 2:
                        //FusionSort(movieList);
                        break;
                    case 3:
                        JavaSort(movieList);
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 3");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 3");
            }
        }
    }

    public static ArrayList<Film> SelectionSort(ArrayList<Film> movieList) {
        return movieList;
    }

    public static void FusionSort(ArrayList<Film> movieList, int debut, int fin) {
        // Tri fusion
		if (debut < fin) {
			int m = (debut + fin) / 2;
			FusionSort(movieList, debut, m);
			FusionSort(movieList, m + 1, fin);

			Fusion(movieList, debut, m, fin);
		}
    }

    public static void Fusion(ArrayList<Film> movieList, int debut, int m, int fin){
		int i = debut;
		int j = m + 1;
		int k = 0;
		int[] tmp = new int[fin - debut + 1];

		while (i <= m && j <= fin) {
			if (movieList[i] < movieList[j]) {
				tmp[k] = movieList[i];
				i++;
			} else {
				tmp[k] = movieList[j];
				j++;
			}
			k++;
		}

    public static void JavaSort(ArrayList<Film> movieList) {
        System.out.println("test");

        Integer input = null;
        Scanner sc=new Scanner(System.in);

        while(input == null){
            System.out.println("En fonction de quel attribut souhaitez vous trier la liste ?\n"+
            "1. Année\n" +
            "2. Genre\n" +
            "3. Durée\n" +
            "4. Pays\n" +
            "5. Langue\n" +
            "6. Description\n" +
            "7. Nombre de votes\n" +
            "8. Note moyenne\n");
            
            try {
                input = Integer.parseInt(sc.nextLine());
                switch(input) {
                    case 1:
                        movieList.sort(Film.compareYear);
                        break;
                    case 2:
                        movieList.sort(Film.compareGenre);
                        break;
                    case 3:
                        movieList.sort(Film.compareDuration);
                        break;
                    case 4:
                        movieList.sort(Film.compareCountry);
                        break;
                    case 5:
                        movieList.sort(Film.compareLanguage);
                    case 6:
                        movieList.sort(Film.compareDescription);
                        break;
                    case 7:
                        movieList.sort(Film.compareVoteCount);
                        break;
                    case 8:
                        movieList.sort(Film.compareVoteAverage);
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 8");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre entre 1 et 8");
            }
        }
    }





    // TODO
    public static ArrayList<Film> SearchList(ArrayList<Film> movieList) {
        return movieList;
    }
}
