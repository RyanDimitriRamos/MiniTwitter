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
    @Override
    public int visit(User user) {
        int countOfPositive = 0;
        for (Tweet tweet : user.getTweets()) {
            if (tweet.containsPositiveWords(positiveWords)) {
                countOfPositive++;

            }
        }
        return countOfPositive;
    }

    @Override
    public int visit(UserGroup userGroup) {
        return 0;
    }
}
