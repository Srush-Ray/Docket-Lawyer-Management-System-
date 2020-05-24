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

public class acc {
	homepageController obj=new homepageController();

	private static String matterType=null;
	
	@FXML
    private BorderPane accpage;
	
    @FXML
    private MenuButton matter_type;

    @FXML
    private TextField matter_no;



    @FXML
    private Button search2;

    @FXML
    private Button search3;

    @FXML
    private TextField year;

    @FXML
    private TextField month;

    @FXML
    private Button home;
    
    @FXML
    private TextArea display_m;
 
    @FXML
    private TextField exp_t;
    
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
    private TextField display_tf;

    @FXML
    private TextField display_trf;

    @FXML
    private TextField display_tref;

    
    @FXML
    private TextField total_matters;


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
	    	accpage.getChildren().setAll(pane);
		}else {
	    	BorderPane pane = FXMLLoader.load(getClass().getResource("menupage.fxml"));
	    	accpage.getChildren().setAll(pane);
		}
    }

 
    @FXML
    void search_month(ActionEvent event) {    	
    	
    	String mth = month.getText().toString();
       	String user=obj.ret_adm();
    	year.clear();    	
       	if(mth.contains("-"))
       	{
    	try {
			Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Lawyer.db";
            Connection con = DriverManager.getConnection(dbURL);
            Statement stmt = null;
            
            if(con != null)
            {
            	stmt = con.createStatement();
            	
            	String query1 = "Select sum(fee) from "+user+" where regis_dte like '"+mth+"%' ;";
            	ResultSet res1 = stmt.executeQuery(query1);
            	display_tf.setText(res1.getString(1));
            	String f = res1.getString(1);
            	

            	String query4 = "Select sum(expen) from "+user+" where regis_dte like '"+mth+"%' ;";
            	ResultSet res4 = stmt.executeQuery(query4);
            	exp_t.setText(res4.getString(1));
            	
            	String query2 = "Select sum(rec_fe) from "+user+" where regis_dte like '"+mth+"%' ;" ;                	
            	ResultSet res2 = stmt.executeQuery(query2);
            	display_trf.setText(res2.getString(1));
            	String rf = res2.getString(1);
            	
            	String query3 = "Select count(cse_no) from "+user+" where regis_dte like '"+mth+"%' ;";
            	ResultSet res3 = stmt.executeQuery(query3);
            	total_matters.setText(res3.getString(1));
            	
            	double pendfee=0;
            	
        		float q = Float.parseFloat(f);
        		float w = Float.parseFloat(rf);
        		pendfee = q - w;
        		String pf = Double.toString(pendfee);
        		display_tref.setText(pf);
            	
            	String search="select * from "+user+" where regis_dte like '"+mth+"%' ;" ;
            	ResultSet res = stmt.executeQuery(search);
            	if(res.next())
            	{
            		
            		int c = 1;
            	
            		display_m.setText("\n");	
            		
            		do{

            			f = res.getString("fee");
                		rf = res.getString("rec_fe");
                		
                		q = Float.parseFloat(f);
                		w = Float.parseFloat(rf);
                		pendfee = q - w;
                		pf = Double.toString(pendfee);

            			
            		String p = Integer.toString(c);
            		display_m.appendText(p + "} ");
            		display_m.appendText("Case no. : "+res.getString("cse_no")+"\n\n");
            		display_m.appendText("Fees : "+res.getString("fee")+"\n\n");
            		display_m.appendText("Recieved Fees : "+res.getString("rec_fe")+"\n\n");
            		display_m.appendText("Pending Fees : "+pf+"\n\n");
            		display_m.appendText("Expenses : "+res.getString("expen")+"\n\n");
               		display_m.appendText("Notes : "+res.getString("notes")+"\n\n");
               		
               		display_m.appendText("\n\n");
            		c++;
            		}while(res.next()) ;
            	}
            	else
            	{
            		Alert a1 = new Alert(Alert.AlertType.WARNING);
            		a1.setTitle("WARNING");
            		a1.setContentText("File not found.");
            		a1.setHeaderText(null);
            		a1.showAndWait();
            	}
            }
		}catch(Exception e)
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
       		Alert a1 = new Alert(Alert.AlertType.WARNING);
    		a1.setTitle("Error");
    		a1.setContentText("Check the input format.\nIt must be \"YYYY-MM\"");
    		a1.setHeaderText(null);
    		a1.showAndWait();
       	}
    }
    

    @FXML
    void search_year(ActionEvent event) {
    	
    	String yr = year.getText().toString();
       	String user=obj.ret_adm();
    
    	month.clear();
    	
    	try {
			Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Lawyer.db";
            Connection con = DriverManager.getConnection(dbURL);
            Statement stmt = null;
         
            if(con != null)
            {
            	stmt = con.createStatement();
            	


            	String query1 = "Select sum(fee) from "+user+" where regis_dte like '"+yr+"%' ;";
            	ResultSet res1 = stmt.executeQuery(query1);
            	display_tf.setText(res1.getString(1));
            	String f = res1.getString(1);
            	
            	String query2 = "Select sum(rec_fe) from "+user+" where regis_dte like '"+yr+"%' ;";                	
            	ResultSet res2 = stmt.executeQuery(query2);
            	display_trf.setText(res2.getString(1));
            	String rf = res2.getString(1);
            	

            	String query4 = "Select sum(expen) from "+user+" where regis_dte like '"+yr+"%' ;";
            	ResultSet res4 = stmt.executeQuery(query4);
            	exp_t.setText(res4.getString(1));
            	
            	String query3 = "Select count(cse_no) from "+user+" where regis_dte like '"+yr+"%' ;";
            	ResultSet res3 = stmt.executeQuery(query3);
            	total_matters.setText(res3.getString(1));
            	
            	double pendfee=0;
        		
        		float q = Float.parseFloat(f);
        		float w = Float.parseFloat(rf);
        		pendfee = q - w;
        		String pf = Double.toString(pendfee);
        		display_tref.setText(pf);     	
            	
            	String search="select * from "+user+" where regis_dte like '"+yr+"%' ;" ;
            	ResultSet res = stmt.executeQuery(search);
     
            	if(res.next())
            	{
            		System.out.println("4");
            		int c = 1;
           
            		display_m.setText("\n");
            	
            	           		
            		 do{
            			
            			 f = res.getString("fee");
                 		 rf = res.getString("rec_fe");
                 		
                 		q = Float.parseFloat(f);
                 		w = Float.parseFloat(rf);
                 		pendfee = q - w;
                 		pf = Double.toString(pendfee);
                		
                 	
                		
                		String p = Integer.toString(c);
                		display_m.appendText(p + "} ");
                		display_m.appendText("Case no. : "+res.getString("cse_no")+"\n\n");
                		display_m.appendText("Fees : "+res.getString("fee")+"\n\n");
                		display_m.appendText("Recieved Fees : "+res.getString("rec_fe")+"\n\n");
                		display_m.appendText("Pending Fees : "+pf+"\n\n");
                		display_m.appendText("Expenses : "+res.getString("expen")+"\n\n");
                   		display_m.appendText("Notes : "+res.getString("notes")+"\n\n");
                   		
                 		display_m.appendText("\n\n");
                		c++;
            		
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
		{System.out.println(e);
			Alert a1=new Alert(Alert.AlertType.ERROR);
        	a1.setTitle("ERROR");
        	a1.setContentText("Unable to connect to database or empty database.");
            a1.setHeaderText(null);
            a1.showAndWait();
		}
		
    }

}
