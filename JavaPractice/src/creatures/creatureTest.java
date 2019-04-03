package creatures;

import java.lang.reflect.*;
import creatures.Animal.AnimalType;

public class creatureTest {
	
	public static void main(String[] args) {
		Animal bobby = new Animal("Bobby", AnimalType.dog);
		try {
			Method animalGetName = Animal.class.getMethod("getName");
			String animalName = (String)animalGetName.invoke(bobby);
			System.out.print(animalName);
		}
		catch(Exception e) {
			
		}
	}
}
