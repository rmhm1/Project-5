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
        glyphs = byHobby();
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
     * 
     * @param attributes
     *            A LinkedList of attributes to build an int array for.
     */
    private int[] calculateHobbyBars(LinkedList<Attributes> attributes) {
        
      
        int[] newBars = new int[4];
        if (attributes != null)
        {
        Iterator<Attributes> iter = attributes.iterator();
        while (iter.hasNext()) {
            Attributes current = iter.next();
            if (current != null) {
            HobbyEnum hobby = current.getHobby();
            if (hobby != null) {
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
        }
        }
        }
      
      newBars = convertToPercentage(newBars, SongSurveyReader.hobbies);
        return newBars;
    }


    /**
     * Convert an int array from raw numbers to percentages
     * (percentage of the sum of all entries represented by each entry).
     * 
     * @param bars
     *            The int array to be converted.
     * @return
     *         The int array, converted to percentages.
     */
    private int[] convertToPercentage(int[] bars, int[] totals) {
        for (int i = 0; i < totals.length; i++) {
            int total = totals[i];
            if (total != 0) {
                double num = (double)bars[i];
                double percent = (num / total) * 100;
                bars[i] = (int)percent;
            }
        }
        return bars;
    }


    /**
     * builds an int array based on region for a list of
     * student attributes.
     * 
     * @param attributes
     *            A LinkedList of attributes to build an int array for.
     */
    private int[] calculateRegionBars(LinkedList<Attributes> attributes) {
        Iterator<Attributes> iter = attributes.iterator();
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
     * 
     * @param attributes
     *            A LinkedList of attributes to build an int array for.
     */
    private int[] calculateMajorBars(LinkedList<Attributes> attributes) {
        Iterator<Attributes> iter = attributes.iterator();
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
        
        return convertToPercentage(newBars, SongSurveyReader.majors);
    }


    /**
     * sorts by title
     */
    public LinkedList<Glyph> sortByTitle() {
        Iterator<Glyph> iter = glyphs.iterator();
        int counter = 0;
        while (iter.hasNext()) {
            Glyph current = iter.next();
            counter++;

            for (int i = counter; i <= glyphs.getLength(); i++) {
                String currentName = current.getSong().getName();
                currentName = currentName.substring(0, 1);
                String otherName = glyphs.getEntry(i).getSong().getName();
                otherName = otherName.substring(0, 1);
                if (currentName.compareTo(otherName) > 0) {
                    glyphs.swap(counter, i);
                }
            }

        }
        return glyphs;
    }


    /**
     * sorts by genre
     */
    public LinkedList<Glyph> sortByGenre() {

        Iterator<Glyph> iter = glyphs.iterator();
        int counter = 0;
        while (iter.hasNext()) {
            Glyph current = iter.next();
            counter++;

            for (int i = counter; i <= glyphs.getLength(); i++) {
                String currentGenre = current.getSong().getGenre();
                currentGenre = currentGenre.substring(0, 1);
                String otherGenre = glyphs.getEntry(i).getSong().getGenre();
                otherGenre = otherGenre.substring(0, 1);
                if (currentGenre.compareTo(otherGenre) > 0) {
                    glyphs.swap(counter, i);
                }
            }
        }
        return glyphs;
    }

}
