package Objects;


interface MatchMakerTable_User
{
	public int getID();
        public void setId(int nID);
        
	public double getRating();
        public void setRating(double nElo);
	
	public String getUsername();
        public void setUsername(String uName);
        
        public int is_online();
        public void set_OStat(int oStat);
        
        public int is_queued();
        public void set_QStat(int qStat);
        
        
        
}