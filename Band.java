
import java.util.ArrayList;

/**
* Class for a Band object.
* @author Madison Schlaff
* @version 1.0
*/

public class Band {
    private String bandName;
    private String genre;
    private ArrayList<BandMember> members = new ArrayList<>();
    private double bandRating = 0;

    /**
    * Constructor for Band.
    * @param n name
    * @param g genre
    * @param m members
    */
    public Band(String n, String g, ArrayList<BandMember> m) {
        bandName = n;
        genre = g;
        members = m;
    }

    /**
    * Method for talent rating.
    * @return returns band's average talent rating as a double
    */
    public double talentRating() {
        for (int i = 0; i < members.size(); i++) {
            bandRating += members.get(i).perform();
        }
        bandRating /= members.size();
        return bandRating;
    }

    /**
    * Perform method. Calls each members perform method and finds avg score.
    * @return returns average performance score as double.
    */
    public double perform() {
        double avg = this.talentRating();
        System.out.println(bandName + "'s Performance Score: " + avg + "/10");
        return avg;
    }

    /**
    * Tostring method to print band name (genre): bandrating.
    * @return returns members name and rating.
    */
    public String toString() {
        String bandstr = "";
        bandstr += bandName + " (" + genre + "): " + bandRating;
        for (int j = 0; j < members.size(); j++) {
            bandstr += "\n" + members.get(j).toString();
        }
        return bandstr;
    }

    /**
    * Gets band name.
    * @return returns band name.
    */
    public String getName() {
        return bandName;
    }

    /**
    * Gets band members.
    * @return returns band members.
    */
    public ArrayList getMembers() {
        return members;
    }

    /**
    * Gets band genre.
    * @return returns genre.
    */
    public String getGenre() {
        return genre;
    }

    /**
    * Gets band genre.
    * @return returns genre.
    */
    public double getRating() {
        return bandRating;
    }
}
