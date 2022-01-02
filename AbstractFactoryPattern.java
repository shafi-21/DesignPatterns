import java.util.*;
import java.io.*;

interface User {
	void fillUser();
}

class Admin implements User{
	public void fillUser(){
		System.out.println("Admin");
	}
}

class Player implements User{
	public void fillUser(){
		System.out.println("Player");
	}	
	
	public void buddyPair(){
		System.out.println("Pairing with Buddy...");
	}
}

class Moderator implements User{
	public void fillUser(){
		System.out.println("Moderator");
	}	
}

interface AbstractUserFactory{
	
	abstract User getUser(String userType);
	
}

class PriviledgedUserFactory implements AbstractUserFactory{
	
	public User getUser(String userType){
	
	  if(userType == null){
         return null;
      }	
	  
      if(userType.equalsIgnoreCase("Admin")){
         return new Admin();
         
      } else if(userType.equalsIgnoreCase("Moderator")){
         return new Moderator();
      }
      
      return null;
	}
}

class NonPriviledgedUserFactory implements AbstractUserFactory{
	
	public User getUser(String userType){
	
	  if(userType == null){
         return null;
      }		
      if(userType.equalsIgnoreCase("Player")){
         return new Player();
      }
	  
      return null;
	}
}

class PriviledgeFactoryProducer{
	public static AbstractUserFactory getPriviledgedFactory(boolean priviledged){
		if (priviledged){
			return new PriviledgedUserFactory();
		}
		else{
			return new NonPriviledgedUserFactory();
		}
	}
}

class AbstractFactoryPattern{
	
	public static void main(String[] args) {
		AbstractUserFactory abstractUserFactory = PriviledgeFactoryProducer.getPriviledgedFactory(false);
		
		User player1 = abstractUserFactory.getUser("Player");
		player1.fillUser();
		
		User player2 = abstractUserFactory.getUser("Player");
		
		((Player)player1).buddyPair();
		
		System.out.println(player1.equals(player2));

		/*AbstractUserFactory abstractUserFactory = PriviledgeFactoryProducer.getPriviledgedFactory(true);
		
		User admin = userFactory.getUser("Admin");
		admin.fillUser();
		
		User moderator = userFactory.getUser("Moderator");
		moderator.fillUser();*/
    }
}