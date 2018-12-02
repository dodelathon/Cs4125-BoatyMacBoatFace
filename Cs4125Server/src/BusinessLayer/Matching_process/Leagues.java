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
public class Leagues 
{
    private static Leagues me;
    private final int wood;
    private final int bronze;
    private final int silver;
    private final int gold;
    private final int platinum;
    private final int diamond;
    
    private Leagues()
    {
        wood = 0;
        bronze = 400;
        silver = 800;
        gold = 1200;
        platinum = 1600;
        diamond = 2000;
    }
    
    public static Leagues getInstance()
    {
        if(me == null)
        {
            me = new Leagues();
        }
        return me;
    }
    
    public int getWood()
    {
        return wood;
    }
    
    public int getBronze()
    {
        return bronze;
    }
    
    public int getSilver()
    {
        return silver;
    }
    
    public int getGold()
    {
        return gold;
    }
    
    public int getPlat()
    {
        return platinum;
    }
   
    public int getDiamond()
    {
        return diamond;
    }
    
}
