package prj5;

/**
 * @author Saakshi Naveen
 * @version 11.18.2019
 */
public class StudentTest extends student.TestCase{
    private Student stu;
    private Attributes a;
    private String[] r;
    /**
     * sets up test cases
     */
    public void setUp()
    {
        a = new Attributes(MajorEnum.CS, HobbyEnum.READ, RegionEnum.NE_USA);
        r = new String[3];
        r[0] = "Yes";
        r[1] = "No";
        r[2] = "Yes";
        stu = new Student(2340, "11/18/2019", a, r);
    }
    /**
     * tests getters
     */
    public void testGettersAndSetters()
    {
        assertEquals(stu.getId(), 2340);
        assertEquals(stu.getAttributes(), a);
        assertEquals(stu.getResponses(), r);
        assertEquals(stu.getDate(), "11/18/2019");
        LinkedList<Song> likes = new LinkedList<Song>();
        LinkedList<Song> listens = new LinkedList<Song>();
        assertEquals(stu.getHeardSongs(), listens);
        assertEquals(stu.getLikedSongs(), likes);
    }
    /**
     * tests determineSongsLiked()
     */
    public void testDetermineSongsLiked()
    {
        Song song = new Song("Pure Water", "Migos", 2018, "Hip Hop");
        assertFalse(stu.determineSongsLiked(song));
        stu.getLikedSongs().add(song);
        assertTrue(stu.determineSongsLiked(song));
    }
    /**
     * tests determineSongsHeard()
     */
    public void testDetermineSongsHeard()
    {
        Song song = new Song("Pure Water", "Migos", 2018, "Hip Hop");
        assertFalse(stu.determineSongsHeard(song));
        stu.getHeardSongs().add(song);
        assertTrue(stu.determineSongsHeard(song));
    }

}
