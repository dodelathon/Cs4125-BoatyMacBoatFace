/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125server;
import cs4125server.MySqlAccess;
import java.sql.SQLException;
/**
 *
 * @author donal
 */
public class test 
{
    public static void main(String[] args) throws Exception
    {
        MySqlAccess meep = new MySqlAccess();
        meep.insertRowIntoLoginInfo("beep", "shabalabadingdong", 0);
        meep.insertRowIntoLoginInfo("beep", "shabalabadingdong", 0);
        meep.insertRowIntoLoginInfo("bepe", "shabalabadingdong", 1);
        System.out.println(meep.readAllFromDB("login_info"));
        System.out.println(meep.isPlayerDev("bepe"));
        System.out.println(meep.getPassword("beep"));
    }
}
