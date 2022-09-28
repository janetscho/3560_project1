import java.util.HashSet;
import java.util.Random;

//use math.random to generate a random 10 

public class SimulationDriver {

	static String abcd = "ABCD";
	static String tf = "TF";

	public static void main(String[] args) {
		int numStd = (int) (Math.random() * (21 - 10)) + 10; // between 10 - 20 students
		int qst = (int) (Math.random() * (11 - 5)) + 5; // between 5 - 10 questions because that's a lot of answers

		System.out.println("There are " + numStd + " students.");
		System.out.println("There are " + qst + " questions.");

		Random random = new Random();

		for (int go = 0; go < qst; go++) {
			System.out.println("\nQuestion #" + (go + 1));
			boolean options = random.nextBoolean(); // decides if multiple choice or t/f

			Question question = new Question(options, "Question");
			int choices; // holds the number of options
			String yup; // holds the answer options

			if (options == true) {
				choices = (int) (Math.random() * (5 - 1)) + 1; // between 1 to 4 choices
				yup = "ABCD";
			} else {
				choices = 1;
				yup = "TF";
			}
			System.out.println(question.toString());

			Student[] studs = new Student[numStd];

			for (int i = 0; i < numStd; i++) {
				String id = randomId();

				if (options == true)
					choices = (int) (Math.random() * (5 - 1)) + 1; // between 1 to 4 choices

				String answer = generate(choices, yup);
				studs[i] = new Student(id, answer);
			}

			setUp(studs);

			VotingService vote = new VotingService(studs);
			vote.increment();
		} // repeat a random amount of times
	} // end main

	public static String generate(int choices, String choice) {
		// choice = ABCD or TF
		// choices = 1 to 4

		Random rand = new Random();
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < choices; i++) {
			int rando = rand.nextInt(choice.length());
			build.append(choice.charAt(rando));
		}
		String ans = build.toString();
		HashSet<Character> remove = new HashSet<>();
		char[] strings = ans.toCharArray();
		for (char c : strings)
			remove.add(c);
		// removing duplicates since hashset don't allow duplicates

		ans = remove.toString();
		ans = ans.replace(",", "");
		ans = ans.replace(" ", "");
		ans = ans.replace("[", "");
		ans = ans.replace("]", "");
		// removing the unnecessary parts from the HashSet toString
		return ans;
	}

	public static void setUp(Student[] studs) {
		for (int i = 0; i < studs.length; i++) {
			System.out.print((i + 1) + " ");
			String ran = randomId();
			studs[i].setId(ran); // setting ID for each student
			System.out.println(studs[i].toString());
		}
	}

	public static String randomId() {
		String ran = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

		Random rand = new Random();
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int rando = rand.nextInt(ran.length());
			build.append(ran.charAt(rando));
		} // adds character found at rand index in the String ran
		return build.toString();
	} // generates random ID numbers 10 digits long

}
