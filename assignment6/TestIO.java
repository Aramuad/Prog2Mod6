//sam ballard

package assignment6;
import java.io.*;
import java.util.Scanner;

public class TestIO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IO io = new IO();
		System.out.println("Enter the file name: ");
		String fileName = sc.nextLine().trim();
		System.out.println("Enter the path name: ");
		String location = sc.nextLine().trim();
		File file = io.getLocation(location, fileName);
		io.MakeFile(file);
		io.loremIpsum(file, "Lorem ipsum ");
		boolean again = true;
		while(again) {
			if(io.exists(file) || io.canRead(file)) {
				System.out.println("File created sucecessfully at specified location and can be read");
				again = false;
			} else {
				System.out.println("Error creating file or gaining read access...");
				System.out.println("Enter a new file name: ");
				fileName = sc.nextLine().trim();
				System.out.println("Enter the path name: ");
				location = sc.nextLine().trim();
				file = io.getLocation(location, fileName);
			}
		}
		again = true;
		while(again) {
			System.out.println("Enter the name of copy: ");
			fileName = sc.nextLine().trim();
			System.out.println("Enter the path of copy: ");
			location = sc.nextLine().trim();
			File copy = io.getLocation(location, fileName);
			if(io.exists(copy)) {
				System.out.println("Would you like to overwrite the file? ('Yes' to overwrite, 'No' to choose a dfferent path/name): ");
				String answer = sc.nextLine().trim().toLowerCase();
				if(answer.equals("yes")) {
					io.copyFile(file, copy);
					System.out.println("File overwritten successfully");
					again = false;
				} else {
					System.out.println("Choose a different path/name...");
				}
			} else {
				io.MakeFile(copy);
				io.copyFile(file, copy);
				System.out.println("File created successfully");
				again = false;
			}
		}
		sc.close();
	}
}


//          /Users/samuelballard/eclipse-workspace/cse_1322/ZModule_6/src/assignment6/







