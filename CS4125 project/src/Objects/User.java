package Objects;


interface User
{
	public int getID();
        public void setID(int nID);
        
	public double getRating();
        public void setRating(double nElo);
	
	public String getUsername();
        public void setUsername(String uName);
	
	public String getEncryptedPassword(String uName);
        public void setPassword(String p);
        
        public String getName();
        public void setName(String n);
}