
public class Question {

	static boolean multiple; // true if multiple ans, false if only one answer
	String question;

	public Question(boolean multiple, String question) {
		this.multiple = multiple;
		this.question = question;
	} // end constructor

	// setters
	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	// getters
	public static boolean getMultiple() {
		return multiple;
	}

	public String getQuestion() {
		return question;
	}

	// print for user
	public String toString() {
		if (multiple == true) {
			return "Please select 1 or more answers between A, B, C, or D.";
		} else
			return "Please select only 1 answer between T or F.";
	}

}
