Package Objects

class Developer implements User
{
	private int ID;
	private int rating;
	private String encryptedPassword;
	private String username();
	
	public Developer()
	
	public Developer(String un, String eP)
	{
		this.encryptedPassword = eP;
		this.username = un;
	}
	
	public String getUsername()
	{
		return username;
	}
	@override
	public int getRating()
	{
		return this.rating;
	}
	
	@override
	public int getID()
	{
		return this.ID;
	}
	
	@override
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
	
	public String seePlayerRating()
	{
		//database shit using player from database stored as Player p = new Player(int rating, String un)
		
		int r = p.getRating;
		
		return r + p.getUsername() + "'s rating is " + r;
	}
}