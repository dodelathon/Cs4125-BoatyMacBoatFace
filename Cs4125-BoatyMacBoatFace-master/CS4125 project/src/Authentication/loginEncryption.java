package Authentication;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class loginEncryption {
    
    /**
     *
     * @param pwForEncryption
     * @return
     */
    public static String loginEncryption(String pwForEncryption)
    {
        
        try {
            MessageDigest mDi = MessageDigest.getInstance("SHA-512");
            byte[] messDigest = mDi.digest(pwForEncryption.getBytes());
            BigInteger num = new BigInteger(1, messDigest);
            String hashedPW = num.toString(16);
            while (hashedPW.length() < 32)
                hashedPW = "0" + hashedPW;
            return hashedPW;
        }
        
        catch (NoSuchAlgorithmException e)
        {
            return "failed";
        }
    }

}