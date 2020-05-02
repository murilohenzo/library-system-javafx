package controllers;

import com.murilo.Main;
import dao.ClientDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Authors;

import java.io.IOException;

public class AuthorsController {

    private final ClientDAO clientDAO = new ClientDAO();

    @FXML
    public TextField authorIdField;

    @FXML
    public TextField authorNameField;

    @FXML
    public TextField authorFnameField;

    @FXML
    public Button insertButton;

    @FXML
    public Button updateButton;

    @FXML
    public Button deleteButton;

    @FXML
    public Button showButton;

    @FXML
    public TableView<Authors> AuthorsTableView;

    @FXML
    public TableColumn<Authors, Integer> authorIdColumn;

    @FXML
    public TableColumn<Authors, String> authorNameColumn;

    @FXML
    public TableColumn<Authors, String> authorFnameColumn;

    public void insert(Authors authors) {clientDAO.insertAuthor(authors);}

    public void update(Authors authors) {clientDAO.updateAuthor(authors);}

    public void delete(int author_id) {clientDAO.deleteAuthor(author_id);}

    public ObservableList<Authors> getAllAuthors() {return clientDAO.authorsList();}

    public void showAuthors() {
        ObservableList<Authors> list = getAllAuthors();
        authorIdColumn.setCellValueFactory(new PropertyValueFactory<Authors, Integer>("author_id"));
        authorNameColumn.setCellValueFactory(new PropertyValueFactory<Authors, String>("name"));
        authorFnameColumn.setCellValueFactory(new PropertyValueFactory<Authors, String>("fname"));
        AuthorsTableView.setItems(list);
    }

    public void insertButton() {
        Authors authors = new Authors();
        authors.author_id = Integer.parseInt(authorIdField.getText());
        authors.name = authorNameField.getText();
        authors.fname = authorFnameField.getText();
        insert(authors);
        showAuthors();

    }

    public void updateButton() {
        Authors authors = new Authors();
        authors.author_id = Integer.parseInt(authorIdField.getText());
        authors.name = authorNameField.getText();
        authors.fname = authorFnameField.getText();
        update(authors);
        showAuthors();
    }

    public void deleteButton() {
        Authors authors = new Authors();
        authors.author_id = Integer.parseInt(authorIdField.getText());
        authors.name = authorNameField.getText();
        authors.fname = authorFnameField.getText();
        delete(authors.author_id);
        showAuthors();
    }

    public void showButton() {showAuthors();}

}
