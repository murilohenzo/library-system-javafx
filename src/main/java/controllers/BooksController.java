package controllers;

import dao.ClientDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Books;

public class BooksController {

    private final ClientDAO clientDAO = new ClientDAO();

    @FXML
    public Button showButton;

    @FXML
    public TextField publisherIdField;

    @FXML
    public TextField isbnField;

    @FXML
    public TextField titleField;

    @FXML
    public TextField priceField;

    @FXML
    public Button insertButton;

    @FXML
    public Button updateButton;

    @FXML
    public Button deleteButton;

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
    public Button searchButton;

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

    public void insertButton() {
        Books books = new Books();
        books.publisher_id = Integer.parseInt(publisherIdField.getText());
        books.isbn = isbnField.getText();
        books.title = titleField.getText();
        books.price = Float.parseFloat(priceField.getText());
        insert(books);
        showBooks();
    }

    public void updateButton() {
        Books books = new Books();
        books.publisher_id = Integer.parseInt(publisherIdField.getText());
        books.isbn = isbnField.getText();
        books.title = titleField.getText();
        books.price = Float.parseFloat(priceField.getText());
        update(books);
        showBooks();
    }

    public void deleteButton() {
        Books books = new Books();
        books.publisher_id = Integer.parseInt(publisherIdField.getText());
        books.isbn = isbnField.getText();
        books.title = titleField.getText();
        books.price = Float.parseFloat(priceField.getText());
        delete(books.isbn);
        showBooks();
    }

    public void showButton() {
        showBooks();
    }

    public void searchButton() {
        Books books = new Books();
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
