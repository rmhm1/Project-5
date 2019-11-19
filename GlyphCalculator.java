/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author Saakshi Naveen
 * @version 11.18.2019
 */
public class GlyphCalculator {
    private LinkedList<Glyph> glyphs;


    /**
     * constructor that creates new Glyph calculator
     */
    public GlyphCalculator(
        LinkedList<Student> students,
        LinkedList<Song> songs) {
        Iterator<Song> songIter = songs.iterator();
        glyphs = new LinkedList<Glyph>();
        while (songIter.hasNext()) {
            Song currentSong = songIter.next();
            Glyph currentGlyph = new Glyph(currentSong, students);
            glyphs.add(currentGlyph);
        }
    }


    /**
     * represents by hobby
     */
    public LinkedList<Glyph> byHobby() {
        Iterator<Glyph> iter = glyphs.iterator();
        while (iter.hasNext()) {
            Glyph current = iter.next();
            LinkedList<Attributes> fans = current.getFans();
            int[] newFans = calculateHobbyBars(fans);
            for (int i = 0; i < newFans.length; i++)
            {
                System.out.println(newFans[i]);
            }
            current.setFanBars(newFans);
            LinkedList<Attributes> listeners = current.getListeners();
            int[] newListeners = calculateHobbyBars(listeners);
            current.setListenerBars(newListeners);
        }
        return glyphs;
    }
    
    /**
     * represents by region
     */
    public LinkedList<Glyph> byRegion() {
        Iterator<Glyph> iter = glyphs.iterator();
        while (iter.hasNext()) {
            Glyph current = iter.next();
            LinkedList<Attributes> fans = current.getFans();
            int[] newFans = calculateRegionBars(fans);
            current.setFanBars(newFans);
            LinkedList<Attributes> listeners = current.getListeners();
            int[] newListeners = calculateRegionBars(listeners);
            current.setListenerBars(newListeners);
        }
        return glyphs;
    }
    
    /**
     * represents by major.
     */
    public LinkedList<Glyph> byMajor() {
        Iterator<Glyph> iter = glyphs.iterator();
        while (iter.hasNext()) {
            Glyph current = iter.next();
            LinkedList<Attributes> fans = current.getFans();
            int[] newFans = calculateMajorBars(fans);
            current.setFanBars(newFans);
            LinkedList<Attributes> listeners = current.getListeners();
            int[] newListeners = calculateMajorBars(listeners);
            current.setListenerBars(newListeners);
        }
        return glyphs;
    }
    
    

    
    /**
     * builds an int array based on hobby for a list of
     * student attributes.
     * @param attributes
     *              A LinkedList of attributes to build an int array for.
     */
    private int[] calculateHobbyBars(LinkedList<Attributes> attributes)
    {
        Iterator<Attributes> iter  = attributes.iterator();
        int[] newBars = new int[4];
        while (iter.hasNext()) {
            Attributes current = iter.next();
            HobbyEnum hobby = current.getHobby();
            switch (hobby) {
                case READING:
                    newBars[0] = newBars[0] + 1;
                    break;
                case ART:
                    newBars[1] = newBars[1] + 1;
                    break;
                case SPORTS:
                    newBars[2] = newBars[2] + 1;
                    break;
                case MUSIC:
                    newBars[3] = newBars[3] + 1;
                    break;
                default:
                    break;
            }
        }
            return newBars;
    }
    
    /**
     * builds an int array based on region for a list of
     * student attributes.
     * @param attributes
     *              A LinkedList of attributes to build an int array for.
     */
    private int[] calculateRegionBars(LinkedList<Attributes> attributes)
    {
        Iterator<Attributes> iter  = attributes.iterator();
        int[] newBars = new int[4];
        while (iter.hasNext()) {
            Attributes current = iter.next();
            RegionEnum region = current.getRegion();
            switch (region) {
                case NE_USA:
                    newBars[0] = newBars[0] + 1;
                    break;
                case SE_USA:
                    newBars[1] = newBars[1] + 1;
                    break;
                case OTHER_USA:
                    newBars[2] = newBars[2] + 1;
                    break;
                case OUTSIDE_USA:
                    newBars[3] = newBars[3] + 1;
                    break;
                default:
                    break;
            }
        }
            return newBars;
    }
    
    
    /**
     * builds an int array based on major for a list of
     * student attributes.
     * @param attributes
     *              A LinkedList of attributes to build an int array for.
     */
    private int[] calculateMajorBars(LinkedList<Attributes> attributes)
    {
        Iterator<Attributes> iter  = attributes.iterator();
        int[] newBars = new int[4];
        while (iter.hasNext()) {
            Attributes current = iter.next();
            MajorEnum major = current.getMajor();
            switch (major) {
                case CMDA_MATH:
                    newBars[0] = newBars[0] + 1;
                    break;
                case CS:
                    newBars[1] = newBars[1] + 1;
                    break;
                case ENG_OTHER:
                    newBars[2] = newBars[2] + 1;
                    break;
                case OTHER:
                    newBars[3] = newBars[3] + 1;
                    break;
                default:
                    break;
            }
        }
            return newBars;
    }
    

    /**
     * sorts by title
     */
    public LinkedList<Glyph> sortByTitle() {
        Iterator <Glyph> iter = glyphs.iterator();
        int counter = 0;
        while (iter.hasNext())
        {
        Glyph current = iter.next();
        counter++;
        
            for (int i = counter; i <= glyphs.getLength(); i++)
               if ( current.getSong().getName().compareTo(glyphs.
                   getEntry(i).getSong() .getName()) < 0 ){
                glyphs.swap(counter, i);
            }
        }
        return glyphs;
    }
    


    /**
     * sorts by genre
     */
    public LinkedList<Glyph> sortByGenre() {
        
        Iterator <Glyph> iter = glyphs.iterator();
        int counter = 0;
        while (iter.hasNext())
        {
        Glyph current = iter.next();
        counter++;
        
            for (int i = counter; i <= glyphs.getLength(); i++)
               if ( current.getSong().getGenre().compareTo(glyphs.
                   getEntry(i).getSong() .getGenre()) < 0 ){
                glyphs.swap(counter, i);
            }
        }
        return glyphs;
    }

}
