package Objects;

<<<<<<< HEAD
public class Developer extends appUsers
=======
public class Developer implements User
>>>>>>> 85d5839b44f7f6e2951c2789e4a8587c3ea3d423
{
    public Developer()
    {
    
    }
    public Developer(String name, String uName, String password)
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
<<<<<<< HEAD
        
	public Developer()
        {
=======
	
	public Developer()
        {
            
>>>>>>> 85d5839b44f7f6e2951c2789e4a8587c3ea3d423
        }
	
	public Developer(String un, String eP)
	{
		this.encryptedPassword = eP;
		this.username = un;
	}
<<<<<<< HEAD
	@Override
=======
	
        @Override
>>>>>>> 85d5839b44f7f6e2951c2789e4a8587c3ea3d423
	public String getUsername()
	{
		return username;
	}
<<<<<<< HEAD
	@Override
=======
        
        @Override
>>>>>>> 85d5839b44f7f6e2951c2789e4a8587c3ea3d423
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
	
	public void setRating(Player p, int r)
	{
		p.setRating(r);
	}
	
	public void setRating(int r)
	{
		this.rating = r;
	}
	
	public String seePlayerRating(Player p)
	{
		//database shit using player from database stored as Player p = new Player(int rating, String un)
		
<<<<<<< HEAD
		//int r = p.getRating;
		
		//return r + p.getUsername() + "'s rating is " + r;
            return "s";
=======
		int r = p.getRating();
		
		return  p.getUsername() + "'s rating is " + r;
>>>>>>> 85d5839b44f7f6e2951c2789e4a8587c3ea3d423
	}
}*/