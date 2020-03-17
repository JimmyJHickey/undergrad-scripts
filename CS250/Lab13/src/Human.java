public class Human extends Mammal {

    protected long ssn;

    public Human (long s) {
	ssn = s;
    }

    public long getSSN() {
	return ssn;
    }


    public String toString() {
	return "I am a human with " + hairColor + " hair color and SSN " +
	    ssn;
    }
}
