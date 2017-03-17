package Survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;



// Yes/No pop-up survey for user to complete when they finish their route
public class Feedback {
		
	private Integer userResponse;
		
	Feedback() {}	
		
	// Stores yes response as 0, no response as 1
	public Integer getFeedback() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		userResponse = JOptionPane.showConfirmDialog(null, "Did you enjoy your route?");
		
		if (userResponse == 0 || userResponse == 1) {
			JOptionPane.showMessageDialog(null, "Thank you for your feedback!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Thank you for testing the app!");
		}
		//System.out.print("Returning " + userResponse);
		// return string as character, but first just test for integer
		

		
		String url = "jdbc:mysql://mysql1.clemson.edu/wrlss_chrgng_lns.jdbc";		
		String driver = "com.mysql.jdbc.Driver";
		String user = "removed";
		String pass = "removed";
		
		try {
			Class.forName(driver).newInstance();
			Connection connect = DriverManager.getConnection(url, user, pass);
		
		
		
		
		// this will be pulled from the google map tracking info
		float startLat = 0, startLong = 0, endLat = 0, endLong = 0;
		
		//We don't currently have a way to pull this information but it would be useful to have eventually.
		float startCharge = 0, endCharge = 0, addedTime = 0;
		
		String query = "insert into Responses(vehicle_make, vehicle_model, vehicle_year, start_Lat," +
		               " Start_Long, End_Lat, End_Long, Start_Charge, End_Charge, Added_Time, Response)" + 
				       " values(Chevrolet, Volt, 2017, " + startLat + ", " + endLat + ", " + startLong + ", " +
		               endLong + ", " + startCharge + ", " + endCharge + ", " + addedTime + ", " + userResponse + ")";
		               
		
		PreparedStatement preparedStatement = connect.prepareStatement(query);
		preparedStatement.execute();
		
		connect.close();
		
		} catch (SQLException e) {
			System.out.println("Could not connect.");
			e.printStackTrace();
		}
		
		return userResponse;				
	}
		
}