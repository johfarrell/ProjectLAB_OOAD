import java.util.*;

public class Main {
	static int roleID;
	Scanner sc = new Scanner(System.in);
	
	/*
	-1 = Human Resource
	-2 = Storage Manager
	-3 = Promo Manager
	-4 = Master Manager
	-5 = Cashier
	*/
	
	Connect connect;
	
	public Main() {
		// TODO Auto-generated constructor stub
		connect = Connect.getConnection();
		roleID = sc.nextInt();
		Login(roleID);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
		
	}
	
	public void Login (int a){
		String username;
		String password;
		username = sc.nextLine();
		password = sc.nextLine();
		
		if(a==1){
			
		}
	}
	

}
