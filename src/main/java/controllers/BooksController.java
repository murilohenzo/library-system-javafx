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
import models.Books;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class BooksController {

    private final ClientDAO clientDAO = new ClientDAO();

    @FXML
    public TextField publisherIdField;

    @FXML
    public TextField isbnField;

    @FXML
    public TextField titleField;

    @FXML
    public TextField priceField;

    @FXML
    public TableView<Books> BooksTableView;

    @FXML
    public TableColumn<Books, Integer> publisherColumn;

    @FXML
    public TableColumn<Books, String> isbnColumn;

    @FXML
    public TableColumn<Books, String> titleColumn;

    @FXML
    public TableColumn<Books, Float> priceColumn;

    @FXML
    public TextField searchField;

    @FXML
    public TableView<Books> SearchTableView;

    @FXML
    public TableColumn<Books, Integer> publisherColumnSearch;

    @FXML
    public TableColumn<Books, String> isbnColumnSearch;

    @FXML
    public TableColumn<Books, String> publisherNameColumnSearch;

    @FXML
    public TableColumn<Books, String> titleColumnSearch;

    @FXML
    public TableColumn<Books, Float> priceColumnSearch;

    @FXML
    public TableColumn<Books, Integer> authorIdColumnSearch;

    @FXML
    public TableColumn<Books, String> nameColumnSearch;


    @FXML
    public TableColumn<Books, String> fnameColumnSearch;


    public void insert(Books books) {clientDAO.insertBooks(books);}

    public void update(Books books) {clientDAO.updateBooks(books);}

    public void delete(String isbn) {clientDAO.deleteBooks(isbn);}

    public ObservableList<Books> getAllBooks() {return clientDAO.booksList();}

    public ObservableList<Books> searchBooks(String title) {return clientDAO.searchBooks(title);}

    public void showBooks() {
        ObservableList<Books> list = getAllBooks();
        publisherColumn.setCellValueFactory(new PropertyValueFactory<Books, Integer>("publisher_id"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Books, Float>("price"));
        BooksTableView.setItems(list);
    }

    public void insertButton(ActionEvent actionEvent) throws IOException {
        Books books = new Books();

        if (publisherIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Publisher ID Field")
                    .showError();
            insert(books);
        } else if (isbnField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty ISBN Field")
                    .showError();
            insert(books);
        } else if (titleField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Title Field")
                    .showError();
            insert(books);
        } else if (priceField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Price Field")
                    .showError();
            insert(books);
        } else {
            books.publisher_id = Integer.parseInt(publisherIdField.getText());
            books.isbn = isbnField.getText();
            books.title = titleField.getText();
            books.price = Float.parseFloat(priceField.getText());

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Successful Insert")
                    .showConfirm();

            insert(books);
            showBooks();
        }
    }

    public void updateButton(ActionEvent actionEvent) throws IOException {
        Books books = new Books();

        if (publisherIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Publisher ID Field")
                    .showError();
            update(books);
        } else if (isbnField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty ISBN Field")
                    .showError();
            update(books);
        } else if (titleField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Title Field")
                    .showError();
            update(books);
        } else if (priceField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Price Field")
                    .showError();
            update(books);
        } else {
            books.publisher_id = Integer.parseInt(publisherIdField.getText());
            books.isbn = isbnField.getText();
            books.title = titleField.getText();
            books.price = Float.parseFloat(priceField.getText());

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Successful Update")
                    .showConfirm();

            update(books);
            showBooks();
        }
    }

    public void deleteButton(ActionEvent actionEvent) throws IOException {
        Books books = new Books();

        if (publisherIdField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Publisher ID Field")
                    .showError();
            delete(books.isbn);
        } else if (isbnField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty ISBN Field")
                    .showError();
            delete(books.isbn);
        } else if (titleField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Title Field")
                    .showError();
            delete(books.isbn);
        } else if (priceField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Price Field")
                    .showError();
            delete(books.isbn);
        } else {
            books.publisher_id = Integer.parseInt(publisherIdField.getText());
            books.isbn = isbnField.getText();
            books.title = titleField.getText();
            books.price = Float.parseFloat(priceField.getText());

            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Successful Delete")
                    .showConfirm();

            delete(books.isbn);
            showBooks();
        }
    }

    public void showButton(ActionEvent actionEvent) throws IOException {
        showBooks();
    }

    public void searchButton(ActionEvent actionEvent) throws IOException {
        Books books = new Books();

        if (searchField.getText().isEmpty()) {
            Notifications.create()
                    .position(Pos.TOP_RIGHT)
                    .title("Books FXML")
                    .text("Empty Search Field")
                    .showError();
            searchBooks(books.title);
        } else {
            books.title = searchField.getText();

            ObservableList<Books> list = searchBooks(books.title);
            publisherColumnSearch.setCellValueFactory(new PropertyValueFactory<Books, Integer>("publisher_id"));
            isbnColumnSearch.setCellValueFactory(new PropertyValueFactory<Books, String>("isbn"));
            publisherNameColumnSearch.setCellValueFactory(new PropertyValueFactory<Books, String>("publisher_name"));
            titleColumnSearch.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
            priceColumnSearch.setCellValueFactory(new PropertyValueFactory<Books, Float>("price"));
            authorIdColumnSearch.setCellValueFactory(new PropertyValueFactory<Books, Integer>("author_id"));
            nameColumnSearch.setCellValueFactory(new PropertyValueFactory<Books, String>("author_name"));
            fnameColumnSearch.setCellValueFactory(new PropertyValueFactory<Books, String>("author_fname"));
            SearchTableView.setItems(list);

        }
    }
}
