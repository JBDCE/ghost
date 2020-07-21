package me.base.database;

import java.io.*;
import java.net.*;
import java.sql.*;

public class MySQL {
	
	 private Connection conn = null;
	 	 
	 public MySQL() {	    	 
	     String userName = "game";
	     String password = "0cD6EavQ4GRiFIBy";
	     String url = "jdbc:mysql://ghostsql.ddns.net:3306/game";
	         
	     //Class.forName("com.mysql.jdbc.Driver").newInstance();
	     DriverManager.setLoginTimeout(2);
	     try {  
	    	 
	         conn = DriverManager.getConnection(url, userName, password);
	         
	         System.out.println("Database connection established");
	        
	         
	     } catch (SQLException e) {
	    	 System.err.println("Cannot connect to database server");
	    	 //System.err.println(e.getMessage());
	         //e.printStackTrace();
	     }
	 }
	  
	  private String getIp(){
		  
		  System.out.println("Getting Ip address...");
		  
		  URL whatismyip;
		  BufferedReader in = null;
		  
		  
		  try{
			  whatismyip = new URL("http://checkip.amazonaws.com");
		  }catch(Exception e){
			  System.err.println("Error retrieving Ip address..");
			  return null;
		  }
		  		  
		  try {
			  in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
			  String ip = in.readLine();
			  //System.out.println(ip);
			  System.out.println("Ip retrieved: " + ip);
			  return ip;
		  } catch(IOException e){
			  System.out.println("Error Server unreachable...");
			  return null;
	  	}finally {
			  if (in != null) {
				  try {
					  in.close();
				  } catch (IOException e) {
					  e.printStackTrace();
				  }
			  }
		  }
	  }
	  
	  
	  private String getGameID(){
		  String sql = "SELECT gameID FROM results ORDER BY gameID desc LIMIT 1;";
		  
		  Statement stmt = null;
		  
		  ResultSet rs = null;
		  
		  int largestID = 0;
		  String id = "";
		  try {
			  stmt = conn.prepareStatement(sql);
			  rs = stmt.executeQuery(sql);
			  
			  rs.next();
			  largestID = rs.getInt("gameID");
			  
		  } catch (SQLException e) {			
			  e.printStackTrace();
		  }
		  
		  id = String.valueOf(largestID+1);
		  
		  return id;
	  }
	  
	  
	  /**
	   * F�gt einen neuen Datensatz hinzu 
	   */
	  public void insertResults(int score) throws Exception{	 
	      try {
	    	
	    	String ip = getIp();
	    	
	    	if(ip==null){
	    		return;
	    	}
	    	
	    	
	    	System.out.println("Uploading Results...");
	        // Insert-Statement erzeugen (Fragezeichen werden sp舩er ersetzt).
	        String sql = "INSERT INTO results(gameID, ipAddress, score) " +
	                     "VALUES(?, ?, ?)";
	        
	        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
	        
	        // Erstes Fragezeichen durch "firstName" Parameter ersetzen
	        preparedStatement.setString(1, getGameID());
	        
	        // Zweites Fragezeichen durch "lastName" Parameter ersetzen
	        //preparedStatement.setString(2, "");
	        
	        preparedStatement.setString(2, ip);
	        
	        preparedStatement.setString(3, String.valueOf(score));
	        // SQL ausf�hren.
	        preparedStatement.executeUpdate();
	        System.out.println("Upload successfull");
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	  }
}
