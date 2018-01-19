package Control;


import dao.daoUsers;

public class LoginController {

	private boolean result = false;


	public boolean getResult(){
		return result;
	}

	public LoginController(String username,String password) throws Exception{
		result = login(username,password);
	}

	public boolean login(String username, String password) throws Exception{
		daoUsers db = new daoUsers();
		return db.checkUser(username,password);
	}

	public void signin(String username, String password) throws Exception{
		daoUsers db = new daoUsers();
		db.insertUser(username, password);
	}

}
