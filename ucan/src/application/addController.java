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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class addController {

	homepageController obj = new homepageController();
	private static String matterType=null;
	
	 @FXML
	 private BorderPane add_page;
	
    @FXML
    private DatePicker filed_date;

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
    private Button save;

    @FXML
    private TextField notes;

    @FXML
    private DatePicker next_date;
    
    @FXML
    private MenuButton matter_type;
    

    @FXML
    private DatePicker rec_date;

    @FXML
    private TextField expenses;

    @FXML
    private TextField status;
    
    @FXML
    private TextField office_no;

    @FXML
    private TextField adv_name;
    
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
        	add_page.getChildren().setAll(pane);
    		}else {
    			BorderPane pane = FXMLLoader.load(getClass().getResource("usermenupage.fxml"));
    	    	add_page.getChildren().setAll(pane);
    		}
    }


    @FXML
    void func_save(ActionEvent event) throws IOException {
    	String offi_no=null;
    	String advocate=null;
    	String petitioner = null;
    	String respondent = null;
    	String stat = null;
    	float fee = 0;
    	float exp = 0;
    	String note = null;
    	String nxt_d = "0000-00-00";
    	String file_no = null;
    	String cse_no = null;
    	String fld_d = "0000-00-00";
    	String rec_d = null;
    	int v = 0 ;
    	float rem = 0;
    	String table = obj.ret_adm();
    	
    	try {
        	offi_no=office_no.getText().toString();
    		petitioner = applicant.getText().toString();
        	respondent = opponent.getText().toString();   
        	rec_d = rec_date.getValue().toString(); 
    	}catch(Exception e)
    	{
    		Alert a1 = new Alert(Alert.AlertType.WARNING);
    		a1.setTitle("WARNING");
    		a1.setContentText("Some input fields are empty.Enter the compulsory fields.");
    		a1.setHeaderText(null);
    		a1.showAndWait();
    		v = 1;
    	}
    	try {
    		fee = Float.parseFloat(fees.getText());    		
    	}catch(Exception e) {
    		fee=0;
    	}
    	try {
    		note = notes.getText().toString();
    	}catch(Exception e) {
    	}
    	try {
    		cse_no = matter_no.getText().toString(); 
    	}catch(Exception e) {
    		cse_no=null;
    	}
    	try {
    		exp = Float.parseFloat(expenses.getText());
    	}catch(Exception e) {
    		exp=0;
    	}
    	try {   	
        	stat = status.getText().toString();
    	}catch(Exception e) {
    		stat=null;
    	}
    	try {
        	advocate=adv_name.getText().toString();
    	}catch(Exception e) {
    		advocate=null;
    	}
    	try {
    		nxt_d = next_date.getValue().toString();
    	}catch(Exception e) {
    		nxt_d = "0000-00-00";
    	}
    
    	try {
    		fld_d = filed_date.getValue().toString();
    	}catch(Exception e) {
    		fld_d = "0000-00-00";
    	}
    	
    	if((offi_no.isEmpty() || petitioner.isEmpty() || respondent.isEmpty() || fee<0  || exp < 0|| respondent == " " || petitioner == " " || offi_no==" " || rec_d.isEmpty() || nxt_d.isEmpty() || fld_d.isEmpty()) && v == 0)
    	{
    		
    		Alert a1 = new Alert(Alert.AlertType.WARNING);
    		a1.setTitle("Error");
    		a1.setContentText("Some input fields are empty.Check input.");
    		a1.setHeaderText(null);
    		a1.showAndWait();
    	}
    	else if( v == 0)
    	{
    		if(matterType!=null && cse_no!=null) {
    		file_no=matterType+" "+cse_no;
    		}else {
    			file_no=null;
    		}
    		try 
    		{
    			Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Lawyer.db";
                Connection con = DriverManager.getConnection(dbURL);
                Statement stmt = null;
                stmt = con.createStatement();
               
                if (con != null) 
                {
        			
                	String que = "Select cse_no from "+table+" where off_no = '"+offi_no+"';";
                  	ResultSet res = stmt.executeQuery(que);
            		
                  	
                  	if(res.next())
                	{
                		Alert a2 = new Alert(Alert.AlertType.WARNING);
                 		a2.setTitle("WARNING");
                 		a2.setContentText("File number already exists.\nFile number must be unique.");
                 		a2.setHeaderText(null);
                 		a2.showAndWait();
                	}
                	else
                	{
                		
                		String query = "insert into "+table+" values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement st = con.prepareStatement(query);
                        st.setString(1, offi_no);
                        st.setString(2, file_no);
                        st.setString(3, petitioner);
                        st.setString(4, respondent);
                        st.setString(5, fld_d);
                        st.setString(6, nxt_d);
                        st.setString(7, rec_d);
                        st.setFloat(8, fee);
                        st.setFloat(9, rem);
                        st.setFloat(10, exp);
                        st.setString(11, stat);
                        st.setString(12, note);
                        st.setString(13, advocate);
                        st.executeUpdate();
                        
                        if(offi_no!=null) {
                        	String ofn;
                        	ofn = offi_no.replace('/','_');
                        	ofn="T"+ofn;
                       String query1 = "CREATE TABLE '"+ofn+"'("
                        		+ "date VARCHAR(10), "
                        		+ "amount REAL "
                        		+ ");" ;
                        
                        stmt.executeUpdate(query1);
                        }                     
                        Alert a2 = new Alert(Alert.AlertType.INFORMATION);
                		a2.setTitle(null);
                		a2.setContentText("Successfully added new file.");
                		a2.setHeaderText(null);
                		a2.showAndWait();
                		

                    	BorderPane pane1 = FXMLLoader.load(getClass().getResource("menupage.fxml"));
                    	add_page.getChildren().setAll(pane1);
                	
                	}
                    	                 
                }
                stmt.close();
                con.close();
    		}catch(Exception e)
    		{ 
    			System.out.println(e.getMessage());
    			Alert a1=new Alert(Alert.AlertType.ERROR);
            	a1.setTitle("ERROR");
            	a1.setContentText("Unable to connect to database.");
                a1.setHeaderText("DATABASE NOT CONNECTED!");
                a1.showAndWait();
    		}
    	}
    	
    }

}