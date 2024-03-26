/**
* Class for an abstract BandMember object.
* @author Madison Schlaff
* @version 1.0
*/

public abstract class BandMember {
    protected String memberName;
    protected int talent;

    /**
    * Constructor for band members.
    * if talent is over 5, talent = 5, if talent is under 1, talent = 1, else talent = t.
    * @param n name
    * @param t talent
    */
    public BandMember(String n, int t) {
        memberName = n;
        if (t > 5) {
            talent = 5;
        } else if (t < 1) {
            talent = 1;
        } else {
            talent = t;
        }
    }

    /**
    * Abstract method for perform.
    * @return returns score int.
    */
    public abstract int perform();

    /**
    * Tostring method that prints name and talent out of 5.
    * @return returns string of name and talent.
    */
    public String toString() {
        String print = memberName + ": " + talent + "/5";
        return print;
    }

    /**
    * Two band members are equal if they have the same name and talent.
    * @param o object to compare to.
    * @return returns true or false if equal.
    */
    public boolean equals(Object o) {
        BandMember bm;
        if (o instanceof BandMember) {
            bm = (BandMember) o;
            if ((this.memberName == bm.memberName) && (this.talent == bm.talent)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    /**
    * Get band member's name.
    * @return returns members name.
    */
    public String getName() {
        return memberName;
    }

    /**
    * Sets member's talent.
    * @param t talent int.
    */
    public void setTalent(int t) {
        talent = t;
    }
}
