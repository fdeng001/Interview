package betterDecrypt;

public class Solution {

	// http://www.yelp.com/user_details?userid=vjWMqGJ9bJpUQ_1t44IuTQ
	// "vjWMqGJ9bJpUQ_1t44IuTQ" => 1234
	// sometimes we get the lowercase string:  http://www.yelp.com/user_details?userid=vjwmqgj9bjpuq_1t44iutq

	//Given two methodS: 
	//public String encryptID(int id);
	//public int decryptID(String encrypted); // return decrypted int, or throw InvalidID if it's bad
	
	//write a forceDecryptID(String lowercasedID) method to decryted the lowercasedID string.

	public int forceDecryptID(String lowercasedID) {
	    int result = help(lowercasedID, 0, "");
	    if(result == -1)
	        throw NosuchIDException;
	    else
	        return result;
	}

	private int help(String lowercasedID, int step, String decrypt) {
		if(step == lowercasedID.length()-1){
			int id = 0;
			try{
				id = decryptID(decrypt);
			}
			catch(InvalidID e){
				id = -1;
			}
			return id;
	    } else {
	    	if(lowercasedID.charAt(step)>='0' && lowercasedID.charAt(step)<='0'){
	    		decrypt = decrypt+lowercasedID.charAt(step);
	    		return help(lowercasedID,step+1,decrypt);
	    	}
	    	else{
	    		int t =0;
	    		t = help(lowerCasedID,step,decrypt+lowerCasedID.charAt(step).toupperCase());
	    		if(t!=-1)
	    			return t;
	    		return help(lowserCasedID, step, decrypt + lowerCasedID.charAt(step).tolowerCase());
	    	}
	    }
	}
}
