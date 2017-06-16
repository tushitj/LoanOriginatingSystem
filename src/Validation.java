
public class Validation {
	public boolean checkInt(String text){
		try{
			int myint = Integer.parseInt(text);
			if(myint>0){
				return true;
			}
		}
		catch(Exception exp){
			return false;
		}
		return true;
	}
}
