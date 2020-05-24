package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class DeletepageController implements Initializable{
	homepageController obj = new homepageController();
	boolean flag =  false;
	
	@FXML
	private BorderPane page;
	
	@FXML
	private TextArea display_text;
    
    @FXML
    private TextField filenumber;

    @FXML
    private Button deletebutton;
    
    @FXML
    private Button home;
    
    @FXML
    private Button detail;
    
    @FXML
    void show_detail(ActionEvent event) {

    	flag = true ;
    	String fileno=filenumber.getText().toString();
    	String table = obj.ret_adm();
    	if(fileno!=null && !fileno.equals(""))
    	{
    		try {
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;
                
                if(con != null)
                {
                	stmt = con.createStatement();
                	String query = "Select * from "+table+" where off_no = '"+fileno+"' ; ";
                	ResultSet res = stmt.executeQuery(query);
                	
                	if(res.next())
                	{
                		
                		display_text.setText("OFFICE FILE NUMBER : ");
                		display_text.appendText(res.getString("off_no")+"\n\n");	
                		display_text.appendText("FILE NUMBER : ");
                		display_text.appendText(res.getString("cse_no")+"\n\n");
                		display_text.appendText("APPLICANT : ");
                		display_text.appendText(res.getString("aplicnt")+"\n\n");
                		display_text.appendText("OPPONENT : ");
                		display_text.appendText(res.getString("opont")+"\n\n");
                		display_text.appendText("REGISTERED DATE : ");
                		display_text.appendText(res.getString("regis_dte")+"\n\n");
                		display_text.appendText("FILED IN COURT ON : ");
                		display_text.appendText(res.getString("fld_dte")+"\n\n");
                		display_text.appendText("IMPORTANT DATE : ");
                		display_text.appendText(res.getString("imp_dte")+"\n\n");                		
                		display_text.appendText("FEES : ");
                		display_text.appendText(res.getString("fee")+"\n\n");
                		display_text.appendText("RECEIVED Fees : ");
                		display_text.appendText(res.getString("rec_fe")+"\n\n");
                		
                		String f = res.getString("fee");
                		String rf = res.getString("rec_fe");
                		
                		float ft = Float.parseFloat(f);
                		float frt = Float.parseFloat(rf);
                		frt = ft - frt;
                		rf = Float.toString(frt);
                		
                		display_text.appendText("PENDING FEES: ");
                		display_text.appendText(rf+"\n\n");
                		display_text.appendText("EXPENSES : ");
                		display_text.appendText(res.getString("expen")+"\n\n");
                		display_text.appendText("STATUS: ");
                		display_text.appendText(res.getString("status")+"\n\n");
                		display_text.appendText("NOTES : ");
                		display_text.appendText(res.getString("notes")+"\n\n");
                		display_text.appendText("RECOMMENDED BY : ");
                		display_text.appendText(res.getString("advocate")+"\n\n");
                	}
                	else
                	{
                		Alert a1 = new Alert(Alert.AlertType.WARNING);
                		a1.setTitle("WARNING");
                		a1.setContentText("File not found.");
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
    		
    	}else {
    		Alert a1 = new Alert(Alert.AlertType.WARNING);
    		a1.setTitle("WARNING");
    		a1.setContentText("Enter file number/ matter Type correctly.");
    		a1.setHeaderText(null);
    		a1.showAndWait();
    		flag = false;
    	}
    	
    }

    	
    
    
    @FXML
    void deleteRecord(ActionEvent event) {
    	
    	if(flag)
    	{
        	String fileno=filenumber.getText().toString();
        	String table = obj.ret_adm();
        	if(fileno!=null && !fileno.equals("")) {
            		try {
            			Class.forName("org.sqlite.JDBC");
            			String url="jdbc:sqlite:Lawyer.db";
            			Connection conn=null;
            			conn=DriverManager.getConnection(url);
                    	Statement stmt = null,stmt1=null;
            			if(conn!=null) {
            				stmt = conn.createStatement();
            				String search="select * from "+table+" where off_no ='"+fileno+"';";
            				ResultSet res= stmt.executeQuery(search);   
            			
            				if(res.next()) {
                				Alert al=new Alert(Alert.AlertType.CONFIRMATION);
                				al.setTitle("CONFIRM DELETE");
                				al.setContentText("Do you want to delete the file?");
                				al.setHeaderText("DELETE?");
                				Optional<ButtonType>alert_result=al.showAndWait();
                				if(alert_result.get()==ButtonType.OK) {
                					stmt1=conn.createStatement();
                					String deleteQuery="delete from "+table+" where off_no ='"+fileno+"';";
                					stmt1.executeUpdate(deleteQuery);
                					String t=fileno.replace('/', '_');
                					t="T"+t;
                    			String drop="drop table "+t+";";
                    			stmt.executeUpdate(drop);
                    				Alert a=new Alert(Alert.AlertType.INFORMATION);
                    				a.setTitle("FILE DELETED");
                    				a.setContentText("Record is deleted.");
                    				a.setHeaderText(null);
                    				a.showAndWait();
                    				
                				}else {
                					
                				}
                				
            				}else {
            					Alert al=new Alert(Alert.AlertType.WARNING);
                				al.setTitle("ERROR");
                				al.setContentText("File not found or record is already deleted.");
                				al.setHeaderText(null);
                				al.showAndWait();
            				}
            				stmt.close();
            				conn.close();        				
            			}else {
            				Alert a1=new Alert(Alert.AlertType.ERROR);
        	            	a1.setTitle("ERROR");
        	                a1.setContentText("Could not establish connection with database.");
        	                a1.setHeaderText("Connection Lost!");
        	                a1.showAndWait();
            				
            			}
            			
            		}catch(Exception E) {
            			System.out.println(E.getLocalizedMessage());
            			Alert a1=new Alert(Alert.AlertType.ERROR);
                    	a1.setTitle("ERROR");
                    	a1.setContentText("Unable to connect to database.");
                        a1.setHeaderText("DATABASE NOT CONNECTED!");
                        a1.showAndWait();
        				
            		}}
        	else {
        		Alert al=new Alert(Alert.AlertType.WARNING);
    			al.setTitle("ERROR");
    			al.setContentText("Enter correct file/matter number.");
    			al.setHeaderText(null);
    			al.showAndWait();
        	}
        	
        	flag = false;
    	}
    	else
    	{
    		Alert al=new Alert(Alert.AlertType.WARNING);
			al.setTitle("WARNING");
			al.setContentText("Click on get details button first.");
			al.setHeaderText(null);
			al.showAndWait();
    	}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    void func_home(ActionEvent event) throws IOException {
		if(obj.getuser().equals(obj.ret_adm())) {
		BorderPane pane = FXMLLoader.load(getClass().getResource("menupage.fxml"));
    	page.getChildren().setAll(pane);
		}else {
			BorderPane pane = FXMLLoader.load(getClass().getResource("usermenupage.fxml"));
	    	page.getChildren().setAll(pane);
		}
	}


}