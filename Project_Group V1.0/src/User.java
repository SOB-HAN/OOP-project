import java.util.ArrayList;

public class User {
    //******************************************************attributes**************************************************
    private String username=null;
    private String password=null;
    private String nickname=null;
    private String Email=null;
    private String passwordRecoveryQuestion=null;
    private String passwordRecoveryAnswer=null;
    private  int level;
    private int gold;
    private int XP;
    private boolean isAdmin=false;
    private boolean isLoggedIn=false;

    ArrayList <Card> ownedCards=new ArrayList<>();
    ArrayList <Card> selectedCards=new ArrayList<>();
    //******************************************************constructors************************************************
    public User(String username,String password,String email,String nickname,String passwordRecoveryQuestion,String passwordRecoveryAnswer){
        this.username=username;
        this.password=password;
        this.Email=email;
        this.nickname=nickname;
        this.passwordRecoveryQuestion=passwordRecoveryQuestion;
        this.passwordRecoveryAnswer=passwordRecoveryAnswer;
        this.level=1;
        this.gold=0;
        this.XP=0;
    }
    public User(String username,String password,String email,String nickname,String passwordRecoveryQuestion,String passwordRecoveryAnswer,boolean isAdmin){
        this.username=username;
        this.password=password;
        this.Email=email;
        this.nickname=nickname;
        this.passwordRecoveryQuestion=passwordRecoveryQuestion;
        this.passwordRecoveryAnswer=passwordRecoveryAnswer;
        this.level=1;
        this.gold=0;
        this.XP=0;
    }
    //******************************************************methods*****************************************************
    public void logHimIn(){
        this.isLoggedIn=true;
    }
    public void logHimOut(){
        this.isLoggedIn=false;
    }
    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }
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
    public String getPassword() {
        return this.password;
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

    public String getPasswordRecoveryAnswer() {
        return this.passwordRecoveryAnswer;
    }
    public void setPasswordRecoveryAnswer(String passwordRecoveryAnswer) {
        this.passwordRecoveryAnswer = passwordRecoveryAnswer;
    }
    public String getPasswordRecoveryQuestion() {
        return this.passwordRecoveryQuestion;
    }

    public void setPasswordRecoveryQuestion(String passwordRecoveryQuestion) {
        this.passwordRecoveryQuestion = passwordRecoveryQuestion;
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

}
