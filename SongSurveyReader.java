package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Reads the input files and converts assessment and song data into objects
 * 
 * @author ryland
 * @version 2019.11.18
 */
public class SongSurveyReader {

    private LinkedList<Student> students;
    private LinkedList<Song> songs;
    private GlyphCalculator calculator;


    /**
     * Calls helper methods to read specified input files and make sense of it
     * 
     * @param file1
     *            Song file
     * @param file2
     *            Student answer file
     * @throws FileNotFoundException
     */
    public SongSurveyReader(String file1, String file2)
        throws FileNotFoundException {
        songs = readSongFile(file2);
        students = readStudentFile(file1);
        //System.out.println(students.getEntry(1).getHeardSongs().getLength());
        calculator = new GlyphCalculator(students, songs);
        this.intermediateSubmission();
    }


    /**
     * Prints what is needed for Intermediate Submission
     */
    public void intermediateSubmission() {
        LinkedList<Glyph> glyphs = calculator.byHobby();
        glyphs = calculator.sortByGenre();
        
        Iterator<Glyph> glyphIter = glyphs.iterator();
        while (glyphIter.hasNext()) {
             Glyph current = glyphIter.next();
             Song song = current.getSong();
            int[] fan = current.getFanBars();
            int[] listener = current.getListenerBars();
            System.out.println("song title " + song.getName());
            System.out.println("song genre " + song.getGenre());
            System.out.println("song year " + song.getDate());
            System.out.println("heard");
            System.out.println("reading" + listener[0] + " art" + listener[1]
                + " sports" + listener[2] + " music" + listener[3]);
            System.out.println("likes");
            System.out.println("reading" + fan[0] + " art" + fan[1]
                + " sports" + fan[2] + " music" + fan[3]);
        }
        glyphs = calculator.sortByTitle();
        glyphIter = glyphs.iterator();
        while (glyphIter.hasNext()) {
            Glyph current = glyphIter.next();
            Song song = current.getSong();
            int[] fan = current.getFanBars();
            int[] listener = current.getListenerBars();
            System.out.println("song title " + song.getName());
            System.out.println("song genre " + song.getGenre());
            System.out.println("song year " + song.getDate());
            System.out.println("heard");
            System.out.println("reading" + listener[0] + " art" + listener[1]
                + " sports" + listener[2] + " music" + listener[3]);
            System.out.println("likes");
            System.out.println("reading" + fan[0] + " art" + fan[1]
                + " sports" + fan[2] + " music" + fan[3]);
        }
    }


    /**
     * Reads the file for the songs surveyed
     * 
     * @param songFile
     *            file of songs
     * @return A LinkedList of the songs
     * @throws FileNotFoundException
     */
    public LinkedList<Song> readSongFile(String songFile)
        throws FileNotFoundException {
        LinkedList<Song> songs = new LinkedList<Song>();
        Scanner file = new Scanner(new File(songFile));
        String[] data;
        file.nextLine();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            data = line.split(", *");
            songs.add(new Song(data[0], data[1], Integer.valueOf(data[2]),
                data[3]));
        }
        file.close();
        return songs;
    }


    /**
     * Reads file of input for the students answers
     * 
     * @param studentFile
     *            the input file
     * @return linkedList of students and their answers
     * @throws FileNotFoundException
     */
    public LinkedList<Student> readStudentFile(String studentFile)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(studentFile));
        LinkedList<Student> students = new LinkedList<Student>();
        file.nextLine();
        int id = -1;
        Student student;
        RegionEnum region;
        HobbyEnum hobby;
        MajorEnum major;
        String[] data;
        String[] responses;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            data = line.split(", *");
            
            if (!data[0].equalsIgnoreCase("")) {
                id = Integer.valueOf(data[0]);
            }

            if (data.length >= 4) {
                major = getMajorEnum(data[2]);
                region = getRegionEnum(data[3]);
                hobby = getHobbyEnum(data[4]);
                
                responses = Arrays.copyOfRange(data, 5, data.length);
                if (!(major == null || hobby == null || region == null)) {
                    student = new Student(id, data[1], new Attributes(major,
                        hobby, region), responses);
                    students.add(student);

                    Iterator<Song> songIter = songs.iterator();
                    while (songIter.hasNext()) {
                        for (int i = 0; i < responses.length; i = i + 2) {
                            Song current = songIter.next();
                            if (responses[i].compareToIgnoreCase("yes") == 0) {
                                current.incrementListens();
                                student.getHeardSongs().add(current);
                            }
                            if (responses[i + 1].compareToIgnoreCase(
                                "yes") == 0) {
                                current.incrementLikes();
                                student.getLikedSongs().add(current);
                            }
                        }
                    }

                }
            }

        }
        file.close();
        return students;
    }


    /**
     * Returns the proper enum or null for Major
     * 
     * @param input
     *            String to check
     * @return Proper enum
     */
    private MajorEnum getMajorEnum(String input) {
        input = input.replaceAll(" ", "");
        input = input.toLowerCase();
        switch (input) {
            case ("computerscience"):
                return MajorEnum.CS;
            // break;
            case ("otherengineering"):
                return MajorEnum.ENG_OTHER;
            // break;
            case ("mathorcmda"):
                return MajorEnum.CMDA_MATH;
            case ("other"):
                return MajorEnum.OTHER;
            default:
                return null;
        }
    }


    /**
     * Returns the proper enum or null for Region
     * 
     * @param input
     *            String to check
     * @return Proper enum
     */
    private RegionEnum getRegionEnum(String input) {
        input = input.replaceAll(" ", "");
        input = input.toLowerCase();
        
        switch (input) {
            case ("northeast"):
                return RegionEnum.NE_USA;
            // break;
            case ("southeast"):
                return RegionEnum.SE_USA;
            // break;
            case ("unitedstates(otherthansoutheastornorthwest)"):
                return RegionEnum.OTHER_USA;
            case ("outsideofunitedstates"):
                return RegionEnum.OUTSIDE_USA;
            default:
                return null;
        }
    }


    /**
     * Returns the proper enum or null for hobby
     * 
     * @param input
     *            the string to check
     * @return the proper enum
     */
    private HobbyEnum getHobbyEnum(String input) {
        input = input.replaceAll(" ", "");
        input = input.toUpperCase();
        if (!input.equals("")) {
            return HobbyEnum.valueOf(input.toUpperCase());
        }
        else {
            return null;
        }
    }
}
