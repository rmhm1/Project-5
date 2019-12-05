/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author Emily Swanson, Saakshi Naveen
 * @version 11.18.2019
 */
public class GlyphCalculator {
    private LinkedList<Glyph> glyphs;


    /**
     * constructor that creates new Glyph calculator
     * @param students
     *          List of Students
     * @param songs
     *      List of songs
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
     * 
     * @return
     *         list of glyphs
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
     * 
     * @return
     *         list of glyphs
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
     * 
     * @return
     *         list of glyphs
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
        if (attributes != null) {
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
        newBars = convertToPercentage(newBars, SongSurveyReader.regions);
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
                case CS:
                    newBars[0] = newBars[0] + 1;
                    break;
                case ENG_OTHER:
                    newBars[1] = newBars[1] + 1;
                    break;
                case CMDA_MATH:
                    newBars[2] = newBars[2] + 1;
                    break;
                case OTHER:
                    newBars[3] = newBars[3] + 1;
                    break;
                default:
                    break;
            }
        }
        newBars = convertToPercentage(newBars, SongSurveyReader.majors);
        return newBars;
    }


    /**
     * sorts by title
     * 
     * @return
     *         list of glyphs
     */
    public LinkedList<Glyph> sortByTitle() {
        for (int h = 0; h < glyphs.getLength(); h++) {
            for (int k = 1; k < glyphs.getLength(); k++) {
                Glyph current = glyphs.getEntry(k);
                String name = current.getSong().getName().replaceAll(" ", "");
                for (int i = k; i <= glyphs.getLength(); i++) {
                    String name2 = glyphs.getEntry(i).getSong().getName()
                        .replaceAll(" ", "");
                    alph(name, name2, k, i);
                }
            }
        }
        return glyphs;
    }


    /**
     * sorts by genre
     * 
     * @return
     *         list of glyphs
     */
    public LinkedList<Glyph> sortByGenre() {
        for (int h = 0; h < glyphs.getLength() / 2; h++) {
            for (int k = 1; k < glyphs.getLength(); k++) {
                Glyph current = glyphs.getEntry(k);
                String name = current.getSong().getGenre().replaceAll(" ", "");
                for (int i = k; i <= glyphs.getLength(); i++) {
                    String name2 = glyphs.getEntry(i).getSong().getGenre()
                        .replaceAll(" ", "");
                    alph(name, name2, k, i);
                }
            }
        }
        return glyphs;
    }


    /**
     * sorts by artist
     * 
     * @return
     *         list of glyphs
     */
    public LinkedList<Glyph> sortByArtist() {
        for (int h = 0; h < glyphs.getLength() / 2; h++) {
            for (int k = 1; k < glyphs.getLength(); k++) {
                Glyph current = glyphs.getEntry(k);
                String name = current.getSong().getArtist().replaceAll(" ", "");
                for (int i = k; i <= glyphs.getLength(); i++) {
                    String name2 = glyphs.getEntry(i).getSong().getArtist()
                        .replaceAll(" ", "");
                    alph(name, name2, k, i);
                }
            }
        }
        return glyphs;

    }


    /**
     * sorts by date
     * 
     * @return
     *         list of glyphs
     */
    public LinkedList<Glyph> sortByDate() {
        for (int h = 0; h < glyphs.getLength(); h++) {
            Iterator<Glyph> iter = glyphs.iterator();
            int counter = 0;
            while (iter.hasNext()) {
                Glyph current = iter.next();
                int currYear = current.getSong().getDate();
                counter++;

                for (int i = 1; i <= glyphs.getLength(); i++) {
                    int otherYear = glyphs.getEntry(i).getSong().getDate();
                    if (otherYear < currYear) {
                        glyphs.swap(i, counter);
                    }

                }

            }
        }
        return glyphs;
    }


    /**
     * Determines if each glyph needs to be switched with
     * another, switches them if so.
     * 
     * @param st1
     *            String associated with first glyph
     * @param st2
     *            String associated with second glyph
     * @param index1
     *            index of first glyph
     * @param index2
     *            index of second glyph
     * 
     */
    private void alph(String st1, String st2, int index1, int index2) {
        char[] currName = st1.toCharArray();
        char[] otherName = st2.toCharArray();
        int len = Math.min(currName.length, otherName.length);
        int j = 0;
        boolean match = true;
        while (match && j < len) {
            if (otherName[j] == currName[j]) {
                j++;
            }
            else {
                if (currName[j] > otherName[j]) {
                    glyphs.swap(index1, index2);
                }
                match = false;
            }
        }
    }

}
