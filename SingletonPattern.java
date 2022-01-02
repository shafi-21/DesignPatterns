import java.util.*;
import java.io.*;

class ArenaStats{
	private static ArenaStats arenaStat = new ArenaStats();
	
	private ArenaStats(){}
	
	public static ArenaStats getInstance(){
		return arenaStat;
	}
	
	public void showStatistics(){
		System.out.println("Loading Arena Stats...");
	}
}

class SingletonPattern{
	
	public static void main(String[] args) {
		ArenaStats arenaStat = ArenaStats.getInstance();
		arenaStat.showStatistics();
    }
}