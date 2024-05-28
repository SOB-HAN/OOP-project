public class UserFunctions {
    public static boolean isEmpty(String string){
        if(string==null){
            return true;
        }
        else if(string.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean isValidUsername(String string){
        string=string.trim();
        if(string.matches("^[_0-9A-Za-z]+$")){
            return true;
        }
        return false;
    }
    public static int isWeakPassword(String Password){
        //if password is ok return 0
        //if password is too short return 1
        //if password doesn't contain the required characters return 2

        //replace this
        return 0;
    }
    public static int isValidEmail(String email){
        //if email is ok return 0
        //if email is empty return 1
        //if domain is empty return 2


        //replace this
        return 0;
    }
}
