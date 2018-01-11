/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controler.KorisnikDAO;
import model.Korisnik;

import Utils.Utils;
import View.ApplicationUI;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Korisnik;

public class EvidencijaClanovaUnosGUi extends Application {
    
    Label imeL, prezimeL, korisnickoL, lozinkaL, privilegijaL, jmbg_L;
    TextField ime_tf, prezime_tf, korisnicko_tf, lozinka_tf, privilegija_tf, jmbg_tf;
    Button registuj, nazad; 
           // Button nazad;
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        Scene scene = new Scene(root, 400,400, Color.LIGHTSKYBLUE);
        
        imeL = new Label("Ime:");
        prezimeL = new Label("Prezime:");
        jmbg_L = new Label("jmbg:");
        korisnickoL = new Label("Korisnicko ime:");
        lozinkaL = new Label("Lozinka:");
        privilegijaL = new Label("Uloga:");
          
        imeL.relocate(50, 50);
        prezimeL.relocate(50, 80);
        jmbg_L.relocate(50, 110);
        korisnickoL.relocate(50, 140);
        lozinkaL.relocate(50, 170);
        privilegijaL.relocate(50, 200);
       
        
        
        
        ime_tf = new TextField();
        prezime_tf = new TextField();
        jmbg_tf = new TextField();
        korisnicko_tf = new TextField();
        lozinka_tf = new TextField();
        privilegija_tf = new TextField();
      
        ime_tf.relocate(150,45);
        prezime_tf.relocate(150, 75);
        jmbg_tf.relocate(150, 105);
        korisnicko_tf.relocate(150, 135);
        lozinka_tf.relocate(150, 165);
        privilegija_tf.relocate(150, 195);
       
        
     
       
        
        
        registuj= new Button("Registruj clana");
        registuj.relocate(150, 300);

        
        nazad = new Button("Nazad");
        nazad.relocate(150, 350);
        

        
        
        
        // akcije
        
        nazad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
               BibliotekaPocetnaGUI pfx = new BibliotekaPocetnaGUI();
                pfx.start(primaryStage);
            }
});
        
        
        
        registuj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             
                // akcija za registraciju
                
                KorisnikDAO kDAO = new KorisnikDAO();
//	    Random r = new Random();
//	    int id = r.nextInt();
	    String ime = ime_tf.getText();
	    String prezime = prezime_tf.getText();
            String jmbg = jmbg_tf.getText();
	    String korisnicko = korisnicko_tf.getText();
	    String lozinka = lozinka_tf.getText();
	    String privilegija = privilegija_tf.getText();
	
	    
	    Korisnik k = new Korisnik();
           
            k.setIme(ime);
            k.setPrezime(prezime);
            k.setJmbg(jmbg);
            k.setUsername(korisnicko);
            k.setPassword(lozinka);
            k.setPrivilegija(privilegija);
	    
	    try{
	    	kDAO.kreirajClana(ApplicationUI.conn, k);
                JOptionPane.showMessageDialog(null, "Uspesno ste dodali novog korisnika sistema");
	    } catch (Exception e)
	    {
	        JOptionPane.showMessageDialog(null, e);
	    }
            }});
        
        
        /*
        Label ;
    TextField ;
    Button , nazad;
        */
        
        root.getChildren().addAll(imeL, prezimeL, korisnickoL, lozinkaL, privilegijaL, jmbg_L,ime_tf, prezime_tf, korisnicko_tf, lozinka_tf, privilegija_tf, jmbg_tf,registuj,nazad);
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
