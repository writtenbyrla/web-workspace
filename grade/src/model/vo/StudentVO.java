package model.vo;

public class StudentVO {
	private int studentNumber;
	private String studentName;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	
	public StudentVO() {}

	public StudentVO(int studentNumber, String studentName, int koreanScore, int englishScore, int mathScore) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	@Override
	public String toString() {
		return "StudentVO [studentNumber=" + studentNumber + ", studentName=" + studentName + ", koreanScore="
				+ koreanScore + ", englishScore=" + englishScore + ", mathScore=" + mathScore + "]";
	}

}
