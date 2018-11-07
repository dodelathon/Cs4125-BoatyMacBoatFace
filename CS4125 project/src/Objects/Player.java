class Player implements User
{
	private int ID;
	private int rating;
	private String encryptedPassword;
	public Developer()
	
	public Player(int r, String eP)
	{
		this.rating = r;
		this.encryptedPassword = eP;
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
	
	public void setRating(int r)
	{
		this.rating = r;
	}
}