package DataAccess;

import Model.Book;
import Model.BookCopy;
import Model.BookCopyDAO;
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
 * @author wijerath_ps13257
 */
public class BookCopyPersistantDAO implements BookCopyDAO {

    @Override
    public boolean addBookCopy(BookCopy bookcopy) {

        String sqlAdd = "INSERT INTO bookcopy VALUES(?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlAdd);

            pst.setInt(1, bookcopy.getBookcopyId());
            pst.setString(2, bookcopy.getBookcopyName());
            pst.setString(3, bookcopy.getBookId());
            pst.setBoolean(4, bookcopy.isBookcopyStatus());

            pst.executeUpdate();

            state = true;

        } catch (SQLException ex) {
            Logger.getLogger(BookCopyDAO.class.getName()).log(Level.SEVERE, null, ex);
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookCopyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return state;
    }

    @Override
    public boolean updateBookCopy(BookCopy bookcopy) {
        String sqlUpdate = "UPDATE bookcopy SET bookcopyName=?,Book_bookId=? , bookcopyStatus=?  WHERE bookcopyId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            state = true;

            pst.setInt(1, bookcopy.getBookcopyId());
            pst.setString(2, bookcopy.getBookcopyName());
            pst.setString(3, bookcopy.getBookId());
            pst.setBoolean(4, bookcopy.isBookcopyStatus());

            pst.executeUpdate();

        } catch (SQLException ex) {
            bookcopy = null;
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookCopyPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public boolean removeBookCopy(int bookcopyId) {
        String sqlUpdate = "DELETE from bookcopy where bookcopyId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            pst.setInt(1, bookcopyId);
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
                Logger.getLogger(BookCopyPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public BookCopy searchBookCopyById(int bookcopyId) {

        String sqlSearch = "SELECT * FROM bookcopy WHERE bookcopyId=?";
        Connection con = null;
        PreparedStatement pst = null;
        BookCopy bookcopySearchID = null;
        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            pst.setInt(1, bookcopyId);
            rs = pst.executeQuery();

            if (rs.next()) {
                bookcopyId = rs.getInt("bookcopyId");
                String bookcopyName = rs.getString("bookcopyName");
                String bookId = rs.getString("book_bookId");
                String status = rs.getString("bookcopystatus");

                bookcopySearchID = new BookCopy(bookcopyId, bookcopyName, true, bookId);

            }

        } catch (Exception ex) {
            bookcopySearchID = null;
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookCopyPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bookcopySearchID;
    }

    @Override
    public ArrayList<BookCopy> searchBookCopyByName(String bookcopyName) {

        String sqlSearch = "SELECT * FROM bookcopy WHERE bookcopyName=?";
        Connection con = null;
        PreparedStatement pst = null;
        BookCopy bookcopySearchID = null;
        ArrayList<BookCopy> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            pst.setString(1, bookcopyName);
            rs = pst.executeQuery();

            while (rs.next()) {
                int bookcopyId = rs.getInt("bookcopyId");
                bookcopyName = rs.getString("bookcopyName");
                String bookId = rs.getString("book_bookId");
                String status = rs.getString("bookcopystatus");

                bookcopySearchID = new BookCopy(bookcopyId, bookcopyName, true, bookId);

            }

        } catch (SQLException ex) {
            bookcopySearchID = null;
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookCopyPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

}
