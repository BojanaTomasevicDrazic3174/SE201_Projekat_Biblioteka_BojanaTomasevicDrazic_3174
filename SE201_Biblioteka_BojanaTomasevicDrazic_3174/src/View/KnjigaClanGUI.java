/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controler.KnjigaDAO;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javax.swing.JOptionPane;

import model.Knjiga;
/**
 *
 * @author Bojana
 */

class EditingCell extends TableCell<Knjiga, String> {
 
        private TextField textField;
 
        public EditingCell() {
        }
 
        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }
 
        @Override
        public void cancelEdit() {
            super.cancelEdit();
 
            setText((String) getItem());
            setGraphic(null);
        }
 
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
 
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }
 
        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> arg0, 
                Boolean arg1, Boolean arg2) -> {
                    if (!arg2) {
                        commitEdit(textField.getText());
                    }
            });
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }





public class KnjigaClanGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    
  
    
      ObservableList<Knjiga> data = FXCollections.observableArrayList();
      TableView<Knjiga> tabela = new TableView<>(data);
  Label label = new Label("Spisak knjiga");
   label.setFont(new Font("Arial", 20));
   Button pretraziButton = new Button("Pronadji knjigu");
   HBox hb = new HBox();
    tabela.setEditable(true);
    
    Callback<TableColumn<Knjiga, String>, TableCell<Knjiga, String>> cellFactory;
      cellFactory = (TableColumn<Knjiga, String> p) -> new EditingCell();
    TableColumn<Knjiga, String> Naziv = 
            new TableColumn<>("Naziv");
        
    TableColumn<Knjiga, String> Autor = 
            new TableColumn<>("Autor");
        
    
    TableColumn<Knjiga, String> Izdavac = 
            new TableColumn<>("Izdavac");
        
        Naziv.setMinWidth(100);
        Naziv.setCellValueFactory(
            new PropertyValueFactory<>("Naziv"));
        Naziv.setCellFactory(cellFactory);        
        Naziv.setOnEditCommit(
            (TableColumn.CellEditEvent<Knjiga, String> t) -> {
                ((Knjiga) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setNaziv(t.getNewValue());
        });
         Autor.setMinWidth(100);
        Autor.setCellValueFactory(
            new PropertyValueFactory<>("Autor"));
        Autor.setCellFactory(cellFactory);
        Autor.setOnEditCommit(
            (TableColumn.CellEditEvent<Knjiga, String> t) -> {
                ((Knjiga) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAutor(t.getNewValue());
        });
        
        
           Izdavac.setMinWidth(200);
        Izdavac.setCellValueFactory(
            new PropertyValueFactory<>("Izdavac"));
        Izdavac.setCellFactory(cellFactory);
        Izdavac.setOnEditCommit(
            (TableColumn.CellEditEvent<Knjiga, String> t) -> {
                ((Knjiga) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setIzdavac(t.getNewValue());
        });
         tabela.setItems(data);
        tabela.getColumns().addAll(Naziv, Autor, Izdavac);
        //polja 
        
        TextField Naziv_tf = new TextField();
        Naziv_tf.setPromptText("Naziv");
        Naziv_tf.setMaxWidth(Naziv.getPrefWidth());
        TextField Autor_tf = new TextField();
        Autor_tf.setMaxWidth(Autor.getPrefWidth());
        Autor_tf.setPromptText("Autor");
        
        
        TextField Izdavac_tf = new TextField();
        Izdavac_tf.setMaxWidth(Izdavac.getPrefWidth());
        Izdavac_tf.setPromptText("Izdavac");
        
        
          pretraziButton.setOnAction((ActionEvent e) -> {
              
            data.add(new Knjiga(
                    Naziv_tf.getText(),
                    Autor_tf.getText(),
                    Izdavac_tf.getText()));
            Naziv_tf.clear();
            Autor_tf.clear();
            Autor_tf.clear();
        });
 Button pregled = new Button("Pregledaj sve knijge");
          pregled.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Zdravo");
                try {
                                     KnjigaDAO kDAO = new KnjigaDAO();
                
                        Knjiga knjiga = kDAO.getNazivAutorIzdavac(ApplicationUI.conn); 
                } catch (Exception e) {
                }
   

                      
               
                    JOptionPane.showMessageDialog(null, "Podaci pronadjeni");
             
               
                            
        }
});
          
         hb.getChildren().addAll(Naziv_tf, Autor_tf, Izdavac_tf, pretraziButton);
        hb.setSpacing(3);
       
         VBox vbox = new VBox();
         
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label,pregled, tabela, hb);
         //vbox.getChildren().addAll(label,tabela, hb);
   
           Scene scene = new Scene(new Group());
       
        stage.setWidth(450);
        stage.setHeight(550);
         stage.setTitle("Tabela knjiga za Clana");
  
         ((Group) scene.getRoot()).getChildren().addAll(vbox);
         stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
    


  
    

