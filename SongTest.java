/**
 * 
 */
package prj5;

/**
 * @author Saakshi Naveen
 * @version 11.18.2019
 */
public class SongTest extends student.TestCase {
    private Song song;


    /**
     * sets up test cases
     */
    public void setUp() {
        song = new Song("Pure Water", "Migos", 2018, "rap");
    }


    /**
     * tests getters and setters
     */
    public void testGettersAndSetters() {
        assertEquals(song.getName(), "Pure Water");
        song.setName("Monster");
        assertEquals(song.getName(), "Monster");
        assertEquals(song.getArtist(), "Migos");
        song.setArtist("Kanye");
        assertEquals(song.getArtist(), "Kanye");
        assertEquals(song.getDate(), 2018);
        song.setDate(2008);
        assertEquals(song.getDate(), 2008);
        song.setGenre("Pop");
        assertEquals(song.getGenre(), "Pop");

    }


    /**
     * tests getLikes, getListens, incrementLikes, and incrementListens
     */
    public void testLikesAndListens() {
        assertEquals(song.getLikes(), 0);
        assertEquals(song.getListens(), 0);
        song.incrementLikes();
        song.incrementListens();
        assertEquals(song.getLikes(), 1);
        assertEquals(song.getListens(), 1);
    }


    /**
     * tests equals()
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        assertTrue(song.equals(song));
        Object o = null;
        assertFalse(song.equals(o));
        assertFalse(song.equals("song"));
        Song one = new Song("Pure Water", "Migos", 2018, "rap");
        assertTrue(song.equals(one));
        Song two = new Song("Narcos", "Migos", 2018, "rap");
        assertFalse(song.equals(two));
        Song three = new Song("Pure Water", "Quavo", 2018, "rap");
        assertFalse(song.equals(three));
        Song four = new Song("Pure Water", "Migos", 2019, "rap");
        assertFalse(song.equals(four));
        Song five = new Song("Pure Water", "Migos", 2019, "pop");
        assertFalse(song.equals(five));
    }

}
