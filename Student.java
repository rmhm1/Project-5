/**
 * 
 */
package prj5;


/**
 * @author Saakshi Naveen
 * @version 11.18.2019
 */
public class Student {
    private Attributes attributes;
    private LinkedList<Song> songsLiked;
    private LinkedList<Song> songsHeard;
    private int id;
    private String[] responses;
    private String date;
    /**
     * constructor that creates a student
     * also added responses as a parameter
     * @param i id of student
     * @param a attributes of student
     */
    public Student(int i, String d, Attributes a, String[] r)
    {
        attributes = a;
        id = i;
        responses = r;
        date = d;
        songsLiked = new LinkedList<Song>();
        songsHeard = new LinkedList<Song>();
    }
    /**
     * gets date
     * @return date
     */
    public String getDate()
    {
        return date;
    }
    /**
     * gets id
     * @return id
     */
    public int getId()
    {
        return id;
    }
    /**
     * gets responses
     * @return responses
     */
    public String[] getResponses()
    {
        return responses;
    }
    /**
     * gets attributes
     * @return attributes of student
     */
    public Attributes getAttributes()
    {
        return attributes;
    }
    /**
     * gets liked songs
     * @return songsLiked
     */
    public LinkedList<Song> getLikedSongs()
    {
        return songsLiked;
    }
    /**
     * gets songs that were heard
     * @return songsHeard
     */
    public LinkedList<Song> getHeardSongs()
    {
        return songsHeard;
    }
    /**
     * determines if student likes song
     * @param song 
     * @return true if song is liked
     */
    public boolean determineSongsLiked(Song song)
    {
        return (songsLiked.contains(song));
    }
    /**
     * determines is student has heard a song 
     * @param song 
     * @return true if song is heard
     */
    public boolean determineSongsHeard(Song song)
    {
        return (songsHeard.contains(song));
    }
    

}
