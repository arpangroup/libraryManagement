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
public interface GuarantorDAO {

    public void addGuarantor(Guarantor guarantor);
        //Done

    public Guarantor searchGuarantorById(int Id);
        //Done

    public ArrayList<Guarantor> searchGuarantorByName(String Name);
        //Done

    public boolean updateGuarantor(Guarantor guarantor);

    public boolean deleteGuarantor(int Id);
}
