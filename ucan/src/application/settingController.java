package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class settingController {

	homepageController obj = new homepageController();
	
	 @FXML
	 private BorderPane setting;
	
    @FXML
    private Button save_change;

    @FXML
    private Button back;

    @FXML
    private TextField old_name;

    @FXML
    private TextField new_name;

    @FXML
    private TextField old_pswrd;

    @FXML
    private TextField new_pswrd;
    
    @FXML
    private TextField newuser;

    @FXML
    private TextField newpassword;

    @FXML
    private Button adduser;

    @FXML
    void func_back(ActionEvent event) throws IOException {

    	if(obj.getuser().equals(obj.ret_adm())) {
    		BorderPane pane = FXMLLoader.load(getClass().getResource("menupage.fxml"));
    		setting.getChildren().setAll(pane);
    		}else {
    			BorderPane pane = FXMLLoader.load(getClass().getResource("usermenupage.fxml"));
    			setting.getChildren().setAll(pane);
    		}   	
    }

    @FXML
    void func_save(ActionEvent event) {
    	String admin=null;
    	admin=obj.ret_adm();
    	String on = null;
    	String nn = null;
    	String op = null;
    	String np = null;
    	try {
    		on = old_name.getText().toString();
    		nn = new_name.getText().toString();
    		op = old_pswrd.getText().toString();
    		np = new_pswrd.getText().toString();
    	}catch(Exception e)
    	{
    		Alert a1 = new Alert(Alert.AlertType.WARNING);
    		a1.setTitle("WARNING");
    		a1.setContentText("Some input fields are empty.");
    		a1.setHeaderText(null);
    		a1.showAndWait();
    	}
    	
    	if(nn.length() >=5 && nn.length() <= 30 && np.length() >= 5 && np.length() <= 30)
    	{
    		try {
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;
                if(con != null)
                {
                if(admin.equals(on)) {
                	stmt = con.createStatement();
                	String query = "Select * from AdminDetails where Username = '"+on+"' and Password = '"+op+"';";
                	ResultSet res = stmt.executeQuery(query);
                	if(res.next())
                	{
                	
                		String que = "update AdminDetails set Username = '"+nn+"' , Password = '"+np+"' where Username = '"+on+"';";
                		stmt.execute(que);
                		String qu1 = "ALTER TABLE "+on+" RENAME TO "+nn+";";
                		stmt.execute(qu1);
                		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                		a1.setTitle("CHANGES SAVED");
                		a1.setContentText("Username and password changed successfully.");
                		a1.setHeaderText(null);
                		a1.showAndWait();
                		obj.set(nn);
                		stmt.close();
                		BorderPane pane = FXMLLoader.load(getClass().getResource("menupage.fxml"));
                    	setting.getChildren().setAll(pane);                		
                	}
                	else
                	{
                		Alert a1 = new Alert(Alert.AlertType.WARNING);
                		a1.setTitle("WARNING");
                		a1.setContentText("Recheck old username and old password");
                		a1.setHeaderText(null);
                		a1.showAndWait();
                	}
                	}else {
                		Alert a1 = new Alert(Alert.AlertType.WARNING);
                		a1.setTitle("WARNING");
                		a1.setContentText("Changes not allowed since you have logged in from different account.");
                		a1.setHeaderText(null);
                		a1.showAndWait(); 
                		
                	}
                con.close();
                }else {
                	Alert a1=new Alert(Alert.AlertType.ERROR);
	            	a1.setTitle("ERROR");
	                a1.setContentText("Could not establish connection with database.");
	                a1.setHeaderText("Connection Lost!");
	                a1.showAndWait();
                }
                
               
    		}catch(Exception e)
    		{
         		Alert a1=new Alert(Alert.AlertType.ERROR);
            	a1.setTitle("ERROR");
            	a1.setContentText("Uable to not connect to database.");
            	a1.setHeaderText("DATABASE NOT CONNECTED!");
                a1.showAndWait();
    		}    		
    	}
    	else if(nn.length() < 5)
		{
			Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Username must have minimum 5 characters");
       		a1.setHeaderText(null);
       		a1.showAndWait();
		}
		else if(nn.length() > 30)
		{
			Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Username can have maximum 30 characters");
       		a1.setHeaderText(null);
       		a1.showAndWait();
		}
		else if(np.length() < 5)
		{
			Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Password must have minimum 5 characters");
       		a1.setHeaderText(null);
       		a1.showAndWait();
		}
		else if(np.length() > 30)
		{
			Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Password can have maximum 30 characters");
       		a1.setHeaderText(null);
       		a1.showAndWait();
		}
    	
    }
    
    @FXML
    void add_newuser(ActionEvent event) {
    	String user=null;
    	String pass=null;
    	try {
    		 user=newuser.getText().toString();
    		 pass=newpassword.getText().toString();
    	}catch(Exception e)
    	{
    		Alert a1 = new Alert(Alert.AlertType.WARNING);
    		a1.setTitle("WARNING");
    		a1.setContentText("Some input fields are empty.");
    		a1.setHeaderText(null);
    		a1.showAndWait();
    	}
    	
    	if(user.length() >=5 && user.length() <= 30 && pass.length() >= 5 && pass.length() <= 30)
    	{
    		try {
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;
                if(con != null)
                {
               
                	stmt = con.createStatement();
                	String query = "Select * from AdminDetails where Username = '"+user+"';";
                	ResultSet res = stmt.executeQuery(query);
                
                	if(res.next())
                	{
                		Alert a1 = new Alert(Alert.AlertType.WARNING);
                		a1.setTitle("WARNING");
                		a1.setContentText("User already exists create new username.");
                		a1.setHeaderText(null);
                		a1.showAndWait();
                	}
                	else
                	{
                		String insert="insert into AdminDetails values(?,?);";
                		 PreparedStatement st1 = con.prepareStatement(insert);
                		 st1.setString(1, user);
                		 st1.setString(2, pass);   
                		 int n=0;
                		  n=st1.executeUpdate();
                		 if(n!=0) {
                			 Alert a1 = new Alert(Alert.AlertType.WARNING);
                     		a1.setTitle("WARNING");
                     		a1.setContentText("User added successfully.");
                     		a1.setHeaderText(null);
                     		a1.showAndWait();
                		 }else {
                			 Alert a1 = new Alert(Alert.AlertType.WARNING);
                     		a1.setTitle("WARNING");
                     		a1.setContentText("Cannot add user.");
                     		a1.setHeaderText(null);
                     		a1.showAndWait();
                		 }
                	}
                	
                con.close();
                }else {
                	Alert a1=new Alert(Alert.AlertType.ERROR);
	            	a1.setTitle("ERROR");
	                a1.setContentText("Could not establish connection with database.");
	                a1.setHeaderText("Connection Lost!");
	                a1.showAndWait();
                }
                
               
    		}catch(Exception e)
    		{
         		Alert a1=new Alert(Alert.AlertType.ERROR);
            	a1.setTitle("ERROR");
            	a1.setContentText("Uable to not connect to database.");
            	a1.setHeaderText("DATABASE NOT CONNECTED!");
                a1.showAndWait();
    		}    		
    	}
    	else if(user.length() < 5)
		{
			Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Username must have minimum 5 characters");
       		a1.setHeaderText(null);
       		a1.showAndWait();
		}
		else if(user.length() > 30)
		{
			Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Username can have maximum 30 characters");
       		a1.setHeaderText(null);
       		a1.showAndWait();
		}
		else if(pass.length() < 5)
		{
			Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Password must have minimum 5 characters");
       		a1.setHeaderText(null);
       		a1.showAndWait();
		}
		else if(pass.length() > 30)
		{
			Alert a1=new Alert(Alert.AlertType.WARNING);
       		a1.setTitle("WARNING");
       		a1.setContentText("Password can have maximum 30 characters");
       		a1.setHeaderText(null);
       		a1.showAndWait();
		}
    }	

}
