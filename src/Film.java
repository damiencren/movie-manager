import java.util.Comparator;

public class Film {
    private String title;
    private Integer year;
    private String genre;
    private Integer duration;
    private String country;
    private String language;
    private String director;
    private String scriptwriter;
    private String actors;
    private String description;
    private Integer voteCount;
    private Double voteAverage;

    Film(String t, Integer y, String g, Integer du, String c, String l, String di, String s, String a, String d, Integer vc, Double va)
    {
        title=t;
        year=y;
        genre=g;
        duration=du;
        country=c;
        language=l;
        director=di;
        scriptwriter=s;
        actors=a;
        description=d;
        voteCount=vc;
        voteAverage=va;
    }

    public String getTitle(){
        return title;
    }

    public Integer getYear(){
        return year;
    } 
    
    public String getGenre(){
        return genre;
    }

    public Integer getDuration(){
        return duration;
    }

    public String getCountry(){
        return country;
    }

    public String getLanguage(){
        return language;
    }

    public String getDirector(){
        return director;
    }

    public String getScriptwriter(){
        return scriptwriter;
    }

    public String getActors(){
        return actors;
    }

    public String getDescription(){
        return description;
    }

    public Integer getVoteCount(){
        return voteCount;
    }

    public double getVoteAverage(){
        return voteAverage;
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

    static public Comparator<Film> compareLanguage = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.language.compareToIgnoreCase(f2.language);
	    }
	};

    static public Comparator<Film> compareDescription = new Comparator <Film>() {
	    public int compare(Film f1, Film f2) {
	        return f1.description.compareToIgnoreCase(f2.description);
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
        return String.format(" Title: %1$-50s Year: %2$-6d Genre: %3$-30s Duration: %4$-5d Country: %5$-12s Langage: %6$-10s Director: %7$-20s Writer: %8$-20s Actors: %9$-10s Description: %10$-10s Vote Count: %11$-5d Vote Average %12$-5.1f", title, year, genre, duration, country, language, director, scriptwriter, actors, description, voteCount, voteAverage);
    }
}
