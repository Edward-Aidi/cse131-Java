package blts;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SetsAndLists {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		List<String> list = new LinkedList<String>();
		String[] lunch = { "open mouth", "insert food", "chew", "chew", "swallow" };
		
		for (String s : lunch) {
			set.add(s);  set.add(s);
			list.add(s); list.add(s);
		}
		
		System.out.println("Set is " + set);
		System.out.println("List is " + list);

	}

}
