package prj5;

import java.io.FileNotFoundException;

/**
 * Creates the SongSurveyReader and launches program
 * 
 * @author ryland
 * @version 2019.11.18
 */
public class Input {
    /**
     * Creates a SongSurveyReader for specified files, or with the default files
     * 
     * @param args
     *            Possible other files
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 2) {
            @SuppressWarnings("unused")
            SongSurveyReader reader = new SongSurveyReader(args[0], args[1]);
        }
        else {
            @SuppressWarnings("unused")
            SongSurveyReader reader = new SongSurveyReader(
                "MusicSurveyData2018Intro.csv", "SongList2018Intro.csv");
        }
    }
}
