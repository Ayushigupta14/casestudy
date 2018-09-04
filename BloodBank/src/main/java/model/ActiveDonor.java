package model;

public class ActiveDonor {
	
	private String name;
	private double age;
	private String gender;
	private String bloodGroup;
	private String mobile;
	private String city;
	private String state;
	
	
	public ActiveDonor()
	{
		
	}

	public ActiveDonor(String name,String mobile,double age, 
			String gender,String bloodGroup,String city,String state)
	{
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.bloodGroup=bloodGroup;
		this.mobile=mobile;
		this.city=city;
		this.state=state;
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
