package Objects;

public class Player implements User
{
	private final int ID;
	private int rating;
        private final String username;
	private final String encryptedPassword;
	
	public Player(int id, String uname, String eP, int r)
	{
            this.ID = id;
            this.username = uname;   
            this.rating = r;
            this.encryptedPassword = eP;
	}
	
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
}