package Objects;


interface MatchMakerTable_User
{
	public int getID();
        public void setId(int nID);
        
	public int getRating();
        public void setRating(int nElo);
	
	public String getUsername();
        public void setUsername(String uName);
        
        public boolean is_online();
        public void set_OStat(int oStat);
        
        public boolean is_queued();
        public void set_QStat(int qStat);
        
        
        
}