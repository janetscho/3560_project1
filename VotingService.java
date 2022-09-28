import java.util.HashMap;

//simply calculates the count for each answer
//can have simulation driver create a randomly generated amount of students, send that amount to voting service, have it count each answer i guess
//use amount of students to create an array to store if the student's answer for the quesiton was received

public class VotingService {
	Student[] studs;
	String[] ids; // to keep track of whether or not the student already voted

	HashMap<Character, Integer> count = new HashMap<Character, Integer>();

	public VotingService(Student[] studs) {
		this.studs = studs;
		ids = new String[studs.length];
	}

	public void increment() {
		String temp;
		for (int i = 0; i < studs.length; i++) {
			temp = studs[i].getAns();
			totalAnswers(temp);
		}

		System.out.println("\nTotal: ");
		count.entrySet().forEach(option -> {
			System.out.print(option.getKey() + ": " + option.getValue() + "\t");
		}); // prints results
		System.out.println();
	} // end increment

	public void totalAnswers(String ans) {
		// key: character, value: # of character

		char[] strings = ans.toCharArray();

		for (int i = 0; i < strings.length; i++) {
			char temp = strings[i];
			if (count.containsKey(temp))
				count.put(temp, count.get(temp) + 1);
			else
				count.put(temp, 1);
		} // increment through student answer; if it exists, increment. if it doesn't,
			// create new option
	} // end totalAnswers

}
