import java.io.BufferedReader;
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
        
        while (status)
        {
            System.out.println("Que souhaitez vous faire ?\n"+
                                "1. Afficher la liste\n" +
                                "2. Filtrer la liste\n" +
                                "3. Trier la liste\n" +
                                "4. Rechercher un film\n" +
                                "5. Reinitialiser la liste de films\n");
            
            int input = Integer.parseInt(sc.nextLine());
            

            switch (input){
                case 1:
                    displayList(movieList);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    initialisation(movieList);
                    break;
            }
        }

        sc.close();
    }


    public static void initialisation(ArrayList<Film> movieList) throws Exception{
        movieList.clear();

        String fileName = "default";
        Scanner sc=new Scanner(System.in);

        while(fileName == "default"){
            System.out.println("Quel fichier souhaitez vous ouvrir?\n"+
                                        "1. IMDbmoviesCUT100.tsv\n" +
                                        "2. IMDbmoviesCUT1000.tsv\n" +
                                        "3. IMDbmoviesCUT10000.tsv\n" +
                                        "4. IMDbmoviesCUT40000.tsv\n" +
                                        "5. IMDbmoviesFULL.tsv\n");
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
                    break;
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
            System.out.println(i+1 +") "+ movieList.get(i));
        }
    }

    // TODO
    public static void filterList(ArrayList<Film> movieList) {
    }

    // TODO
    public static void sortList(ArrayList<Film> movieList) {
    }

    // TODO
    public static ArrayList<Film> SearchList(ArrayList<Film> movieList) {
        return movieList;
    }
}
