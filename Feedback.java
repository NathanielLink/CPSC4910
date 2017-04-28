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
	//public Integer getFeedback() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	public Integer getFeedback() {	
		userResponse = JOptionPane.showConfirmDialog(null, "Did you enjoy your route?");
		
		// wrap around insertion statements below when ready
		if (userResponse == 0 || userResponse == 1) {
			JOptionPane.showMessageDialog(null, "Thank you for your feedback!");
		}
		else if (userResponse == 2 || userResponse == -1) {
			JOptionPane.showMessageDialog(null, "Thank you for testing the app!");
		}		//System.out.print("Returning " + userResponse);
		else {
			System.out.println("Error: user response format not accepted.");
		}
		
		return userResponse;
	}
	
}

/*
	
		//String url = "http://myadmin.clemson.edu/phpmyadmin";
		// FORMAT OF URL - - - jdbc:mysql://localhost:3306/dbname
		String url = "jdbc:mysql://mysql1.clemson.edu:3306/wrlss_chrgng_lns";
		String driver = "com.mysql.jdbc.Driver";
		
		String user = "wrlss_chrgng_lns";
		String pass = "(DUX0hMxd,ak";
		
		try {

			Class.forName(driver);			
			Connection connection = DriverManager.getConnection(url, user, pass);
		
 
		
			// this will be pulled from the google map tracking info
			float startLat = 0, startLong = 0, endLat = 0, endLong = 0;
		
			//We don't currently have a way to pull this information but it would be useful to have eventually.
			float startCharge = 0, endCharge = 0, addedTime = 0;
		
			//This inserts all of the column data for the responses table if the user answers the survey
			String Response = "insert into Responses(vehicle_make, vehicle_model, vehicle_year, start_Lat," +
						" Start_Long, End_Lat, End_Long, Start_Charge, End_Charge, Added_Time, Response)" + 				
				       " values(Chevrolet, Volt, 2017, " + startLat + ", " + endLat + ", " + startLong + ", " +
		               endLong + ", " + startCharge + ", " + endCharge + ", " + addedTime + ", " + userResponse + ")";
			PreparedStatement ResponseStatement = connection.prepareStatement(Response);
			ResponseStatement.execute();
		

			//This pulls the most recent unique identifier within the Responses SQL table
			//this should always be the identifier corresponding to the insert statement above
			//this will only not work if by the time the code executes this select statement 
			//another row has been inserted into the Response table
			int Trip_id = 0;
			Statement LookupTrip_id = connection.createStatement();
			LookupTrip_id.executeQuery("SELECT TOP 1 id FROM Responses order by id desc");	
			ResultSet rs = LookupTrip_id.getResultSet();
			while(rs.next()){
				Trip_id = rs.getInt("id");
			}
			rs.close();
			LookupTrip_id.close();
		
		
			//this needs to be within a loop. there should be a new record in the Trips table for every inductive 
			//charging road the user took. The corresponding Trip_id will always be the same.
			float Charging_Start_Lat = 0, Charging_Start_Long = 0, Charging_End_Lat = 0, Charging_End_Long = 0;
		
			String Trips = "insert into Trips(Trip_id, Start_Lat, Start_Long, End_Lat, End_Long)" +
						" values(" + Trip_id + ", " + Charging_Start_Lat + ", " + Charging_Start_Long + 
						", " + Charging_End_Lat + ", " + Charging_End_Long + ")";
			PreparedStatement TripsStatement = connection.prepareStatement(Trips);
			TripsStatement.execute();
		
			connection.close();
		
		} catch (SQLException e) {
			System.out.println("Could not connect.");
			e.printStackTrace();
		}
		
		//return userResponse;				
	}
		
}
*/
