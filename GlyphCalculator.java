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
            Iterator<Attributes> fans = current.getFans().iterator();
            int[] newFans = new int[4];
            while (fans.hasNext()) {
                Attributes attributes = fans.next();
                HobbyEnum hobby = attributes.getHobby();
                switch (hobby) {
                    case READ:
                        newFans[0] = newFans[0]++;
                        break;
                    case ART:
                        newFans[1] = newFans[1]++;
                        break;
                    case SPORTS:
                        newFans[2] = newFans[2]++;
                        break;
                    case MUSIC:
                        newFans[3] = newFans[3]++;
                        break;
                }
                current.setFanBars(newFans);
                Iterator<Attributes> listeners = current.getListeners()
                    .iterator();
                int[] newListeners = new int[4];
                while (listeners.hasNext()) {
                    attributes = listeners.next();
                    hobby = attributes.getHobby();
                    switch (hobby) {
                        case READ:
                            newListeners[0] = newListeners[0]++;
                            break;
                        case ART:
                            newListeners[1] = newListeners[1]++;
                            break;
                        case SPORTS:
                            newListeners[2] = newListeners[2]++;
                            break;
                        case MUSIC:
                            newListeners[3] = newListeners[3]++;
                            break;
                    }
                    current.setListenerBars(newListeners);
                }

            }
        }
        return glyphs;
    }


    /**
     * sorts by title
     */
    public LinkedList<Glyph> sortByTitle() {
        for (int i = 1; i < glyphs.getLength() + 1; i++) {
            for (int j = i; (j > 0) && glyphs.getEntry(j).getSong().getName()
                .compareTo(glyphs.getEntry(j - 1).getSong()
                    .getName()) < 0; j--) {
                glyphs.replace(j, g);
                glyphs.replace(j - 1, g2);
            }
        }
        return glyphs;
    }


    /**
     * sorts by genre
     */
    public LinkedList<Glyph> sortByGenre() {
        for (int i = 1; i < glyphs.getLength() + 1; i++) {
            for (int j = i; (j > 0) && glyphs.getEntry(j).getSong().getGenre()
                .compareTo(glyphs.getEntry(j - 1).getSong()
                    .getGenre()) < 0; j--) {
                glyphs.replace(j, g);
                glyphs.replace(j - 1, g2);
            }
        }
        return glyphs;
    }

}
