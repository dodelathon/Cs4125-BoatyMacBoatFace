package Objects;

public class MatchMaker_Player extends MatchMaker_appUsers
{
    public MatchMaker_Player()
    {
    
    }
    public MatchMaker_Player(int id, String uName, double nElo, int oStat, int qStat)
    {
        
        this.setUsername(uName);
        this.setId(id);
        this.setRating(nElo);
        this.set_OStat(oStat);
        this.set_QStat(qStat);
        
    }
    

}   
