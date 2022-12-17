import java.util.ArrayList;
import java.util.Comparator;

public class Film {
    private String title;
    private int year;
    private String genre;
    private int duration;
    private String country;
    private String language;
    private String director;
    private String scriptwriter;
    private String actorsList;
    private String description;
    private int voteCount;
    private Float voteAverage;

    Film(String t, int y, String g, int du, String c, String l, String di, String s, String a, String d, int vc, Float va)
    {
        title=t;
        year=y;
        genre=g;
        duration=du;
        country=c;
        language=l;
        director=di;
        scriptwriter=s;
        actorsList=a;
        description=d;
        voteCount=vc;
        voteAverage=va;
    }

	static public Comparator<Film> compareTitle = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.title.compareToIgnoreCase(f2.title);
	    }
	};

    static public Comparator<Film> compareYear = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.year-f2.year;
	    }
	};

    static public Comparator<Film> compareGenre = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.genre.compareToIgnoreCase(f2.genre);
	    }
	};

    static public Comparator<Film> compareDuration = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.duration-f2.duration;
	    }
	};

    static public Comparator<Film> compareCountry = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.country.compareToIgnoreCase(f2.country);
	    }
	};

    static public Comparator<Film> compareDirector = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.director.compareToIgnoreCase(f2.director);
	    }
	};

    static public Comparator<Film> compareVoteCount = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.voteCount-f2.voteCount;
	    }
	};

    static public Comparator<Film> compareVoteAverage = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
            if (f1.voteAverage < f2.voteAverage) return -1;
            if (f1.voteAverage > f2.voteAverage) return 1;
            return 0;
	    }
	};
    

    @Override
    public String toString() {
        return String.format("Title: %1$-15s Year: %2$-6d Genre: %3$-30s Duration: %4$-5d Country: %5$-12s Langage: %6$-10s Director: %7$-20s Writer: %8$-20s Actors: %9$-10% Description: %10$-10s Vote Count: %11$-5d Vote Average %12$-5f", title, year, genre, duration, country, language, director, scriptwriter, actorsList, description, voteCount, voteAverage);
    }
}
