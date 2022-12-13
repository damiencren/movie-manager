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
    private ArrayList<String> actorsList;
    private String description;
    private int voteCount;
    private int voteAverage;

    Film(String t, int y, String g, int du, String c, String l, String di, String s, ArrayList<String> a, String d, int vc, int va)
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
}
