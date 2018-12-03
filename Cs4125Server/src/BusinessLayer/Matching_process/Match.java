/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.Matching_process;

import java.util.ArrayList;
import DataLayer.MySqlAccess;

/**
 *
 * @author donal
 */
public class Match 
{
    public ArrayList<Integer> pIDs;
    public ArrayList <String> pNames;
    private MySqlAccess a;
    
    public Match()
    {
        pIDs = new ArrayList<>();
        pNames = new ArrayList<>();
        a = MySqlAccess.getInstance();
    }
    
    public int AddPlayer(int id, String uname)
    {
        int gid = -1;
        int ret;
        if(pIDs.size() < 5)
        {
            pIDs.add(id);
            pNames.add(uname);
        }
        
        ret = pIDs.size();
        return ret;
    }   
}
