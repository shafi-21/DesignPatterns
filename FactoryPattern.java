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

class UserFactory{
	
	public User getUser(String userType){
	
	  if(userType == null){
         return null;
      }	
	  
      if(userType.equalsIgnoreCase("Admin")){
         return new Admin();
         
      } else if(userType.equalsIgnoreCase("Moderator")){
         return new Moderator();
      }
	  else if(userType.equalsIgnoreCase("Player")){
         return new Player();
      }
      
      return null;
	}
}


class FactoryPattern{
	
	public static void main(String[] args) {
		UserFactory userFactory = new UserFactory();
		
		User player = userFactory.getUser("Player");
		player.fillUser();
		((Player)player).buddyPair();
		
		User admin = userFactory.getUser("Admin");
		admin.fillUser();
		
		User moderator = userFactory.getUser("Moderator");
		moderator.fillUser();
    }
}