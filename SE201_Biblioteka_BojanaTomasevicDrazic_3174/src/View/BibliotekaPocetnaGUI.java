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
public class BibliotekaPocetnaGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button eknj = new Button();
        eknj.setText("Evidencija knjiga");
         eknj.relocate(100, 50);
        eknj.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               KnjigaGUI kgui = new KnjigaGUI();
               kgui.start(primaryStage);
            }
        });
        Button ecl = new Button();
        ecl.setText("Evidencija \n iznajmljivanjem\n knjiga");
         ecl.relocate(100, 150);
         
         Button eik = new Button();
        eik.setText("Evidencija clanova");
         eik.relocate(350, 50);
           eik.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               EvidencijaClanovaUnosGUi rc = new EvidencijaClanovaUnosGUi();
               rc.start(primaryStage);
            }
        });
         Button eib = new Button();
        eib.setText("Evidencija \ninformacija \n o biblioteci");
         eib.relocate(350, 150);
         
        Group root = new Group();
        Scene scene = new Scene(root, 600,300, Color.LIGHTSKYBLUE); 
        root.getChildren().addAll(eknj,ecl,eik,eib);
        primaryStage.setTitle("Bibliotekar");
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
