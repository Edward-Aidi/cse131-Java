package studio8;

import java.util.HashSet;

public class Appointment {
	private Date date;
	private Time time;
	private String person;
	private String location;
	
	public Appointment(Date date, Time time, String person, String location) {
		super();
		this.date = date;
		this.time = time;
		this.person = person;
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Appointment other = (Appointment) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Appointment [date=" + date + ", time=" + time + ", person=" + person + ", location=" + location + "]";
	}

	public static void main(String[] args) {
		Date date = new Date(7, 4, 2017, true);
		Time time = new Time(13, 0, false);
		Appointment ap = new Appointment(date, time, "Harry", "St. Louis");
		System.out.println(ap);
		
	}

}
