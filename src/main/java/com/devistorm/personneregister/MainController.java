package com.devistorm.personneregister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController{

    @FXML private TableView<Personne> table;

    @FXML private TableColumn<Personne, String> nom;
    @FXML private TableColumn<Personne, String> prenom;
    @FXML private TableColumn<Personne, String> mail;

    @FXML private Button addPerson_btn;
    @FXML private Button deletePerson_btn;

    private ObservableList<Personne> personnes;

    public MainController () {
        personnes = FXCollections.observableArrayList();

    }

    @FXML
    private void initialize() {

        nom.setCellValueFactory(data -> data.getValue().getNom());
        prenom.setCellValueFactory(data -> data.getValue().getPrenom());
        mail.setCellValueFactory(data -> data.getValue().getMail());

        table.setItems(personnes);
        table.setEditable(true );

    }

    @FXML
    private void itemSelected(Event e) {
        System.out.println("test");
    }


    @FXML
    private void actionAddPerson(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-person.fxml"));

        CreatePersonController createPersonController = new CreatePersonController(new ResponseCallback<CreatePersonController>() {
            @Override
            public void success(CreatePersonController p) {
                createPersonne(p.getNomSaisie(), p.getPrenomSaisie(), p.getMailSaisie());
            }

            @Override
            public void fail(CreatePersonController createPersonController) {

            }
        });

        fxmlLoader.setController(createPersonController);

        Stage popup = new Stage();
        popup.setTitle("Ajouter une personne");
        popup.initModality(Modality.WINDOW_MODAL);

        Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        popup.setScene(scene);
        popup.show();
    }

    private void createPersonne(String nom, String prenom, String mail) {
        Personne p = new Personne(nom, prenom, mail);

        personnes.add(p);
    }


}
