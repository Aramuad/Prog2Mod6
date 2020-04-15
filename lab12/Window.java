//sam ballard

package lab12;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Window {
	private JFrame frame;
	private JTextArea textArea;
	private JPanel buttonPanel;
	private JButton put, get;
	private File file;
	private FileWriter writer;
	private FileReader reader;
	Window() {
		makeWindow();
	}
	public void makeWindow() {
		frame = new JFrame("Text Editor");
		frame.setVisible(true);
		frame.setSize(500, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea = new JTextArea("Enter a string...");
		buttonPanel = new JPanel();
		put = new JButton("Save");
		get = new JButton("Display File Contents");
		buttonPanel.add(put);
		buttonPanel.add(get);
		frame.add(textArea);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.getRootPane().setDefaultButton(put);
		
		file = new File(getCurrentDir() + "/WriteFile.java");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public File getFile() {
		return file;
	}
	public JButton getPut() {
		return put;
	}
	public JButton getGet() {
		return get;
	}
	 public void setJTextArea() {
	        try {
	            reader = new FileReader(getCurrentDir() + "/WriteFile.java");
	            textArea.read(reader, "File");
	            reader.close();
	        } catch(IOException i) {
	            i.printStackTrace();
	        }
	    }
	public void saveJTextArea() {
		try {
			writer = new FileWriter(getCurrentDir() + "/WriteFile.java");
			textArea.write(writer);
			writer.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		textArea.setText("Saved!");
	}
	public String getCurrentDir() {
		String currentDir = System.getProperty("user.dir");
		return currentDir;
	}
}

//     "/Users/samuelballard/eclipse-workspace/cse_1322/ZModule_6/src//lab12/WriteFile.java"