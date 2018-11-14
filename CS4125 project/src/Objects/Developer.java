package Objects;

public class Developer extends appUsers implements User
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
