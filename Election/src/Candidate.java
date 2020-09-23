
public class Candidate {
	public Citizen me;
	public Candidate(String name, int id, int yearOfBirth, Kalpi kalpi, boolean isQuarantine , int daysSick, Party pmember) {
		me = new Citizen(name, id, yearOfBirth, kalpi, isQuarantine, daysSick, null);
	}
}
