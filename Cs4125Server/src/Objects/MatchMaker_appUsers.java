package Objects;

public abstract class MatchMaker_appUsers implements MatchMakerTable_User 
{
    private String username;
    private int online;
    private int queued;
    private double rating;
    private int uID;
    
    @Override
    public String getUsername()
    {
        return username;
    }
    @Override
    public double getRating()
    {
        return rating;
    }
    @Override
    public int getID()
    {
        return uID;
    }

    @Override
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    @Override
    public int is_online()
    {
        return online;
    }
    
    /**
     *
     * @return 
     * @Boolean
     */
    @Override
    public int is_queued()
    {
       return queued;
    }
    
    @Override
    public void set_OStat(int oStat)
    {
        online = oStat;
    }
    
    @Override
    public void set_QStat(int qStat)
    {   
        queued = qStat;
    }
    
    @Override
    public void setId(int id)
    {
        uID = id;
    }
    
    @Override
    public void setRating(double nElo)
    {
        rating = nElo;
    }
}
