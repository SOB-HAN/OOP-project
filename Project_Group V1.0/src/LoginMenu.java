import java.util.Scanner;

public class LoginMenu {
    public static void  run(Scanner scanner){
        String tempInput=null;
        boolean done=false;
        while(!done){
            tempInput=scanner.nextLine();
            if(tempInput.matches("^\\s*back\\s*$")){
                done=true;
            }
            else if(tempInput.matches("^\\s*show\\s+current\\s+menu\\s*$")){
                //only in phase 1
                System.out.println("Current Menu:Login Menu");
            }
            //*******************************************************admin login****************************************
            else if(tempInput.matches(Regex.ADMIN_LOGIN.regex)){
                //login admin
            }
            //*******************************************************user login*****************************************
            else if(tempInput.matches(Regex.USER_LOGIN.regex)){
                //login user
                int failureCount=0;
                if(Database.getUserByUsername(Regex.USER_LOGIN.getGroup(tempInput,"username"))==null){
                    //replace in phase 2
                    System.out.println("Username doesn't exist!");
                }
                else if(!Database.getUserByUsername(Regex.USER_LOGIN.getGroup(tempInput,"username")).isCorrectPassword(Regex.USER_LOGIN.getGroup(tempInput,"password"))){
                    System.out.println("Password and Username don't match!");
                    //replace in phase 2
                    //add penalty time
                }
                else{
                    Database.getUserByUsername(Regex.USER_LOGIN.getGroup(tempInput,"username")).logHimIn();
                    done=true;
                    MainMenu.run(scanner);
                }
            }
            //**************************************************Forgot password*****************************************
            else if(tempInput.matches(Regex.Forgot_Password.regex)){
                if(Database.getUserByUsername(Regex.Forgot_Password.getGroup(tempInput,"username"))==null){
                    //replace in phase 2
                    System.out.println("Username doesn't exist!");
                }
                else{
                    String tempQuestion=Database.getUserByUsername(Regex.Forgot_Password.getGroup(tempInput,"username")).getPasswordRecoveryQuestion();
                    String tempAnswer=Database.getUserByUsername(Regex.Forgot_Password.getGroup(tempInput,"username")).getPasswordRecoveryAnswer();
                    System.out.println(tempQuestion);
                    tempInput=scanner.nextLine();
                    if(tempInput.equals(tempAnswer)){
                        //user should be able to change password here
                    }
                    else{
                        System.out.println("wrong answer!");
                    }
                }
            }
            //more ifs here
            else{
                System.out.println("invalid input");
            }
        }
    }
}
