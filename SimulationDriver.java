import java.util.Random;

//use math.random to generate a random 10 

public class SimulationDriver {

	static String abcd = "ABCD";
	static String tf = "TF";

	public static void main(String[] args) {
		int numStd = (int) (Math.random() * (20 - 10)) + 10; // between 10 - 20 students
		int qst = (int) (Math.random() * (10 - 5)) + 5; // between 5 - 10 questions because that's a lot of answers

		System.out.println("There are " + numStd + " students.");
		System.out.println("There are " + qst + " questions.");

		boolean options = false;

		Question question = new Question(options, "Yes");
		int choices;
		String yup;

		if (options == true) {
			choices = (int) (Math.random() * (4 - 1)) + 1; // between 1 to 4 choices
			yup = "ABCD";
		} else {
			choices = 1;
			yup = "TF";
		}

		Student[] studs = new Student[numStd];

		for (int i = 0; i < numStd; i++) {
			String id = randomId();
			String answer = generate(choices, yup);
			studs[i] = new Student(id, answer);
		}

		setUp(studs);

		VotingService vote = new VotingService(studs);
		vote.increment();
	}

	public static String generate(int choices, String choice) {
		// choice = ABCD or TF
		// choices = 1 to 4

		Random rand = new Random();
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < choices; i++) {
			int rando = rand.nextInt(choice.length());
			build.append(choice.charAt(rando));
		}
		return build.toString();
	}

	public static void setUp(Student[] studs) {
		System.out.println("List of ID numbers: ");
		for (int i = 0; i < studs.length; i++) {
			System.out.print("#" + (i + 1));
			String ran = randomId();
			studs[i].setId(ran); // setting ID for each student
			System.out.print(" " + ran + " answered " + studs[i].getAns() + ".\n");
		}
	}

	public static String randomId() {
		String ran = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

		Random rand = new Random();
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int rando = rand.nextInt(ran.length());
			build.append(ran.charAt(rando));
		}
		return build.toString();
	} // generates random ID numbers 10 digits long

	public static boolean randomOptions() {
		int i = (int) (Math.random() * (2 - 1) + 1);
		if (i == 1)
			return true;
		else
			return false;
	}
}
