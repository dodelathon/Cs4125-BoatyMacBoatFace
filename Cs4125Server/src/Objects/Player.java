package Objects;

public class Player extends appUsers
{
    public Player()
    {
    
    }
    public Player(int id, String uName, int nElo, int oStat, int qStat)
    {
        
        setUsername(uName);
        setId(id);
        setRating(nElo);
        set_OStat(oStat);
        set_QStat(qStat);
        
    }
    

}   
