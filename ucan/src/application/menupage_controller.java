package application;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class menupage_controller {

	homepageController obj = new homepageController();
	
	 @FXML
	 private BorderPane menu;
	
    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Button search;
    
    @FXML
    private Button setting;

    @FXML
    private Button home;

    @FXML
    private Button update;
    
    @FXML
    private Button logout;

    @FXML
    private Button display;

    @FXML
    private TextArea view_table;

    @FXML
    private TextField show_date;
    
    @FXML
    private DatePicker date;
    
    @FXML
    private TextField show_user;

 public void initialize()
    {
    	Date dte = new Date();  
        SimpleDateFormat formatter	;	
    	formatter = new SimpleDateFormat("dd MMMM yyyy");
    	String strDate = formatter.format(dte);  
    	
    	String table = obj.ret_adm();
    	
    	show_date.setText(strDate);
    	show_user.setText(obj.ret_adm());
    	
    	LocalDate d = LocalDate.now();
    	LocalDate tom = d.plusDays(1);
    	try {
			Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Lawyer.db";
            Connection con = DriverManager.getConnection(dbURL);
            Statement stmt = null;
            
            if(con != null)
            {
           
            	stmt = con.createStatement();
            	String query = "Select * from "+table+" where imp_dte = '"+tom+"' ; ";
            	ResultSet res = stmt.executeQuery(query);
            	int c = 1;             
            	view_table.setText("\t\t\t\t\t\t\tWORK FOR " + tom + "\n\n");
            if(res.next()) {
            		do{
                		String p = Integer.toString(c);
                		view_table.appendText(p + "} FILE NUMBER : ");
                		view_table.appendText(res.getString("cse_no")+"\n");
                		view_table.appendText("     OFFICE FILE NO. : ");
                		view_table.appendText(res.getString("off_no")+"\n");
                		view_table.appendText("     APPLICANT : ");
                		view_table.appendText(res.getString("aplicnt")+"\n");
                		view_table.appendText("     OPPONENT : ");
                		view_table.appendText(res.getString("opont")+"\n");
                		view_table.appendText("     MATTER STATUS : ");
                		view_table.appendText(res.getString("status")+"\n");
                		view_table.appendText("     RECOMMENDED BY : ");
                		view_table.appendText(res.getString("advocate")+"\n\n\n");
                		c++;
                		
                	}while(res.next());
            }else {
            	view_table.setText("\n\n\n\n \t\t\t\t\tNo  Schedule  For  Tomorrow"  );
            }
            }
            stmt.close();
            con.close();
		}catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			Alert a1=new Alert(Alert.AlertType.ERROR);
			a1.setTitle("ERROR");
			a1.setContentText("Unable to connect to database.");
			a1.setHeaderText("DATABASE NOT CONNECTED!");
			a1.showAndWait();
		}
		
    	
    }
 
    @FXML
    void func_add(ActionEvent event) throws IOException {
    	
    	BorderPane pane = FXMLLoader.load(getClass().getResource("add_page.fxml"));
    	menu.getChildren().setAll(pane);
    		
    	
    }

    @FXML
    void func_delete(ActionEvent event) throws IOException {
    	
    	BorderPane pane = FXMLLoader.load(getClass().getResource("del_page.fxml"));
    	menu.getChildren().setAll(pane);	
     
    }

    @FXML
    void accnts(ActionEvent event) throws IOException {

    	BorderPane pane = FXMLLoader.load(getClass().getResource("acc_page.fxml"));
    	menu.getChildren().setAll(pane);
    }

    @FXML
    void func_search(ActionEvent event) throws IOException {

    	BorderPane pane = FXMLLoader.load(getClass().getResource("search_page.fxml"));
    	menu.getChildren().setAll(pane);
    }

    @FXML
    void func_update(ActionEvent event) throws IOException {

    	BorderPane pane = FXMLLoader.load(getClass().getResource("update_page.fxml"));
    	menu.getChildren().setAll(pane);
    }

    @FXML
    void func_logout(ActionEvent event) throws IOException {
    	
    	obj.set(null);
    	
    	BorderPane pane = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    	menu.getChildren().setAll(pane);

    }

    @FXML
    void func_setting(ActionEvent event) throws IOException {

    	BorderPane pane = FXMLLoader.load(getClass().getResource("setting_page.fxml"));
    	menu.getChildren().setAll(pane);

    }
    
    @FXML
    void func_display(ActionEvent event) {
    
    	String mod_dte = null;
    	String table = obj.ret_adm();
    	
    	try {
    		mod_dte = date.getValue().toString();
    	}catch(Exception e)
    	{
    		Alert a1 = new Alert(Alert.AlertType.WARNING);
    		a1.setTitle("WARNING");
    		a1.setContentText("Select date.");
    		a1.setHeaderText(null);
    		a1.showAndWait();
    	}   	
    	if(mod_dte != null)
    	{
    	try {
			Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Lawyer.db";
            Connection con = DriverManager.getConnection(dbURL);
            Statement stmt = null;
            
            if(con != null)
            {
            	
            	stmt = con.createStatement();
            	String query = "Select * from "+table+" where imp_dte = '"+mod_dte+"' ; ";
            	ResultSet res = stmt.executeQuery(query);
            	int c = 1;
            	view_table.setText("\t\t\t\t\t\t SCHEDULE  FOR  " + mod_dte + "\n\n");
            	if(res.next()) {
            		do{
                		String p = Integer.toString(c);
                		view_table.appendText(p + "} FILE NUMBER : ");
                		view_table.appendText(res.getString("cse_no")+"\n");
                		view_table.appendText("     OFFICE FILE NO. : ");
                		view_table.appendText(res.getString("off_no")+"\n");
                		view_table.appendText("     APPLICANT : ");
                		view_table.appendText(res.getString("aplicnt")+"\n");
                		view_table.appendText("     OPPONENT : ");
                		view_table.appendText(res.getString("opont")+"\n");
                		view_table.appendText("     MATTER STATUS : ");
                		view_table.appendText(res.getString("status")+"\n");
                		view_table.appendText("     RECOMMENDED BY : ");
                		view_table.appendText(res.getString("advocate")+"\n\n\n");      		
                		c++;
                	}while(res.next());                    	
            }else {
            	view_table.setText("\n\n\n\n \t\t\t\t\t No  Schedule  For  " + mod_dte  );   
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
    }
}
