package Objects;

<<<<<<< HEAD
public class Player extends appUsers
{
    public Player()
    {
    
    }
    public Player(String name, String uName, String password)
    {
        setName(name);
        setUsername(uName);
        setPassword(password);
    }
    

}   
/*{
	private int ID;
	private int rating;
	private String encryptedPassword;
        private String username;
	
	public Player(int r, String eP, String name)
=======
public class Player implements User
{
	private final int ID;
	private int rating;
        private final String username;
	private final String encryptedPassword;
	
	public Player(int id, String uname, String eP, int r)
>>>>>>> 85d5839b44f7f6e2951c2789e4a8587c3ea3d423
	{
            this.ID = id;
            this.username = uname;   
            this.rating = r;
            this.encryptedPassword = eP;
	}
	
<<<<<<< HEAD
        @Override
        public String getUsername()
        {
            return this.username;
        }
        
        
        
=======
>>>>>>> 85d5839b44f7f6e2951c2789e4a8587c3ea3d423
	@Override
	public int getRating()
	{
		return this.rating;
	}
	
	@Override
	public int getID()
	{
		return this.ID;
	}
	
	@Override
	public String getEncryptedPassword()
	{
		return this.encryptedPassword;
	}
	
        @Override
        public String getUsername()
        {
            return username;
        }
        
	public void setRating(int r)
	{
		this.rating = r;
	}


}*/