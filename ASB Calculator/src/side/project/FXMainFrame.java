/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package side.project;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sufyan
 */
public class FXMainFrame extends Application {
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
            
            Scene scene = new Scene(root);
            
            primaryStage.setResizable(false);
            
//            primaryStage.initStyle(StageStyle.DECORATED.UNDECORATED);
//            
//            root.setOnMousePressed(new EventHandler<MouseEvent>(){
//                public void handle(MouseEvent event){
//                    xOffset = event.getSceneX();
//                    yOffset = event.getSceneY();
//                    
//                }
//            });
//            
//            root.setOnMouseDragged(new EventHandler<MouseEvent>(){
//                public void handle(MouseEvent event){
//                    primaryStage.setX(event.getSceneX() - xOffset);
//                    primaryStage.setY(event.getSceneY() - yOffset);
//                    
//                    
//                }
//            });           
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
