package application;
	
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("homepage.fxml"));
			Scene scene = new Scene(root,1000,1000);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			String css = Main.class.getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			//set Stage boundaries to visible bounds of the main screen
			primaryStage.setX(primaryScreenBounds.getMinX());
			primaryStage.setY(primaryScreenBounds.getMinY());
			primaryStage.setWidth(primaryScreenBounds.getWidth());
	        primaryStage.setHeight(primaryScreenBounds.getHeight());
			primaryStage.show();			
			/* stage.setScene(scene);

        

        //*/
	    	try 
			{	    	
	    		Connection conn=null;
	    		Class.forName("org.sqlite.JDBC");
	            String dbURL = "jdbc:sqlite:Lawyer.db";
	            
	            conn =DriverManager.getConnection(dbURL);
	            
	            Statement stmt = null;
	            if(conn!=null) {
	            	String create = "CREATE TABLE IF NOT EXISTS AdminDetails (\n"
	                        + "	Username text PRIMARY KEY,\n"
	                        + "	Password text NOT NULL\n"
	                        + ");";            	
	               	stmt = conn.createStatement();
	                stmt.execute(create);
	                }else {
	            	Alert a1=new Alert(Alert.AlertType.ERROR);
	            	a1.setTitle("ERROR");
	                a1.setContentText("Could not establish connection with database.");
	                a1.setHeaderText("Connection Lost!");
	                a1.showAndWait();
	            }	           
	            stmt.close();
                conn.close();              
	            }catch(Exception e)
	            {
	         		Alert a1=new Alert(Alert.AlertType.ERROR);
	            	a1.setTitle("ERROR");
	            	a1.setContentText("Uable to not connect to database.");
	                a1.setTitle("DATABASE NOT CONNECTED!");
	                a1.setHeaderText(null);
	                a1.showAndWait();
	           	}
			} catch(Exception e) {
				Alert a1=new Alert(Alert.AlertType.ERROR);
            	a1.setTitle("ERROR");
                a1.setContentText("CANNOT RUN APPLICATION");
                a1.setHeaderText(null);
                a1.showAndWait();
			}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
