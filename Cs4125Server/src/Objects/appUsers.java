package Objects;

public abstract class appUsers implements MatchMakerTable_User 
{
    private String username;
    private int online;
    private int queued;
    private int rating;
    private int uID;
    
    @Override
    public String getUsername()
    {
        return username;
    }
    @Override
    public int getRating()
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
    public boolean is_online()
    {
        if(online == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     *
     * @return 
     * @Boolean
     */
    @Override
    public boolean is_queued()
    {
        if(queued == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
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
    public void setRating(int nElo)
    {
        rating = nElo;
    }
}
