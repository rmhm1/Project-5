package prj5;

import student.TestCase;
import java.io.FileNotFoundException;

/**
 * Tests for glyph
 * 
 * @author emiswan
 * @version 2019.12.04
 */
public class GlyphTest extends TestCase {
    
    private Glyph glyph;
    private Song song;
    private LinkedList<Student> students;


    /**
     * sets up test cases
     * 
     * @throws FileNotFoundException
     */
    public void setUp() throws FileNotFoundException {
        song = new Song("My Heart Will Go On", "Celine Dion", 1997, "pop");
        SongSurveyReader reader = new SongSurveyReader(
            "MusicSurveyData2018Intro.csv", "SongList2018Intro.csv");
        students = reader.readStudentFile("MusicSurveyData2018Intro.csv");
        glyph = new Glyph(song, students);
    }


    /**
     * tests getSong()
     */
    public void testGetSong() {
        assertEquals(song, glyph.getSong());
    }


    /**
     * tests getListeners() and getFans()
     */
    public void testGetListenersAndFans() {

        Attributes one = new Attributes(MajorEnum.CMDA_MATH, HobbyEnum.READING,
            RegionEnum.NE_USA);
        Attributes two = new Attributes(MajorEnum.CS, HobbyEnum.MUSIC,
            RegionEnum.SE_USA);
        assertEquals(glyph.getListeners().getEntry(1), one);
        assertEquals(glyph.getFans().getEntry(1), one);
        assertEquals(glyph.getListeners().getEntry(2), two);
        assertEquals(glyph.getFans().getEntry(2), two);
    }


    /**
     * tests setters and getters for listenerBars
     */
    public void testSetListenerBars() {
        int[] arr = new int[4];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        glyph.setListenerBars(arr);
        assertEquals(glyph.getListenerBars(), arr);
    }


    /**
     * tests setters and getters for fanBars
     */
    public void testSetFanBars() {
        int[] arr = new int[4];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        glyph.setFanBars(arr);
        assertEquals(glyph.getFanBars(), arr);
    }


    /**
     * tests equals
     * 
     * @throws FileNotFoundException
     */
    public void testEquals() throws FileNotFoundException {
        Object o = null;
        assertFalse(glyph.equals(o));
        assertTrue(glyph.equals(glyph));
        assertFalse(glyph.equals("glyph"));
        Song newSong = new Song("Holy Grail", "Jay-Z", 2013, "pop");
        Glyph one = new Glyph(newSong, students);
        assertFalse(glyph.equals(one));
        SongSurveyReader newReader = new SongSurveyReader(
            "MusicSurveyData2019F.csv", "SongList2019F.csv");
        LinkedList<Student> newStudents = newReader.readStudentFile(
            "MusicSurveyData2019F.csv");
        Glyph two = new Glyph(song, newStudents);
        assertFalse(glyph.equals(two));
        Attributes a1 = new Attributes(MajorEnum.CMDA_MATH, HobbyEnum.READING,
            RegionEnum.NE_USA);
        Attributes a2 = new Attributes(MajorEnum.CS, HobbyEnum.MUSIC,
            RegionEnum.NE_USA);
        LinkedList<Student> students2 = new LinkedList<Student>();
        String[] s = new String[2];
        s[0] = "No";
        s[1] = "Yes";
        Student first = new Student(542, "11/03", a1, s);
        Student second = new Student(542, "11/03", a2, s);
        students2.add(first);
        students2.add(second);
        Glyph three = new Glyph(song, students2);
        assertFalse(glyph.equals(three));
        Glyph four = new Glyph(song, students);
        assertTrue(four.equals(glyph));
    }

}
