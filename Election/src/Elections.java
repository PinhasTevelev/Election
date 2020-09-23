import java.util.ArrayList;

public class Elections {
	private ArrayList<Citizen> allCitizens;
	private ArrayList<Kalpi> allKalpis;
	private ArrayList<Party> allParties;
	private int year;
	private int month;

	public Elections(int month, int year) {
		this.month = month;
		this.year = year;
		this.allKalpis = new ArrayList<Kalpi>();
		this.allParties = new ArrayList<Party>();
		this.allCitizens = new ArrayList<Citizen>();
	}

	public boolean addParty(String name, String section, int y, int m) {
		allParties.add(new Party(name, section, m, y));
		return true;
	}

	public boolean addCitizen(String name, int id, int yearOfBirth, Kalpi kal, boolean isQuarantine, int daysSick) {
		if (!allCitizens.isEmpty()) {
			for (int i = 0; i < allCitizens.size(); i++) {
				if (allCitizens.get(i).getId() == id) {
					return false;
				}
			}
		}
			allCitizens.add(new Citizen(name, id, yearOfBirth, kal, isQuarantine, daysSick, null));
			kal.addCitizentoKalpi(allCitizens.get(allCitizens.size() - 1));
		return true;
	}

	public boolean addCandidate(String name, int id, int yearOfBirth, Kalpi kal, boolean isQuarantine, int daysSick,
			Party pmember) {
		if (!allCitizens.isEmpty()) {
			for (int i = 0; i < allCitizens.size(); i++) {
				if (allCitizens.get(i).getId() == id) {
					return false;
				}
			}
		} 
			allCitizens.add(new Citizen(name, id, yearOfBirth, kal, isQuarantine, daysSick, pmember));
			pmember.addCandidatetoParty(allCitizens.get(allCitizens.size() - 1));
			kal.addCitizentoKalpi(allCitizens.get(allCitizens.size() - 1));
		return true;
	}

	public boolean addKalpi(String Address, String kalpiType) {
		if (kalpiType.equals("Kalpi")) {
			allKalpis.add(new Kalpi(Address));
			return true;
		} else if (kalpiType.equals("KalpiCorona")) {
			allKalpis.add(new KalpiCorona(Address));
			return true;
		} else if (kalpiType.equals("KalpiArmy")) {
			allKalpis.add(new KalpiArmy(Address));
			return true;
		} else
			return false;
	}

	private int getVotesPerPartyInAllKalpis(int partyPlace) {
		int result = 0;
		for (int i = 0; i < allKalpis.size(); i++) {
			if (allKalpis.get(i) != null) {
				result = result + allKalpis.get(i).getNumOfVotersPehrParty(partyPlace);
			}
		}
		return result;
	}

	public void doubleTheListForVotesForAllKalpis() {
		for (int i = 0; i < allKalpis.size(); i++) {
			if (allKalpis.get(i) != null) {
				allKalpis.get(i).doubleTheListForVotes(allParties.size());
			}
		}
	}

	public boolean checkAge(int yearOfBirth) {
		int age = year - yearOfBirth;
		if (age > 17 && age < 22) {
			return true;
		}
		return false;
	}

	public void vote(Citizen c, Party p) {
		for (int i = 0; i < allKalpis.size(); i++) {
				if (allKalpis.get(i).equals(c.getKalpi())) {
					for (int j = 0; j < allParties.size(); j++) {
							if (allParties.get(j).equals(p)) {
								allKalpis.get(i).voteToParty(j);
								continue;
							}
					}
				}
		}
	}

	public Party findWhoWon() {
		int index = 0;
		int temp = 0;
		for (int i = 0; i < allParties.size(); i++) {
				if (getVotesPerPartyInAllKalpis(i) > temp) {
					temp = getVotesPerPartyInAllKalpis(i);
					index = i;
				}
		}

		for (int i = 0; i < allParties.size(); i++) {

				if (i != index) {
					if (getVotesPerPartyInAllKalpis(i) == getVotesPerPartyInAllKalpis(index)) {
						return null;
					}
				}
		}
		return allParties.get(index);
	}

	public int getYear() {
		return year;
	}

	public ArrayList<Kalpi> getAllKalpis() {
		return this.allKalpis;
	}

	public ArrayList<Party> getAllParties() {
		return allParties;
	}

	public ArrayList<Citizen> getAllCitizens() {
		return allCitizens;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("Election date " + month + "/" + year + "\n");
		for (int i = 0; i < allKalpis.size(); i++) {
			if (allKalpis.get(i) != null) {
				sb.append("in Kalpi Number " + allKalpis.get(i).getId() + " Voted " + allKalpis.get(i).percentageOfVoters()
						+ "% . \n");
				for (int j = 0; j < allParties.size(); j++) {
					if (allParties.get(j) != null) {
						sb.append("Party " + allParties.get(j).getName() + " got " + allKalpis.get(i).getVotesPerParty(j)
								+ " votes. \n");
					}
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
		sb.append("Results from all Kalpis:\n \n");
		for (int i = 0; i < allParties.size(); i++) {
			if (allParties.get(i) != null) {
				sb.append("Party " + allParties.get(i).getName() + " got " + getVotesPerPartyInAllKalpis(i) + " votes.\n");
			}
		}
		if (findWhoWon() != null) {
			sb.append("The Winner of this Election is " + findWhoWon().getName() + ".\n");
		} else {
			sb.append("There is no Winner on This Election!!!");
		}
		return sb.toString();
	}

}
