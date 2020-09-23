import java.util.Scanner;

public class mainProgram {

	private static void buildTheElectionBeforeStart(Elections e1) {
		e1.addKalpi("Dizengoff 46 ,TLV", "Kalpi");
		e1.addKalpi("hertzel 52 ,TLV", "KalpiArmy");
		e1.addKalpi("igal alon 12 ,TLV", "KalpiCorona");
		e1.addKalpi("Balfur 66 ,TLV", "Kalpi");
		e1.addParty("Likud", "Right", 02, 1988);
		e1.addParty("Blue and White", "Center", 04, 2019);
		e1.addParty("Israel Beiteinu", "Right", 02, 1999);
		e1.addCitizen("Alon", 315764986, (e1.getYear() - 27), e1.getAllKalpis().get(0), false, 0);
		e1.addCitizen("Pini", 645788913, (e1.getYear() - 18), e1.getAllKalpis().get(1), false, 0);
		e1.addCitizen("Jenia", 210465782, (e1.getYear() - 26), e1.getAllKalpis().get(0), false, 0);
		e1.addCitizen("Anton", 312202458, (e1.getYear() - 30), e1.getAllKalpis().get(2), true, 10);
		e1.addCitizen("Anna", 205547849, (e1.getYear() - 35), e1.getAllKalpis().get(0), false, 0);
		e1.addCitizen("Michael", 645983214, (e1.getYear() - 22), e1.getAllKalpis().get(2), true, 8);
		e1.addCandidate("Benny Gantz", 312022584, 1959, e1.getAllKalpis().get(0), false, 0, e1.getAllParties().get(1));
		e1.addCandidate("Benjamin Netanyahu", 655321242, 1963, e1.getAllKalpis().get(2), true, 14,
				e1.getAllParties().get(0));
		e1.addCandidate("Yair Lapid", 312598762, 1963, e1.getAllKalpis().get(0), false, 0, e1.getAllParties().get(1));
		e1.addCandidate("Avigdor Lieberman", 369874562, 1958, e1.getAllKalpis().get(3), false, 0,
				e1.getAllParties().get(2));
		e1.addCandidate("Gideon Sa'ar", 220013467, 1966, e1.getAllKalpis().get(3), false, 0, e1.getAllParties().get(0));
		e1.addCandidate("Evgeny Sova", 365987641, 1980, e1.getAllKalpis().get(0), false, 0, e1.getAllParties().get(2));
	}

	public static int idCheck() {
		boolean flag = true;
		int temp = 0;
		do {
			System.out.println("Enter Citizen Id:");
			try {
				temp = Integer.parseInt(s.nextLine());
				String strTemp = Integer.toString(temp);
				if (strTemp.length() != 9) {
					throw new IndexOutOfBoundsException();
				}
				flag = false;
			} catch (NumberFormatException e) {
				System.out.println("Id can be Only With Digits, Try Again...");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("The id is not 9 digit number, Try Again...");
			}
		} while (flag);
		return temp;
	}

	private static int yearOfBirthCheck(int electionYear) {
		boolean flag = true;
		int temp = 0;
		do {
			System.out.println("Enter Year Of Birth:");
			try {
				temp = Integer.parseInt(s.nextLine());
				if (electionYear - temp < 18) {
					throw new IndexOutOfBoundsException();
				}
				flag = false;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Citizens cannot vote under age of 18, Try Again...");
			}
		} while (flag);
		return temp;
	}

	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome! \n Enter Election Date (MM YYYY)");
		Elections e1 = new Elections(s.nextInt(), s.nextInt());

		buildTheElectionBeforeStart(e1);

