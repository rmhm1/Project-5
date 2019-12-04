// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all
//times. I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
// -- Emily Swanson (emiswan)



package prj5;

import java.awt.Color;
import java.util.Iterator;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * 
 * 
 * @author Emily Swanson (emiswan)
 * @version 2019.11.17
 */
public class GUIGlyphWindow {

 // --------------------------------FIELDS-------------------------------
    // GlyphCalculator field to be added.
    private Window window;
    private Button byMajor;
    private Button byHobby;
    private Button byRegion;
    private Button byTitle;
    private Button byArtist;
    private Button byDate;
    private Button byGenre;
    private Button prev;
    private Button next;
    private int legendNum;
    private GlyphCalculator calc;
    private LinkedList<LinkedList<Glyph>> currPages;
    private static final int  WIDTH = 1000;
    private static final int  HEIGHT = 800;
    private static final int  BAR_HEIGHT = 10;
    private static final int  GLYPH_X_INC = 200;
    private static final int  GLYPH_X_INITIAL = 100;
    private static final int  GLYPH_Y_INITIAL = 50;
    private static final int  GLYPH_Y_INC = 265;
    private static final int  GLYPH_WIDTH = 80;
    private static final int  GLYPH_HEIGHT_GAP = 40;
    private static final int  BAR_WIDTH= 10;
    private static final int  GLYPHS_PER_PAGE = 9;
    
    private static final Color[] COLORS =  {Color.pink, Color.orange, 
        Color.blue, Color.green};
    private int currPage;
    private int glyphNum;

     // -------------------------------METHODS-------------------------------
     // -----------------------------------------------------------
     /**
      * Create a new GUIGlyphWindow.
      * 
      *  **GlyphCalculator param to be added**
      */
    public GUIGlyphWindow(GlyphCalculator calc) {
        currPage = 1;
        legendNum = 1;
        window = new Window();
        window.setSize(WIDTH, HEIGHT);
        this.calc = calc;
        intializeButtons();
        addButtons();
        currPages = new LinkedList<LinkedList<Glyph>>();
        LinkedList<Glyph> g = calc.byHobby();
        assemblePages(g);
        paintLegend(legendNum);
        paintGlyphs(currPages.getEntry(1));
       
    }
     // =======================end of method=======================
    
    
    /**
     *  This method assembles the legend. It will be cleaned up in the 
     *  future please excuse the mess I'm so sorry :(
     */
    private void paintLegend(int enumInt)
    {
        String[] enums = new String[5];
        switch(enumInt) {
            case 1:
                enums[0] = "Hobby";
                enums[1] = "Read";
                enums[2] = "Art";
                enums[3] = "Sports";
                enums[4] = "Music";
            default:
                enums[0] = "Hobby";
                enums[1] = "Read";
                enums[2] = "Art";
                enums[3] = "Sports";
                enums[4] = "Music";
        }
        
        Shape legend = new Shape(810, 400, 290, 200, Color.black);
        legend.setBackgroundColor(Color.white);
        int y = 410;
        
        TextShape legendName = new TextShape(870, y, enums[0] + " Legend:");
        legendName.setBackgroundColor(Color.white);
        window.addShape(legendName);
        for (int i = 1; i < enums.length; i++)
        {
            y+= 15;
            TextShape enumText = new TextShape(870, y, enums[i]);
            enumText.setBackgroundColor(Color.white);
            enumText.setForegroundColor(COLORS[i-1]);
            window.addShape(enumText);
        }
       
        
        
        TextShape legendSong = new TextShape(880, 500, "Song Name");
        legendSong.setBackgroundColor(Color.white);
        legendSong.setForegroundColor(Color.black);
        TextShape legendHeard = new TextShape(865, 530, "heard");
        legendHeard.setBackgroundColor(Color.white);
        legendHeard.setForegroundColor(Color.black);
        TextShape legendLikes = new TextShape(930, 530, "likes");
        legendLikes.setBackgroundColor(Color.white);
        legendLikes.setForegroundColor(Color.black);
        Shape legendBar = new Shape (915, 520, 5, 40, Color.black);
        window.addShape(legendBar);
        window.addShape(legendSong);
        window.addShape(legendHeard);
        window.addShape(legendLikes);
        window.addShape(legend);
    }
    
    
 // -----------------------------------------------------------
    /**
     * Initialize buttons and designate On-click behaviors.
     */
    private void intializeButtons()
    {
        byMajor = new Button("Represent by Major");
        byMajor.onClick(this, "clickedByMajor");
        byHobby = new Button("Represent by Hobby");
        byHobby.onClick(this, "clickedByHobby");
        byRegion = new Button("Represent by Region");
        byRegion.onClick(this, "clickedByRegion");
        byTitle = new Button("Sort by Title");
        byTitle .onClick(this, "clickedByTitle");
        byArtist = new Button("Sort by Artist Name");
        byArtist.onClick(this, "clickedByArtist");
        byDate = new Button("Sort by Release Year");
        byDate.onClick(this, "clickedByDate");
        byGenre = new Button("Sort by Genre");
        byGenre.onClick(this, "clickedByGenre");
        prev = new Button("Previous");
        prev.onClick(this, "clickedPrev");
        next = new Button("Next");
        next.onClick(this, "clickedNext");
        prev.disable();
    }
    
