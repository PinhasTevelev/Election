import java.util.ArrayList;

public class Kalpi {
	private static int count = 0;
	private String address;
	private int id;
	private ArrayList<Citizen> listOfCitizens;
	private int[] votesPerParty;

	public Kalpi(String address) {
		this.id = ++count;
		this.address = address;
		listOfCitizens = new ArrayList<Citizen>();
	}

	public boolean addCitizentoKalpi(Citizen c) {
		listOfCitizens.add(c);
		return true;
	}
	
	int getSizeOfArr()
	{
		return votesPerParty.length;
	}

	public int percentageOfVoters() {
		int count = 0;
		for (int i = 0; i < listOfCitizens.size(); i++) {
			if (listOfCitizens.get(i) != null) {
				count++;
			}
		}
		if(count !=0) {
		int howManyVoted = 0;
		for (int i = 0; i < getSizeOfArr(); i++) {
			howManyVoted = (howManyVoted + votesPerParty[i]);
		}
		int result = howManyVoted * 100 / count;
		return result;
		}
		else {
			return 0;
		}
	}

	public int getNumOfVotersPehrParty(int indexNum) {
		return votesPerParty[indexNum];
	}

	public void voteToParty(int indexOfParty) {
		votesPerParty[indexOfParty]++;
	}
	
	public void doubleTheListForVotes(int length) {
		votesPerParty = new int[length];
	}

	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public int getVotesPerParty(int  index) {
		return votesPerParty[index];
	}

	public boolean equals(Kalpi k) {
		if (this.id == k.getId()) {
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("Kalpi " + id + ", Address: " + address + "\n");
		if (listOfCitizens.isEmpty()) {
			sb.append("There are no Citizens assinged to this kalpi yet!! \n");
		} else {
			sb.append("The Citizens are: \n");
			for (int i = 0; i < listOfCitizens.size(); i++) {
				if (listOfCitizens.get(i) != null) {
					sb.append((i + 1) + "- " + listOfCitizens.get(i).toString() + "\n");
				}
			}
		}
		return sb.toString();
	}
}
