package DataAccess;

import Model.Guarantor;
import Model.GuarantorDAO;
import java.sql.Connection;
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
public class GuarantorPersistantDAO implements GuarantorDAO {

    @Override
    public void addGuarantor(Guarantor guarantor) {
        String sqlAdd = "INSERT INTO guaranter VALUES(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlAdd);
            pst.setInt(1, guarantor.getGuarantorId());
            pst.setString(2, guarantor.getGuarantorName());
            pst.setString(3, guarantor.getGuarantorContactNo());
            pst.setString(4, guarantor.getGuarantorAddress());
            pst.setString(5, guarantor.getFk_memberId());
            pst.executeUpdate();

            state = true;

        } catch (SQLException ex) {
            Logger.getLogger(Guarantor.class.getName()).log(Level.SEVERE, null, ex);
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Guarantor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override

    public Guarantor searchGuarantorById(int Id) {

        String sqlSearch = "SELECT * FROM guaranter WHERE guaranterId=?";
        Connection con = null;
        PreparedStatement pst = null;
        Guarantor guarantorSearchID = null;

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

                guarantorSearchID = new Guarantor(Id, Name, Contact, Address,fk_memberId);

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
                Logger.getLogger(GuarantorPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return guarantorSearchID;
    }

    @Override
    public ArrayList<Guarantor> searchGuarantorByName(String Name) {

        String sqlSearch = "SELECT * FROM guaranter WHERE guaranterName LIKE ?";
        Connection con = null;
        PreparedStatement pst = null;
        Guarantor guarantorSearchID = null;
        ArrayList<Guarantor> list = new ArrayList<>();
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
                guarantorSearchID = new Guarantor(Id, Name, Contact, Address, fk_memberId);
                list.add(guarantorSearchID);
            }

        } catch (SQLException ex) {
            guarantorSearchID = null;
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuarantorPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    @Override
    public boolean updateGuarantor(Guarantor guarantor) {
        String sqlUpdate = "UPDATE guaranter SET guaranterName=?,guaranterContactNo=? , guaranterAddress=?  WHERE guaranterId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            state = true;
            pst.setString(1, guarantor.getGuarantorName());
            pst.setString(2, guarantor.getGuarantorContactNo());
            pst.setString(3, guarantor.getGuarantorAddress());
            pst.setInt(4, guarantor.getGuarantorId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            guarantor = null;
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuarantorPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public boolean deleteGuarantor(int Id) {
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
                Logger.getLogger(GuarantorPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public int setId() {
  int setId=0;
        
        String sqlGuarantor = "SELECT COUNT(GuarantorId) FROM Employee";
        Connection conGuarantor = null;
        PreparedStatement pstGuarantor = null;
        ResultSet rsGuarantor = null;

        try {
            conGuarantor = DBconnectionProject.connect();
            pstGuarantor = conGuarantor.prepareStatement(sqlGuarantor);
            rsGuarantor = pstGuarantor.executeQuery();

            if (rsGuarantor.next()) {
           setId = rsGuarantor.getInt(1);
            }

        } catch (SQLException ex) {
        } finally {
            try {
                rsGuarantor.close();
                pstGuarantor.close();
                conGuarantor.close();

            } catch (SQLException ex) {
                Logger.getLogger(GuarantorPersistantDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
                Logger
                        .getLogger(GuarantorPersistantDAO.class
                                .getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
        return setId;
            }
}
