package application;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class regis_page {

	@FXML
	private BorderPane res_page;

    @FXML
    private TextField name;

    @FXML
    private TextField s_p;

    @FXML
    private TextField c_p;

    @FXML
    void back(ActionEvent event) throws IOException {
    	
    	BorderPane pane = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        res_page.getChildren().setAll(pane); 
	}

    @FXML
    void register(ActionEvent event) {    	
    	String userName = name.getText().toString();
    	String s_pw = s_p.getText().toString();
    	String c_pw = c_p.getText().toString();
    	int v = 1;
    	
    	if(s_pw.contains(" ") || userName.contains(" ") || userName.isEmpty() || s_pw.isEmpty()) {
    		v = 0;
      		Alert a1=new Alert(Alert.AlertType.WARNING);
        	a1.setTitle("WARNING");
        	a1.setContentText("Username of password cannot be empty.");
            a1.setHeaderText(null);
            a1.showAndWait();
    		}
    	
    	if(s_pw.equals(c_pw) && !userName.isEmpty() && !s_pw.isEmpty() && !c_pw.isEmpty()  && v == 1)
    	{
    		
    		if(userName.length() >= 5 && userName.length() <= 30 && s_pw.length() >= 5 && s_pw.length() <= 30)
    		{
    			try 
        		{
        			Class.forName("org.sqlite.JDBC");
                    String dbURL = "jdbc:sqlite:Lawyer.db";
                    Connection con = DriverManager.getConnection(dbURL);
            
                    Statement stmt = null;
                
                    String create_table = "CREATE TABLE '"+userName+"' (\n"
                    		+ "off_no VARCHAR(50), \n"
                    		+ "cse_no VARCHAR(50) , \n"
                    		+ "aplicnt VARCHAR(50)DEFAULT NULL, \n"
                    		+ "opont VARCHAR(50), \n"
                    		+ "fld_dte VARCHAR(10), \n"
                    		+ "imp_dte VARCHAR(10), \n"
                    		+ "regis_dte VARCHAR(10),\n"
                    		+ "fee REAL, \n"
                    		+ "rec_fe REAL, \n"
                    		+ "expen REAL, \n"
                    		+ "status VARCHAR(300)DEFAULT NULL, \n"
                    		+ "notes VARCHAR(1000) DEFAULT NULL,\n"
                    		+ "advocate VARCHAR(50) DEFAULT NULL\n"
                    		+ ");";
                    

                    String search="select Username from AdminDetails where Username='"+userName+"';";
                    
  
                    String count = "select count( Username) from AdminDetails ;";
                    
                    String index = "create  index office_index on "+userName+"(off_no);" ;
                    
                    String index1 = "create  index case_index on "+userName+"(cse_no);" ;
                    
                    String index2 = "create  index advocate_index on "+userName+"(advocate);" ;
                    
                    String index3 = "create  index reg_date_index on "+userName+"(regis_dte);" ;
                    
                    if (con != null) 
                    {
                    	stmt = con.createStatement();
                    	ResultSet result=stmt.executeQuery(search);
                    	ResultSet res0 = stmt.executeQuery(count);
                    	int r = res0.getInt(1);
                    
                    	 if( r < 1) {
            
                        String query = "insert into AdminDetails values(?,?)";
                        PreparedStatement st = con.prepareStatement(query);
        			
                        st.setString(1, userName);
                        st.setString(2, s_pw);
                        st.executeUpdate();
                        
                        
                        stmt.executeUpdate(create_table);
                        try {
                        	stmt.execute(index);
                        }catch (Exception e)
                        {
                        	System.out.println(e);
                        }
                        
                        try {
                        	stmt.execute(index1);
                        }catch (Exception e)
                        {
                        	System.out.println(e);
                        }
                        
                        try {
                        	stmt.execute(index2);
                        }catch (Exception e)
                        {
                        	System.out.println(e);
                        }
                        
                        try {
                        	stmt.execute(index3);
                        }catch (Exception e)
                        {
                        	System.out.println(e);
                        }
                        
                        
        			
                        Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                        a1.setTitle("REGISTERED");
                        a1.setContentText("Successfully Registered");
                        a1.setHeaderText(null);
                        a1.showAndWait();
                        
                       
                        stmt.close();
                        con.close();
                        
                        BorderPane pane = FXMLLoader.load(getClass().getResource("homepage.fxml"));
                        res_page.getChildren().setAll(pane); 	
                        }
                    	 else
                    	 {
                          	
                          	Alert a1=new Alert(Alert.AlertType.WARNING);
                         		a1.setTitle("WARNING");
                         		a1.setContentText("No more owners can be created.");
                         		a1.setHeaderText(null);
                         		a1.showAndWait();
                          }
                     	 
                    }else {
                    	Alert a1=new Alert(Alert.AlertType.ERROR);
    	            	a1.setTitle("ERROR");
    	                a1.setContentText("Could not establish connection with database.");
    	                a1.setHeaderText("Connection Lost!");
    	                a1.showAndWait();
            		}
            		stmt.close();
            		con.close();
              	}catch(Exception e)
        		{
              		Alert a1=new Alert(Alert.AlertType.ERROR);
                	a1.setTitle("ERROR");
                	a1.setContentText("Unable to connect to database.");
                    a1.setHeaderText("DATABASE NOT CONNECTED!");
                    a1.showAndWait();
        		}

    		}
    		else if(userName.length() < 5)
    		{
    			Alert a1=new Alert(Alert.AlertType.WARNING);
           		a1.setTitle("WARNING");
           		a1.setContentText("Username must have minimum 5 characters");
           		a1.setHeaderText(null);
           		a1.showAndWait();
    		}
    		else if(userName.length() > 30)
    		{
    			Alert a1=new Alert(Alert.AlertType.WARNING);
           		a1.setTitle("WARNING");
           		a1.setContentText("Username can have maximum 30 characters");
           		a1.setHeaderText(null);
           		a1.showAndWait();
    		}
    		else if(s_pw.length() < 5)
    		{
    			Alert a1=new Alert(Alert.AlertType.WARNING);
           		a1.setTitle("WARNING");
           		a1.setContentText("Password must have minimum 5 characters");
           		a1.setHeaderText(null);
           		a1.showAndWait();
    		}
    		else if(s_pw.length() > 30)
    		{
    			Alert a1=new Alert(Alert.AlertType.WARNING);
           		a1.setTitle("WARNING");
           		a1.setContentText("Password can have maximum 30 characters");
           		a1.setHeaderText(null);
           		a1.showAndWait();
    		}
    	}
    	else if (!s_pw.equals(c_pw))
    	{
    		Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Password did not match.Try again.");
       		a1.setHeaderText(null);
       		a1.showAndWait();
    	}
    	else if (userName.isEmpty())
    	{
    		Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Enter user name.");
       		a1.setHeaderText(null);
       		a1.showAndWait();
    	}
    	else if (v == 0)
    	{
    		Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("User name and password should not contain blank-spaces.");
       		a1.setHeaderText(null);
       		a1.showAndWait();
    	}
    }
    	

}

	



