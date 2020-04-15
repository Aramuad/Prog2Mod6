package lab11;
import java.util.Scanner;
public class ExceptionsTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Exceptions test = new Exceptions();
		boolean stop = false;
		String answer = "";
		while(!stop) {
			try {
				System.out.println("Enter the 24 hour time: ");
				String time = sc.nextLine();
				while(test.stripper(time).equals("0")) {
					throw(new BoundsTimeFormatException("Invalid Format"));
				}
				time = test.stripper(time);
				for(int i = 0; i < time.length(); i++) {
					switch(time.charAt(i)) {
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						break;
					default:
						throw new TimeFormatException("That is not a number");
					}
				}
				if(Integer.parseInt(time) > 2459 || Integer.parseInt(time) < 0000) {
					throw new TimeFormatException("Out of bounds");
				}
				System.out.println("Time: " + test.converter(time));
			} catch (TimeFormatException t) {
				System.out.println(t.getMessage());
				main(args);
			} catch (BoundsTimeFormatException b) {
				System.out.println(b.getMessage());
				main(args);
			}
			System.out.println("Convert again? (yes/no): ");
			answer = sc.nextLine().toLowerCase();
			if(answer.equals("no")) {
				stop = true;
			}
		}
		sc.close();
	}
}
