import java.util.Random;

/**
* Class for a Guitarist object.
* @author Madison Schlaff
* @version 1.0
*/

public class Guitarist extends BandMember {
    /**
    * Specialty enum.
    */
    public enum Specialty { ACOUSTIC, ELECTRIC };
    private Specialty specialization;

    /**
    * Constructor for guitarists.
    * @param n name.
    * @param t talent.
    * @param s specialty.
    */
    public Guitarist(String n, int t, Specialty s) {
        //constructor for a guitarist
        super(n, t);
        specialization = s;
    }

    /**
    * Perform method.
    * Score value is random # from 1-10.
    * Add talent to score.
    * 30% chance to add talent to score again.
    * if score < 5 fingers slipped, else captured attention.
    * @return returns guitarist's score.
    */
    public int perform() {
        Random gen = new Random();
        int score = gen.nextInt(10) + 1;
        score += talent;
        int doubleScore = gen.nextInt(10);
        if (doubleScore <= 2) {
            score += talent;
        }
        if (score < 5) {
            System.out.println(memberName
                + "'s fingers slipped and hit the wrong note! Score: " + score + "/10");
        } else {
            System.out.println(memberName
                + " captured everyone's attention! Score: " + score + "/10");
        }
        return score;
    }

    /**
    * Print statement for guitarists. Prints name, talent, and specialty.
    * @return returns print string.
    */
    public String toString() {
        String print = memberName + ": " + talent + "/5 " + specialization;
        return print;
    }

    /**
    * Two guitarists are equal if they have same name, talent, and specialty.
    * @param o object to compare to.
    * @return returns true or false if equal.
    */
    public boolean equals(Object o) {
        Guitarist gt;
        if (o instanceof Guitarist) {
            gt = (Guitarist) o;
            if ((this.memberName == gt.memberName)
                && (this.talent == gt.talent) && (this.specialization == gt.specialization)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    /**
    * Gets band genre.
    * @return returns genre.
    */
    public Specialty getSpecialty() {
        return specialization;
    }
}
