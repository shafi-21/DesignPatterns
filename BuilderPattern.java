import java.util.*;
import java.io.*;

interface Sport{
	String sportType();
	Facility getFacilities();
	float price();
	String sportName();
}

interface Facility{
	String type();
	float addPrice();
}

class Lights implements Facility{
	public String type(){
		return "Lights";
	}
	
	public float addPrice(){
		return 200.0f;
	}
}

class RestRoom implements Facility{
	public String type(){
		return "Rest room";
	}
	
	public float addPrice(){
		return 300.0f;
	}
}

abstract class Indoor implements Sport{
	public String sportType(){
		return "Indoor";
	} 
	
	public Facility getFacilities(){
		return new Lights();
	}
	
	public float price(){
		return 400.0f;
	}
	
	public abstract String sportName();
}

abstract class Outdoor implements Sport{
	
	public String sportType(){
		return "Outdoor";
	}

	public Facility getFacilities(){
		return new RestRoom();
	}	
	
	public float price(){
		return 350.0f;
	}
	
	public abstract String sportName();
}

class Badminton extends Indoor{
	
	public String sportName(){
		return "Badminton";
	}
	
	public float price(){
		return super.price() + 300.0f;
	}
}

class Volleyball extends Indoor{
	
	public String sportName(){
		return "Volleyball";
	}
	
	public float price(){
		return super.price() + 500.0f;
	}
}

class Basketball extends Outdoor{
	
	public String sportName(){
		return "Basketball";
	}
	
	public float price(){
		return super.price() + 300.0f;
	}
}

class Cricket extends Outdoor{
	
	public String sportName(){
		return "Cricket";
	}
	
	public float price(){
		return super.price() + 2000.0f;
	}
}

class ReserveCourt {
   private List<Sport> sports = new ArrayList<Sport>();	

   public void addSport(Sport sport){
      sports.add(sport);
   }

   public float getCost(){
      float cost = 0.0f;
      
      for (Sport sport : sports) {
         cost += sport.price();
      }		
      return cost;
   }

   public void showSports(){
   
      for (Sport sport : sports) {
         System.out.print("Sport : " + sport.sportName());
         System.out.print(", Facility : " + sport.getFacilities().type());
		 float totalPrice = sport.price() + sport.getFacilities().addPrice();
         System.out.println(", Price : " + totalPrice);
      }		
   }	
}

class ReserveCourtBuilder {

   public ReserveCourt createIndoorCourt (){
      ReserveCourt court = new ReserveCourt();
      court.addSport(new Badminton());
      court.addSport(new Volleyball());
      return court;
   }   

   /*public ReserveCourt createOutdoorCourt (){
      ReserveCourt court = new ReserveCourt();
      court.addSport(new Basketball());
      court.addSport(new Cricket());
      return court;
   }*/
}

class BuilderPattern{
	
	public static void main(String[] args) {
   
      ReserveCourtBuilder courtBuilder = new ReserveCourtBuilder();

      ReserveCourtBuilder indoorSports = courtBuilder.createIndoorCourt();
      System.out.println("Indoor Sports");
      indoorSports.showSports();
      System.out.println("Total Cost: " + indoorSports.getCost());

	  /*ReserveCourtBuilder outdoorSports = courtBuilder.createOutdoorCourt();
      System.out.println("Outdoor Sports");
      outdoorSports.showSports();
      System.out.println("Total Cost: " + outdoorSports.getCost());*/
   }
}