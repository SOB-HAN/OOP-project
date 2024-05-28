import java.util.Scanner;

public class SignUpMenu {
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
                System.out.println("Current Menu:SignUp Menu");
            }
            //****************************************************Create New User***************************************
            else if(tempInput.matches(Regex.CREATE_NEW_USER.regex)){
                boolean problem=false;
                if(UserFunctions.isEmpty(Regex.CREATE_NEW_USER.getGroup(tempInput,"username"))){
                    //replace in phase 2
                    System.out.println("username is empty!");
                    problem=true;
                }
                if(UserFunctions.isEmpty(Regex.CREATE_NEW_USER.getGroup(tempInput,"password"))){
                    //replace in phase 2
                    System.out.println("password is empty!");
                    problem=true;
                }
                if(UserFunctions.isEmpty(Regex.CREATE_NEW_USER.getGroup(tempInput,"passwordConfirmation"))){
                    //replace in phase 2
                    System.out.println("passwordConfirmation is empty!");
                    problem=true;
                }
                if(UserFunctions.isEmpty(Regex.CREATE_NEW_USER.getGroup(tempInput,"Email"))){
                    //replace in phase 2
                    System.out.println("Email is empty!");
                    problem=true;
                }
                if(UserFunctions.isEmpty(Regex.CREATE_NEW_USER.getGroup(tempInput,"nickname"))){
                    //replace in phase 2
                    System.out.println("nickname is empty!");
                    problem=true;
                }
                if(!problem){
                    //checking validity of the username
                    if(!UserFunctions.isValidUsername(Regex.CREATE_NEW_USER.getGroup(tempInput,"username"))){
                        //replace in phase 2
                        System.out.println("invalid username : username must only contain letters,digits and underscore!");
                    }
                    //checking availability of the username
                    else if(Database.getUserByUsername(Regex.CREATE_NEW_USER.getGroup(tempInput,"username"))!=null){
                        //replace in phase 2
                        System.out.println("username already taken!");
                    }
                    //checking if the password should be random
                    else if (Regex.CREATE_NEW_USER.getGroup(tempInput,"password").equalsIgnoreCase("random")){
                        //replace in phase 2
                        //create random password and ....
                    }
                    //checking if the password is weak ....
                    else if(UserFunctions.isWeakPassword(Regex.CREATE_NEW_USER.getGroup(tempInput,"password"))==1){
                        //replace in phase 2
                        System.out.println("Password too short! (must contain at least 8 characters)");
                    }
                    else if(UserFunctions.isWeakPassword(Regex.CREATE_NEW_USER.getGroup(tempInput,"password"))==2){
                        //replace in phase 2
                        System.out.println("Password must contain at least 1 CAPITAL letter,1 small letter and 1 special character!");
                    }
                    //checking password confirmation matches password
                    else if(!Regex.CREATE_NEW_USER.getGroup(tempInput,"password").equals(Regex.CREATE_NEW_USER.getGroup(tempInput,"passwordConfirmation"))){
                        //replace in phase 2
                        System.out.println("password confirmation doesn't match entered password!");
                    }
                    else if(UserFunctions.isValidEmail(Regex.CREATE_NEW_USER.getGroup(tempInput,"Email"))==1){
                        //replace in phase 2
                        System.out.println("invalid Email! (email slot is empty)");
                    }
                    else if(UserFunctions.isValidEmail(Regex.CREATE_NEW_USER.getGroup(tempInput,"Email"))==2){
                        //replace in phase 2
                        System.out.println("invalid Email! (domain slot is empty)");
                    }
                    else if((Database.getUserByUsername(Regex.CREATE_NEW_USER.getGroup(tempInput,"username"))==null)&&(UserFunctions.isWeakPassword(Regex.CREATE_NEW_USER.getGroup(tempInput,"password"))==0)&&(UserFunctions.isValidEmail(Regex.CREATE_NEW_USER.getGroup(tempInput,"Email"))==0)){
                        boolean finished=false;
                        String tempUsername=Regex.CREATE_NEW_USER.getGroup(tempInput,"username");
                        String tempPassword=Regex.CREATE_NEW_USER.getGroup(tempInput,"password");
                        String tempEmail=Regex.CREATE_NEW_USER.getGroup(tempInput,"Email");
                        String tempNickname=Regex.CREATE_NEW_USER.getGroup(tempInput,"nickname");
                        System.out.println("User created successfully. Please choose a security question :");
                        while(!finished){
                            System.out.println("\t1-What is your father's name ?");
                            System.out.println("\t2-What is your favourite color ?");
                            System.out.println("\t3-What was the name of your first pet?");
                            tempInput=scanner.nextLine();
                            if(tempInput.matches(Regex.PICK_QUESTION.regex)){
                                if(Integer.valueOf(Regex.PICK_QUESTION.getGroup(tempInput,"questionNumber"))>3||Integer.valueOf(Regex.PICK_QUESTION.getGroup(tempInput,"questionNumber"))<1){
                                    //replace in phase2
                                    System.out.println("invalid question number");
                                }
                                else if(!Regex.PICK_QUESTION.getGroup(tempInput,"answer").equals(Regex.PICK_QUESTION.getGroup(tempInput,"answerConfirm"))){
                                    //replace in phase2
                                    System.out.println("answer confirmation is does not match the answer!");
                                }
                                else{
                                    //captcha here later
                                    finished=true;
                                }
                            }
                            else{
                                System.out.println("invalid input!");
                            }
                        }
                        String tempQuestion;
                        switch (Integer.valueOf(Regex.PICK_QUESTION.getGroup(tempInput,"questionNumber"))){
                            case 1:
                                tempQuestion="What is your father's name ?";
                                break;
                            case 2:
                                tempQuestion="What is your favourite color ?";
                                break;
                            case 3:
                                tempQuestion="What was the name of your first pet?";
                                break;
                            default:
                                tempQuestion=null;
                                break;
                        }
                        String tempAnswer=Regex.PICK_QUESTION.getGroup(tempInput,"answer");
                        //create new user might need more work later ......
                        if(tempUsername.equals("admin")){
                            Database.addUser(new User(tempUsername,tempPassword,tempEmail,tempNickname,tempQuestion,tempAnswer,true));
                        }
                        else{
                            Database.addUser(new User(tempUsername,tempPassword,tempEmail,tempNickname,tempQuestion,tempAnswer));
                        }
                        done=true;
                        System.out.println("going back to startmenu");
                    }
                    else{
                        System.out.println("invalid input1");
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
