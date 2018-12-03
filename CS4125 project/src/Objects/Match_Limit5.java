/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
/**
 *
 * @author donal
 */
public class Match_Limit5 
{
    private final int MatchID;
    private final int p1;
    private final int p2;
    private final int p3;
    private final int p4;
    private final int p5;
    private final String p1n;
    private final String p2n;
    private final String p3n;
    private final String p4n;
    private final String p5n;
    
    public Match_Limit5(int gid, int p1, int p2, int p3, int p4, int p5, String p1n, String p2n, String p3n, String p4n, String p5n)
    {
        this.MatchID = gid;
        
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        
        this.p1n = p1n;
        this.p2n = p2n;
        this.p3n = p3n;
        this.p4n = p4n;
        this.p5n = p5n;
    }
    
    public int getGID()
    {
        return MatchID;
    }
    
    public int getP1()
    {
        return p1;
    }
    
    public int getP2()
    {
        return p2;
    }
    
    public int getP3()
    {
        return p3;
    }
    
    public int getP4()
    {
        return p4;
    }
    
    public int getP5()
    {
        return p5;
    }
    
    public String getP1n()
    {
        return p1n;
    }
    
    public String getP2n()
    {
        return p2n;
    }
    
    public String getP3n()
    {
        return p3n;
    }
    
    public String getP4n()
    {
        return p4n;
    }
    
    public String getP5n()
    {
        return p5n;
    }  
}
