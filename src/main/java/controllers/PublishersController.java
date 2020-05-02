package controllers;

import dao.ClientDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Publishers;

public class PublishersController {

    private final ClientDAO clientDAO = new ClientDAO();

    @FXML
    public TextField publisherIdField;

    @FXML
    public TextField publisherNameField;

    @FXML
    public TextField urlField;

    @FXML
    public Button insertButton;

    @FXML
    public Button updateButton;

    @FXML
    public Button deleteButton;

    @FXML
    public Button showButton;

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

    public void insertButton() {
        Publishers publishers = new Publishers();
        publishers.publisher_id = Integer.parseInt(publisherIdField.getText());
        publishers.name = publisherNameField.getText();
        publishers.url = publisherNameField.getText();
        insert(publishers);
        showPublishers();
    }

    public void updateButton() {
        Publishers publishers = new Publishers();
        publishers.publisher_id = Integer.parseInt(publisherIdField.getText());
        publishers.name = publisherNameField.getText();
        publishers.url = publisherNameField.getText();
        update(publishers);
        showPublishers();
    }

    public void deleteButton() {
        Publishers publishers = new Publishers();
        publishers.publisher_id = Integer.parseInt(publisherIdField.getText());
        publishers.name = publisherNameField.getText();
        publishers.url = publisherNameField.getText();
        delete(publishers.publisher_id);
        showPublishers();
    }

    public void showButton() {
        showPublishers();
    }
}
