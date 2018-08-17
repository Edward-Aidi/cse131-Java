package exercises8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UsingList {

	public static void main(String[] args) {
		//
		// Your code goes here:
		//
		List<String> eating = new ArrayList<String>();
		eating.add("open mouth");
		eating.add("insert food");
		eating.add("chew");
		eating.add("chew");
		eating.add("swallow");
		System.out.println(eating);

		eating.add("close mouth");
		eating.add("open mouth again");
		eating.add("drink water");
		eating.add("chew");
		eating.add("close mouth");
		System.out.println(eating);
		
		eating.remove("chew");
		eating.remove(7);
		System.out.println(eating);
		System.out.println(eating.size());
	}
}
