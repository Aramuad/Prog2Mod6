//sam ballard

package assignment6;
import java.io.*;
public class IO {
	IO() {
	}
	public void MakeFile(File file) {
		try {			
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean exists(File temp) {
		if(temp.exists()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean canRead(File file) {
		if(file.canRead()) {
			return true;
		} else {
			return false;
		}
	}
	public void copyFile(File from, File to) {
		try {
			File file = from;
			File copy = to;
			BufferedReader reader = new BufferedReader(new FileReader(file));
		    StringBuilder sb = new StringBuilder();
		    String line = "";
		    while ((line = reader.readLine()) != null) {
		    	sb.append(line);
		    }
		    copy.delete();
		    copy.createNewFile();
		    FileWriter writer = new FileWriter(copy, true);
			writer.write(sb.toString());
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loremIpsum(File file, String string) {
		try{
			FileWriter writer = new FileWriter(file, true);
			writer.write(string);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public File getLocation(String location, String fileName) {
		File file = new File(location+fileName);
		return file;
	}
}
