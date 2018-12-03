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
    private ArrayList<Integer> pIDs;
    private ArrayList <String> pNames;
    private MySqlAccess a;
    
    public Match()
    {
        pIDs = new ArrayList<>();
        pNames = new ArrayList<>();
        a = MySqlAccess.getInstance();
    }
    
    public int[] AddPlayer(int id, String uname)
    {
        int gid = -1;
        int[] ret = new int[2];
        if(pIDs.size() < 5)
        {
            pIDs.add(id);
            pNames.add(uname);
        }
        else
        {
           gid = a.newGame(pIDs.get(0), pNames.get(0), pIDs.get(1), pNames.get(1), pIDs.get(2), pNames.get(2), pIDs.get(3), pNames.get(3), pIDs.get(4), pNames.get(4));
        }
        
        ret[0] = pIDs.size();
        ret[1] = gid;
        return ret;
    }   
}
