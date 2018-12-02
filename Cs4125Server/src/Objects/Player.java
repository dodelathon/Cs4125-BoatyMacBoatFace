package Objects;

public class Player extends appUsers
{
    public Player()
    {
    
    }
    public Player(int id, String uName, int nElo, int oStat, int qStat)
    {
        
        this.setUsername(uName);
        this.setId(id);
        this.setRating(nElo);
        this.set_OStat(oStat);
        this.set_QStat(qStat);
        
    }
    

}   
