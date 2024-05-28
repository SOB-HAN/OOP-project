import java.util.ArrayList;

public class User {
    //******************************************************attributes**************************************************
    private String username=null;
    private String password=null;
    private String nickname=null;
    private String Email=null;
    private String passwordRecoveryQuestion=null;
    private  int level;
    private int gold;
    private int XP;
    ArrayList <Card> ownedCards=new ArrayList<>();
    ArrayList <Card> selectedCards=new ArrayList<>();
    //******************************************************constructors************************************************

    //******************************************************methods*****************************************************

    public String getUserName() {
        return this.username;
    }
    public void setUserName(String UserName) {
        username = UserName;
    }
    public boolean isCorrectPassword(String Password){
        if(password!=null){
            if(Password.equals(this.password)){
                return true;
            }
        }
        return false;
    }
    public void setPassword(String Password) {
        this.password = Password;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String Nickname) {
        this.nickname = Nickname;
    }
    public String getEmail() {
        return this.Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public String getPasswordRecoveryQuestion() {
        return this.passwordRecoveryQuestion;
    }
    public void setPasswordRecoveryQuestion(String PasswordRecoveryQuestion) {
        this.passwordRecoveryQuestion = PasswordRecoveryQuestion;
    }
    public int getLevel() {
        return this.level;
    }
    public int getGold() {
        return this.gold;
    }
    public int getXP() {
        return this.XP;
    }
    public void setGold(int Gold) {
        this.gold = Gold;
    }
    public void setLevel(int Level) {
        this.level = Level;
    }
    public void setXP(int XP) {
        this.XP = XP;
    }
    public ArrayList<Card> getOwnedCards() {
        return this.ownedCards;
    }
    public ArrayList<Card> getSelectedCards() {
        return this.selectedCards;
    }
    public boolean isValidPassword(String Password){
        return true;
    }
}
