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
import models.Authors;
import org.controlsfx.control.Notifications;

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

    public void insertButton(ActionEvent actionEvent) throws IOException{
        Authors authors = new Authors();

        if (authorIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author ID Field")
                    .showError();
            insert(authors);
        } else if (authorNameField.getText().isEmpty()){
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author Name Field")
                    .showError();
            insert(authors);
        } else if (authorFnameField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author Fname Field")
                    .showError();
            insert(authors);
        } else {
            authors.author_id = Integer.parseInt(authorIdField.getText());
            authors.name = authorNameField.getText();
            authors.fname = authorFnameField.getText();

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Successful Insert")
                    .showConfirm();

            insert(authors);
            showAuthors();

        }

    }

    public void updateButton(ActionEvent actionEvent) throws IOException {
        Authors authors = new Authors();

        if (authorIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author ID Field")
                    .showError();
            update(authors);
        } else if (authorNameField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author Name Field")
                    .showError();
            update(authors);
        } else if (authorFnameField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author Fname Field")
                    .showError();
            update(authors);
        } else {
            authors.author_id = Integer.parseInt(authorIdField.getText());
            authors.name = authorNameField.getText();
            authors.fname = authorFnameField.getText();

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Successful Update")
                    .showConfirm();

            update(authors);
            showAuthors();
        }
    }

    public void deleteButton(ActionEvent actionEvent) throws IOException {
        Authors authors = new Authors();

        if (authorIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author ID Field")
                    .showError();
            delete(authors.author_id);
        } else if (authorNameField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author Name Field")
                    .showError();
            delete(authors.author_id);
        } else if (authorFnameField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Empty Author Fname Field")
                    .showError();
            delete(authors.author_id);
        } else {
            authors.author_id = Integer.parseInt(authorIdField.getText());
            authors.name = authorNameField.getText();
            authors.fname = authorFnameField.getText();

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Authors FXML")
                    .text("Successful Delete")
                    .showConfirm();

            delete(authors.author_id);
            showAuthors();
        }
    }

    public void showButton(ActionEvent actionEvent) throws IOException {showAuthors();}

}
