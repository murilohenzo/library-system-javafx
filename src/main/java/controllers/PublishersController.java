package controllers;

import dao.ClientDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Publishers;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class PublishersController {

    private final ClientDAO clientDAO = new ClientDAO();

    @FXML
    public TextField publisherIdField;

    @FXML
    public TextField publisherNameField;

    @FXML
    public TextField urlField;

    @FXML
    public TableView<Publishers> PublishersTableView;

    @FXML
    public TableColumn<Publishers, Integer> publisherIdColumn;

    @FXML
    public TableColumn<Publishers, String> publisherNameColumn;

    @FXML
    public TableColumn<Publishers, String> urlColumn;

    public void insert(Publishers publishers) {clientDAO.insertPublishers(publishers);}

    public void update(Publishers publishers) {clientDAO.updatePublishers(publishers);}

    public void delete(int publisher_id) {clientDAO.deletePublishers(publisher_id);}

    public ObservableList<Publishers> getAllPublishers() {return clientDAO.publishersList();}

    public void showPublishers() {
        ObservableList<Publishers> list = getAllPublishers();
        publisherIdColumn.setCellValueFactory(new PropertyValueFactory<Publishers, Integer>("publisher_id"));
        publisherNameColumn.setCellValueFactory(new PropertyValueFactory<Publishers, String>("name"));
        urlColumn.setCellValueFactory(new PropertyValueFactory<Publishers, String>("url"));
        PublishersTableView.setItems(list);
    }

    public void insertButton(ActionEvent actionEvent) throws IOException {
        Publishers publishers = new Publishers();

        if (publisherIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publishers FXML")
                    .text("Empty Publisher ID Field")
                    .showError();
            insert(publishers);
        } else if (publisherNameField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Empty Publisher Name Field")
                    .showError();
            insert(publishers);
        } else if (urlField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Empty Publisher URL Field")
                    .showError();
            insert(publishers);
        } else {
            publishers.publisher_id = Integer.parseInt(publisherIdField.getText());
            publishers.name = publisherNameField.getText();
            publishers.url = urlField.getText();

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Successful Insert")
                    .showConfirm();
            insert(publishers);
            showPublishers();
        }
    }

    public void updateButton(ActionEvent actionEvent) throws IOException {
        Publishers publishers = new Publishers();

        if (publisherIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publishers FXML")
                    .text("Empty Publisher ID Field")
                    .showError();
            update(publishers);
        } else if (publisherNameField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Empty Publisher Name Field")
                    .showError();
            update(publishers);
        } else if (urlField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Empty Publisher URL Field")
                    .showError();
            update(publishers);
        } else {
            publishers.publisher_id = Integer.parseInt(publisherIdField.getText());
            publishers.name = publisherNameField.getText();
            publishers.url = urlField.getText();

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Successful Update")
                    .showConfirm();
            update(publishers);
            showPublishers();
        }
    }

    public void deleteButton(ActionEvent actionEvent) throws IOException {
        Publishers publishers = new Publishers();

        if (publisherIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publishers FXML")
                    .text("Empty Publisher ID Field")
                    .showError();
            delete(publishers.publisher_id);
        } else if (publisherNameField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Empty Publisher Name Field")
                    .showError();
            delete(publishers.publisher_id);
        } else if (urlField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Empty Publisher URL Field")
                    .showError();
            delete(publishers.publisher_id);
        } else {
            publishers.publisher_id = Integer.parseInt(publisherIdField.getText());
            publishers.name = publisherNameField.getText();
            publishers.url = urlField.getText();

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Publisher FXML")
                    .text("Successful Delete")
                    .showConfirm();

            delete(publishers.publisher_id);
            showPublishers();
        }
    }

    public void showButton(ActionEvent actionEvent)throws IOException {
        showPublishers();
    }
}
