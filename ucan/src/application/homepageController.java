package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class homepageController {

	public static String admin,user ; 
	
    @FXML
    private BorderPane home_page;

    @FXML
    private TextField user_name;

    @FXML
    private PasswordField password;

    @FXML
    private Button signOwner;

    @FXML
    private TextField user_name1;

    @FXML
    private PasswordField password1;

    @FXML
    private Button signUser;

    
    @FXML
    private menupage_controller obj;
    
    @FXML
    public Main ma;

    @FXML
    void new_acc(ActionEvent event) throws IOException {
    	
    	BorderPane pane = FXMLLoader.load(getClass().getResource("regis_page.fxml"));
      	home_page.getChildren().setAll(pane); 
    }

    @FXML
    void sign_in(ActionEvent event) throws IOException  {   
    	String name = user_name.getText().toString();
    	String pas = password.getText().toString();
    	int v = 0;    	
    	if(!name.isEmpty() && !pas.isEmpty())
    	{    		
    		try {
        		Class.forName("org.sqlite.JDBC");
             	String url = "jdbc:sqlite:Lawyer.db";
        	
        		Connection con = null; 
        		con = DriverManager.getConnection(url);
        		Statement stm=null;
        		
        		if(con != null)
        		{
        			stm = con.createStatement();
        			String search = "SELECT Password FROM AdminDetails WHERE Username = '"+name+"' ;";
        			ResultSet result = stm.executeQuery(search);
        			
        			String p = null;
        			
        			if(result.next())
        			{
        				p = result.getString("Password"); 
        				if(!p.equals(pas))
            			{
            				Alert al=new Alert(Alert.AlertType.WARNING);
            				al.setTitle("WARNING");
            				al.setContentText("Wrong password");
            				al.setHeaderText(null);
            				al.showAndWait(); 
            				v = 1;
            			}
        			}
        			else
        			{
        				Alert al=new Alert(Alert.AlertType.WARNING);
        				al.setTitle("WARNING");
        				al.setContentText("Owner not found. \nCreate new Owner.");
        				al.setHeaderText(null);
        				al.showAndWait();    
        				v = 1;
        			}
        			
        			if(v == 0)
        			{
        				admin = name;
						BorderPane pane = FXMLLoader.load(getClass().getResource("menupage.fxml"));
						home_page.getChildren().setAll(pane);
        
        		    }
        		}else {
        			Alert a1=new Alert(Alert.AlertType.ERROR);
	            	a1.setTitle("ERROR");
	                a1.setContentText("Could not establish connection with database.");
	                a1.setHeaderText("Connection Lost!");
	                a1.showAndWait();
        		}
        		stm.close();
        		con.close();
        	}catch (Exception e)
    		{
        		Alert a1=new Alert(Alert.AlertType.ERROR);
            	a1.setTitle("ERROR");
            	a1.setContentText("Unable to connect to database.");
                a1.setHeaderText("DATABASE NOT CONNECTED!");
                a1.showAndWait();
    		}
    	}
    	else
    	{
    		Alert al=new Alert(Alert.AlertType.WARNING);
			al.setTitle("WARNING");
			al.setContentText("Some fields are empty.");
			al.setHeaderText(null);
			al.showAndWait();
    	}
    }
    
    public String ret_adm()
    {
	
    	try {
    		Class.forName("org.sqlite.JDBC");
         	String url = "jdbc:sqlite:Lawyer.db";    	
    		Connection con = null; 
    		con = DriverManager.getConnection(url);
    		Statement stm=null;

    		if(con != null)
    		{
    			String get="select * from AdminDetails limit 1;";
    			stm=con.createStatement();
    			ResultSet res=stm.executeQuery(get);
    			if(res.next()) {
    				user=res.getString("Username");
    			}
    			
    		}else {
    			
    		}
    		con.close();
			stm.close();
    	}catch(Exception e) {
    		
    	}
    	return user;
    }
    
    
    public void set(String r)
    {
    	admin = r;
    }
    public String getuser() {
    	
		return admin;
    	
    }
    
    @FXML
    void sign_in_user(ActionEvent event) throws IOException {
    	String name1 = user_name1.getText().toString();
    	String pas1 = password1.getText().toString();
    	int v = 0;    	
    	if(!name1.isEmpty() && !pas1.isEmpty())
    	{    		
    		try {
        		Class.forName("org.sqlite.JDBC");
             	String url = "jdbc:sqlite:Lawyer.db";
        	
        		Connection con = null; 
        		con = DriverManager.getConnection(url);
        		Statement stm=null;
        		
        		if(con != null)
        		{
        			stm = con.createStatement();
        			String search = "SELECT Password FROM AdminDetails WHERE Username = '"+name1+"' ;";
        			ResultSet result = stm.executeQuery(search);
        			
        			String p = null;
        			
        			if(result.next())
        			{
        				p = result.getString("Password"); 
        				if(!p.equals(pas1))
            			{
            				Alert al=new Alert(Alert.AlertType.WARNING);
            				al.setTitle("WARNING");
            				al.setContentText("Wrong password");
            				al.setHeaderText(null);
            				al.showAndWait();
            				v = 1;
            			}
        			}
        			else
        			{
        				Alert al=new Alert(Alert.AlertType.WARNING);
        				al.setTitle("WARNING");
        				al.setContentText("User not found. \nCreate new user.");
        				al.setHeaderText(null);
        				al.showAndWait();
        				v = 1;
        			}
        			
        			if(v == 0)
        			{
        				admin = name1;
						BorderPane pane = FXMLLoader.load(getClass().getResource("usermenupage.fxml"));
						home_page.getChildren().setAll(pane);
        
        		    }
        		}else {
        			Alert a1=new Alert(Alert.AlertType.ERROR);
	            	a1.setTitle("ERROR");
	                a1.setContentText("Could not establish connection with database.");
	                a1.setHeaderText("Connection Lost!");
	                a1.showAndWait();
        		}
        		stm.close();
        		con.close();
        	}catch (Exception e)
    		{
        		Alert a1=new Alert(Alert.AlertType.ERROR);
            	a1.setTitle("ERROR");
            	a1.setContentText("Unable to connect to database.");
                a1.setHeaderText("DATABASE NOT CONNECTED!");
                a1.showAndWait();
    		}
    	}
    	else
    	{
    		Alert al=new Alert(Alert.AlertType.WARNING);
			al.setTitle("WARNING");
			al.setContentText("Some fields are empty.");
			al.setHeaderText(null);
			al.showAndWait();
    	}
    }
}





