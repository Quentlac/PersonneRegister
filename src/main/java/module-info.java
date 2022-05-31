module com.devistorm.personneregister {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.devistorm.personneregister to javafx.fxml;
    exports com.devistorm.personneregister;
}