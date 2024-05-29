import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regex {
    //****************************************************SignUp Menu Regexes*******************************************
    CREATE_NEW_USER("^\\s*user\\s+create\\s+-u\\s+(?<username>.+)\\s+-p\\s+(?<password>.+)\\s+(?<passwordConfirmation>.+)\\s+-email\\s+(?<Email>.+)\\s+-n\\s+(?<nickname>.+)\\s*$"),
    PICK_QUESTION("^\\s*question\\s+pick\\s+-q\\s+(?<questionNumber>\\d+)\\s+-a\\s+(?<answer>\\S+)\\s+-c\\s+(?<answerConfirm>\\S+)\\s*$"),
    //****************************************************SignUp Menu Regexes*******************************************
    //****************************************************Login Menu Regexes********************************************
    ADMIN_LOGIN("^\\s*login\\s+admin\\s+(?<password>\\S+)\\s*$"),
    USER_LOGIN("^\\s*user\\s+login\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s*$"),
    Forgot_Password("^\\s*Forgot\\s+my\\s+password\\s+-u\\s+(?<username>\\S+)\\s*$"),

    //****************************************************Login Menu Regexes********************************************
    //****************************************************Profile Menu Regexes******************************************
    CHANGE_USER("^\\s*Profile\\s+change\\s+-u\\s+(?<username>\\S+)\\s*$"),
    CHANGE_NICKNAME("^\\s*Profile\\s+change\\s+-n\\s+(?<nickname>\\S+)\\s*$"),
    CHANGE_EMAIL("^\\s*Profile\\s+change\\s+-e\\s+(?<Email>\\S+)\\s*$"),
    CHANGE_PASSWORD("^\\s*profile\\s+change\\s+password\\s+-o\\s+(?<oldPassword>\\S+)\\s+-n\\s+(?<newPassword>\\S+)\\s*$"),

    //****************************************************Profile Menu Regexes******************************************
    //****************************************************Shop Menu Regexes*********************************************


    //****************************************************Shop Menu Regexes*********************************************
    ;
    final String regex;
    Regex(String regex) {
        this.regex = regex;
    }
    private Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher  = pattern.matcher(input);
        matcher.matches();
        return matcher;
    }
    public boolean matches(String input) {
        return getMatcher(input).matches();
    }
    public String getGroup(String input, String group) {
        return getMatcher(input).group(group);
    }
}
