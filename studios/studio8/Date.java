package studio8;

import java.util.HashSet;
import java.util.LinkedList;

public class Date implements Working{
	
	private final int month;
	private final int day;
	private final int year;
	private final boolean holiday;
	
	public Date(int month, int day, int year, boolean holiday) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.holiday = holiday;
	}

	

	@Override
	public String toString() {
		if(this.holiday) {
			return "Date [month=" + month + ", day=" + day + ", year=" + year + ", and it is a holiday]";
		}
		else {
			return "Date [month=" + month + ", day=" + day + ", year=" + year + ", and it is not a holiday]";
		}
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public boolean isEarlierThan(Date other) {
		if(this.year < other.year) {
			return true;
		}
		else if (this.year == other.year && this.month < other.month) {
			return true;
		}
		else if(this.year == other.year && this.month == other.month && this.day < other.day){
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Date date = new Date(7, 4, 2017, true);
		Date date2 = new Date(11, 2, 2017, false);
		Date date3 = new Date(7, 4, 2016, true);
		Date date4 = new Date(11, 2, 2017, true);
		Date date5 = new Date(11, 2, 2017, false);
		System.out.println(date +"\n" + date2);
		System.out.println();
		
		System.out.println(date + " should not be equal with " + date2 +" and the result is "+ date.equals(date2));
		System.out.println(date + " should not be equal with " + date3 +" and the result is "+ date.equals(date3));
		System.out.println(date2 + " should be equal with " + date4 +" and the result is "+ date2.equals(date4));
		System.out.println(date2 + " should be equal with " + date5 +" and the result is "+ date2.equals(date5));
		System.out.println();
		
		LinkedList<Date> list = new LinkedList<Date>();
		list.add(date);
		list.add(date2);
		list.add(date3);
		list.add(date4);
		list.add(date5);
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		System.out.println();
		LinkedList<Date> list1 = new LinkedList<Date>();
		list1.add(date4);
		list1.add(date5);
		list1.add(date4);
		System.out.println("We add two Date objects to the list that equal each other: "+list1);
		
		System.out.println();
		HashSet<Date> set = new HashSet<Date>();
		set.add(date4);
		set.add(date5);
		set.add(date4);
		System.out.println("We add two Date objects to the set that equal each other: "+ set);
		
		
		//Create a list of Working objects and add up the number of those objects that indicate that you are working.
		System.out.println();
		Date date6 = new Date(11, 5, 2017, true);
		System.out.println(date.amWorking());
		System.out.println(date2.amWorking());
		System.out.println(date6.amWorking());
		
	}



	@Override
	public boolean amWorking() {
		if(this.day % 2 == 0) {
			return true;
		}
		else{
			return false;
		}
	}

}
