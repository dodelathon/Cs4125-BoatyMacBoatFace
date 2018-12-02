/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.Matching_process;

/**
 *
 * @author donal
 */

import DataLayer.*;
import Objects.*;
import java.util.*;


public class Matchmaker 
{
    private final MySqlAccess a;
    private static Matchmaker me;
    private ArrayList<appUsers> matchable;
    private final Leagues league;
    private final Availibility_Filter avail;
    private final int AMOUNTOFTIERS = 7;
    
    
    private Matchmaker()
    {
        a = MySqlAccess.getInstance();
        avail = Availibility_Filter.getInstance();
        matchable = new ArrayList<>();
        league = Leagues.getInstance();
    }
    
    public static Matchmaker getInstance()
    {
        if(me == null)
        {
            me = new Matchmaker();
        }
        return me;
    }
    
    public String matchingProcess(int id, String uname)
    {
        matchable = avail.findQueued();
        int i = 0;
        Match match;
        match = new Match();
        for(appUsers x : matchable)
        {
            if(x.getRating() <= league.getWood() + 200)
            {
            
            }
            
            else if(x.getRating() >= league.getBronze() - 200 || x.getRating() <= league.getBronze() + 200)
            {
              
            }
            
            else if(x.getRating() >= league.getSilver() - 200 || x.getRating() <= league.getBronze() + 200)
            {
              
            }
            
            else if(x.getRating() >= league.getGold() - 200 || x.getRating() <= league.getBronze() + 200)
            {
              
            }
            
            else if(x.getRating() >= league.getPlat() - 200 || x.getRating() <= league.getBronze() + 200)
            {
              
            }
            
            else if(x.getRating() >= league.getDiamond() - 200 || x.getRating() <= league.getBronze() + 200)
            {
              
            }
            
        }
        return "";
    }
    
    
}
