import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

public class Database {
    private ArrayList<Film> movieList;


    public void initialisation() throws Exception {
        if (movieList == null) {
            movieList = new ArrayList<Film>();
        }

        
        long startTime = System.nanoTime();

        while (!movieList.isEmpty()){
            movieList.remove(0);
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime/1000000.00000 + " milliseconds");

        String fileName = null;
        Scanner sc=new Scanner(System.in);

        while(fileName == null){
            System.out.println(String.format(" ______             _          ______                                      \n|  ___ \\           (_)        |  ___ \\                                     \n| | _ | | ___ _   _ _  ____   | | _ | | ____ ____   ____  ____  ____  ____ \n| || || |/ _ \\ | | | |/ _  )  | || || |/ _  |  _ \\ / _  |/ _  |/ _  )/ ___)\n| || || | |_| \\ V /| ( (/ /   | || || ( ( | | | | ( ( | ( ( | ( (/ /| |    \n|_||_||_|\\___/ \\_/ |_|\\____)  |_||_||_|\\_||_|_| |_|\\_||_|\\_|| |\\____)_|    \n                                                        (_____|            \n"+
                                            "     ____________________________________________________________________\n\n"+
                                            "%-10sQuel fichier souhaitez vous ouvrir?\n"+
                                            "%-15s[1] IMDbmoviesCUT100.tsv\n" +
                                            "%-15s[2] IMDbmoviesCUT1000.tsv\n" +
                                            "%-15s[3] IMDbmoviesCUT10000.tsv\n" +
                                            "%-15s[4] IMDbmoviesCUT40000.tsv\n" +
                                            "%-15s[5] IMDbmoviesFULL.tsv\n" +
                                            "     ____________________________________________________________________\n", "", "", "", "", "", ""));

            try {
                System.out.print(String.format("%-10sVotre choix : ", ""));
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
    public void linearFilter(Integer attribute, String value) {
        switch(attribute) {
            case 1:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!movieList.get(i).getTitle().contains(value)) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!(movieList.get(i).getYear()==Integer.parseInt(value))) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!movieList.get(i).getGenre().contains(value)) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!(movieList.get(i).getDuration()==Integer.parseInt(value))) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 5:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!movieList.get(i).getCountry().contains(value)) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 6:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!movieList.get(i).getLanguage().contains(value)) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 7:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!movieList.get(i).getDirector().contains(value)) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 8:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!movieList.get(i).getScriptwriter().contains(value)) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 9:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!movieList.get(i).getActors().contains(value)) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 10:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!movieList.get(i).getDescription().contains(value)) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 11:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!(movieList.get(i).getVoteCount()==Integer.parseInt(value))) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            case 12:
                for (int i = 0; i < movieList.size(); i++) {
                    if (!(movieList.get(i).getVoteAverage()==Double.parseDouble(value))) {
                        movieList.remove(i);
                        i--;
                    }
                }
                break;
            default:
                System.out.println("Veuillez entrer un nombre entre 1 et 12");
        }
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
        ListIterator<Film> iter = movieList.listIterator();
        while (iter.hasNext()) {
            int minIndex = iter.nextIndex();
            Film minValue = iter.next();
            for (ListIterator<Film> searchIter = movieList.listIterator(minIndex + 1); searchIter.hasNext();) {
                Film searchValue = searchIter.next();
                if (comparator.compare(searchValue, minValue) < 0) {
                    minIndex = searchIter.previousIndex();
                    minValue = searchValue;
                }
            }
            if (minIndex != iter.previousIndex()) {
                Film temp = iter.previous();
                iter.set(minValue);
                movieList.set(minIndex, temp);
                iter.next();
            }
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
        System.out.println("     ____________________________________________________________________\n\n");
        switch(attribute) {
            case 1:
                for (Film film : movieList) {
                    if (film.getTitle().contains(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 2:
                for (Film film : movieList) {
                    if (film.getYear()==Integer.parseInt(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 3:
                for (Film film : movieList) {
                    if (film.getGenre().contains(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 4:
                for (Film film : movieList) {
                    if (film.getDuration()==Integer.parseInt(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 5:
                for (Film film : movieList) {
                    if (film.getCountry().contains(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 6:
                for (Film film : movieList) {
                    if (film.getLanguage().contains(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 7:
                for (Film film : movieList) {
                    if (film.getDirector().contains(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 8:
                for (Film film : movieList) {
                    if (film.getScriptwriter().contains(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 9:
                for (Film film : movieList) {
                    if (film.getActors().contains(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 10:
                for (Film film : movieList) {
                    if (film.getDescription().contains(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 11:
                for (Film film : movieList) {
                    if (film.getVoteCount()==Integer.parseInt(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
            case 12:
                for (Film film : movieList) {
                    if (film.getVoteAverage()==Integer.parseInt(value)) {
                        System.out.println(film+"\n");
                    }
                }
                break;
        }
    }

    public void dichotomicalSearch(Integer attribute, String value, Database database) {

        System.out.println("     ____________________________________________________________________\n\n");
        int left = 0;
        int right = database.movieList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Film midFilm = database.movieList.get(mid);
            int cmp = 0;

            switch (attribute) {
                case 1:
                    cmp = midFilm.getTitle().compareTo(value);
                    break;
                case 2:
                    cmp = Integer.compare(midFilm.getYear(), Integer.parseInt(value));
                    break;
                case 3:
                    cmp = midFilm.getGenre().compareTo(value);
                    break;
                case 4:
                    cmp = Integer.compare(midFilm.getDuration(), Integer.parseInt(value));
                    break;
                case 5:
                    cmp = midFilm.getCountry().compareTo(value);
                    break;
                case 6:
                    cmp = midFilm.getLanguage().compareTo(value);
                    break;
                case 7:
                    cmp = midFilm.getDirector().compareTo(value);
                    break;
                case 8:
                    cmp = midFilm.getScriptwriter().compareTo(value);
                    break;
                case 9:
                    cmp = midFilm.getActors().compareTo(value);
                    break;
                case 10:
                    cmp = midFilm.getDescription().compareTo(value);
                    break;
                case 11:
                    cmp = Integer.compare(midFilm.getVoteCount(), Integer.parseInt(value));
                    break;
                case 12:
                    cmp = Integer.compare((int)midFilm.getVoteAverage(), Integer.parseInt(value));
                    break;
            }
            if (cmp == 0) {
                System.out.println(midFilm + "\n");
                break;
            } else if (cmp > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    public void copyData(Database db) {
        if (movieList == null) {
            movieList = new ArrayList<Film>();
        }

        for (Film film : db.movieList) {
            movieList.add(film);
        }

    }
    
}

