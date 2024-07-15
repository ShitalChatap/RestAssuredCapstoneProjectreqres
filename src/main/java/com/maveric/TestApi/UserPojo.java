package com.maveric.TestApi;

public class UserPojo 
{
    private String email,password;
    
 

	public String getEmail()
	{
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}


	public String getPassword() 
	{
		return password;
	}


	public void setPassword(String password)
	{
		this.password = password;
	}
	 @Override
		public String toString() 
		{
			return "UserPojo [email="+email+",password="+password+"]";
		}


}
