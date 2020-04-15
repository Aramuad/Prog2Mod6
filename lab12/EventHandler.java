//sam ballard

package lab12;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class EventHandler extends Window {
	EventHandler() {
		put();
		get();
	}
	public void put() {
		getPut().addActionListener(new ActionListener() {
			// save text area to file
			public void actionPerformed(ActionEvent e) {
				saveJTextArea();
			}
			
		});
	}
	public void get() {
		getGet().addActionListener(new ActionListener() {
			// Display Contents of file
			public void actionPerformed(ActionEvent e) {
				setJTextArea();
			}
			
		});
	}
}