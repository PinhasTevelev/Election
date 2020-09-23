
public class Citizen {
	private String name;
	private int id;
	private int yearOfBirth;
	boolean isQuarantine;
	private Kalpi kalpi;
	private Party partyVoted;
	int daysSick;

	private Party partyMember;
	
	public Citizen(String name, int id, int yearOfBirth, Kalpi kalpi, boolean isQuarantine ,int daysSick, Party partyMember) {
		this.name = name;
		this.id = id;
		this.yearOfBirth = yearOfBirth;
		this.kalpi = kalpi;
		this.isQuarantine = isQuarantine;
		this.daysSick = daysSick;
		
		if (partyMember != null)
		{
			this.partyMember = partyMember;
		}
	}

	

	public boolean equals(Citizen c) {
		if (this.getId() == c.getId()) {
			return true;
		}
		return false;
	}

	public void setPartyeVoted(Party partyeVoted) {
		this.partyVoted = partyeVoted;
	}

	public String getName() {
		return name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public Kalpi getKalpi() {
		return kalpi;
	}

	public boolean isQuarantine() {
		return isQuarantine;
	}

	public Object getPartyVoted() {
		return this.partyVoted;
	}

	public int getId() {
		return this.id;
	}

	public String toString() {
		String prefix = "Citizen Name: ";
		if (partyMember != null)
			prefix = "Candidate Name: ";
		
		StringBuffer sb = new StringBuffer(prefix + name + ", ID: " + id + ", YearOfBirth: " + yearOfBirth
				+ ", assigned to kalpi " + kalpi.getId() + ", ");
		if (isQuarantine) {
			sb.append("is quarantined ");

		} else {
			sb.append("is not quarantined ");
		}
		
		if (partyMember != null)
		{
			String suffix = " Member of party: " + partyMember.getName();
			sb.append(suffix);
		}		
		
		return sb.toString();
	}

	public Party getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(Party partyMember) {
		this.partyMember = partyMember;
	}
}
