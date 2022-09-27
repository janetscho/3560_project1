
public class Student {

	String id;
	String answer; // a, b, c, d, right, wrong

	public Student() {
		this.id = "";
		this.answer = "";
	}

	public Student(String id, String answer) {
		this.id = id;
		this.answer = answer;
	}

	// setters
	public void setId(String id) {
		this.id = id;
	}

	public void setAns(String answer) {
		this.answer = answer;
	}

	// getters
	public String getId() {
		return id;
	}

	public String getAns() {
		return answer;
	}

	// prints student with answer
	public String printAns() {
		return "Student: " + id + " Answer: " + answer;
	}

}
