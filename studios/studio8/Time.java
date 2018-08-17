package studio8;

public class Time implements Working{
	
	private final int hour;
	private final int minute;
	private final boolean format;
	
	public Time(int hour, int minute, boolean format) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.format = format;
	}


	
	@Override
	public String toString() {
		if(format) {
			if(this.hour < 12 && this.hour > 0) {
				return "Time [hour=" + hour + ", minute=" + minute + " a.m.]";
			}
			else if(this.hour == 12){
				return "Time [hour=" + hour + ", minute=" + minute + " p.m.]";
			}
			else if(this.hour == 0){
				return "Time [hour=" + (hour+12) + ", minute=" + minute + " a.m.]";
			}
			else {
				return "Time [hour=" + (hour-12) + ", minute=" + minute + " p.m.]";
			}
		}
		else {
			return "Time [hour=" + hour + ", minute=" + minute + " and this is in 24-hour format]";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + minute;
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
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		return true;
	}

	public boolean isEarlierThan(Time other) {
		if(this.hour < other.hour) {
			return true;
		}
		else if (this.hour == other.hour && this.minute < other.minute) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Time time = new Time(13, 0, false);
		Time time2 = new Time(12, 1, true);
		Time time3 = new Time(13, 0, true);
		
		System.out.println(time +"\n" +time2);
		System.out.println(time.equals(time3));
		System.out.println();
		
		System.out.println(time.amWorking());
		System.out.println(time2.amWorking());
		Time time4 = new Time(0,0, false);
		System.out.println(time4.amWorking());
	}



	@Override
	public boolean amWorking() {
		if(this.hour >= 9 && this.hour <= 17) {
			return true;
		}
		else{
			return false;
		}
	}

}
