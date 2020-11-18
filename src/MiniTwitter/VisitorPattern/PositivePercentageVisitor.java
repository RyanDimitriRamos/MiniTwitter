package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserComponent;
import MiniTwitter.CompositeUsers.UserGroup;
import MiniTwitter.Tweet.Tweet;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.Stack;

public class PositivePercentageVisitor implements Visitor {
    private String[] positiveWords = {"Milk", "Day", "Night", "Man"}; // Stuff from its always sunny in philidelphia

    private int count = 0;

    public void visit(User user) {
        for (Tweet tweet : user.getTweets()) {
            if (tweet.containsPositiveWords(positiveWords)) {
                count++;

            }
        }
    }

    public void visit(UserGroup userGroup) {
    }
    public int getCount() {
        return count;
    }
}
