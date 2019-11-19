/**
 * 
 */
package prj5;

/**
 * @author Saakshi Naveen
 * @version 11.18.2019
 */
public class GlyphCalculator {
    private LinkedList<Glyph> glyphs;
    /**
     * constructor that creates new Glyph calculator
     */
    public GlyphCalculator(LinkedList<Glyph> list)
    {
        glyphs = list;
    }
    /**
     * represents by hobby
     */
    public LinkedList<Glyph> byHobby()
    {
        for (int i = 1; i < glyphs.getLength(); i++)
        {
            
        }
    }
    /**
     * sorts by title
     */
    public LinkedList<Glyph> sortByTitle()
    {
        for (int i = 1; i < glyphs.getLength(); i++) {
            for (int j = i; (j > 0) && glyphs.getEntry(j).getSong().getName().compareTo(glyphs
                .getEntry(j - 1).getSong().getName()) < 0; j--) {
                glyphs.swap(j, j - 1);
            }
        }
        return glyphs;
    }
    /**
     * sorts by genre
     */
    public LinkedList<Glyph> sortByGenre()
    {
        for (int i = 1; i < glyphs.getLength(); i++) {
            for (int j = i; (j > 0) && glyphs.getEntry(j).getSong().getGenre().compareTo(glyphs
                .getEntry(j - 1).getSong().getGenre()) < 0; j--) {
                glyphs.swap(j, j - 1);
            }
        }
        return glyphs;
    }

}
