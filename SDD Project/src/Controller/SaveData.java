package Controller;

import Model.Score;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author ryan
 */
public class SaveData {
    
    private String fileName;
    private Vector<Score> loadedScores;
    private boolean firstLoad;
    String filePath = System.getProperty("user.dir");
    // separator: Windows '\', Linux '/'
    String separator = System.getProperty("file.separator");
    
    public SaveData(boolean firstLoad) {
       if(firstLoad) {
           readFile();
       }
    }
    
    public void readFile() {
        FileReader reader = null;
        String line = null;
        fileName = filePath + separator + "save data" + separator + "save.txt";
        try {
            reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            Score score = null;
            while((line = bufferedReader.readLine()) != null) {
                score = new Score();
                //consume the line
                line = null;
                //read in the name
                score.setName(line);
                //read in the score
                score.setScore(Integer.parseInt(line));
                //read in the time played
                String[] values = line.split(Pattern.quote("."));
                Time time = new Time(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                score.setTimePlayed(time);
                //read in the max level
                score.setHighestLevel(Integer.parseInt(line));
                //add to the loaded in scores
                loadedScores.add(score);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveFile() {
        FileWriter writer = null;
        String line = null;
        fileName = filePath + separator + "save data" + separator + "save.txt";
        try {
            writer = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for(int i = 0; i < loadedScores.size() && !loadedScores.isEmpty(); i++) {
                //header for marking individuals
                bufferedWriter.write("***\n");
                //write the name
                bufferedWriter.write(loadedScores.elementAt(i).getName() + "\n");
                //write the score
                bufferedWriter.write(String.valueOf(loadedScores.elementAt(i).getScore()) + "\n");
                //get the time and then go and save it
                Time time = new Time(0, 0, 0);
                int hours, minutes, seconds;
                time = loadedScores.elementAt(i).getTimePlayed();
                hours = time.getHours();
                minutes = time.getMinutes();
                seconds = time.getSeconds();
                String value = String.valueOf(hours) + "." + String.valueOf(minutes) + "." + String.valueOf(seconds) + "\n";
                bufferedWriter.write(value);
                //save the highest level
                bufferedWriter.write(String.valueOf(loadedScores.elementAt(i).getHighestLevel()));
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
