package UserFeedback;

import javax.swing.JOptionPane;


// Yes/No pop-up survey for user to complete when they finish their route
public class Feedback {
	
	private Integer userResponse;
	
	Feedback() {}	
	
	// Stores yes response as 0, no response as 1
	public Integer getFeedback() {
		
		userResponse = JOptionPane.showConfirmDialog(null, "Did you enjoy your route?");
		
		if (userResponse == 0 || userResponse == 1) {
			JOptionPane.showMessageDialog(null, "Thank you for your feedback!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Thank you for testing the app!");
		}
		
		return userResponse;
	}
	
}
