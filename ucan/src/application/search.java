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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class  search{
    private static String matterType=null;
	homepageController obj = new homepageController();
	
	 @FXML
	 public TextArea display;
	
	 @FXML
	 public TextField matter_no;
	 
	 @FXML
	 private TextArea date_dis;

	 @FXML
	 private TextArea amt_dis;

	 @FXML
	 private MenuButton matter_type;
	
	 @FXML
	 private BorderPane search_page;
	 
    @FXML
    private Button home;

    @FXML
    private Button search;
    

    @FXML
    private Button search1;

    @FXML
    private Button search2;

    @FXML
    private TextField adv_name;

    @FXML
    private TextField file_no;
    
    @FXML
    private MenuItem SA;

    @FXML
    private MenuItem WP;

    @FXML
    private MenuItem CA;

    @FXML
    private MenuItem CRA;

    @FXML
    private MenuItem CrApp;

    @FXML
    private MenuItem AO;

    @FXML
    private MenuItem CP;

    @FXML
    private MenuItem FA;

    @FXML
    private MenuItem MCA;

    @FXML
    private MenuItem CrAppl;

    @FXML
    private MenuItem CrWP;

    @FXML
    private MenuItem PIL;

    @FXML
    private MenuItem ArbPet;

    @FXML
    private void getAO(ActionEvent event) {
    	try {
    	AO=(MenuItem) event.getSource();
    	matterType="A.O.";
    	matter_type.setText("A.O.");      	
    	}catch(Exception E) {
    	}
    }

    @FXML
    private void getArbPet(ActionEvent event) {
    	try {
    		ArbPet=(MenuItem) event.getSource();
    		matterType="Arb.Pet.";
    		matter_type.setText("Arb.Pet.");
	}catch(Exception E) {
	}
    }

    @FXML
    private void getCA(ActionEvent event) {
    	try {
    	CA=(MenuItem) event.getSource();
    	matterType="C.A.";
    	matter_type.setText("C.A.");
	}catch(Exception E) {
	}
    }

    @FXML
    private void getCP(ActionEvent event) {
    	try {
    		CP=(MenuItem) event.getSource();
    		matterType="C.P.";
    		matter_type.setText("C.P.");
	}catch(Exception E) {
		
	}
    }

    @FXML
    private void getCRA(ActionEvent event) {
    	try {
    		CRA=(MenuItem) event.getSource();
    		matterType="C.R.A.";
    		matter_type.setText("C.R.A.");
    	}catch(Exception E) {
    	}
    }

    @FXML
    private void getCrApp(ActionEvent event) {
    	try {
    		CrApp=(MenuItem) event.getSource();
    		matterType="Cr.App.";
    		matter_type.setText("Cr.App.");
    	}catch(Exception E) {
    	}
    }

    @FXML
    private void getCrAppl(ActionEvent event) {
    	try {
    		CrAppl=(MenuItem) event.getSource();
    		matterType="Cr.Appl.";
    		matter_type.setText("Cr.Appl.");
    }catch(Exception E) {
		}
    }

    @FXML
    private void getCrWP(ActionEvent event) {
    	try {
    		CrWP=(MenuItem) event.getSource();
    		matterType="Cr.W.P.";
    		matter_type.setText("Cr.W.P.");
    }catch(Exception E) {
		}
    }

    @FXML
    private void getFA(ActionEvent event) {
    	try { 
    		FA=(MenuItem) event.getSource();
    		matterType="F.A.";
    		matter_type.setText("F.A.");
    }catch(Exception E) {
		}
    }

    @FXML
    private void getMCA(ActionEvent event) {
    	try { 
    	MCA=(MenuItem) event.getSource();
    	matterType="M.C.A.";
    	matter_type.setText("M.C.A.");
    	 }catch(Exception E) {
    			}
    }

    @FXML
    private void getPIL(ActionEvent event) {
    	try { 
    		PIL=(MenuItem) event.getSource();
    		matterType="P.I.L.";
    		matter_type.setText("P.I.L.");
    }catch(Exception E) {
		}
    }

    @FXML
    private void getSA(ActionEvent event) {
    	try { 
    SA=(MenuItem) event.getSource();
    matterType="S.A.";
    matter_type.setText("S.A.");
    }catch(Exception E) {
		}
    }

    @FXML
    private void getWP(ActionEvent event) {
    	try { 
    		WP=(MenuItem) event.getSource();
    		matterType="W.P.";
    		matter_type.setText("W.P.");
    	    }catch(Exception E) {
    			}
    }

    @FXML
    void func_home(ActionEvent event) throws IOException {
    	if(obj.getuser().equals(obj.ret_adm())) {
    		BorderPane pane = FXMLLoader.load(getClass().getResource("menupage.fxml"));
        	search_page.getChildren().setAll(pane);
    		}else {
    			BorderPane pane = FXMLLoader.load(getClass().getResource("usermenupage.fxml"));
    	    	search_page.getChildren().setAll(pane);
    		}

    }

    @FXML
    void ad_search(ActionEvent event) {
    	file_no.clear();
    	matter_no.clear();
    	matter_type.setText("Matter Type");
    	display.clear();
    	String table = obj.ret_adm();
    	String ad=null;
    	try {
    		ad=adv_name.getText().toString();
    	}catch(Exception E){
    		Alert a1=new Alert(Alert.AlertType.WARNING);
        	a1.setTitle("WARNING");
            a1.setContentText("Enter advocate name.");
            a1.showAndWait();
    	}
    	if(ad!=null) {
    		try {
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;
                
                if(con != null)
                {
                	stmt=con.createStatement();
                	String query = "Select * from "+table+" where advocate = '"+ad+"' ; ";
                	ResultSet res = stmt.executeQuery(query);                			
                	int count=1;
                	if(res.next())
                	{
                		do {
                		String p = Integer.toString(count);
                    	display.appendText(p + "} ");
                    	display.appendText("OFFICE FILE NUMBER : ");
                    	display.appendText(res.getString("off_no")+"\n\n");	
                		display.appendText("FILE NUMBER : ");
                		display.appendText(res.getString("cse_no")+"\n\n");
                		display.appendText("APPLICANT : ");
                		display.appendText(res.getString("aplicnt")+"\n\n");
                		display.appendText("OPPONENT : ");
                		display.appendText(res.getString("opont")+"\n\n");
                		display.appendText("IMPORTANT DATE : ");
                		display.appendText(res.getString("imp_dte")+"\n\n");                		
                		display.appendText("FEES : ");
                		display.appendText(res.getString("fee")+"\n\n");
                		display.appendText("STATUS : ");
                		display.appendText(res.getString("status")+"\n\n");
                		display.appendText("NOTES : ");
                		display.appendText(res.getString("notes")+"\n\n\n\n");
                		count++;
                		}while(res.next());
                		
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
    		Alert a1=new Alert(Alert.AlertType.WARNING);
        	a1.setTitle("WARNING");
            a1.setContentText("Enter advocate name.");
            a1.showAndWait();
    	}
    }

    @FXML
    void file_search(ActionEvent event) {
    	adv_name.clear();
    	matter_no.clear();
    	matter_type.setText("Matter Type");
    	String table = obj.ret_adm();
    	String fno=null;
    	try {
    		fno=file_no.getText().toString();
    	}catch(Exception E){
    		Alert a1=new Alert(Alert.AlertType.WARNING);
        	a1.setTitle("WARNING");
            a1.setContentText("Enter file number name.");
            a1.showAndWait();
    	}
    	if(fno!=null) {
    		try {
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;
                
                if(con != null)
                {
                	stmt=con.createStatement();
                	String query = "Select * from "+table+" where off_no = '"+fno+"' ; ";
                	ResultSet res = stmt.executeQuery(query);                			
                	
                	if(res.next())
                	{
                		display.setText("OFFICE FILE NUMBER : ");
                    	display.appendText(res.getString("off_no")+"\n\n");	
                		display.appendText("FILE NUMBER : ");
                		display.appendText(res.getString("cse_no")+"\n\n");
                		display.appendText("APPLICANT : ");
                		display.appendText(res.getString("aplicnt")+"\n\n");
                		display.appendText("OPPONENT : ");
                		display.appendText(res.getString("opont")+"\n\n");
                		display.appendText("REGISTERED DATE : ");
                		display.appendText(res.getString("regis_dte")+"\n\n");
                		display.appendText("FILED IN COURT ON : ");
                		display.appendText(res.getString("fld_dte")+"\n\n");
                		display.appendText("IMPORTANT DATE : ");
                		display.appendText(res.getString("imp_dte")+"\n\n");                		
                		display.appendText("FEES : ");
                		display.appendText(res.getString("fee")+"\n\n");
                		display.appendText("RECEIVED Fees : ");
                		display.appendText(res.getString("rec_fe")+"\n\n");
                		
                		String f = res.getString("fee");
                		String rf = res.getString("rec_fe");
                		
                		float ft = Float.parseFloat(f);
                		float frt = Float.parseFloat(rf);
                		frt = ft - frt;
                		rf = Float.toString(frt);
                		
                		display.appendText("PENDING FEES: ");
                		display.appendText(rf+"\n\n");
                		
                		display.appendText("EXPENSES : ");
                		display.appendText(res.getString("expen")+"\n\n");
                		display.appendText("STATUS : ");
                		display.appendText(res.getString("status")+"\n\n");
                		display.appendText("NOTES : ");
                		display.appendText(res.getString("notes")+"\n\n");
                		display.appendText("ADVOCATE : ");
                    	display.appendText(res.getString("advocate")+"\n\n");	
                    	
                    	
                    	String t =res.getString("off_no");
                    	
                    	String offn=t.replace('/','_');
                    	offn="T"+offn;
                    	String que = "select * from "+offn+" ;";
                    	ResultSet res1 = stmt.executeQuery(que);
                    	if(res1.next())
                    	{
                    		
                    		int c = 1;
                    	
                    		amt_dis.setText("\n");
                    		date_dis.setText("\n");
                   
                    		do{
         
                    			String p = Integer.toString(c);
                    			amt_dis.appendText(p + "} ");
                    			amt_dis.appendText(res.getString(2)+"\n\n");
                    			date_dis.appendText(p + "} ");
                    			date_dis.appendText(res.getString(1)+"\n\n");
                    			c++;
         
                    		}while(res1.next()) ;
                    	}
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
    		Alert a1=new Alert(Alert.AlertType.WARNING);
        	a1.setTitle("WARNING");
            a1.setContentText("Enter file number name.");
            a1.showAndWait();
    	}
    }
    
    
    @FXML
    void func_search(ActionEvent event) {
    	String fileno=matter_no.getText().toString();
    	String table = obj.ret_adm();
    	String matter;
    	
    	if(fileno!=null && !fileno.equals("") && matterType!=null)
    	{
    		try {
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;
                
                if(con != null)
                {
                	matter=matterType+" "+fileno;
                	stmt = con.createStatement();
                	String query = "Select * from "+table+" where cse_no = '"+matter+"' ; ";
                	ResultSet res = stmt.executeQuery(query);
                			
                	
                	if(res.next())
                	{
                		display.setText("OFFICE FILE NUMBER : ");
                    	display.appendText(res.getString("off_no")+"\n\n");	
                		display.appendText("FILE NUMBER : ");
                		display.appendText(res.getString("cse_no")+"\n\n");
                		display.appendText("APPLICANT : ");
                		display.appendText(res.getString("aplicnt")+"\n\n");
                		display.appendText("OPPONENT : ");
                		display.appendText(res.getString("opont")+"\n\n");
                		display.appendText("REGISTERED DATE : ");
                		display.appendText(res.getString("regis_dte")+"\n\n");
                		display.appendText("FILED IN COURT ON : ");
                		display.appendText(res.getString("fld_dte")+"\n\n");
                		display.appendText("IMPORTANT DATE : ");
                		display.appendText(res.getString("imp_dte")+"\n\n");                		
                		display.appendText("FEES : ");
                		display.appendText(res.getString("fee")+"\n\n");
                		display.appendText("RECEIVED Fees : ");
                		display.appendText(res.getString("rec_fe")+"\n\n");
                		
                		String f = res.getString("fee");
                		String rf = res.getString("rec_fe");
                		
                		float ft = Float.parseFloat(f);
                		float frt = Float.parseFloat(rf);
                		frt = ft - frt;
                		rf = Float.toString(frt);
                		
                		display.appendText("PENDING FEES: ");
                		display.appendText(rf+"\n\n");
                		
                		display.appendText("EXPENSES : ");
                		display.appendText(res.getString("expen")+"\n\n");
                		display.appendText("STATUS : ");
                		display.appendText(res.getString("status")+"\n\n");
                		display.appendText("NOTES : ");
                		display.appendText(res.getString("notes")+"\n\n");
                		display.appendText("ADVOCATE : ");
                    	display.appendText(res.getString("advocate")+"\n\n");	
                    	
                    	
                	}
                	else
                	{
                		Alert a1 = new Alert(Alert.AlertType.WARNING);
                		a1.setTitle("WARNING");
                		a1.setContentText("File not found.");
                		a1.setHeaderText(null);
                		a1.showAndWait();
                	}
                	
                	
                	String t =res.getString("off_no");                	
                	String offn=t.replace('/','_');
                	offn="T"+offn;
                	String que = "select * from "+offn+" ;";
                	ResultSet res1 = stmt.executeQuery(que);
            
                	if(res1.next())
                	{
                		
                		int c = 1;
                	
                		amt_dis.setText("\n");
                		date_dis.setText("\n");
               
                		do{
     
                			String p = Integer.toString(c);
                			amt_dis.appendText(p + "} ");
                			amt_dis.appendText(res.getString(2)+"\n\n");
                			date_dis.appendText(p + "} ");
                			date_dis.appendText(res.getString(1)+"\n\n");
                			c++;
     
                		}while(res1.next()) ;
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
    	}
    }

}
