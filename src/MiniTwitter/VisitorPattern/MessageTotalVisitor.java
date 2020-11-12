package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.*;

import javax.swing.*;
import java.util.Stack;

public class MessageTotalVisitor implements Visitor{

    public void visit(User user) {
        int count = 0;
        UserGroup userGroup = user.getParent();
        Stack<UserGroup> userGroupsToCheck = new Stack<>();
        userGroupsToCheck.push(userGroup);
        while(!userGroupsToCheck.isEmpty()) {
            UserGroup currentUserGroup = userGroupsToCheck.pop();
            for (UserComponent userComponent : currentUserGroup.getUsers()) {
                if (userComponent instanceof UserGroup) {
                    userGroupsToCheck.push((UserGroup) userComponent);
                } else {
                    User currentUser = ((User) userComponent);
                    count += currentUser.getTweets().size();
                }
            }
        }
            JOptionPane.showMessageDialog(currentFrame,
                    "The current number of messages by users in the selected directory is " + count,
                    "Metrics",
                    JOptionPane.PLAIN_MESSAGE);
    }


    @Override
    public void visit(UserGroup userGroup) {
        int count = 0;
        Stack<UserGroup> userGroupsToCheck = new Stack<>();
        userGroupsToCheck.push(userGroup);
        while(!userGroupsToCheck.isEmpty()){
            UserGroup currentUserGroup = userGroupsToCheck.pop();
            for(UserComponent user : currentUserGroup.getUsers()){
                if (user instanceof UserGroup) {
                    userGroupsToCheck.push((UserGroup) user);
                } else {
                    User currentUser = ((User) user);
                    count += currentUser.getTweets().size();
                }
            }
        }
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of messages by users in the selected directory is " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }
}
