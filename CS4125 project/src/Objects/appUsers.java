package Objects;

public abstract class appUsers implements User {
    private String name;
    private String username;
    private String password;
    private int rating;
    private int uID;
    
    @Override
    public String getName()
    {
        return name;
    }
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
    public String getEncryptedPassword(String userName)
    {
        return "password";
    }
    @Override
    public void setUsername(String username)
    {
        this.username = username;
    }
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public void setPassword(String password)
    {
        this.password = password;
    }
            
    
}
