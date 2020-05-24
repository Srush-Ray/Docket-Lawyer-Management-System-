package application;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class updateController {
	homepageController obj=new homepageController();
	private static String matterType = null;
	boolean updatedm=false,updatedo=false;
    @FXML
    private BorderPane update_page;

    @FXML
    private DatePicker filed_date;

    @FXML
    private MenuButton matter_type;

    @FXML
    private TextField matter_no;

    @FXML
    private TextField opponent;

    @FXML
    private TextField applicant;

    @FXML
    private TextField fees;

    @FXML
    private TextField fees_reci;

    @FXML
    private Button cancel;

    @FXML
    private Button update;

    @FXML
    private TextField notes;

    @FXML
    private DatePicker next_date;
    
    @FXML
    private TextField fild_date_update;

    @FXML
    private TextField imp_date_update;

    @FXML
    private TextField add_money;

    @FXML
    private Button detil;
    
    @FXML
    private DatePicker rec_date;

    @FXML
    private TextField status;

    @FXML
    private TextField rec_dm;

    @FXML
    private DatePicker up_rec_dm;
    

    @FXML
    private TextField expen;
    
    @FXML
    private TextField adv_name;

    @FXML
    private TextField office_no;

    @FXML
    private TextField oldcaseno;


    @FXML
    private Button odetail;

    
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
    void func_cancel(ActionEvent event) throws IOException {
    	if(obj.getuser().equals(obj.ret_adm())) {
    		BorderPane pane = FXMLLoader.load(getClass().getResource("menupage.fxml"));
        	update_page.getChildren().setAll(pane);
    		}else {
    			BorderPane pane = FXMLLoader.load(getClass().getResource("usermenupage.fxml"));
    	    	update_page.getChildren().setAll(pane);
    		}
    }
   
    @FXML
    void func_update(ActionEvent event) {
    	
    	String officeno=null;
    	officeno=office_no.getText().toString();
    	String fileno=null;
    	fileno=matter_no.getText().toString();
    	if(officeno!=null && !officeno.equals("") && updatedo) {
    		update_by_on();	
    	}else if(fileno!=null && !fileno.equals("") && matterType!=null && updatedm)
    	{
    		update_by_mn();	
    	}else {
    		Alert a1 = new Alert(Alert.AlertType.WARNING);
    		a1.setTitle("WARNING");
    		a1.setContentText("Enter file number/ matter Type/ case number correctly.");
    		a1.setHeaderText(null);
    		a1.showAndWait();
    	}
    	 
    }
    
    
    private void update_by_mn() {
    	boolean doupdate=true;
    	boolean flag1 = true;   
    	if(!updatedm) {
    		applicant.clear();
    		opponent.clear();
    		fild_date_update.clear();                		
    		imp_date_update.clear();
    		fees.clear();
    		fees_reci.clear();
    		notes.clear();
    		add_money.clear();
    		rec_dm.clear();
    		status.clear();
    		filed_date.getEditor().clear();
    		next_date.getEditor().clear();
    		up_rec_dm.getEditor().clear();
    		rec_date.getEditor().clear();
    		expen.clear();
    		adv_name.clear();
    		updatedm=false;
    		}
    	String app_up=null,opp_up=null,filedate_up="0000-00-00",nextdate_up="0000-00-00",sta = null, regis_d = null, recDate = null,notes_up=null,adv=null;
    	String officeno=null;
    	officeno=office_no.getText().toString();
    	String fileno=null;
    	fileno=matter_no.getText().toString();    	
    	String table = obj.ret_adm();
    	String matter=null;
    	boolean flag=true;
    	float NR_fees=0,fee_up=0,rec_up=0,rold_f=0, exp = 0;
    	Alert al=new Alert(Alert.AlertType.CONFIRMATION);
    	al.setTitle("CONFIRM UPDATE");
    	al.setContentText("Do you want to update the file?");
    	al.setHeaderText("UPDATE?");
    	Optional<ButtonType>alert_result=al.showAndWait();
    	if(alert_result.get()==ButtonType.OK) { 
    		try {
    		app_up=applicant.getText().toString();
    		opp_up=opponent.getText().toString();    		
    		fee_up=Float.parseFloat(fees.getText());	
    		rold_f=Float.parseFloat(fees_reci.getText());
    		exp = Float.parseFloat(expen.getText());		    	
    	}catch(Exception E) {
    		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
    		a1.setTitle("WARNING");
    		a1.setHeaderText("All fields are compulsory.");
    		a1.setContentText("Click get details button to get exsisting details.\nEnter the same dates if no updates.");
    		a1.showAndWait();
    		flag=false;
    	}  
    		try {
    			adv=adv_name.getText().toString();
    		}catch(Exception e) {
    			adv=null;
    		}
    		try {
        		notes_up=notes.getText().toString();
        		}catch(Exception E)
        		{
        			notes_up=null;
        		}
    		try {
    			sta = status.getText().toString();
        		}catch(Exception E)
        		{    
        			sta=null;
        		}
    		
    		try {   
    			recDate=rec_date.getValue().toString();
    		}catch(Exception E) {
    			recDate="0000-00-00";
    		}
    		
    		try {
    			filedate_up = filed_date.getValue().toString();				
        	}catch(Exception e) {
        		filedate_up=fild_date_update.getText().toString();	    		
        	}
    		
    		try {
    			nextdate_up = next_date.getValue().toString();				
        	}catch(Exception e) {
        		nextdate_up=imp_date_update.getText().toString();	    		
        	}
    		

    		try {
    			regis_d = up_rec_dm.getValue().toString();				
        	}catch(Exception e) {
        		regis_d=rec_dm.getText().toString();	    		
        	}
    		
    		try {
    			rec_up=Float.parseFloat(add_money.getText());
    		}catch(Exception e) {
    			rec_up=0;
    		}
    		if(rec_up>0) {
    			if(recDate.equals("0000-00-00")) {
    				Alert al1=new Alert(Alert.AlertType.WARNING);
    		    	al1.setTitle("WARNING");
    		    	al1.setContentText("Enter Received Date.");
    		    	al1.setHeaderText(null);
    		    	al1.showAndWait();
    		    	flag1 = false;
    		    	doupdate=false;
    			}
    		}
    	if(!recDate.equals("0000-00-00")) {
    		if(rec_up<1) {
    			Alert al1=new Alert(Alert.AlertType.WARNING);
		    	al1.setTitle("WARNING");
		    	al1.setContentText("Enter Received Amount.");
		    	al1.setHeaderText(null);
		    	al1.showAndWait();
		    	flag1 = false;
		    	doupdate=false;
    		}
    	}
    	
    	if(recDate.equals("0000-00-00") && rec_up==0)
    		flag1 = false;
    	
      		if(flag) {
    		try {
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;                
                
                if(con != null)
                {
                	matter=matterType+" "+fileno;
                	stmt = con.createStatement();
        			String Sreachquery = "Select * from "+table+" where cse_no = '"+matter+"' ; ";
                	ResultSet result = stmt.executeQuery(Sreachquery);
                	if(result.next()) {                  	
                		NR_fees=rold_f+rec_up;
                		

                		if( fee_up < rec_up || NR_fees > fee_up )
                		{
                			Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    		a1.setTitle("WARNING");
                    		a1.setContentText("Received fees is wrong.");
                    		a1.setHeaderText(null);
                    		a1.showAndWait();
            		    	doupdate=false;
                		}
                		if(doupdate) {
                	String query ="UPDATE "+table+" set fld_dte='"+filedate_up+"', imp_dte='"+nextdate_up+"',regis_dte = '"+regis_d+"', opont='"+opp_up+"', aplicnt='"+app_up+"', notes='"+notes_up+"', status = '"+sta+"',fee="+fee_up+",expen = "+exp+", rec_fe="+NR_fees+",advocate='"+adv+"' where cse_no='"+matter+"';";
                	int n=0;
                	n=stmt.executeUpdate(query);
                	if(flag1)
                	{
                		String offn;
                		try
                		{
                			offn = officeno.replace('/','_');
                			offn="T"+offn;
                		String q = "INSERT INTO "+offn+" VALUES (?,?)";
                		
                		PreparedStatement st = con.prepareStatement(q);
                         st.setString(1, recDate);
                         st.setFloat(2, rec_up);
                         st.executeUpdate();
                		}catch (Exception e)
                		{
                			System.out.println(e.getLocalizedMessage());
                			Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    		a1.setTitle("WARNING");
                    		a1.setContentText("Could not update received fees.");
                    		a1.setHeaderText(null);
                    		a1.showAndWait();	
                		}
                	}
                	
                	if(n!=0)
                	{
                		applicant.clear();
                		opponent.clear();
                		fild_date_update.clear();                		
                		imp_date_update.clear();
                		fees.clear();
                		fees_reci.clear();
                		notes.clear();
                		add_money.clear();
                		rec_dm.clear();
                		status.clear();
                		filed_date.getEditor().clear();
                		next_date.getEditor().clear();
                		up_rec_dm.getEditor().clear();
                		rec_date.getEditor().clear();
                		expen.clear();
                		adv_name.clear();
                		
                			Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    		a1.setTitle("DATA UPDATED");
                    		a1.setContentText("File/Record updated successfully.");
                    		a1.setHeaderText(null);
                    		a1.showAndWait();
                	}
                	else
                	{
                		Alert a1 = new Alert(Alert.AlertType.ERROR);
                		a1.setTitle("ERROR");
                		a1.setContentText("Could not update data.Try again later.");
                		a1.setHeaderText("DATABASE CONNECTIVITY ERROR");
                		a1.showAndWait();
                	}
                		}else {
                			Alert a1 = new Alert(Alert.AlertType.WARNING);
                    		a1.setTitle("WARNING");
                    		a1.setContentText("Could not update data.Try again later.Date and recevied amount is wrong.");
                    		a1.setHeaderText(null);
                    		a1.showAndWait();
                		}
                	
                	
                	
                }else {
                	Alert a1 = new Alert(Alert.AlertType.WARNING);
            		a1.setTitle("WARNING");
            		a1.setContentText("File not found.Try again later.");
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
      		}
    }
    
    
    
    private void update_by_on() {
    	boolean doupdate=true;
    	boolean flag1 = true;   
    	if(!updatedo) {
    		applicant.clear();
    		opponent.clear();
    		fild_date_update.clear();                		
    		imp_date_update.clear();
    		fees.clear();
    		fees_reci.clear();
    		notes.clear();
    		add_money.clear();
    		rec_dm.clear();
    		status.clear();
    		filed_date.getEditor().clear();
    		next_date.getEditor().clear();
    		up_rec_dm.getEditor().clear();
    		rec_date.getEditor().clear();
    		expen.clear();
    		adv_name.clear();
    		updatedm=false;
    		}
    	String app_up=null,opp_up=null,filedate_up="0000-00-00",nextdate_up="0000-00-00",sta = null, regis_d = null, recDate = null,notes_up=null,adv=null;
    	String officeno=null;
    	officeno=office_no.getText().toString();
    	
    	String table = obj.ret_adm();
    	boolean flag=true;
    	float NR_fees=0,fee_up=0,rec_up=0,rold_f=0, exp = 0;
    	Alert al=new Alert(Alert.AlertType.CONFIRMATION);
    	al.setTitle("CONFIRM UPDATE");
    	al.setContentText("Do you want to update the file?");
    	al.setHeaderText("UPDATE?");
    	Optional<ButtonType>alert_result=al.showAndWait();
    	if(alert_result.get()==ButtonType.OK) { 
    		try {
    		app_up=applicant.getText().toString();
    		opp_up=opponent.getText().toString();    		
    		fee_up=Float.parseFloat(fees.getText());	
    		rold_f=Float.parseFloat(fees_reci.getText());
    		exp = Float.parseFloat(expen.getText());	
    		
    		
    	}catch(Exception E) {
    		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
    		a1.setTitle("WARNING");
    		a1.setHeaderText("All fields are compulsory.");
    		a1.setContentText("Click get details button to get exsisting details.\nEnter the same dates if no updates.");
    		a1.showAndWait();
    		flag=false;
    	}  
    		try {
    			adv=adv_name.getText().toString();
    		}catch(Exception e) {
    			adv=null;
    		}
    		try {
        		notes_up=notes.getText().toString();
        		}catch(Exception E)
        		{
        			notes_up=null;
        		}
    		try {
    			sta = status.getText().toString();
        		}catch(Exception E)
        		{    
        			sta=null;
        		}
    		
    		try {   
    			recDate=rec_date.getValue().toString();
    		}catch(Exception E) {
    			recDate="0000-00-00";
    		}
    		
    		try {
    			filedate_up = filed_date.getValue().toString();				
        	}catch(Exception e) {
        		filedate_up=fild_date_update.getText().toString();	    		
        	}
    		
    		try {
    			nextdate_up = next_date.getValue().toString();				
        	}catch(Exception e) {
        		nextdate_up=imp_date_update.getText().toString();	    		
        	}
    		
    		try {
    			regis_d = up_rec_dm.getValue().toString();				
        	}catch(Exception e) {
        		regis_d=rec_dm.getText().toString();	    		
        	}
    		
    		try {
    			rec_up=Float.parseFloat(add_money.getText());
    		}catch(Exception e) {
    			rec_up=0;
    		}
    		if(rec_up>0) {
    			if(recDate.equals("0000-00-00")) {
    				Alert al1=new Alert(Alert.AlertType.WARNING);
    		    	al1.setTitle("WARNING");
    		    	al1.setContentText("Enter Received Date.");
    		    	al1.setHeaderText(null);
    		    	al1.showAndWait();
    		    	flag1 = false;
    		    	doupdate=false;
    			}
    		}
    	if(!recDate.equals("0000-00-00")) {
    		if(rec_up<1) {
    			Alert al1=new Alert(Alert.AlertType.WARNING);
		    	al1.setTitle("WARNING");
		    	al1.setContentText("Enter Received Amount.");
		    	al1.setHeaderText(null);
		    	al1.showAndWait();
		    	flag1 = false;
		    	doupdate=false;
    		}
    	}
    	
    	if(recDate.equals("0000-00-00") && rec_up==0)
    		flag1 = false;
    	
      		if(flag) {
    		try {
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;                
                
                if(con != null)
                {
                	stmt = con.createStatement();
        			String Sreachquery = "Select * from "+table+" where off_no = '"+officeno+"' ; ";
                	ResultSet result = stmt.executeQuery(Sreachquery);
                	if(result.next()) {                  	
                		NR_fees=rold_f+rec_up;
                		

                		if( fee_up < rec_up || NR_fees > fee_up )
                		{
                			Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    		a1.setTitle("WARNING");
                    		a1.setContentText("Received fees is wrong.");
                    		a1.setHeaderText(null);
                    		a1.showAndWait();
                    		doupdate=false;
                		}
                		if(doupdate) {
                	String query ="UPDATE "+table+" set fld_dte='"+filedate_up+"', imp_dte='"+nextdate_up+"',regis_dte = '"+regis_d+"', opont='"+opp_up+"', aplicnt='"+app_up+"', notes='"+notes_up+"', status = '"+sta+"',fee="+fee_up+",expen = "+exp+", rec_fe="+NR_fees+",advocate='"+adv+"' where off_no='"+officeno+"';";
                	int n=0;
                	n=stmt.executeUpdate(query);
                	if(flag1)
                	{
                		String offn;
                		try
                		{
                			offn = officeno.replace('/','_');
                			offn="T"+offn;
                		String q = "INSERT INTO "+offn+" VALUES (?,?)";
                		
                		PreparedStatement st = con.prepareStatement(q);
                         st.setString(1, recDate);
                         st.setFloat(2, rec_up);
                         st.executeUpdate();
                		}catch (Exception e)
                		{
                			System.out.println(e.getLocalizedMessage());
                			Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    		a1.setTitle("WARNING");
                    		a1.setContentText("Could not update received fees.");
                    		a1.setHeaderText(null);
                    		a1.showAndWait();	
                		}
                	}
                	
                	if(n!=0)
                	{
                		applicant.clear();
                		opponent.clear();
                		fild_date_update.clear();                		
                		imp_date_update.clear();
                		fees.clear();
                		fees_reci.clear();
                		notes.clear();
                		add_money.clear();
                		rec_dm.clear();
                		status.clear();
                		filed_date.getEditor().clear();
                		next_date.getEditor().clear();
                		up_rec_dm.getEditor().clear();
                		rec_date.getEditor().clear();
                		expen.clear();
                		adv_name.clear();
                		
                			Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    		a1.setTitle("DATA UPDATED");
                    		a1.setContentText("File/Record updated successfully.");
                    		a1.setHeaderText(null);
                    		a1.showAndWait();
                	}
                	else
                	{
                		Alert a1 = new Alert(Alert.AlertType.ERROR);
                		a1.setTitle("ERROR");
                		a1.setContentText("Could not update data.Try again later.");
                		a1.setHeaderText("DATABASE CONNECTIVITY ERROR");
                		a1.showAndWait();
                	}
                		}else {
                			Alert a1 = new Alert(Alert.AlertType.WARNING);
                    		a1.setTitle("WARNING");
                    		a1.setContentText("Could not update data.Try again later.Date and recevied amount is wrong.");
                    		a1.setHeaderText(null);
                    		a1.showAndWait();
                		}
                	
                	
                }else {
                	Alert a1 = new Alert(Alert.AlertType.WARNING);
            		a1.setTitle("WARNING");
            		a1.setContentText("File not found.Try again later.");
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
      		}
    }
    
    
    @FXML
    void getdetailson(ActionEvent event) {
    	applicant.clear();
		opponent.clear();
		fild_date_update.clear();                		
		imp_date_update.clear();
		fees.clear();
		fees_reci.setText("0");
		notes.clear();
		add_money.setText("0");
		rec_dm.clear();
		status.clear();
		filed_date.getEditor().clear();
		next_date.getEditor().clear();
		up_rec_dm.getEditor().clear();
		rec_date.getEditor().clear();
		expen.clear();
		adv_name.clear();
		oldcaseno.clear();
		matter_no.clear();
		matter_type.setText("Matter Type");
		
		
    	String officeno=null;
    	try {
    		officeno=office_no.getText().toString();
        	}catch(Exception E) {
        		officeno=null;
        	}
    	String table=obj.ret_adm();
    	try {
			Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Lawyer.db";
            Connection con = DriverManager.getConnection(dbURL);
            Statement stmt = null;
            
            if(con != null)
            {    
            	stmt = con.createStatement();            	
            	if(officeno!=null && !officeno.equals(""))
            	{
            	String query = "Select * from "+table+" where off_no = '"+officeno+"' ; ";
            	ResultSet res = stmt.executeQuery(query);
            	if(res.next())
            	{            		
            		oldcaseno.setText(res.getString("cse_no"));
            		office_no.setText(res.getString("off_no"));
            		applicant.setText(res.getString("aplicnt"));
            		opponent.setText(res.getString("opont"));
            		fild_date_update.setText(res.getString("fld_dte"));
            		imp_date_update.setText(res.getString("imp_dte"));
            		fees.setText(res.getString("fee"));
            		fees_reci.setText(res.getString("rec_fe"));
            		notes.setText(res.getString("notes"));
            		status.setText(res.getString("status"));
            		rec_dm.setText(res.getString("regis_dte"));
            		expen.setText(res.getString("expen"));
            		adv_name.setText(res.getString("advocate"));
            		updatedo=true;
            	}
            	else
            	{
            		Alert a1 = new Alert(Alert.AlertType.WARNING);
            		a1.setTitle("WARNING");
            		a1.setContentText("Case not found.May not be present.Try again later.");
            		a1.setHeaderText(null);
            		a1.showAndWait();
            	}
            }                	
            else {
            	Alert a1 = new Alert(Alert.AlertType.WARNING);
        		a1.setTitle("WARNING");
        		a1.setContentText("Enter file number correctly.");
        		a1.setHeaderText(null);
        		a1.showAndWait();
            }
            }else{
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
   
    
    @FXML
    void func_detail(ActionEvent event) {

    	applicant.clear();
		opponent.clear();
		fild_date_update.clear();                		
		imp_date_update.clear();
		fees.clear();
		fees_reci.setText("0");
		notes.clear();
		add_money.setText("0");
		rec_dm.clear();
		status.clear();
		filed_date.getEditor().clear();
		next_date.getEditor().clear();
		up_rec_dm.getEditor().clear();
		rec_date.getEditor().clear();
		expen.clear();
		adv_name.clear();
		oldcaseno.clear();
		office_no.clear();
    	String fileno,matter_n=null;
    	try {
    		fileno=matter_no.getText().toString();
    	
        	}catch(Exception E) {
        		fileno=null;
        	}
    	String table=obj.ret_adm();
    	try {
			Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Lawyer.db";
            Connection con = DriverManager.getConnection(dbURL);
            Statement stmt = null;
            
            if(con != null)
            {    
            	
            	stmt = con.createStatement();            	
            	if(fileno!=null && !fileno.equals("") && matterType!=null)
            	{
            		
            		matter_n=matterType+" "+fileno;
            	String query = "Select * from "+table+" where cse_no = '"+matter_n+"' ; ";
            	ResultSet res = stmt.executeQuery(query);
            	if(res.next())
            	{            		
            		oldcaseno.setText(res.getString("cse_no"));
            		office_no.setText(res.getString("off_no"));
            		applicant.setText(res.getString("aplicnt"));
            		opponent.setText(res.getString("opont"));
            		fild_date_update.setText(res.getString("fld_dte"));
            		imp_date_update.setText(res.getString("imp_dte"));
            		fees.setText(res.getString("fee"));
            		fees_reci.setText(res.getString("rec_fe"));
            		notes.setText(res.getString("notes"));
            		status.setText(res.getString("status"));
            		rec_dm.setText(res.getString("regis_dte"));
            		expen.setText(res.getString("expen"));
            		adv_name.setText(res.getString("advocate"));
            		updatedm=true;
            	}
            	else
            	{
            		Alert a1 = new Alert(Alert.AlertType.WARNING);
            		a1.setTitle("WARNING");
            		a1.setContentText("File not found.May not be present.Try again later.");
            		a1.setHeaderText(null);
            		a1.showAndWait();
            	}
            }                	
            else {
            	Alert a1 = new Alert(Alert.AlertType.WARNING);
        		a1.setTitle("WARNING");
        		a1.setContentText("Enter Case number/matter Type correctly.");
        		a1.setHeaderText(null);
        		a1.showAndWait();
            }
            }else{
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