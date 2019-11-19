// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all
// times. I will not lie, cheat, or steal, nor will I accept the
// actions of those who do.
// -- Emily Swanson (emiswan)

package prj5;

import java.util.Iterator;

/**
 * Glyph object for  song, includes a list of listener
 * and fan attributes as well as int arrays for the number students
 * in each category of major, hobby, or region, which can be changed
 * and accessed.
 * 
 * @author Emily Swanson (emiswan)
 * @version 2019.11.17
 */
public class Glyph {
    // --------------------------------FIELDS-------------------------------
    private Song song;
    private LinkedList<Attributes> listenerAttributes;
    private LinkedList<Attributes> fanAttributes;
    private int[] fanBars;
    private int[] listenerBars;


    // -------------------------------METHODS-------------------------------
    // -----------------------------------------------------------
    /**
     * Create a new Glyph.
     * 
     * @param song
     *            The song this glyph is representing.
     * @param students
     *            The list of students.
     */
    public Glyph(Song song, LinkedList<Student> students) {
        this.song = song;
        fanBars = new int[4];
        listenerBars = new int[4];
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()) {
            Student current = iter.next();
            if (likesSong(current)) {
                addFan(current);
            }
            if (heardSong(current)) {
                addListener(current);
            }
        }
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Determine if the song is in a student's liked songs.
     * 
     * @param fan
     *            potential fan of the song.
     * @return
     *         True, if the student likes the song.
     */
    private boolean likesSong(Student fan) {
        if (fan.getLikedSongs().contains(song)) {
            return true;
        }
        return false;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Get the song associated with this glyph.
     * 
     * @return
     *         The Song object.
     */
    public Song getSong() {
        return song;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Determine if the song is a student's heard songs.
     * 
     * @param listener
     *            potential listener of the song.
     * @return
     *         True, if the student has heard the song.
     */
    private boolean heardSong(Student listener) {
        if (listener.getHeardSongs().contains(song)) {
            return true;
        }
        return false;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Add student data to the list of listeners.
     * 
     * @param listener
     *            listener to add.
     */
    private void addListener(Student listener) {
        Attributes studentAttributes = listener.getAttributes();
        listenerAttributes.add(studentAttributes);
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Get the list of listener attributes.
     * 
     * @return
     *         LinkedList<Attributes> of listener attributes.
     */
    public LinkedList<Attributes> getListeners() {

        return listenerAttributes;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Add student data to the list of fans.
     * 
     * @param fan
     *            listener to add.
     */
    private void addFan(Student fan) {
        Attributes studentAttributes = fan.getAttributes();
        fanAttributes.add(studentAttributes);
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Get the list of fan attributes.
     * 
     * @return
     *         LinkedList<Attributes> of fan attributes.
     */
    public LinkedList<Attributes> getFans() {

        return fanAttributes;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Set the values for "listener bars" (number
     * of students in each category).
     * 
     * @param newBars
     *            int array of new values.
     */
    public void setListenerBars(int[] newBars) {
        listenerBars = newBars;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Get the values for "listener bars" (number
     * of students in each category).
     * 
     * @return
     *         int array of values.
     */
    public int[] getListenerBars() {
        return listenerBars;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Set the values for "fan bars" (number
     * of students in each category).
     * 
     * @param newBars
     *            int array of new values.
     */
    public void setFanBars(int[] newBars) {
        fanBars = newBars;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Get the values for "fan bars" (number
     * of students in each category).
     * 
     * @return
     *         int array of values.
     */
    public int[] getFanBars() {
        return fanBars;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Determine if to glyphs are equal; two glyphs
     * are considered equal if they have the same
     * song and listener/fan attributes.
     * 
     * @param other
     *            glyph to be compared
     * @return
     *         true if they're equal.
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != getClass()) {
            return false;
        }
        Glyph otherGlyph = (Glyph)other;
        if (otherGlyph.getSong() != song) {
            return false;
        }
        if (otherGlyph.getFans() != fanAttributes) {
            return false;
        }
        if (otherGlyph.getListeners() != listenerAttributes) {
            return false;
        }
        return true;
    }

    // =======================end of method=======================

}
