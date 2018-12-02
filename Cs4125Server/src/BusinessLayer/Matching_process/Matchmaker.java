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

import DataLayer.MySqlAccess;
import Objects.*;
import java.util.*;


public class Matchmaker 
{
    private final MySqlAccess a;
    private static Matchmaker me;
    private ArrayList<appUsers> matchable;
    private Leagues league;
    
    
    private Matchmaker()
    {
        a = MySqlAccess.getInstance();
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
    
    public String matchingProcess(int id)
    {
        
        return "";
    }
    
    
}
