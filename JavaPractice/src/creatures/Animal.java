package creatures;

import java.util.*;

public class Animal 
{
	public Animal() {
		animalAmount++;
		id = animalAmount;
		hasOwner = false;
		name = "";
		weight = 0.1f;
		height = 0.1f;
		age = 1;
	}
	public Animal(String name) {
		this();
		this.name = name;
	}

	public String getName() { return name; }
	
	private long id;
	private static long animalAmount = 0;
	private boolean hasOwner;
	private String name;
	private float weight;
	private float height;
	private byte age;
	private enum HealthState{ healthy, ill }
	//private HealthState healthState = HealthState.healthy;


	
	
	
}
