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
public interface MemberDAO {
    

    public void addMember(Member member);
        //Done

    public Member searchMemberById(int Id);
        //Done

    public ArrayList<Member> searchMemberByName(String Name);
        //Done

    public boolean updateMember(Member member);

    public boolean deleteMember(int Id);
    
    public int setId();
    
}
