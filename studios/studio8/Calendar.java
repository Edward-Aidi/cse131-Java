package studio8;

import java.util.HashSet;

public class Calendar {
	private Appointment app;

	public Calendar(Appointment app) {
		super();
		this.app = app;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((app == null) ? 0 : app.hashCode());
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
		Calendar other = (Calendar) obj;
		if (app == null) {
			if (other.app != null)
				return false;
		} else if (!app.equals(other.app))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Calendar [app=" + app + "]\n";
	}

	public static void main(String[] args) {
		Date date = new Date(7, 4, 2017, true);
		Time time = new Time(13, 0, false);
		Appointment app = new Appointment(date, time, "Harry", "St. Louis");
		Appointment app2 = new Appointment(date, time, "Peter", "New York");
		Calendar cal = new Calendar(app);
		Calendar cal2 = new Calendar(app2);
		HashSet<Calendar> calset = new HashSet<Calendar>();
		calset.add(cal);
		calset.add(cal2);
		calset.add(cal);
		System.out.println(calset);
	}

}
