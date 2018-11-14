package Objects;


interface User
{
	public int getID();
        
	public int getRating();
	
	public String getUsername();
        public void setUsername(String uName);
	
	public String getEncryptedPassword(String uName);
        public void setPassword(String p);
        
        public String getName();
        public void setName(String n);
}