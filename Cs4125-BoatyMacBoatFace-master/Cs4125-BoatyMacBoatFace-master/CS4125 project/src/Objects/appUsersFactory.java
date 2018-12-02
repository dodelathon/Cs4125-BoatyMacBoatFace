package Objects;

public class appUsersFactory 
{
    public appUsers makeUser(String newUserType)
    {
        appUsers newUser = null;
        switch (newUserType) {
            case "player":
                return  new Player();
            case "dev":
                return new Developer();
            default:
                return null;
        }
    }
    
}
 