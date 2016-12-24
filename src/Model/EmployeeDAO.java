/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Wishwa
 */
public interface EmployeeDAO {
    
    public Employee loginEmployee(String username, String password);
        //Done

    public void addEmployee(Employee employee);
        //Done

    public Employee searchEmployeeById(int Id);
        //Done

    public ArrayList<Employee> searchEmployeeByName(String Name);
        //Done

    public boolean updateEmployee(Employee employee);

    public boolean deleteEmployee(int Id);
    
    public int setId();

}
