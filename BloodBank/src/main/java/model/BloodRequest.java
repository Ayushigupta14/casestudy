package model;

public class BloodRequest {
	
	
	private String name;
	private String mobile;
	private String bloodGroup;
	
	private String city;
	private String state;
	
	
	public BloodRequest()
	{
		
	}
	public BloodRequest(String name,String mobile,
			String bloodGroup,String city,String state)
	{
		
		this.name=name;
		this.mobile=mobile;
		this.bloodGroup=bloodGroup;
		this.city=city;
		this.state=state;
	
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

	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
