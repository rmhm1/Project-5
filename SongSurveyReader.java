package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Reads the input files and converts assessment and song data into objects
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
        LinkedList<Glyph> glyphs = new LinkedList<Glyph>();
        //for (int i = 1; i < songs.getLength(); i++) {
            //glyphs.add(new Glyph(songs.getEntry(i), students));
        //}
        //calculator = new GlyphCalculator(glyphs);
        this.intermediateSubmission();
    }
    /**
     * Prints what is needed for Intermediate Submission
     */
    public void intermediateSubmission() {
        //
        
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
        for (int i = 1; i <= songs.getLength(); i++) {
            //System.out.println(i);
        }
        file.nextLine();
        int id = -1;
        RegionEnum region;
        HobbyEnum hobby;
        MajorEnum major = null;
        String[] data;
        String[] responses;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            data = line.split(", *");
            if (!data[0].equalsIgnoreCase("")) {
                id = Integer.valueOf(data[0]);
            }

            if (data.length >= 3) {
                major = getMajorEnum(data[2]);
            }
            if (data.length >= 4) {
                region = getRegionEnum(data[3]);
                hobby = getHobbyEnum(data[4]);

                responses = Arrays.copyOfRange(data, 5, data.length);
                int index = 1;
                for (int i = 0; i < responses.length / 2; i++)
                {
                    Song song;
                    Student student = new Student(id, data[1], new Attributes(major,
                        hobby, region), responses);
                    if (i % 2 == 1)
                    {
                        index++;
                        song = songs.getEntry(index);
                        if (responses[i].equals("Yes"))
                        {
                            song.incrementListens();
                            student.getHeardSongs().add(song);
                        }
                    }
                    else if (i % 2 == 0)
                    {
                        song = songs.getEntry(index);
                        if (responses[i].equals("Yes"))
                        {
                            song.incrementLikes();
                            student.getLikedSongs().add(song);
                        }
                    }
                }
                 
                if (!(major == null || hobby == null || region == null)) {
                    students.add(new Student(id, data[1], new Attributes(major,
                        hobby, region), responses));
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
        input.replaceAll(" ", "");
        input.toLowerCase();
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
        input.replaceAll(" ", "");
        input.toLowerCase();
        switch (input) {
            case ("northeast"):
                return RegionEnum.NE_USA;
            // break;
            case ("southeast"):
                return RegionEnum.SE_USA;
            // break;
            case ("unitedstates(otherthansoutheastornorthwest"):
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
        input.replaceAll(" ", "");
        //input.toUpperCase();
        if (!input.equals("")) {
            return HobbyEnum.valueOf(input.toUpperCase());
        }
        else {
            return null;
        }
    }
}
