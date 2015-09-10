package Model;

import java.sql.Time;

/**
 *
 * @author ryan
 */
public class Score {
    private int score, highestLevel;
    private Time timePlayed;
    private String name;

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the highestLevel
     */
    public int getHighestLevel() {
        return highestLevel;
    }

    /**
     * @param highestLevel the highestLevel to set
     */
    public void setHighestLevel(int highestLevel) {
        this.highestLevel = highestLevel;
    }

    /**
     * @return the timePlayed
     */
    public Time getTimePlayed() {
        return timePlayed;
    }

    /**
     * @param timePlayed the timePlayed to set
     */
    public void setTimePlayed(Time timePlayed) {
        this.timePlayed = timePlayed;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
