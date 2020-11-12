package MiniTwitter.Tweet;

import MiniTwitter.CompositeUsers.User;

public class Tweet implements Message{

    private String text;
    private User user;

    public Tweet(String text, User user){
        this.text = text;
        this.user = user;
    }

    public String getText(){
        return text;
    }

    public boolean containsPositiveWords(String[] positiveWords) {
        String textInLowerCase = text.toLowerCase();
        for(String positiveWord : positiveWords){
            if(textInLowerCase.contains(positiveWord.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return user.toString() + ": " + text;
    }
}
