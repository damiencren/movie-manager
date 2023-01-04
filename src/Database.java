import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Database {
    private LinkedList<Film> movieList;


    public void initialisation() throws Exception {
        if (movieList == null) {
            movieList = new LinkedList<Film>();
        } else

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
            Film film = new Film(data[1], Integer.parseInt(data[3]), data[5], Integer.parseInt(data[6]), data[7], data[8],data[9], data[10], data[12],data[13],Integer.parseInt(data[15]),Double.parseDouble(data[14]));
            movieList.add(film);
        }

        tsvReader.close();
    }

    public void display() {
        for (int i = 0; i < movieList.size(); i++) {
            String prefix = Integer.toString(i+1) + ") ";
            System.out.println(String.format("%1$-6s %2$s", prefix, movieList.get(i)));
        }
    }

    // FILTRES 
    public void linearFilter() {

        // Stream<Film> filtered_data = list.stream().filter(s -> s.rollNo > 2);  

        // // using lambda to iterate through collection  
        // filtered_data.forEach(  
        //         student -> System.out.println(student.name)  
        // );
    }

    public void javaFilter(Integer attribute, String value) {



        switch(attribute) {
            case 1:
                movieList.removeIf(f -> !f.getTitle().contains(value));
                break;
            case 2:
                System.out.println(Integer.parseInt(value));
                movieList.removeIf(f -> !(f.getYear()==Integer.parseInt(value)));
                break;
            case 3:
                movieList.removeIf(f -> !f.getGenre().contains(value));
                break;
            case 4:
                movieList.removeIf(f -> !(f.getDuration()==Integer.parseInt(value)));
                break;
            case 5:
                movieList.removeIf(f -> !f.getCountry().contains(value));
                break;
            case 6:
                movieList.removeIf(f -> !f.getLanguage().contains(value));
                break;
            case 7:
                movieList.removeIf(f -> !f.getDirector().contains(value));
                break;
            case 8:
                movieList.removeIf(f -> !f.getScriptwriter().contains(value));
                break;
            case 9:
                movieList.removeIf(f -> !f.getActors().contains(value));
                break;
            case 10:
                movieList.removeIf(f -> !f.getDescription().contains(value));
                break;
            case 11:
                movieList.removeIf(f -> !(f.getVoteCount()-Integer.parseInt(value)!=0));
                break;
            case 12:
                movieList.removeIf(f -> !(f.getVoteAverage()-Integer.parseInt(value)!=0));
                break;
        }
    }

    public void save() {}

    // TRIS 


    
    public void selectionSort(Comparator<Film> comparator) {

		for (int i = 0; i < movieList.size() - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j < movieList.size(); j++) {
                if (comparator.compare(movieList.get(j), movieList.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Film tmp = movieList.get(minIndex);
            movieList.set(minIndex, movieList.get(i));
            movieList.set(i, tmp);
        }
    }

    public void fusionSort(Comparator<Film> comparator) {
        fusionRec(0, movieList.size()-1, comparator);
    }

    public void fusionRec(int debut, int fin, Comparator<Film> comparator){
        // Tri fusion
        if (debut < fin) {
            int m = (debut + fin) / 2;
            fusionRec(debut, m, comparator);
            fusionRec(m + 1, fin, comparator);

            fusion(debut, m, fin, comparator);
        }
    }
    
    public void fusion(int debut, int m, int fin, Comparator<Film> comparator){
        int i = debut;
        int j = m + 1;
        int k = 0;
        Film[] tmp = new Film[fin - debut + 1];

        while (i <= m && j <= fin) {
            if (comparator.compare(movieList.get(i), movieList.get(j)) < 0) {
                tmp[k] = movieList.get(i);
                i++;
            } else {
                tmp[k] = movieList.get(j);
                j++;
            }
            k++;
        }

        while (i <= m) {
            tmp[k] = movieList.get(i);
            i++;
            k++;
        }

        while (j <= fin) {
            tmp[k] = movieList.get(j);
            j++;
            k++;
        }

        for (i = debut; i <= fin; i++) {
            movieList.set(i, tmp[i - debut]);
        }
    }
        
    public void javaSort(Comparator<Film> comparator) {
        movieList.sort(comparator);
    }

    public void linearSearch(Integer attribute, String value) {
        switch(attribute) {
            case 1:
                for (Film film : movieList) {
                    if (film.getTitle().contains(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 2:
                for (Film film : movieList) {
                    if (film.getYear()==Integer.parseInt(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 3:
                for (Film film : movieList) {
                    if (film.getGenre().contains(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 4:
                for (Film film : movieList) {
                    if (film.getDuration()==Integer.parseInt(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 5:
                for (Film film : movieList) {
                    if (film.getCountry().contains(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 6:
                for (Film film : movieList) {
                    if (film.getLanguage().contains(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 7:
                for (Film film : movieList) {
                    if (film.getDirector().contains(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 8:
                for (Film film : movieList) {
                    if (film.getScriptwriter().contains(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 9:
                for (Film film : movieList) {
                    if (film.getActors().contains(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 10:
                for (Film film : movieList) {
                    if (film.getDescription().contains(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 11:
                for (Film film : movieList) {
                    if (film.getVoteCount()==Integer.parseInt(value)) {
                        System.out.println(film);
                    }
                }
                break;
            case 12:
                for (Film film : movieList) {
                    if (film.getVoteAverage()==Integer.parseInt(value)) {
                        System.out.println(film);
                    }
                }
                break;
        }
    }

    public void dichotomicalSearch(Integer attribute, String value) {
    }

    
}

