package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities;


public class User {


	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	
	public User() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void set(User user) {
		this.setEmail(user.getEmail() != null ? user.getEmail() : this.getEmail());
		this.setFirstName(user.getFirstName() != null ? user.getFirstName() : this.getFirstName());
		this.setLastName(user.getLastName() != null ? user.getLastName() : this.getLastName());
		this.setPassword(user.getPassword() != null ? user.getPassword() : this.getPassword());
		this.setPhoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber() : this.getPhoneNumber());
		this.setUsername(user.getUsername() != null ? user.getUsername() : this.getUsername());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User temp = (User) obj;
			return this.id == temp.id;
		}
		return false;
	}
	
	
	
	
}
