package sg.edu.rp.c346.id20047518.l09ps;

import java.io.Serializable;
import java.util.ArrayList;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public Song(String title, String singers, int year, int stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getid() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {

        String starsString = "";
        if (stars == 5) {
            starsString = "*****";
        } else if (stars == 4) {
            starsString = "****";
        } else if (stars == 3) {
            starsString = "***";
        } else if (stars == 2) {
            starsString = "**";
        } else if (stars == 1) {
            starsString = "*";
        }
        return title + "\n" + singers + " - " + year + "\n" + starsString;
    }

}
