package UserFeedback;

import UserFeedback.Feedback;

public class Driver {

	public static void main(String[] args) {
			
		Feedback f = new Feedback();
		
		
		// Only call when route is finished  
		// I do not know the proper syntax for checking if the route is finished yet
		// if (route.isFinished() == true) {	
		Integer answer = f.getFeedback();
        //}
	}
}
