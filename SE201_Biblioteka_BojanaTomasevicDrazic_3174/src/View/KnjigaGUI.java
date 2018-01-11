
package View;


import controler.KnjigaDAO;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static javafx.application.Application.launch;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Knjiga;


 
public class KnjigaGUI extends Application {
    
    
    TabPane tab;
    //komponente za tab1
     
    Label knjiga_id,nazivp,autorp,izdavacp,godinap_izdanja,brojp_primeraka;
    TextField knjiga_id_tf,nazivp_tf,autorp_tf,izdavacp_tf,godinap_izdanja_tf,brojp_primeraka_tf;

    ListView<String> lista;
    ObservableList<String> podaci_lista_1;
   
  
    
    Button pretrazi_knjige, obrisi, promeni;
    
    
    // komponente za tab2
    Label  naziv, izdavac,autor, godina_izdanja, broj_primeraka;
    Button pretrazi, dodaj;
    //ComboBox comboTarifna, comboOsiguranje;
    
    TextField naziv_tf, autor_tf, izdavac_tf,godina_izdanja_tf, broj_primeraka_tf;
  
     @Override
    public void start(Stage primaryStage) {
        
     
        
        
        StackPane root = new StackPane();      
        Scene scene = new Scene(root, 800, 800, Color.PINK);
        
        
        // dodavanje tabova
        tab = new TabPane();
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        Tab tab3 = new Tab();
        tab1.setText("Pregled knjiga");
        tab2.setText("Unos knjige");
        tab3.setText("Unos pozicije knjige");
        
        tab.getTabs().add(tab1);
        tab.getTabs().add(tab2);
        tab.getTabs().add(tab3);
      //tab 1 labele
      knjiga_id = new Label("ID knjige:   ");
        nazivp = new Label("Naslov");
        autorp = new Label("Autor: ");
        izdavacp = new Label("Izdavac: ");
        godinap_izdanja = new Label("godina \nizdanja");
        brojp_primeraka = new Label("Broj \nprimeraka");
        
        
        
        // tab2 labele
      
      
        naziv = new Label("Naslov");
      autor  = new Label("Autor :");
      izdavac = new Label("Izdavac");
    godina_izdanja= new Label("Godina \nizdanja:");
    broj_primeraka = new Label("Broj \n primer.:   ");
     
        //tab 1 dubmici
         pretrazi_knjige = new Button("Pretrazi");
         obrisi = new Button("Obrisi knjigu");
         promeni = new Button("Promeni podatke");
        
        // tab2 dugmici
        
        dodaj = new Button("Dodaj u bazu");
        pretrazi = new Button("Pretrazi");
        //polja t1
         knjiga_id_tf = new TextField();
        nazivp_tf = new TextField();
        autorp_tf = new TextField();
        izdavacp_tf = new TextField();
        godinap_izdanja_tf = new TextField();
        brojp_primeraka_tf = new TextField();
        
        // polja t2
      
         
            naziv_tf = new TextField();
            autor_tf = new TextField();
            izdavac_tf = new TextField();
            godina_izdanja_tf = new TextField();
            broj_primeraka_tf = new TextField();
//lista tab 1

lista = new ListView<>();
     podaci_lista_1 = FXCollections.observableArrayList();
        

        
        // relokacija
        //tab1 
        knjiga_id.relocate(300, 255);
         nazivp.relocate(300, 285);
        autorp.relocate(300, 315);
        izdavacp.relocate(300, 345);
        godinap_izdanja.relocate(300, 375);
        brojp_primeraka.relocate(300, 405);
        
        knjiga_id_tf.relocate(400, 250);
        nazivp_tf.relocate(400, 280);
        autorp_tf.relocate(400, 310);
        izdavacp_tf.relocate(400,340);
        godinap_izdanja_tf.relocate(400, 370);
        brojp_primeraka_tf.relocate(400, 400);
          // relokacija listi
        
        lista.relocate(20, 250);
        //tab 2
          //knjiga_id.relocate(100, 150);
          naziv.relocate(100, 150);
          autor.relocate(100, 180);
          izdavac.relocate(100, 210);
          godina_izdanja.relocate(100, 240);
          broj_primeraka.relocate(100, 270);

            
            //knjiga_id_tf.relocate(150, 150);
            naziv_tf.relocate(150, 150);
            autor_tf.relocate(150, 180);
            izdavac_tf.relocate(150, 210);
            godina_izdanja_tf.relocate(150, 240);
            broj_primeraka_tf.relocate(150, 270);

        
       // dodaj.setPrefWidth(150);
        dodaj.relocate(250, 300);
        

 pretrazi_knjige.relocate(300, 195);
         obrisi.relocate(350, 510);
         promeni.relocate(350, 550);

/*
pretrazi_knjige, obrisi, promeni
*/      Group grupa_tab1 = new Group();
      
        grupa_tab1.getChildren().addAll(knjiga_id,nazivp,autorp,izdavacp,godinap_izdanja,brojp_primeraka,knjiga_id_tf,nazivp_tf,autorp_tf,izdavacp_tf,godinap_izdanja_tf,brojp_primeraka_tf,pretrazi_knjige, obrisi, promeni,lista);
        tab1.setContent(grupa_tab1);
        
        Group grupa_tab2 = new Group();
      
        grupa_tab2.getChildren().addAll(naziv,naziv_tf,autor,autor_tf,izdavac,izdavac_tf,godina_izdanja,godina_izdanja_tf,broj_primeraka,broj_primeraka_tf,dodaj);
            tab2.setContent(grupa_tab2);

        
        
        // AKCIJE****
        
//        
dodaj.setOnAction(new EventHandler<ActionEvent>() {
        @Override
          public void handle(ActionEvent event) {
      
        String naziv = naziv_tf.getText();
        String autor= autor_tf.getText();
        String izdavac = izdavac_tf.getText();
            int godina_izdanja =Integer.parseInt(godina_izdanja_tf.getText());
            int broj_primeraka = Integer.parseInt(broj_primeraka_tf.getText());






          Knjiga k = new Knjiga();
            k.setNaziv(naziv);
            k.setAutor(autor);
            k.setIzdavac(izdavac);
            k.setGodinaIzdanja(godina_izdanja);
            k.setBrojPrimeraka(broj_primeraka);
            
            
            KnjigaDAO kDAO = new KnjigaDAO();


        try
        {
            kDAO.add(ApplicationUI.conn,k);

            JOptionPane.showMessageDialog(null, "Knjiga je uspesno dodata!");
 

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
          }
});
        
        
pretrazi_knjige.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
         KnjigaDAO kDAO = new KnjigaDAO();
                try {
                     List<Integer> listIds= kDAO.getAllKnjigaIds(ApplicationUI.conn);
                     for(Integer id : listIds){
                     podaci_lista_1.add(id+"");
                     }
                     
                     lista.getItems().addAll(podaci_lista_1);
                     JOptionPane.showMessageDialog(null, "Podaci pronadjeni");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
});
        lista.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
            int selektovano = Integer.parseInt(lista.getSelectionModel().getSelectedItem().toString());
             KnjigaDAO kDAO = new KnjigaDAO();
             Knjiga k;
                try {
                    k = kDAO.getKnjigaById(ApplicationUI.conn, selektovano);
                        knjiga_id_tf.setText("" + selektovano);
                        nazivp_tf.setText(""+k.getNaziv());
                        autorp_tf.setText("" + k.getAutor());
                        izdavacp_tf.setText("" + k.getIzdavac());
                        godinap_izdanja_tf.setText("" + k.getGodinaIzdanja());
                        brojp_primeraka_tf.setText(""+k.getBrojPrimeraka());
                        JOptionPane.showMessageDialog(null, "Podaci o knjizi prikazani");
                } catch (Exception e) {
                }
            
            }
            
        });
        promeni.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
      
            }
        });
        
        obrisi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
        
         try{
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
                
            }
     });
        
               
        primaryStage.setTitle("Evidencija knjiga");
        root.getChildren().addAll(tab);
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
