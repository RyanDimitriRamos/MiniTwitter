package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserComponent;
import MiniTwitter.CompositeUsers.UserGroup;
import MiniTwitter.Tweet.Tweet;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Stack;

public class PositivePercentageVisitor implements Visitor {
    private String[] positiveWords = {"Fight", "Milk", "Day", "Night", "Man"};
    public void visit(User user) {
        double totalWordCount = 0.0;
        double countOfPositive = 0.0;
        UserGroup userGroup = user.getParent(); // this is to have access to the outer folder
        Stack<UserGroup> userGroupsToCheck = new Stack<>();
        userGroupsToCheck.push(userGroup);
        while(!userGroupsToCheck.isEmpty()) {
            UserGroup currentUserGroup = userGroupsToCheck.pop();
            for (UserComponent userComponent : currentUserGroup.getUsers()) {
                if (userComponent instanceof UserGroup) {
                    userGroupsToCheck.push((UserGroup) userComponent);
                } else {
                    User currentUser = ((User) userComponent);
                    totalWordCount += currentUser.getTweets().size();
                    for(Tweet tweet : currentUser.getTweets()){
                        if(tweet.containsPositiveWords(positiveWords)){
                            countOfPositive++;

                        }
                    }
                }
            }
        }
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setMinimumFractionDigits(1);
        double percentage = countOfPositive / totalWordCount;
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of messages by users in the selected directory is " + defaultFormat.format(percentage),
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }


    @Override
    public void visit(UserGroup userGroup) {
        double totalWordCount = 0.0;
        double countOfPositive = 0.0;
        Stack<UserGroup> userGroupsToCheck = new Stack<>();
        userGroupsToCheck.push(userGroup);
        while(!userGroupsToCheck.isEmpty()) {
            UserGroup currentUserGroup = userGroupsToCheck.pop();
            for (UserComponent user : currentUserGroup.getUsers()) {
                if (user instanceof UserGroup) {
                    userGroupsToCheck.push((UserGroup) user);
                } else {
                    User currentUser = ((User) user);
                    totalWordCount += currentUser.getTweets().size();
                    for (Tweet tweet : currentUser.getTweets()) {
                        if (tweet.containsPositiveWords(positiveWords)) {
                            countOfPositive++;
                        }
                    }
                }
            }
        }
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setMinimumFractionDigits(1);
        double percentage = countOfPositive / totalWordCount;
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of messages by users in the selected directory is " + defaultFormat.format(percentage),
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }
}
