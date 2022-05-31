package com.devistorm.personneregister;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.security.auth.callback.CallbackHandler;

public class CreatePersonController {

    @FXML private TextField nom_tf;
    @FXML private TextField prenom_tf;
    @FXML private TextField mail_tf;

    private ResponseCallback<CreatePersonController> responseCallback;

    public CreatePersonController(ResponseCallback<CreatePersonController> t) {
        this.responseCallback = t;
    }

    @FXML
    private void actionValidate(ActionEvent e) {
        responseCallback.success(this);

        ((Stage) ((Button) e.getTarget()).getScene().getWindow()).close();
    }


    public String getNomSaisie() {
        return nom_tf.getText();
    }

    public String getPrenomSaisie() {
        return prenom_tf.getText();
    }

    public String getMailSaisie() {
        return mail_tf.getText();
    }
}
