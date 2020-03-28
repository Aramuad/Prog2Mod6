package lab11;

public class Exceptions {
	int hour, min;
	String time, temp;
	
	Exceptions() {
	}
	public String stripper(String time) {
		if(time.length() == 4) {
			time = "0" + time;
		}
		StringBuilder sb = new StringBuilder(time);
		sb.deleteCharAt(2);
		String stripped = sb.toString();
		return stripped;
	}
	public String converter(String time) {
		if(time.charAt(0) == 0) {
			temp = time.charAt(1) + "";
		} else {			
			temp = time.charAt(0) + "" + time.charAt(1);
		}
		hour = Integer.parseInt(temp);
		if(hour > 12) {
			hour = hour - 12;
		}
		temp = time.charAt(2) + "" + time.charAt(3);
		min = Integer.parseInt(temp);
		if(Integer.parseInt(time) >= 1200) {
			time = Integer.toString(hour) + ":" + Integer.toString(min) + " PM";
		} else {			
			time = Integer.toString(hour) + ":" + Integer.toString(min) + " AM";
		}
		return time;
	}
}
