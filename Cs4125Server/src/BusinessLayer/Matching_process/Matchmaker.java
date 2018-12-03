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
    private ArrayList<MatchMaker_appUsers> matchable;
    private final Leagues league;
    private final Availibility_Filter avail;
    private final int AMOUNTOFTIERS = 6;
    private Match[] matchTiers;
    
    
    private Matchmaker()
    {
        a = MySqlAccess.getInstance();
        avail = Availibility_Filter.getInstance();
        matchable = new ArrayList<>();
        league = Leagues.getInstance();
        matchTiers = new Match[AMOUNTOFTIERS];
    }
    
    public static Matchmaker getInstance()
    {
        if(me == null)
        {
            me = new Matchmaker();
        }
        return me;
    }
    
    public String matchingProcess()
    {
        
        matchable = avail.findQueued();
        for(Match x: matchTiers)
        {
            x = new Match();
        }
        try
        {
            for(MatchMaker_appUsers x : matchable)
            {
                if(x.getRating() <= league.getWood() + 200)
                {
                    if(matchTiers[0].AddPlayer(x.getID(), x.getUsername())[0] == 5)
                    {
                        matchTiers[0] = new Match();
                        matchTiers[0].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getBronze() - 200 || x.getRating() <= league.getBronze() + 200)
                {
                    if(matchTiers[1].AddPlayer(x.getID(), x.getUsername())[0] == 5)
                    {
                        matchTiers[1] = new Match();
                        matchTiers[1].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getSilver() - 200 || x.getRating() <= league.getSilver() + 200)
                {
                    if(matchTiers[2].AddPlayer(x.getID(), x.getUsername())[0] == 5)
                    {
                        matchTiers[2] = new Match();
                        matchTiers[2].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getGold() - 200 || x.getRating() <= league.getGold() + 200)
                {
                    if(matchTiers[3].AddPlayer(x.getID(), x.getUsername())[0] == 5)
                    {
                        matchTiers[3] = new Match();
                        matchTiers[3].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getPlat() - 200 || x.getRating() <= league.getPlat() + 200)
                {
                    if(matchTiers[4].AddPlayer(x.getID(), x.getUsername())[0] == 5)
                    {
                        matchTiers[4] = new Match();
                        matchTiers[4].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getDiamond() - 200 || x.getRating() <= league.getDiamond() + 200)
                {
                if(matchTiers[5].AddPlayer(x.getID(), x.getUsername())[0] == 5)
                    {
                        matchTiers[5] = new Match();
                        matchTiers[5].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        String hold = a.readAllFromDB("matches");
        return hold;
    }
}
