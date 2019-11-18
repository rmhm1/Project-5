package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SongSurveyReader {

    private LinkedList<Student> students;
    private LinkedList<Song> songs;


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
        Scanner file = new Scanner(new File(songFile));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] data = line.split(", *");
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
        file.nextLine();
        while (file.hasNextLine()) {
            int id = -1;
            RegionEnum region;
            HobbyEnum hobby;
            MajorEnum major = null;
            String[] responses;
            String line = file.nextLine();
            String[] data = line.split(", *");
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
        input.toUpperCase();
        if (!input.equals("")) {
            return HobbyEnum.valueOf(input);
        }
        else {
            return null;
        }
    }
}
