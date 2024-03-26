import java.util.Random;

/**
* Class for a Singer object.
* @author Madison Schlaff
* @version 1.0
*/

public class Singer extends BandMember {
    /**
    * Range enum.
    */
    public enum Range { BASS, BARITONE, TENOR, ALTO, SOPRANO };
    private Range range;

    /**
    * Constructor for singers.
    * @param n name.
    * @param t talent.
    * @param r range.
    */
    public Singer(String n, int t, Range r) {
        //constructor for a singer
        super(n, t);
        range = r;
    }

    /**
    * Perform method.
    * Score value is random # from 1-10.
    * 10% chance to double score.
    * If score < 5 voice cracks, else sang their heart out.
    * @return returns singer's score.
    */
    public int perform() {
        Random gen = new Random();
        int score = gen.nextInt(10) + 1;
        int doubleScore = gen.nextInt(10);
        if (doubleScore == 1) {
            score = score * 2;
        }
        if (score < 5) {
            System.out.println(memberName
                + "'s voice cracked in the middle of their performance! Score: " + score + "/10");
        } else {
            System.out.println(memberName
                + " sang their heart out! Score: " + score + "/10");
        }
        return score;
    }

    /**
    * Print statement for singers. Prints name, talent, and specialty.
    * @return returns print string.
    */
    public String toString() {
        String print = memberName + ": " + talent + "/5 " + range;
        return print;
    }

    /**
    * Two singers are equal if they have same name, talent, and specialty.
    * If compared to nonsinger return false.
    * @param o object to compare to.
    * @return returns true or false if equal.
    */
    public boolean equals(Object o) {
        Singer sing;
        if (o instanceof Singer) {
            sing = (Singer) o;
            if ((this.memberName == sing.memberName)
                && (this.talent == sing.talent) && (this.range == sing.range)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    /**
    * Gets singer range.
    * @return returns range.
    */
    public Range getRange() {
        return range;
    }
}
