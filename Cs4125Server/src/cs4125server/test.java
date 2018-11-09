/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125server;

/**
 *
 * @author donal
 */
public class test 
{
    public static void main(String[] args)
    {
        MySqlAccess conn = MySqlAccess.getInstance();
        try
        {
            System.out.println(conn.readAllFromDB("login_info"));
        }
        catch(Exception e)
        {
            System.out.println("wtf");
        }
    }
}
