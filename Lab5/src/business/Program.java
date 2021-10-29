package business;

public class Program {
	private String id, name;
	private int crHrs, seats;
	
	public Program(String id, String name, int crHrs, int seats) {
		this.id = id;
		this.name = name;
		this.crHrs = crHrs;
		this.seats = seats;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCrHrs() {
		return crHrs;
	}
	public void setCrHrs(int chHrs) {
		this.crHrs = chHrs;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String toString() {
		return String.format("Program [id=%s, name=%s, crHrs=%d, seats=%d]",
				this.getId(),
				this.getName(),
				this.getCrHrs(),
				this.getSeats());
	}
	
	
}
