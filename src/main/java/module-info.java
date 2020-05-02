module Projeto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.sql;

    opens com.murilo to javafx.fxml;
    opens controllers to javafx.fxml;
    opens dao to javafx.fxml;
    opens models to javafx.fxml;

    exports com.murilo;
    exports controllers;
    exports dao;
    exports models;
}