    // -----------------------------------------------------------
    /**
     * add buttons to the window.
     */
    private void addButtons()
    {
        window.addButton(prev, WindowSide.NORTH);
        window.addButton(byArtist, WindowSide.NORTH);
        window.addButton(byTitle, WindowSide.NORTH);
        window.addButton(byDate, WindowSide.NORTH);
        window.addButton(byGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(byMajor, WindowSide.SOUTH);
        window.addButton(byRegion, WindowSide.SOUTH);
        window.addButton(byHobby, WindowSide.SOUTH);
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedByMajor(Button button) {
        legendNum = 3;
        assemblePages(calc.byMajor());
        currPage = 1;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        paintGlyphs(iter.next());
        prev.disable();
    }
    
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedByRegion(Button button) {
        legendNum = 2;
        assemblePages(calc.byRegion());
        currPage = 1;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        paintGlyphs(iter.next());
        paintLegend(2);
        prev.disable();
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedByHobby(Button button) {
        legendNum = 1;
        assemblePages(calc.byHobby());
        currPage = 1;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        paintGlyphs(iter.next());
        paintLegend(1);
        prev.disable();
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedByTitle(Button button) {
        assemblePages(calc.sortByTitle());
        currPage = 1;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        paintGlyphs(iter.next());
        paintLegend(1);
        prev.disable();
    }
    
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedByArtist(Button button) {
    //    assemblePages(calc.sortByArtist());
        currPage = 1;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        paintGlyphs(iter.next());
        paintLegend(1);
        prev.disable();
    }
    
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedByDate(Button button) {
    //    assemblePages(calc.sortByDate());
        currPage = 1;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        paintGlyphs(iter.next());
        paintLegend(1);
        prev.disable();
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedByGenre(Button button) {
        assemblePages(calc.sortByGenre());
        currPage = 1;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        paintGlyphs(iter.next());
        paintLegend(1);
        prev.disable();
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedNext(Button button) {
        prev.enable();
        currPage++;
        int counter = currPage;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        while (counter > 1 && iter.hasNext())
        {
            iter.next();
            counter--;
        }
        if(iter.hasNext())
        {
            paintGlyphs(iter.next());
        }
        if (!iter.hasNext())
        {
            next.disable();
        }
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    public void clickedPrev(Button button) {
        next.enable();
        currPage--;
        int counter = currPage;
        Iterator<LinkedList<Glyph>> iter = currPages.iterator();
        while (counter > 1 && iter.hasNext())
        {
            iter.hasNext();
            counter--;
        }
        paintGlyphs(iter.next());
        if (currPage == 1)
        {
            prev.disable();
        }
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: this method will remove all shapes, then call assemble
     * glyphGlyphRow three times with the glyphs for each row.
     * 
     * @param glyphs
     *          The linked list of glyphs to paint.
     */
    private void paintGlyphs(LinkedList<Glyph> page)
    {
        window.removeAllShapes();
        paintLegend(legendNum);
        Iterator<Glyph> iter = page.iterator();
        int row = 1;
        while(iter.hasNext())
        {
            int col = 1;
            while (col < 4 && iter.hasNext())
            {
                addGlyph(row, col, iter.next());   
                col++;
            }
            row++;
        }
    }
        
   

    private void assemblePages(LinkedList<Glyph> glyphs)
    {
        LinkedList<LinkedList<Glyph>> pages =  new LinkedList<LinkedList<Glyph>>(); 
        Iterator<Glyph> iter = glyphs.iterator();
        while (iter.hasNext())
        {
            LinkedList<Glyph> page = new LinkedList<Glyph>();
            while(iter.hasNext() && page.getLength() <= GLYPHS_PER_PAGE)
            {
                page.add(iter.next());
            }
            pages.add(page);
        }
        currPages = pages;
    }
    
 
    
 // -----------------------------------------------------------
    /**
     * TO-DO: this method will add a glyph at the indicated position.
     * 
     * @param row
     *                  The row number (1, 2, or 3)
     * @param col
     *                  The column number (1, 2, or 3)
     * @param glpyph
     *                  glyph to be added.
     */
    private void addGlyph(int row, int col, Glyph glyph)
    {
        int x = GLYPH_X_INITIAL + ( (col - 1) * GLYPH_X_INC);
        int fanX= x + GLYPH_WIDTH + BAR_WIDTH;
        int y = GLYPH_Y_INITIAL + ( (row - 1) * GLYPH_Y_INC);
        addGlyphText(glyph, fanX, y);
        int[] fans = glyph.getFanBars();
        int[] listeners = glyph.getListenerBars();
        y += GLYPH_HEIGHT_GAP;
        for (int i =0; i < fans.length ; i++)
        {
            makeListenerBar(x, y, listeners[i], COLORS[i]);
            makeFanBar(fanX, y, fans[i], COLORS[i]);
            y +=  BAR_HEIGHT;
        }
        y -= GLYPH_HEIGHT_GAP;
        Shape bar = new Shape(fanX - BAR_WIDTH/2, y , BAR_WIDTH/2, 
            BAR_HEIGHT * 4, Color.black);
        window.addShape(bar);
    }
    
    
    private void addGlyphText(Glyph glyph, int x, int y)
    {
        String name = glyph.getSong().getName();
        String artist = "By " + glyph.getSong().getArtist();
        int xCoord = x  - (2 * name.length())  ;
        int yCoord = y -  GLYPH_HEIGHT_GAP;
        
        TextShape songName = new TextShape(xCoord, yCoord, name);
        songName.setBackgroundColor(Color.white);
        window.addShape(songName);
        xCoord = x  - ( 2 * artist.length() );
        yCoord += 20;
        TextShape artistName = new TextShape(xCoord, yCoord, artist);
        artistName.setBackgroundColor(Color.white);
        window.addShape(artistName);
    }
    
    private void makeListenerBar(int x, int y, int listeners, Color color)
    {
        double listener = (double) listeners / 100;
        double barLength = listener * GLYPH_WIDTH;
        int length = (int) barLength;
        int barDeficit = GLYPH_WIDTH - length + 5;
        Shape bar = new Shape(x + barDeficit, y, length, BAR_HEIGHT, color);
        window.addShape(bar);
    }
    
    private void makeFanBar(int x, int y, int fans, Color color)
    {
        double fan = (double) fans / 100;
        double barLength = fan * GLYPH_WIDTH;
        int length = (int) barLength;
        Shape bar = new Shape(x, y, length, BAR_WIDTH, color);
        System.out.println(fans);
        window.addShape(bar);
    }
    
    
}
