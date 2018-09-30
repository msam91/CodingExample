package microsoft;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Person {

	String name;
	Person[] n;

	public Person(String name, Person[] n) {
		this.name = name;
		this.n = n;
	}

	public boolean isMystry(String name) {

		Set<String>visited = new HashSet<>();
		visited.add(this.name);
		Stack<Person> s = new Stack<>();
		for (Person p : this.n) {
			s.push(p);
		}
		


		do {
			Person p1 = s.pop();
			if (p1.name.equals(name)) {
				return true;
			} else {
				visited.add(p1.name);
				for (Person p : p1.n) {
					if(!visited.contains(p.name))
					s.push(p);
				}
			}

		} while (s.size() >0);
		return false;

	}
	
	public static void main(String args[]) {
		Person Manas = new Person("Manas",new Person[3]);
		Person Akshay = new Person("Akshay",new Person[2]);
		Person Akriti = new Person("Akriti", new Person[2]);
		Person Deep = new Person("Deep",new Person[2]);
		Person Op = new Person("Op", new Person[3]);
		
		Manas.n[0] = Akshay;
		Manas.n[1]=Akriti;
		Manas.n[2]=Op;
		
		Akriti.n[0]=Manas;
		Akriti.n[1]=Deep;
		
		Akshay.n[0] = Manas;
		Akshay.n[1] = Op;
		
		Deep.n[0]=Akriti;
		Deep.n[1]=Op;
		
		Op.n[0]=Manas;
		Op.n[1]=Akshay;
		Op.n[2]=Manas;
		
		System.out.println(Manas.isMystry("Microsoft"));
		System.out.println("Done");
		
		
	}
}
