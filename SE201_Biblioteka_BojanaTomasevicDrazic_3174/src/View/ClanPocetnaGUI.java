/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Bojana
 */
public class ClanPocetnaGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button eknj = new Button();
        eknj.setText("Evidencija knjiga");
         eknj.relocate(100, 50);
        eknj.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               KnjigaClanGUI kgui = new KnjigaClanGUI();
                try {
                    kgui.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ClanPocetnaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
   
         
        Group root = new Group();
        Scene scene = new Scene(root, 600,300, Color.LIGHTSKYBLUE); 
        root.getChildren().addAll(eknj);
        primaryStage.setTitle("Clan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
