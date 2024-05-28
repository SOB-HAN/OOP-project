import java.util.Scanner;

public class MainMenu {

    public static void  run(Scanner scanner) {
        //give player starterpack if it's his owncards is empty ....
        String tempInput=null;
        boolean done=false;
        while(!done) {
            tempInput = scanner.nextLine();
            if (tempInput.matches("^\\s*logout\\s*$")) {
                System.out.println("User "+Database.loggedInUser().getUserName()+" logged out!");
                Database.loggedInUser().logHimOut();
                done = true;
            }
            else if (tempInput.matches("^\\s*show\\s+current\\s+menu\\s*$")) {
                //only in phase 1
                System.out.println("Current Menu:Main Menu");
            }
            else if(tempInput.matches(("^\\s*show\\s+current\\s+user\\s*$"))){
                System.out.println("Logged in user: "+Database.loggedInUser().getUserName());
            }

            else if(tempInput.matches("^\\s*profile\\s+menu")){
                ProfileMenu.run(scanner,Database.loggedInUser());
            }
            //more ifs
            else {
                System.out.println("invalid input");
            }
        }
    }

}
