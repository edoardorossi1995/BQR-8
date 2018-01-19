package Bean;

import Control.LoginController;

public class UserBean {

	private boolean result = false;
	private String username;
	private String password;
	private String text;

	public UserBean(){}

	public void callLogin() throws Exception{
		LoginController log = new LoginController(username,password);
		this.result = log.getResult();
	}

	public void callSignin() throws Exception{
		LoginController log = new LoginController(username,password);
		if (log.getResult() == false){
			log.signin(username,password);
			text = "You have correctly signed at this site.\n"
					+ "Now you can access your new Account!";
		}
		else{
			text = "You already have an Account at this site.\n"
					+ "You can access your account!";

		}
	}

	public boolean getResult(){
		return result;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public String getText(){
		return text;
	}


	public void setUsername(String username){
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}


}
