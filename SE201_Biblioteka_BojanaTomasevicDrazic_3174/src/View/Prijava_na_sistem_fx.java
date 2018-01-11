/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controler.KorisnikDAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Radnik;

public class Prijava_na_sistem_fx extends Application {
    Button prijavi_se;
    TextField korisnicko;
    TextField lozinka;
    Label korisnicko_l, lozinka_l;

 
      private String prijavljenProsledi; 

    public String getPrijavljenProsledi() {
        return prijavljenProsledi;
    }

    public void setPrijavljenProsledi(String prijavljenProsledi) {
        this.prijavljenProsledi = prijavljenProsledi;
    }
    
    @Override
    public void start(Stage primaryStage) {
      
       
        
        Group root = new Group();
        Scene scene = new Scene(root, 600,300, Color.LIGHTSKYBLUE); 
        
        prijavi_se = new Button("PRIJAVI SE");
        prijavi_se.setPrefWidth(150);
        korisnicko = new TextField();
        lozinka = new TextField();
        korisnicko_l = new Label("Korisnicko ime");
        lozinka_l = new Label("Lozinka");
          korisnicko_l.relocate(50, 50);
        lozinka_l.relocate(50, 100);
        prijavi_se.relocate(200, 150);
        korisnicko.relocate(200, 50);
        lozinka.relocate(200, 100);
     

        
        
     
        
        
        // akcije
         prijavi_se.setOnAction(new EventHandler<ActionEvent>() {
            
            
           
            
            @Override
            public void handle(ActionEvent event) {
                KorisnikDAO kn = new KorisnikDAO();
                
                try
                {
                    String korisnickoK = korisnicko.getText();
                    String lozinkaK = lozinka.getText();
                    
                    Radnik k = kn.login(ApplicationUI.conn, korisnickoK, lozinkaK);

		    setPrijavljenProsledi(korisnickoK);
                    String privilegija = k.getPrivilegija();
                    
                    if (privilegija.equals("clan")) {
				ClanPocetnaGUI cfx = new ClanPocetnaGUI();
                               
				cfx.start(primaryStage);
            	} 
                   else if (privilegija.equals("admin")) {
                    AdminstratorPocetnaGUI afx = new AdminstratorPocetnaGUI();
                       afx.start(primaryStage);
               	} 
                    else  if (privilegija.equals("bibliotekar")) {
			BibliotekaPocetnaGUI  bfx = new BibliotekaPocetnaGUI();
                                bfx.start(primaryStage);
               	} 
                    
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
                
                
            }
        });
        
        
        root.getChildren().addAll(prijavi_se, korisnicko, lozinka, korisnicko_l, lozinka_l);
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
