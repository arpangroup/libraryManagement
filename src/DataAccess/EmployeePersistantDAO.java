package DataAccess;

import Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.EmployeeDAO;

public class EmployeePersistantDAO implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {

        String sqlAdd = "INSERT INTO employee VALUES(?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlAdd);

            pst.setInt(1, employee.getUserId());
            pst.setString(2, employee.getUserName());
            pst.setInt(3, employee.getUserContactNo());
            pst.setString(4, employee.getUserAddress());
            pst.setString(5, employee.getUsername());
            pst.setString(6, employee.getUserPassword());
            pst.setString(7, employee.getUserAccess());

            pst.executeUpdate();

            state = true;

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // return state;
    }

    @Override
    public Employee searchEmployeeById(int Id) {

        String sqlSearch = "SELECT * FROM employee WHERE empId=?";
        Connection con = null;
        PreparedStatement pst = null;
        Employee employeeSearchID = null;
        /* Employee Id is unique*/
        //  ArrayList<Employee> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            pst.setInt(1, Id);
            rs = pst.executeQuery();

            if (rs.next()) {
                Id = rs.getInt("empId");
                String userName = rs.getString("empName");
                int contact = rs.getInt("empContactNo");
                String address = rs.getString("empAddress");
                String username = rs.getString("empUsername");
                String password = rs.getString("empPassword");
                String access = rs.getString("empAccess");
                employeeSearchID = new Employee(Id, userName, contact, address, username, password, access);
                //  list.add(employeeSearchID);
            }

        } catch (Exception ex) {
            employeeSearchID = null;
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeePersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return employeeSearchID;
    }

    @Override

    public ArrayList<Employee> searchEmployeeByName(String name) {

        String sqlSearch = "SELECT * FROM employee WHERE empName LIKE ?";
        Connection con = null;
        PreparedStatement pst = null;
        Employee employeeSearchID = null;
        ArrayList<Employee> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlSearch);
            pst.setString(1, "%" + name + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                int Id = rs.getInt("empId");
                name = rs.getString("empName");
                int contact = rs.getInt("empContactNo");
                String address = rs.getString("empAddress");
                String username = rs.getString("empUsername");
                String password = rs.getString("empPassword");
                String access = rs.getString("empAccess");
                employeeSearchID = new Employee(Id, name, contact, address, username, password, access);
                list.add(employeeSearchID);
            }

        } catch (SQLException ex) {
            employeeSearchID = null;
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeePersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    @Override
    public boolean updateEmployee(Employee employee) {

        String sqlUpdate = "UPDATE employee SET empName=?,empContactNo=? , empAddress=? WHERE empId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            state = true;
            pst.setString(1, employee.getUserName());
            pst.setInt(2, employee.getUserContactNo());
            pst.setString(3, employee.getUserAddress());
            pst.setInt(4, employee.getUserId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            employee = null;
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeePersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override

    public boolean deleteEmployee(int Id) {
        String sqlUpdate = "DELETE from employee where empId=?";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);
            pst.setInt(1, Id);
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
                Logger.getLogger(EmployeePersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return state;
    }

    @Override
    public Employee loginEmployee(String username, String password) {

        Employee employee = null;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {

            con = DBconnectionProject.connect();
            String preparedSql = "SELECT * FROM employee WHERE empUserName = ? AND empPassword = ?";
            pst = con.prepareStatement(preparedSql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("empId");
                String userName = rs.getString("empName");
                int contact = rs.getInt("empContactNo");
                String address = rs.getString("empAddress");
                username = rs.getString("empUsername");
                password = rs.getString("empPassword");
                String access = rs.getString("empAccess");
                employee = new Employee(id, userName, contact, address, username, password, access);

            } 

        } catch (SQLException ex) {

            Logger.getLogger(EmployeePersistantDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeePersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return employee;
    }

    @Override
    public int setId() {
        int setId=0;
        
        String sqlEmp = "SELECT MAX(EmpId) FROM Employee";
        Connection conEmp = null;
        PreparedStatement pstEmp = null;
        ResultSet rsEmp = null;

        try {
            conEmp = DBconnectionProject.connect();
            pstEmp = conEmp.prepareStatement(sqlEmp);
            rsEmp = pstEmp.executeQuery();

            if (rsEmp.next()) {
           setId = rsEmp.getInt(1);
            }

        } catch (SQLException ex) {
        } finally {
            try {
                rsEmp.close();
                pstEmp.close();
                conEmp.close();

            } catch (SQLException ex) {
                Logger.getLogger(EmployeePersistantDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
                Logger
                        .getLogger(EmployeePersistantDAO.class
                                .getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
        return setId;
        
    }
}
