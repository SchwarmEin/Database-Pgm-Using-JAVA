package business;

public class Student {
	private String program, course;
	private int stID, semester;
	//public final static int STID_SIZE = 10, PRGM_SIZE = 5, COS_SIZE = 2;
	
	// STID_SIZE is 4 because it's an integer
	// PRGM_SIZE is 3 because ProgramList.txt has ITC and ITE
	// COS_SIZE is 14 because C1,C2,C3,C4,C5 = 14 characters
	public final static int STID_SIZE = 4, SEM_SIZE = 4, PRGM_SIZE = 3, COS_SIZE = 14; 
	public final static int REC_SIZE = (PRGM_SIZE + COS_SIZE) * 2 + STID_SIZE + SEM_SIZE;
	
	public int getStID() {
		return stID;
	}
	
	public void setStID(int stID) {
		this.stID = stID;
	}
	
	public String getProgram() {
		return program;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		
		// pad the course
		if (course.length() < COS_SIZE)
			this.course = String.format("%1$"+COS_SIZE+ "s", course);
		else
			this.course = course;
		
	}
	
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public int getSTID_SIZE() {
		return STID_SIZE;
	}
	
	public int getPRGM_SIZE() {
		return PRGM_SIZE;
	}
	
	public int getCOS_SIZE() {
		return COS_SIZE;
	}
	
	public int getREC_SIZE() {
		return REC_SIZE;
	}
	
	public String toString() {
		return String.format("%s, %s, (%s), %d", this.stID, this.program, this.course.trim(), this.semester); 
	}
	
	public Student(int stID, String program, String course, int semester) {
		super();
		this.stID = stID;
		this.program = program;
		
		//pad the course
		if (course.length() < COS_SIZE)
			this.course = String.format("%1$"+COS_SIZE+ "s", course);
		else
			this.course = course;
		
		this.semester = semester;
	}
	
	public Student() {

	}
	
}
