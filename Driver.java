package Survey;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Survey.Feedback;

public class Driver {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		// if (route.isFinished()) {
		
		Feedback f = new Feedback();		
		Integer answer = f.getFeedback();
		
		// File feedbackFile = new File("feedback.txt");
		String fileName = "feedback.txt";
		File feedbackFile = new File("C:\\Users\\Andrew\\Desktop\\" + fileName);
		FileWriter fileWriter = new FileWriter(feedbackFile, true);
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(buffer);			
		
		if (!feedbackFile.exists())  {
			feedbackFile.createNewFile();
			System.out.println("file created");
			
			printWriter.println("User Feedback");
			printWriter.println();
		}
		else {
			System.out.println("file exists");;
		}
		
		
		if (answer == 0) {
			printWriter.println("Yes");
			System.out.println("'Yes' response added to " + fileName);
		}
		else if (answer == 1) {
			printWriter.println("No");
			System.out.println("'No' response added to " + fileName);
		}
		
        printWriter.close();
	
	}
	
	//  }
}
