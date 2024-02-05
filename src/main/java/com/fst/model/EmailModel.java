package com.fst.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailModel {

    private List<String> addresses = new ArrayList<>();
    private List<String> dbEmails = new ArrayList<>();
    private Connection connection;

    public EmailModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public List<String> getDbEmails() {
        return dbEmails;
    }

    public void insertEmailToDatabase(String email) {
        // Implement your logic to insert into the database
    	  try {
          	//Cette ligne crée une requête SQL INSERT 
              String insertQuery = "INSERT INTO email (email) VALUES (?)";
              PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
              preparedStatement.setString(1, email);
              int rowCount = preparedStatement.executeUpdate();
              if (rowCount > 0) {
                  System.out.println("E-mail " + email + " inserted successfully.");
              } else {
                  System.out.println("Failed to insert email " + email);
              }
          } catch (SQLException e) {
              e.printStackTrace();
              // Handle the exception appropriately
          }
    }

    public void removeEmailFromDatabase(String email) {
        // Implement your logic to remove from the database
    	
    	 try {
    		 //String deleteQuery = "DELETE FROM email WHERE email = ?";: Cette ligne crée une requête SQL DELETE qui supprimera une ligne de la table "email" de la base de données        	
    		            String deleteQuery = "DELETE FROM email WHERE email = ?";
    		// Cette ligne prépare la requête SQL en utilisant un objet PreparedStatement
    		            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
    		            preparedStatement.setString(1, email);
    		            int rowCount = preparedStatement.executeUpdate();
    		//tester si supérieur à zéro, cela signifie que la suppression a réussi
    		            if (rowCount > 0) {
    		                System.out.println("E-mail " + email + " removed successfully.");
    		            } else {
    		                System.out.println("Email " + email + " not found in the database.");
    		            }
    		        } catch (SQLException e) {
    		            e.printStackTrace();
    		            // Handle the exception appropriately
    		        }
    }
  


    public List<String> retrieveEmailsFromDatabase() {
        List<String> dbEmails = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT email FROM email;");
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                dbEmails.add(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return dbEmails;
    }
}
