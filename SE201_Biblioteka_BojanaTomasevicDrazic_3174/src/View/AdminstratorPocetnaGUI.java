

/**
 *
 * @author Bojana
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.application.Application;
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
public class AdminstratorPocetnaGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button eogr = new Button();
        eogr.setText("Evidencija ogranicenja");
         eogr.relocate(100, 50);
        eogr.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              
            }
        });
        Button rbp = new Button();
        rbp.setText("Rad sa bazom \n podataka");
         rbp.relocate(200, 150);
         
         Button ez = new Button();
        ez.setText("Evidencija zaposlenih");
         ez.relocate(350, 50);
      
         
        Group root = new Group();
        Scene scene = new Scene(root, 600,300, Color.LIGHTSKYBLUE); 
        root.getChildren().addAll(eogr,rbp,ez);
        primaryStage.setTitle("Administrator");
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
