package model;

public class Patient {
	
	
	private String name;
	private String mobile;
	private String city;
	private String state;
	private String password;
	
	public Patient()
	{
		
	}
	
	public Patient( String name,String mobile,String city,
			String state, String password)
	{
		
		this.name=name;
		this.mobile=mobile;
		this.password=password;
		this.city=city;
		this.state=state;
		
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
	
	

}
