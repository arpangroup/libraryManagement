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
public interface GuaranterDAO {

    public void addGuarantor(Guaranter guarantor);
        //Done

    public Guaranter searchGuarantorById(int Id);
        //Done

    public ArrayList<Guaranter> searchGuarantorByName(String Name);
        //Done

    public boolean updateGuarantor(Guaranter guarantor);

    public boolean deleteGuaranter(int Id);
    
    public int setId();
}

