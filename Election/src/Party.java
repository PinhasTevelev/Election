import java.util.ArrayList;

public class Party {
	private String name;
	private String section;
	private int year;
	private int month;
	private ArrayList<Citizen> candidates;

	public Party(String name, String section, int month, int year) {
		this.name = name;
		this.section = section;
		this.year = year;
		this.month = month;
		candidates = new ArrayList<Citizen>();
	}

	public boolean checkIfCandidateInParty(int id) {
		for (int i = 0; i < candidates.size(); i++) {
			if (candidates.get(i) != null) {
				if (candidates.get(i).getId() == id) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean addCandidatetoParty(Citizen c) {
		candidates.add(c);
		return true;
	}

	public String getSection() {
		return section;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public ArrayList<Citizen> getCandidates() {
		return candidates;
	}

	public String getName() {
		return this.name;
	}

	public boolean equals(Party p) {
		if (this.name.equals(p.getName())) {
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("Party " + name + ", Wing: " + section + ", created in  " + month + "/"
				+ year + "\nThe Candidates are: \n");
		for (int i = 0; i < candidates.size(); i++) {
			if (candidates.get(i) != null) {
				sb.append((i + 1) + ". " + candidates.get(i).toString() + "\n");
			}
		}
		return sb.toString();
	}

}
