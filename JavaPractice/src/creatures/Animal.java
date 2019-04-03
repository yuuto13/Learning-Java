package creatures;

import java.util.*;

public class Animal implements Comparable<Animal>
{
	public enum HealthState { healthy, ill }
	public enum AnimalType {
		undefined, cat, dog, horse, cow, chicken, duck, fish, pig, bird, fox
	}
	long id;
	static long animalAmount = 0;
	boolean hasOwner;
	String name;
	float weight;
	float height;
	byte age;
	AnimalType type;
	HealthState healthState;
	
	
	public Animal() {
		animalAmount++;
		id = animalAmount;
		hasOwner = false;
		name = "";
		weight = 0.1f;
		height = 0.1f;
		age = 1;
		type = AnimalType.undefined;
		healthState = HealthState.healthy;
	}
	public Animal(String name, AnimalType type) {
		this();
		this.name = name;
		this.type = type;
	}

	public String getName() { return name; }
	public int compareTo(Animal other) {
		return (int)(id - other.id);
	}
	public String toString() {
		return name + " the " + type;
	}
	

	
	
	
	
}
