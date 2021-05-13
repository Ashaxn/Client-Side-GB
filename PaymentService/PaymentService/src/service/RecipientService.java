package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import model.Recipient;


public class RecipientService {
	
	private Connection getConnection() {
	    Connection con = null;
	    try {
	      Class.forName("com.mysql.jdbc.Driver");

	      con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paymentDB", "root", "");
	    } catch (SQLException | ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    return con;
   }
	
	public Response addRecipient(Recipient recipient) {
		int insertedId = -99;
		try {
		      Connection con = getConnection();
		      if (con == null) return Response
		        .status(Response.Status.INTERNAL_SERVER_ERROR)
		        .entity("DataBase connectivity Error")
		        .build();

		      String query = "INSERT INTO recipient(account_number,bank, branch) VALUES (?, ?, ?)";
		      PreparedStatement preparedStmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

		      preparedStmt.setString(1, recipient.getAccountNumber());
		      preparedStmt.setString(2, recipient.getBank());
		      preparedStmt.setString(3, recipient.getBranch());
		      
		      preparedStmt.execute();
		      ResultSet rs = preparedStmt.getGeneratedKeys();
		      if (rs.next()){
		    	  insertedId  = Integer.parseInt(rs.getString(1));
		      }
		      con.close();
		      
		      recipient.setId(insertedId);
		      recipient.setIssuedAt("A few seconds ago");
		    } catch (Exception e) {
		      return Response
		        .status(Response.Status.INTERNAL_SERVER_ERROR)
		        .entity(e)
		        .build();
		    }
		    return Response
		      .status(Response.Status.CREATED)
		      .entity(recipient)
		      .build();
	}

	public Response getRecipients() {
		List <Recipient> recipients = new ArrayList <Recipient> ();

	    try {
	      Connection con = getConnection();
	      if (con == null) return Response
	        .status(Response.Status.INTERNAL_SERVER_ERROR)
	        .entity("DataBase connectivity Error")
	        .build();

	      String query = "select * from recipient";
	      Statement stmt = con.createStatement();
	      ResultSet rs = stmt.executeQuery(query);

	      while (rs.next()) {
	        int id = rs.getInt("id");
	        String account_number = rs.getString("account_number");
	        String bank = rs.getString("bank");
	        String branch = rs.getString("branch");
	        String issuedAt = rs.getString("issuedAt");

	        Recipient recipient = new Recipient(bank,branch,account_number);
	        recipient.setIssuedAt(issuedAt);
	        recipient.setId(id);
	        recipients.add(recipient);

	      }
	      con.close();

	    } catch (Exception e) {
	      return Response
	        .status(Response.Status.INTERNAL_SERVER_ERROR)
	        .entity(e)
	        .build();
	}


    return Response
      .status(Response.Status.OK)
      .entity(recipients)
      .build();
	}

	public Response getRecipientById(Integer recipientid) {
		Recipient recipient = null;

	    try {
	      Connection con = getConnection();
	      if (con == null) return Response
	        .status(Response.Status.INTERNAL_SERVER_ERROR)
	        .entity("DataBase connectivity Error")
	        .build();

	      String query = "select * from recipient where id = " + recipientid;
	      Statement stmt = con.createStatement();
	      ResultSet rs = stmt.executeQuery(query);

	      while (rs.next()) {
	    	  int id = rs.getInt("id");
		        String account_number = rs.getString("account_number");
		        String bank = rs.getString("bank");
		        String branch = rs.getString("branch");
		        String issuedAt = rs.getString("issuedAt");

		        recipient = new Recipient(bank,branch,account_number);
		        recipient.setIssuedAt(issuedAt);
		        recipient.setId(id);
		        
	      }
	      con.close();

	    } catch (Exception e) {
	      return Response
	        .status(Response.Status.INTERNAL_SERVER_ERROR)
	        .entity(e)
	        .build();
	    }

	    return Response
	      .status(Response.Status.OK)
	      .entity(recipient)
	      .build();
	}
}
