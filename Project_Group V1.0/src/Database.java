import java.util.ArrayList;

public class Database {
    //******************************************************attributes**************************************************
    private static ArrayList<User> users=new ArrayList<>();
    private static ArrayList<Card> allCards=new ArrayList<>();
    //******************************************************attributes**************************************************
    //******************************************************methods*****************************************************
    public static void addUser(User user){
        users.add(user);
    }
    public static User getUserByUsername(String Username){
        if(users.isEmpty()){
            return null;
        }
        for(User i:users){
            if(i.getUserName().equals(Username)){
                return i;
            }
        }
        return null;
    }
    public static User getUserByNickname(String Nickname){
        if(users.isEmpty()){
            return null;
        }
        for(User i:users){
            if(i.getNickname().equals(Nickname)){
                return i;
            }
        }
        return null;
    }
    public static User getUserByEmail(String Email){
        if(users.isEmpty()){
            return null;
        }
        for(User i:users){
            if(i.getEmail().equals(Email)){
                return i;
            }
        }
        return null;
    }
    public static User getAdmin(){
        if(users.isEmpty()){
            return null;
        }
        for(User i:users){
            if(i.isAdmin()){
                return i;
            }
        }
        return null;
    }
    public static User loggedInUser(){
        if(users.isEmpty()){
            return null;
        }
        for(User i:users){
            if(i.isLoggedIn()){
                return i;
            }
        }
        return null;
    }

    //write a method that loads users from
    //******************************************************methods*****************************************************
}
