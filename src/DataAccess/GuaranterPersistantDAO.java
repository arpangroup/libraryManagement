package DataAccess;

import Model.Guaranter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.GuaranterDAO;

/**
 *
 * @author Wishwa
 */
public class GuaranterPersistantDAO implements GuaranterDAO {

    @Override
    public void addGuarantor(Guaranter guaranter) {
        String sqlAdd = "INSERT INTO guaranter VALUES(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlAdd);
            pst.setInt(1, guaranter.getGuaranterId());
            pst.setString(2, guaranter.getGuaranterName());
            pst.setString(3, guaranter.getGuaranterContactNo());
            pst.setString(4, guaranter.getGuaranterAddress());
            pst.setString(5, guaranter.getFk_memberId());
            pst.executeUpdate();

            state = true;

        } catch (SQLException ex) {
            Logger.getLogger(Guaranter.class.getName()).log(Level.SEVERE, null, ex);
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Guaranter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override

    public Guaranter searchGuarantorById(int Id) {

        String sqlSearch = "SELECT * FROM guaranter WHERE guaranterId=?";
        Connection con = null;
        PreparedStatement pst = null;
        Guaranter guarantorSearchID = null;

        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            pst.setInt(1, Id);
            rs = pst.executeQuery();

            if (rs.next()) {
                Id = rs.getInt("guaranterId");
                String Name = rs.getString("guaranterName");
                String Contact = rs.getString("guaranterContactNo");
                String Address = rs.getString("guaranterAddress");
                String fk_memberId = rs.getString("Member_memberId");

                guarantorSearchID = new Guaranter(Id, Name, Contact, Address, fk_memberId);

            }

        } catch (SQLException ex) {
            guarantorSearchID = null;
            ex.printStackTrace();

        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuaranterPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return guarantorSearchID;
    }

    @Override
    public ArrayList<Guaranter> searchGuarantorByName(String Name) {

        String sqlSearch = "SELECT * FROM guaranter WHERE guaranterName LIKE ?";
        Connection con = null;
        PreparedStatement pst = null;
        Guaranter guaranterSearchID = null;
        ArrayList<Guaranter> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            pst.setString(1, "%" + Name + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                int Id = rs.getInt("guaranterId");
                Name = rs.getString("guaranterName");
                String Contact = rs.getString("guaranterContactNo");
                String Address = rs.getString("guaranterAddress");
                String fk_memberId = rs.getString("Member_memberId");
                guaranterSearchID = new Guaranter(Id, Name, Contact, Address, fk_memberId);
                list.add(guaranterSearchID);
            }

        } catch (SQLException ex) {
            guaranterSearchID = null;
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuaranterPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    @Override
    public boolean updateGuarantor(Guaranter guaranter) {
        String sqlUpdate = "UPDATE guaranter SET guaranterName=?,guaranterContactNo=? , guaranterAddress=?  WHERE guaranterId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            state = true;
            pst.setString(1, guaranter.getGuaranterName());
            pst.setString(2, guaranter.getGuaranterContactNo());
            pst.setString(3, guaranter.getGuaranterAddress());
            pst.setInt(4, guaranter.getGuaranterId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            guaranter = null;
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuaranterPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public boolean deleteGuaranter(int Id) {
        String sqlUpdate = "DELETE from guaranter where guaranterId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            pst.setInt(1, Id);
            pst.executeUpdate();
            state = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            state = false;

        } finally {

            try {

                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuaranterPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public int setId() {
        int setId = 0;

        String sqlGuaranter = "SELECT MAX(GuaranterId) FROM Guaranter";
        Connection conGuaranter = null;
        PreparedStatement pstGuaranter = null;
        ResultSet rsGuaranter = null;

        try {
            conGuaranter = DBconnectionProject.connect();
            pstGuaranter = conGuaranter.prepareStatement(sqlGuaranter);
            rsGuaranter = pstGuaranter.executeQuery();

            if (rsGuaranter.next()) {
                setId = rsGuaranter.getInt(1);
            }

        } catch (SQLException ex) {
        } finally {
            try {
                rsGuaranter.close();
                pstGuaranter.close();
                conGuaranter.close();

            } catch (SQLException ex) {
                Logger.getLogger(GuaranterPersistantDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
                Logger
                        .getLogger(GuaranterPersistantDAO.class
                                .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setId;
    }
}
