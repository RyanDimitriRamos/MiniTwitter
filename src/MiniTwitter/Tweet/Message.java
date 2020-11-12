package MiniTwitter.Tweet;

public interface Message {

    String getText();

    boolean containsPositiveWords(String[] positiveWords);

}
