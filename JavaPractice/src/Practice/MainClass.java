package Practice;

import java.util.*;
import creatures.Animal;
import creatures.Animal.AnimalType;

public class MainClass {
	
	public static void main(String[] args) {
//		TalkingClock clock = new TalkingClock(10000, true);
//		clock.startTimePrinter();

		List<String> a = new LinkedList<String>();
		a.add("Alice");
		a.add("Ben");
		a.add("Cameron");
		List<String> b = new LinkedList<String>();
		b.add("Derek");
		b.add("Emily");
		b.add("Frank");
		b.add("George");
		System.out.println(a);
		System.out.println(b);
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();

		while(bIter.hasNext()) {
			if(aIter.hasNext()) {
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		bIter = b.iterator();
		while(bIter.hasNext()) {
			bIter.next();
			if(bIter.hasNext()) {
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
		
		//--------------------- Test Map ----------------------
		System.out.println();
		
		Map<String, Animal> pet = new LinkedHashMap<>();
		pet.put("Alice", new Animal("Arya", AnimalType.cat));
		pet.put("Ben", new Animal("Bobi", AnimalType.dog));
		pet.put("Cameron", new Animal("Cody", AnimalType.fox));
		
		//How to iterate through a map
		//---------------- primal version ----------------
//		for(Map.Entry<String, Animal> entry : pet.entrySet()) {
//			String ownerName = entry.getKey();
//			String animalName = entry.getValue().toString();
//			System.out.println(ownerName + " owns " + animalName + ".");
//		}
		//---------------- short version ----------------
//		pet.forEach((ownerName, animal) -> {
//			System.out.println(ownerName + " owns " + animal + ".");
//		});
		//---------------- linked map iterator version ----------------
		Iterator<String> iterA = pet.keySet().iterator();
		Iterator<Animal> iterB = pet.values().iterator();
		while(iterA.hasNext()) {
			String ownerName = iterA.next();
			String animalName = iterB.next().toString();
			System.out.println(ownerName + " owns " + animalName + ".");
		}
		
	}
}

