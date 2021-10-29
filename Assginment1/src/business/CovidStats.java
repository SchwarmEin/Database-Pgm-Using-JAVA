package business;

public class CovidStats {
	
	private String Date, City, NumCase, NumDeath, NumRec;

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		this.Date = date;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getNumCase() {
		return NumCase;
	}

	public void setNumCase(String numCase) {
		this.NumCase = numCase;
	}

	public String getNumDeath() {
		return NumDeath;
	}

	public void setNumDeath(String numDeath) {
		this.NumDeath = numDeath;
	}

	public String getNumRec() {
		return NumRec;
	}

	public void setNumRec(String numRec) {
		this.NumRec = numRec;
	}

	public CovidStats(String date, String city, String numCase, String numDeath, String numRec) {
		super();
		this.Date = date;
		this.City = city;
		this.NumCase = numCase;
		this.NumDeath = numDeath;
		this.NumRec = numRec;
	}

	public CovidStats() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Date=" + Date + ", City=" + City + ", NumCase=" + NumCase + ", NumDeath=" + NumDeath
				+ ", NumRec=" + NumRec;
	}
	
	
	


	
	


}
