/**
 * 
 */
package musicVisualization;

/**
 * @author Saakshi Naveen
 * @version 11.18.2019
 */
public class Song {
    private String name;
    private String artist;
    private int date;
    /**
     * constructor that creates new song
     * @param n name of song
     * @param a artist of song
     * @param d date of song release
     */
    public Song(String n, String a, int d)
    {
        name = n;
        artist = a;
        date = d;
    }
    /**
     * gets date
     * @return date
     */
    public int getDate()
    {
        return date;
    }
    /**
     * sets date
     * @param newDate
     */
    public void setDate(int newDate)
    {
        date = newDate;
    }
    /**
     * gets name
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * sets name
     * @param newName
     */
    public void setName(String newName)
    {
        name= newName;
    }
    /**
     * gets artist
     * @return artist
     */
    public String getArtist()
    {
        return artist;
    }
    /**
     * sets artist
     * @param newArtist
     */
    public void setArtist(String newArtist)
    {
        artist = newArtist;
    }
    /**
     * checks to see if this song is equal to another song
     * @param other object
     * @return true if equals
     */
    public boolean equals(Object obj)
    {
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
        if (other.getName().equals(name) && other.getDate() == date && other.getArtist().equals(artist))
        {
            return true;
        }
        return false;
    }

}
