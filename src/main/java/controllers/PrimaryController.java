package controllers;

import com.murilo.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

public class PrimaryController {


    public void goToAuthors(ActionEvent actionEvent) throws IOException {
        Main.setRoot("Authors");
    }

    public void goToPublishers(ActionEvent actionEvent) throws IOException {
        Main.setRoot("Publishers");
    }

    public void goToBooks(ActionEvent actionEvent) throws IOException {
        Main.setRoot("Books");
    }
}