		boolean b = false;
		do {
			System.out.println("Please Enter Your Choice :");
			System.out.println(
					"1. Add Kalpi \n2. Add Citizen \n3. Add Party \n4. Add Citizen as a candidate of a party \n5. Show all Kalpis \n6. Show All Citizens \n7. Show all Parties \n8. Elections \n9. Show Election Results \n10.Exit!");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("choose Kalpi Type: \n 1. Regular Kalpi \n 2. Army Kalpi \n 3. Corona Kalpi");
				int kalpiChoice = s.nextInt();
				System.out.println("Enter Kalpi Address: ");
				s.nextLine();
				String kalpiAddress = s.nextLine();
				if (kalpiChoice == 1) {
					e1.addKalpi(kalpiAddress, "Kalpi");
					System.out.println("Regular Kalpi Added!");
				} else if (kalpiChoice == 2) {
					e1.addKalpi(kalpiAddress, "KalpiArmy");
					System.out.println("Army Kalpi Added!");
				} else if (kalpiChoice == 3) {
					e1.addKalpi(kalpiAddress, "KalpiCorona");
					System.out.println("Corona Kalpi Added!");
				}
				break;
			case 2:
				// add citizen
				System.out.println("Please Enter Citizen name:");
				s.nextLine();
				String citizenName = s.nextLine();
				int citizenId = idCheck();
				int citizenYearOfBirth = yearOfBirthCheck(e1.getYear());
				System.out.println("Is " + citizenName + " on quarantine(True/False)?");
				boolean citizenIsQuarantine = s.nextBoolean();
				System.out.println("Now we choose a kalpi:");
				int daysSick = 0;
				if (citizenIsQuarantine) {
					System.out.println("Please Enter how much days you are sick:");
					daysSick = s.nextInt();
					System.out.println("This Citizen can only vote at corona Kalpi. \nChoose a Corona Kalpi(by ID):");
					for (int i = 0; i < e1.getAllKalpis().size(); i++) {
						if (e1.getAllKalpis().get(i) instanceof KalpiCorona) {
							System.out.println("Kalpi Corona id: " + e1.getAllKalpis().get(i).getId() + ", Address: "
									+ e1.getAllKalpis().get(i).getAddress());
						}
					}
				} else if (e1.checkAge(citizenYearOfBirth)) {
					System.out.println(
							"This citizen is a soldier and can only vote at Army Kalpi. \nChoose a Army Kalpi(By ID):");
					for (int i = 0; i < e1.getAllKalpis().size(); i++) {
						if (e1.getAllKalpis().get(i) instanceof KalpiArmy) {
							System.out.println("Kalpi Army id: " + e1.getAllKalpis().get(i).getId() + ", Address: "
									+ e1.getAllKalpis().get(i).getAddress());
						}
					}
				} else {
					System.out.println("This citizen can vote at Regular Kalpi. \nChoose a regular Kalpi(By ID):");
					for (int i = 0; i < e1.getAllKalpis().size(); i++) {
							if (e1.getAllKalpis().get(i).getClass().getName() == "Kalpi") {
								System.out.println("Kalpi Regular id: " + e1.getAllKalpis().get(i).getId()
										+ ", Address: " + e1.getAllKalpis().get(i).getAddress());
							}
					}
				}

				int kalpiId = s.nextInt();
				for (int i = 0; i < e1.getAllKalpis().size(); i++) {
						if (e1.getAllKalpis().get(i).getId() == kalpiId) {
							if (e1.addCitizen(citizenName, citizenId, citizenYearOfBirth, e1.getAllKalpis().get(i),
									citizenIsQuarantine, daysSick)) {
								System.out.println("Citizen Added!");
								break;
							} else {
								System.out.println("Citizens cannot  be with the same ID!");
							}
					}
				}
				break;
			case 3:
				System.out.println("Please Enter Party name:");
				s.nextLine();
				String name = s.nextLine();
				System.out.println("Enter Party Section:");
				String sec = s.nextLine();
				System.out.println("Enter party Creation date(MM YYYY) : ");
				e1.addParty(name, sec, s.nextInt(), s.nextInt());
				System.out.println("Party Added");
				break;
			case 4:
				// add party member
				System.out.println("Please Enter candidate name:");
				s.nextLine();
				String candidateName = s.nextLine();
				int candidateId = idCheck();
				int candidateyearOfBirth = yearOfBirthCheck(e1.getYear());
				System.out.println("Is " + candidateName + " on quarantine(True/False)?");
				boolean candidateIsQuarantine = s.nextBoolean();
				System.out.println("Now we choose a kalpi:");
				int daysSick2 = 0;
				if (candidateIsQuarantine) {
					System.out.println("Please Enter how much days you are sick:");
					daysSick2 = s.nextInt();
					System.out.println("This candidate can only vote at corona Kalpi. \nChoose a Corona Kalpi(by ID):");
					for (int i = 0; i < e1.getAllKalpis().size(); i++) {
						if (e1.getAllKalpis().get(i) instanceof KalpiCorona) {
							System.out.println("Kalpi Corona id: " + e1.getAllKalpis().get(i).getId() + ", Address: "
									+ e1.getAllKalpis().get(i).getAddress());
						}
					}
				} else if (e1.checkAge(candidateyearOfBirth)) {
					System.out.println(
							"This candidate is a soldier and can only vote at Army Kalpi. \nChoose a Army Kalpi(By ID):");
					for (int i = 0; i < e1.getAllKalpis().size(); i++) {
						if (e1.getAllKalpis().get(i) instanceof KalpiArmy) {
							System.out.println("Kalpi Army id: " + e1.getAllKalpis().get(i).getId() + ", Address: "
									+ e1.getAllKalpis().get(i).getAddress());
						}
					}
				} else {
					System.out.println("This candidate can vote at Regular Kalpi. \nChoose a regular Kalpi(By ID):");
					for (int i = 0; i < e1.getAllKalpis().size(); i++) {
							if (e1.getAllKalpis().get(i).getClass().getName() == "Kalpi") {
								System.out.println("Kalpi Regular id: " + e1.getAllKalpis().get(i).getId()
										+ ", Address: " + e1.getAllKalpis().get(i).getAddress());
							}
					}
				}

				int candidateKalpiId = s.nextInt();
				for (int i = 0; i < e1.getAllKalpis().size(); i++) {
						if (e1.getAllKalpis().get(i).getId() == candidateKalpiId) {
							System.out.println("Choose Candidates Party(By Name): ");
							for (int j = 0; j < e1.getAllParties().size(); j++) {
									System.out.println((j + 1) + ". " + e1.getAllParties().get(j).getName());
							}
							s.nextLine();
							String partyName = s.nextLine();
							for (int k = 0; k < e1.getAllParties().size(); k++) {

									if (e1.getAllParties().get(k).getName().equalsIgnoreCase(partyName)) {
										if (!e1.addCandidate(candidateName, candidateId, candidateyearOfBirth,
												e1.getAllKalpis().get(i), candidateIsQuarantine, daysSick2,
												e1.getAllParties().get(k))) {
											System.out.println("this citizen is already a party candidate!!");
											break;
										} else
											System.out.println(candidateName + " is now candidate of party "
													+ e1.getAllParties().get(k).getName() + "!");
										System.out.println("Candidate Added!");
									}
								}
							
						}
				}
				break;
			case 5:
				// show all ballotBox
				System.out.println("The Kalpis Are:");
				for (int i = 0; i <= e1.getAllKalpis().size() - 1; i++) {
					if (e1.getAllKalpis().get(i) != null) {
						System.out.println((i + 1) + ". " + e1.getAllKalpis().get(i).toString());
					}
				}
				break;
			case 6:
				// show all citizens
				if (!e1.getAllCitizens().isEmpty()) {
					for (int i = 0; i < e1.getAllCitizens().size(); i++) {				
						System.out.println((i + 1) + ". " + e1.getAllCitizens().get(i).toString());
						continue;
					}
				} else {
					System.out.println("there are no Citizens!!!");
				}

				System.out.println();
				break;
			case 7:
				// show all parties
				System.out.println("The Parties Are:");
				for (int i = 0; i <= e1.getAllParties().size() - 1; i++) {
					if (e1.getAllParties().get(i) != null) {
						System.out.println((i + 1) + ". " + e1.getAllParties().get(i).toString());
					}
				}
				System.out.println();
				break;
			case 8:
				// Election check if the citizen wants to vote if yes he need to choose a party
				// and update the kalpi associated
				System.out.println("Election!! , Lets start Voting");
				e1.doubleTheListForVotesForAllKalpis();
				for (int i = 0; i < e1.getAllCitizens().size(); i++) {
					if (true) {
						System.out.println(e1.getAllCitizens().get(i).getName() + " , do u want to vote(Y / N) ?");
						char ifWatnsToVote = s.next().charAt(0);
						if (ifWatnsToVote == 'n' || ifWatnsToVote == 'N') {
							continue;
						} else if (ifWatnsToVote == 'y' || ifWatnsToVote == 'Y') {
							System.out.println("OK , Enter The party name you want to vote to:");
							for (int j = 0; j < e1.getAllParties().size(); j++) {
								if (!e1.getAllParties().isEmpty()) {
									System.out.println("Party " + e1.getAllParties().get(j).getName() + ", Lead By "
											+ e1.getAllParties().get(j).getCandidates().get(0).getName());
								}
							}
							s.nextLine();
							String partyVoted = s.nextLine();
							for (int k = 0; k < e1.getAllParties().size(); k++) {
									if (e1.getAllParties().get(k).getName().equalsIgnoreCase(partyVoted)) {
										e1.vote(e1.getAllCitizens().get(i), e1.getAllParties().get(k));
										System.out.println(e1.getAllCitizens().get(i).getName() + " has Voted!!!");
									}
							}
						} else {

							System.out.println("Entered wrong input so its a no!");
						}
						System.out.println();
					}
				}
				System.out.println("Elections Finished!!!");
				break;
			case 9:
				// before choosing 9 , must first choose option 8 to start the Election.
				// show Election result
				System.out.println(e1.toString());

				break;
			case 10:
				// Exit program
				System.out.println("Good Bye!!");
				b = true;
				break;
			}
		} while (!b);
		s.close();
	}

}
