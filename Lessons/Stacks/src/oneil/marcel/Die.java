package oneil.marcel;

import java.util.Random;

public class Die {
	int value;
	String name;
	int numSides;
	static Random rnd = new Random();
	
	Die(String nameIn, int sides){
		name = nameIn;
		value = 1;
		numSides = sides;
	}

	public void roll() {
		value = (int) (Math.random()*numSides)+1;
	}
	
	public void roll2() {
		value = rnd.nextInt(numSides)+1;
	}
	
	public int getValue(){
		return value;
	}
	
	
	
	
}
