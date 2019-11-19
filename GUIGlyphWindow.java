// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all
//times. I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
// -- Emily Swanson (emiswan)



package prj5;

import java.awt.Color;
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
    private static final int  WIDTH = 1000;
    private static final int  HEIGHT = 700;
    private static final int  GLYPH_HEIGHT = 10;
    private static final int  GLYPH_WIDTH = 80;
    private static final int  GLYPH_WIDTH_GAP = 50;
    private static final int  GLYPH_HEIGHT_GAP = 100;
    private static final int  BAR_WIDTH= 5;
    private static final int  GLYPHS_PER_PAGE = 9;
    private int pageNum;
    private int glyphNum;

     // -------------------------------METHODS-------------------------------
     // -----------------------------------------------------------
     /**
      * Create a new Glyph.
      * @param song
      *                  The song this glyph is representing.
      *@param students
      *                  The list of students.
      */
    public GUIGlyphWindow() {
        pageNum = 1;
        glyphNum = 1;
        window = new Window();
        window.setSize(WIDTH, HEIGHT);
        intializeButtons();
        addButtons();
        paintLegend();
       makeGlyph(50, 100);
       makeGlyph(50, 300);
       makeGlyph(50, 500);
       makeGlyph(315, 100);
       makeGlyph(315, 300);
       makeGlyph(315, 500);
       makeGlyph(580, 500);
       makeGlyph(580, 100);
       makeGlyph(580, 300);
       TextShape textShape = new TextShape(75, 40, "Song Name Here");
       textShape.setBackgroundColor(Color.white);
       
       TextShape textShape2 = new TextShape(65, 60, " By Artist Name Here");
       textShape2.setBackgroundColor(Color.white);
       window.addShape(textShape);
       window.addShape(textShape2);
       
    }

                
     // =======================end of method=======================
    
    
    /**
     *  This method assembles the legend. It will be cleaned up in the 
     *  future please excuse the mess I'm so sorry :(
     */
    private void paintLegend()
    {
        Shape legend = new Shape(810, 400, 290, 200, Color.black);
        legend.setBackgroundColor(Color.white);
        TextShape legend1 = new TextShape(870, 410, "Hobby Legend:");
        legend1.setBackgroundColor(Color.white);
        TextShape legend2 = new TextShape(890, 425, "Read");
        legend2.setBackgroundColor(Color.white);
        legend2.setForegroundColor(Color.pink);
        TextShape legend3 = new TextShape(890, 440, "Art");
        legend3.setBackgroundColor(Color.white);
        legend3.setForegroundColor(Color.orange);
        TextShape legend4 = new TextShape(890, 455, "Sports");
        legend4.setBackgroundColor(Color.white);
        legend4.setForegroundColor(Color.blue);
        TextShape legend5 = new TextShape(890, 470, "Music");
        legend5.setBackgroundColor(Color.white);
        legend5.setForegroundColor(Color.green);
        TextShape legend6 = new TextShape(880, 500, "Song Name");
        legend6.setBackgroundColor(Color.white);
        legend6.setForegroundColor(Color.black);
        
        TextShape legend7 = new TextShape(865, 530, "heard");
        legend7.setBackgroundColor(Color.white);
        legend7.setForegroundColor(Color.black);
        TextShape legend8 = new TextShape(930, 530, "likes");
        legend8.setBackgroundColor(Color.white);
        legend8.setForegroundColor(Color.black);
        Shape legendBar = new Shape (915, 520, 5, 40, Color.black);
        window.addShape(legend2);
        window.addShape(legend1);
        window.addShape(legend3);
        window.addShape(legend4);
        window.addShape(legend5);
        window.addShape(legend6);
        window.addShape(legend7);
        window.addShape(legend8);
        window.addShape(legendBar);
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
        byTitle .onClick(this, "clickedByTitle ");
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
    private void clickedByMajor(Button button) {
        // to do
    }
    
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    private void clickedByRegion(Button button) {
        // to do
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    private void clickedByHobby(Button button) {
        // to do
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    private void clickedByTitle(Button button) {
        // to do
    }
    
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    private void clickedByArtist(Button button) {
        // to do
    }
    
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    private void clickedByDate(Button button) {
        // to do
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    private void clickedByGenre(Button button) {
        // to do
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    private void clickedNext(Button button) {
        // to do
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: these methods are not attatched to the front end
     * yet, but will define behavior for each button when clicked.
     * 
     * @param button
     *              Button to trigger this behavior.
     */
    private void clickedPrev(Button button) {
        // to do
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: this method will remove all shapes, then call assemble
     * glyphGlyphRow three times with the glyphs for each row.
     * 
     * @param glyphs
     *          The linked list of glyphs to paint.
     */
    private void paintGlyphs(LinkedList<Glyph> glyphs)
    {
        // to do
    }
    
 // -----------------------------------------------------------
    /**
     * TO-DO: this method will add three glyphs in
     * their respective places in each row by calling
     * addGlyph.
     * 
     * @param row
     *                  The row number (1, 2, or 3)
     * @param first
     *                  The first (left-most) glyph to be put in the row.
     * @param second
     *                  The second (middle) glyph to be put in the row.                 
     * @param third
     *                  The third (right-most) glyph to be put in the row.                 
     */
    private void assembleGlyphRow(int row, Glyph first, Glyph second, Glyph third )
    {
        // To-do
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
        // to-do
        
    }
    
    // -----------------------------------------------------------
    /**
     * This is a temporary method to display a dummy
     * glyph for screenshot purposes.
     *                  
     */
    private void makeGlyph(int x, int y) {
        
        int fanX = x + GLYPH_WIDTH + BAR_WIDTH;
        Shape pink = new Shape(x + 40, y, 40, 10, Color.pink);
        Shape pink2 = new Shape(fanX, y, 60, 10, Color.pink);
        Shape orange = new Shape(x , y + GLYPH_HEIGHT, 80, 10);
        Shape orange2 = new Shape(fanX , y + GLYPH_HEIGHT, 50, 10);
        Shape blue = new Shape(x + 10, y + (GLYPH_HEIGHT  * 2), 70, 10, Color.blue);
        Shape blue2 = new Shape(fanX, y + (GLYPH_HEIGHT  * 2), 10, 10, Color.blue);
        Shape green = new Shape(x + 50, y + (GLYPH_HEIGHT  * 3), 30, 10, Color.green);
        Shape green2 = new Shape(fanX, y + (GLYPH_HEIGHT  * 3), 50, 10, Color.green);
        Shape bar = new Shape(fanX - BAR_WIDTH, y , BAR_WIDTH, 40, Color.black);
        window.addShape(pink);
        window.addShape(pink2);
        window.addShape(orange);
        window.addShape(orange2);
        window.addShape(blue);
        window.addShape(blue2);
        window.addShape(green);
        window.addShape(green2);
        window.addShape(bar);
    }
    
}
