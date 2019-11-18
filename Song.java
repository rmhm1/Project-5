package prj5;

/**
 * @author Saakshi Naveen
 * @version 11.18.2019
 */
public class Song {
    private String name;
    private String artist;
    private int date;
    private String genre;


    /**
     * constructor that creates new song
     * 
     * @param n
     *            name of song
     * @param a
     *            artist of song
     * @param d
     *            date of song release
     */
    public Song(String title, String a, int d, String genre) {
        name = title;
        artist = a;
        date = d;
        this.genre = genre;
    }


    /**
     * gets date
     * 
     * @return date
     */
    public int getDate() {
        return date;
    }


    /**
     * sets date
     * 
     * @param newDate
     *            new Date to set
     */
    public void setDate(int newDate) {
        date = newDate;
    }


    /**
     * gets name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * sets name
     * 
     * @param newName
     *            new Song name
     */
    public void setName(String newName) {
        name = newName;
    }


    /**
     * gets artist
     * 
     * @return artist
     */
    public String getArtist() {
        return artist;
    }


    /**
     * sets artist
     * 
     * @param newArtist
     *            The new artist
     */
    public void setArtist(String newArtist) {
        artist = newArtist;
    }


    /**
     * Gets the genre of a song
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Sets a new genre
     * 
     * @param newGenre
     *            the new genre
     */
    public void setGenre(String newGenre) {
        genre = newGenre;
    }


    /**
     * checks to see if this song is equal to another song
     * 
     * @param other
     *            object
     * @return true if equals
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Song other = (Song)obj;
        if (other.getName().equals(name) && other.getDate() == date && other
            .getArtist().equals(artist)) {
            return true;
        }
        return false;
    }

}