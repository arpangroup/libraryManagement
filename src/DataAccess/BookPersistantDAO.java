package DataAccess;

import Model.Book;
import Model.BookDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wishwa
 */
public class BookPersistantDAO implements BookDAO {

    @Override
    public boolean addBook(Book book) {

        String sqlAdd = "INSERT INTO book VALUES(?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlAdd);

            pst.setInt(1, book.getBookId());
            pst.setString(2, book.getBookName());
            pst.setString(3, book.getIsbn());
            pst.setString(4, book.getAuthor());
            pst.setString(5, book.getPublisher());
            pst.setInt(6, book.getNoBooksAvailable());
            pst.setString(7, book.getLanguage());

            pst.executeUpdate();

            state = true;

        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return state;
    }

    @Override
    public Book searchBookById(int bookId) {

        String sqlSearch = "SELECT * FROM book WHERE bookId=?";
        Connection con = null;
        PreparedStatement pst = null;
        Book bookSearchID = null;
        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            pst.setInt(1, bookId);
            rs = pst.executeQuery();

            if (rs.next()) {
                bookId = rs.getInt("bookId");
                String bookName = rs.getString("bookName");
                String ISBN = rs.getString("isbn");
                String author = rs.getString("bookAuthor");
                String publisher = rs.getString("bookPublisher");
                int noBooks = rs.getInt("bookNumber");
                int language = rs.getInt("Language_languageId");
                String addDate = rs.getString("bookAddDate");
                bookSearchID = new Book(bookId, bookName, ISBN, author, publisher, noBooks, bookName);

            }

        } catch (Exception ex) {
            bookSearchID = null;
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bookSearchID;

    }

    @Override
    public ArrayList<Book> searchBookByName(String bookName) {

        String sqlSearch = "SELECT * FROM book WHERE bookName=?";
        Connection con = null;
        PreparedStatement pst = null;
        Book bookSearchID = null;
        ArrayList<Book> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            pst.setString(1, bookName);
            rs = pst.executeQuery();

            while (rs.next()) {
                int bookId = rs.getInt("bookId");
                bookName = rs.getString("bookName");
                String ISBN = rs.getString("isbn");
                String author = rs.getString("bookAuthor");
                String publisher = rs.getString("bookPublisher");
                int noBooks = rs.getInt("bookNumber");
                int language = rs.getInt("Language_languageId");
                bookSearchID = new Book(bookId, bookName, ISBN, author, publisher, noBooks, bookName);
                list.add(bookSearchID);
            }

        } catch (SQLException ex) {
            bookSearchID = null;
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;

    }

    @Override
    public boolean updateBook(Book book) {
        String sqlUpdate = "UPDATE book SET bookName=?,isbn=? , bookAuthor=? ,bookPublisher=?,bookNumber=?,Language_languageId=? WHERE bookId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            state = true;

            pst.setString(1, book.getBookName());
            pst.setString(2, book.getIsbn());
            pst.setString(3, book.getAuthor());
            pst.setString(4, book.getPublisher());
            pst.setInt(5, book.getNoBooksAvailable());
            pst.setString(6, book.getLanguage());
            pst.setInt(7, book.getBookId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            book = null;
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public boolean removeBook(int bookId) {
        String sqlUpdate = "DELETE from book where bookId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            pst.setInt(1, bookId);
            pst.executeUpdate();
            state = true;

        } catch (Exception ex) {
            ex.printStackTrace();
            state = false;

        } finally {

            try {

                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        String sqlSearch = "SELECT * FROM book ";
        Connection con = null;
        PreparedStatement pst = null;
        Book bookSearchID = null;
        ArrayList<Book> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            rs = pst.executeQuery();

            while (rs.next()) {
                int bookId = rs.getInt("bookId");
                String bookName = rs.getString("bookName");
                String ISBN = rs.getString("isbn");
                String author = rs.getString("bookAuthor");
                String publisher = rs.getString("bookPublisher");
                int noBooks = rs.getInt("bookNumber");
                int language = rs.getInt("Language_languageId");

                bookSearchID = new Book(bookId, bookName, ISBN, author, publisher, noBooks, bookName);
                list.add(bookSearchID);
            }

        } catch (SQLException ex) {
            bookSearchID = null;
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;

    }

}
