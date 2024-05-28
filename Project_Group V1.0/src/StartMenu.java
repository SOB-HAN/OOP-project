import java.util.Scanner;

public class StartMenu {
    public static void run(Scanner scanner){
        String tempInput;
        boolean done=false;
        while(!done){
            tempInput=scanner.nextLine();
            if(tempInput.matches("^\\s*quit\\s*$")){
                done=true;
            }
            else if(tempInput.matches("^\\s*show\\s+current\\s+menu\\s*$")){
                //only in phase 1
                System.out.println("Current Menu:StartMenu");
            }
            else if(tempInput.matches("^\\s*signup\\s+menu\\s*$")){
                //moves into signup menu
                SignUpMenu.run(scanner);
            }
            else if(tempInput.matches("\\s*login\\s+menu\\s*$")){
                //moves into login menu
                LoginMenu.run(scanner);
            }
            else{
                System.out.println("invalid input");
            }
        }
        System.out.println("Adios Amigos....");
    }
}
