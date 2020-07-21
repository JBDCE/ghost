package me.base.engine;

import java.util.*;

public class RandomNumberGenerator {
	
	Random rand = new Random();
	
	public int createRandomInt(int minimum, int maximum){
		return minimum + rand.nextInt(maximum-minimum);
	}
}
