package business;

public class Person {
	
	public static int FIRSTNAME_SIZE = 20; //firstname is 20 character
	public static int LASTNAME_SIZE = 25; //lastname is 25 character
	public static int PHONE_SIZE = 10; //phone is 10 character
	public static int REC_SIZE = (Person.FIRSTNAME_SIZE + Person.LASTNAME_SIZE + Person.PHONE_SIZE) * 2 + 4; // 4 is the age
	
	private String firstName;
	private String lastName;
	private String phone;
	private int age;
	
	
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setFirstName(String f) {
		//this.firstName = f;
		
		if (f.length() < FIRSTNAME_SIZE)
			this.firstName = String.format("%1$"+FIRSTNAME_SIZE+ "s", f);
		else 
			this.firstName = f.substring(0, FIRSTNAME_SIZE);
	}
	
	public void setLastName(String l) {
		//this.lastName = l;
		
		if (l.length() < LASTNAME_SIZE)
			this.lastName =  String.format("%1$"+LASTNAME_SIZE+ "s",l);
		else
			this.lastName = l.substring(0, LASTNAME_SIZE);


	}
	
	public void setPhone(String p) {
		//this.phone = p;
		
		if (p.length() < PHONE_SIZE)
			this.phone = String.format("%1$"+PHONE_SIZE+ "s", p);
		else
			this.phone = p.substring(0, PHONE_SIZE);
	}
	
	public void setAge(int age) {
		this.age = age;
	}

}
