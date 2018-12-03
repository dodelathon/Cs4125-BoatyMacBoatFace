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
        a.onlineAll();
        a.queueAll();
        matchable = avail.findQueued();
        for(int i = 0; i < AMOUNTOFTIERS; i++)
        {
            matchTiers[i] = new Match();
        }
        try
        {
            int temp; 
            for(MatchMaker_appUsers x : matchable)
            {
                
                if(x.getRating() <= league.getWood() + 200)
                {
                    temp = matchTiers[0].AddPlayer(x.getID(), x.getUsername());
                    System.out.println(temp);
                    if(temp == 5)
                    {
                        a.newGame(matchTiers[0].pIDs.get(0), matchTiers[0].pNames.get(0), matchTiers[0].pIDs.get(1), matchTiers[0].pNames.get(1), matchTiers[0].pIDs.get(2), matchTiers[0].pNames.get(2), matchTiers[0].pIDs.get(3), matchTiers[0].pNames.get(3), matchTiers[0].pIDs.get(4), matchTiers[0].pNames.get(4));
                        matchTiers[0] = new Match();
                        matchTiers[0].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                        
                    }
                }
            
                else if(x.getRating() >= league.getBronze() - 200 || x.getRating() <= league.getBronze() + 200)
                {
                    temp = matchTiers[1].AddPlayer(x.getID(), x.getUsername());
                    if(temp == 5)
                    {
                        a.newGame(matchTiers[1].pIDs.get(0), matchTiers[1].pNames.get(0), matchTiers[1].pIDs.get(1), matchTiers[1].pNames.get(1), matchTiers[1].pIDs.get(2), matchTiers[1].pNames.get(2), matchTiers[1].pIDs.get(3), matchTiers[1].pNames.get(3), matchTiers[1].pIDs.get(4), matchTiers[1].pNames.get(4));
                        matchTiers[1] = new Match();
                        matchTiers[1].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getSilver() - 200 || x.getRating() <= league.getSilver() + 200)
                {
                    a.newGame(matchTiers[2].pIDs.get(0), matchTiers[2].pNames.get(0), matchTiers[2].pIDs.get(1), matchTiers[2].pNames.get(1), matchTiers[2].pIDs.get(2), matchTiers[2].pNames.get(2), matchTiers[2].pIDs.get(3), matchTiers[2].pNames.get(3), matchTiers[2].pIDs.get(4), matchTiers[2].pNames.get(4));
                    temp = matchTiers[2].AddPlayer(x.getID(), x.getUsername());
                    if(temp == 5)
                    {
                        matchTiers[2] = new Match();
                        matchTiers[2].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getGold() - 200 || x.getRating() <= league.getGold() + 200)
                {
                    a.newGame(matchTiers[3].pIDs.get(0), matchTiers[3].pNames.get(0), matchTiers[3].pIDs.get(1), matchTiers[3].pNames.get(1), matchTiers[3].pIDs.get(2), matchTiers[3].pNames.get(2), matchTiers[3].pIDs.get(3), matchTiers[3].pNames.get(3), matchTiers[3].pIDs.get(4), matchTiers[3].pNames.get(4));
                    temp = matchTiers[3].AddPlayer(x.getID(), x.getUsername());
                    if(temp == 5)
                    {
                        matchTiers[3] = new Match();
                        matchTiers[3].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getPlat() - 200 || x.getRating() <= league.getPlat() + 200)
                {
                    a.newGame(matchTiers[4].pIDs.get(0), matchTiers[4].pNames.get(0), matchTiers[4].pIDs.get(1), matchTiers[4].pNames.get(1), matchTiers[4].pIDs.get(2), matchTiers[4].pNames.get(2), matchTiers[4].pIDs.get(3), matchTiers[4].pNames.get(3), matchTiers[4].pIDs.get(4), matchTiers[4].pNames.get(4));
                    temp = matchTiers[4].AddPlayer(x.getID(), x.getUsername());
                    if(temp == 5)
                    {
                        matchTiers[4] = new Match();
                        matchTiers[4].AddPlayer(x.getID(), x.getUsername());
                        a.updateQueuedStatus(x.getID(), 0);
                    }
                }
            
                else if(x.getRating() >= league.getDiamond() - 200 || x.getRating() <= league.getDiamond() + 200)
                {
                    a.newGame(matchTiers[5].pIDs.get(0), matchTiers[5].pNames.get(0), matchTiers[5].pIDs.get(1), matchTiers[5].pNames.get(1), matchTiers[5].pIDs.get(2), matchTiers[5].pNames.get(2), matchTiers[5].pIDs.get(3), matchTiers[5].pNames.get(3), matchTiers[5].pIDs.get(4), matchTiers[5].pNames.get(4));
                    temp = matchTiers[5].AddPlayer(x.getID(), x.getUsername());
                    if(temp == 5)
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
            System.out.println(e.toString());
        }
        String hold = a.readAllFromDB("matches");
        //System.out.println(hold);
        return hold;
    }
}
