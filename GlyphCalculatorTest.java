package prj5;

import java.io.FileNotFoundException;
import java.util.Iterator;
import student.TestCase;

/**
 * Tests for GlyphCalculator
 * 
 * @author Emily Swanson (emiswan)
 * @version 2019.11.17
 */
public class GlyphCalculatorTest extends TestCase {

    private LinkedList<Song> songs;
    private GlyphCalculator gc;


    /**
     * sets up
     */
    public void setUp() {
        SongSurveyReader r;
        try {
            r = new SongSurveyReader("MusicSurveyData2016S-1.csv",
                "SongList2016S-1.csv");
            gc = r.getCalculator();
            songs = r.getSongs();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * tests the constructor
     */
    public void testConstructor() {
        assertEquals(gc.byHobby().getLength(), songs.getLength());
    }


    /**
     * test by hobby
     */
    public void testByHobby() {

        // test the first two songs have the expected values:
        Glyph g1 = gc.byHobby().getEntry(1);
        Glyph g2 = gc.byHobby().getEntry(2);
        assertEquals(21, g1.getFanBars()[0]);
        assertEquals(16, g1.getFanBars()[1]);
        assertEquals(21, g1.getFanBars()[2]);
        assertEquals(9, g1.getFanBars()[3]);
        assertEquals(50, g2.getFanBars()[0]);
        assertEquals(18, g2.getFanBars()[1]);
        assertEquals(47, g2.getFanBars()[2]);
        assertEquals(21, g2.getFanBars()[3]);
        assertEquals(25, g1.getListenerBars()[0]);
        assertEquals(16, g1.getListenerBars()[1]);
        assertEquals(21, g1.getListenerBars()[2]);
        assertEquals(11, g1.getListenerBars()[3]);
        assertEquals(71, g2.getListenerBars()[0]);
        assertEquals(20, g2.getListenerBars()[1]);
        assertEquals(51, g2.getListenerBars()[2]);
        assertEquals(26, g2.getListenerBars()[3]);

    }


    /**
     * test by region
     */
    public void testByRegion() {
        // test the first two songs have the expected values:
        Glyph g1 = gc.byRegion().getEntry(1);
        Glyph g2 = gc.byRegion().getEntry(2);
        assertEquals(35, g1.getFanBars()[0]);
        assertEquals(33, g1.getFanBars()[1]);
        assertEquals(28, g1.getFanBars()[2]);
        assertEquals(7, g1.getFanBars()[3]);
        assertEquals(70, g2.getFanBars()[0]);
        assertEquals(66, g2.getFanBars()[1]);
        assertEquals(85, g2.getFanBars()[2]);
        assertEquals(23, g2.getFanBars()[3]);
        assertEquals(35, g1.getListenerBars()[0]);
        assertEquals(37, g1.getListenerBars()[1]);
        assertEquals(28, g1.getListenerBars()[2]);
        assertEquals(7, g1.getListenerBars()[3]);
        assertEquals(87, g2.getListenerBars()[0]);
        assertEquals(77, g2.getListenerBars()[1]);
        assertEquals(100, g2.getListenerBars()[2]);
        assertEquals(38, g2.getListenerBars()[3]);

    }


    /**
     * test by major
     */
    public void testByMajor() {
        // test the first two songs have the expected values:
        Glyph g1 = gc.byMajor().getEntry(1);
        Glyph g2 = gc.byMajor().getEntry(2);
        assertEquals(28, g1.getFanBars()[0]);
        assertEquals(28, g1.getFanBars()[1]);
        assertEquals(43, g1.getFanBars()[2]);
        assertEquals(22, g1.getFanBars()[3]);
        assertEquals(58, g2.getFanBars()[0]);
        assertEquals(60, g2.getFanBars()[1]);
        assertEquals(71, g2.getFanBars()[2]);
        assertEquals(77, g2.getFanBars()[3]);
        assertEquals(32, g1.getListenerBars()[0]);
        assertEquals(28, g1.getListenerBars()[1]);
        assertEquals(43, g1.getListenerBars()[2]);
        assertEquals(29, g1.getListenerBars()[3]);
        assertEquals(74, g2.getListenerBars()[0]);
        assertEquals(71, g2.getListenerBars()[1]);
        assertEquals(82, g2.getListenerBars()[2]);
        assertEquals(81, g2.getListenerBars()[3]);

    }


    /**
     * test by artist
     */
    public void testByArtist() {
        // test that glyphs are in correct order
        Iterator<Glyph> iter = gc.sortByArtist().iterator();
        int pos = 0;
        while (iter.hasNext()) {
            Glyph g = iter.next();
            pos++;
            char[] name = g.getSong().getArtist().toCharArray();
            for (int i = pos + 1; i < 20; i++) {
                Glyph other = gc.sortByArtist().getEntry(i);
                char[] name2 = other.getSong().getArtist().toCharArray();
                int length = Math.min(name.length, name2.length);
                boolean match = true;
                int index = 0;
                while (match && index < length) {
                    if (name[index] == name2[index]) {
                        index++;
                    }
                    else {

                        assertTrue(name[index] < name2[index]);
                        match = false;
                    }
                }

            }

        }

    }


    /**
     * test by genre
     */
    public void testByGenre() {
        // test that glyphs are in correct order
        Iterator<Glyph> iter = gc.sortByGenre().iterator();
        int pos = 0;
        while (iter.hasNext()) {
            Glyph g = iter.next();
            pos++;
            String name = g.getSong().getGenre();
            for (int i = pos + 1; i < 20; i++) {
                Glyph other = gc.sortByGenre().getEntry(i);
                String otherName = other.getSong().getGenre();
                if (name.equals(otherName)) {
                    assertEquals(name, otherName);
                }
                else {
                    assertTrue(name.compareTo(otherName) < 0);
                }

            }
        }
    }


    /**
     * test byTitle.
     */
    public void testByTitle() {
        // test that glyphs are in correct order
        Iterator<Glyph> iter = gc.sortByTitle().iterator();
        int pos = 0;
        while (iter.hasNext()) {
            Glyph g = iter.next();
            pos++;
            String name = g.getSong().getName().replaceAll(" ", "");
            for (int i = pos + 1; i < 10; i++) {
                Glyph other = gc.sortByTitle().getEntry(i);
                String otherName = other.getSong().getName().replaceAll(" ",
                    "");
                if (name.equals(otherName)) {
                    assertEquals(name, otherName);
                }
                else {

                    assertTrue(name.compareTo(otherName) < 0);
                }

            }

        }

    }


    /**
     * Test by date.
     */
    public void testByDate() {
        // test that glyphs are in correct order
        Iterator<Glyph> iter = gc.sortByDate().iterator();
        int pos = 0;
        while (iter.hasNext()) {
            Glyph g = iter.next();
            pos++;
            int year = g.getSong().getDate();
            for (int i = pos + 1; i < 10; i++) {
                Glyph other = gc.sortByDate().getEntry(i);
                int otherDate = other.getSong().getDate();

                assertTrue(year >= otherDate);

            }

        }

    }

}
