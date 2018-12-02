/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.Matching_process;

import java.util.ArrayList;

/**
 *
 * @author donal
 */
public class Match 
{
    private ArrayList<Integer> pIDs;
    private ArrayList <String> pNames;
    
    public Match()
    {
        pIDs = new ArrayList<>();
        pNames = new ArrayList<>();
    }
    
    public void AddPlayer(int id, String uname)
    {
        if(pIDs.size() < 5)
        {
            pIDs.add(id);
            pNames.add(uname);
        }
    }
    
    
    
}
