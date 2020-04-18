package utilites;

import java.security.SecureRandom;
import java.util.Random;
//32-126

public class RandomTextGenerator {
	
	public static String generateRandomString(int stringLength){
		char ascii[] = new char[95];
		 for (int i=0; i<=94; i++) {
	   ascii[i]=(char)(i+32);
	  		 
	   }
		 StringBuilder sb = new StringBuilder();
	        Random random = new SecureRandom();
	        for (int i = 0; i < stringLength; i++) {
	            char c = ascii[random.nextInt(ascii.length)];
	            sb.append(c);
	            
	        }
		 
	        String output = sb.toString();
	        
	        return output ;
	}
}
