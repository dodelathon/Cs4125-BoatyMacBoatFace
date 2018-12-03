/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Objects.*;
import java.util.ArrayList;

/**
 *
 * @author donal
 */
public class Availibility_Filter 
{
    private ArrayList<MatchMaker_appUsers> online;
    private ArrayList<MatchMaker_appUsers> matchable;
    private final MySqlAccess a;
    private static Availibility_Filter me;
    
    private Availibility_Filter()
    {
        a = MySqlAccess.getInstance();
        online = new ArrayList<>();
        matchable = new ArrayList<>();
    }
    
    public static Availibility_Filter getInstance()
    {
        if(me == null)
        {
            me = new Availibility_Filter();
        }
        return me;
    }
    
    public ArrayList<MatchMaker_appUsers> findQueued()
    {
        try
        {
            findOnline();
            for(MatchMaker_appUsers x : online)
            {
                if(x.is_queued() == 1)
                {
                    matchable.add(x);               
                }      
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return matchable;
    }
    
    private void findOnline()
    {
        String[] interim;
        try
        {
            //System.out.println(a.getOnlinePlayers().trim());
            interim = a.getOnlinePlayers().trim().split(",");
            for(int i = 0; i < interim.length - 5; i += 5)
            {
                if(Integer.parseInt(interim[3]) == 1)
                {
                    int id = Integer.parseInt(interim[i]);
                    String username = interim[i + 1];
                    double elo = Double.parseDouble(interim[i + 2]);
                    int onl = Integer.parseInt(interim[i + 3]);
                    int queued = Integer.parseInt(interim[i + 4]);
                    
                    online.add(new MatchMaker_Player(id, username, elo, onl, queued));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Unable to handle query");
            System.out.println(e.getMessage());
        }
    } 
}
