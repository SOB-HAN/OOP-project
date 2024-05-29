import java.util.Scanner;

public class ProfileMenu {
    public static void showInfo(User user){
        System.out.println("Username : "+user.getUserName());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Nickname : "+user.getNickname());
        System.out.println("Email : "+user.getEmail());
        System.out.println("Password Recovery Question : "+"\""+user .getPasswordRecoveryQuestion()+"\"");
        System.out.println("Password Recovery Answer : "+"\""+user .getPasswordRecoveryAnswer()+"\"");
        System.out.println("Level : "+user.getLevel());
        System.out.println("Gold : "+user.getGold());
        //add more shit later.....
    }
    public static void changeUsername(User user,String newUsername){
        if(!UserFunctions.isValidUsername(newUsername)){
            //replace in phase 2
            System.out.println("invalid username : username must only contain letters,digits and underscore!");
        }
        //checking availability of the username
        else if(Database.getUserByUsername(newUsername)!=null){
            //replace in phase 2
            System.out.println("username already taken!");
        }
        else{
            user.setUserName(newUsername);
            //replace in phase 2
            System.out.println("username changed to "+user.getUserName()+" !");
        }
    }
    public static void changeNickname(User user,String newNickname){
        if(Database.getUserByNickname(newNickname)!=null){
            System.out.println("nickname already taken!");
        }
        else{
            user.setNickname(newNickname);
            //replace in phase 2
            System.out.println("nickname changed to "+user.getNickname()+" !");
        }
    }
    public static void changeEmail(User user,String newEmail){
        if(UserFunctions.isValidEmail(newEmail)==1){
            //replace in phase 2
            System.out.println("invalid Email! (email slot is empty)");
        }
        else if(UserFunctions.isValidEmail(newEmail)==2){
            //replace in phase 2
            System.out.println("invalid Email! (domain slot is empty)");
        }
        else if(Database.getUserByEmail(newEmail)!=null){
            System.out.println("Email already taken!");
        }
        else{
            user.setEmail(newEmail);
            //replace in phase 2
            System.out.println("Email changed to "+user.getEmail()+" !");
        }
    }
    public static void changePassword(User user,String oldPassword,String newPassword,Scanner scanner){
        if(!user.isCorrectPassword(oldPassword)){
            //replace in phase 2
            System.out.println("Current password is incorrect!");
        }
        else if(UserFunctions.isWeakPassword(newPassword)==1){
            System.out.println("new password too short! (must contain at least 8 characters)");
        }
        else if(UserFunctions.isWeakPassword(newPassword)==2){
            System.out.println("new password must contain at least 1 CAPITAL letter,1 small letter and 1 special character!");
        }
        else if(oldPassword.equals(newPassword)){
            System.out.println("Please enter a new password!");
        }
        else{
            //captcha here
            System.out.println("Please enter your new password again:");
            String newPasswordConfirm=scanner.nextLine();
            if(newPasswordConfirm.equals(newPassword)){
                user.setPassword(newPassword);
                System.out.println("Password changed successfully!");
            }
            else{
                System.out.println("Password confirmation failed!");
            }

        }
    }
    //******************************************************************************************************************
    public static void  run(Scanner scanner,User user) {
        String tempInput = null;
        boolean done = false;
        while (!done) {
            tempInput = scanner.nextLine();
            if (tempInput.matches("^\\s*back\\s*$")) {
                done = true;
            }
            else if (tempInput.matches("^\\s*show\\s+current\\s+menu\\s*$")) {
                //only in phase 1
                System.out.println("Current Menu:Profile Menu");
            }
            else if (tempInput.matches(("^\\s*show\\s+current\\s+user\\s*$"))) {
                System.out.println("Logged in user: " + user.getUserName());
            }
            //***************************************************show info**********************************************
            else if(tempInput.matches("^\\s*Show\\s+information\\s*$")){
                //replace in phase 2
                showInfo(user);
            }
            //**********************************************change username*********************************************
            else if(tempInput.matches(Regex.CHANGE_USER.regex)){
                changeUsername(user,Regex.CHANGE_USER.getGroup(tempInput,"username"));
            }
            //**********************************************change nickname*********************************************
            else if(tempInput.matches(Regex.CHANGE_NICKNAME.regex)){
                changeNickname(user,Regex.CHANGE_NICKNAME.getGroup(tempInput,"nickname"));
            }
            //**********************************************change Email************************************************
            else if(tempInput.matches(Regex.CHANGE_EMAIL.regex)){
                changeEmail(user,Regex.CHANGE_EMAIL.getGroup(tempInput,"Email"));
            }
            //*********************************************change password**********************************************
            else if(tempInput.matches(Regex.CHANGE_PASSWORD.regex)){
                changePassword(user,Regex.CHANGE_PASSWORD.getGroup(tempInput,"oldPassword"),Regex.CHANGE_PASSWORD.getGroup(tempInput,"newPassword"),scanner);
            }
            //more ifs
            else{
                System.out.println("invalid input");
            }
        }
    }
}
