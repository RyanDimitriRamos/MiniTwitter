package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserComponent;
import MiniTwitter.CompositeUsers.UserGroup;

import javax.swing.*;
import java.util.List;
import java.util.Stack;

public class GroupTotalVisitor implements Visitor {

    @Override
    public void visit(User user) {
        int count = 1; //set to one to count the root group
        UserGroup userGroup = user.getParent();
        Stack<UserGroup> userGroupsToCheck = new Stack<>();
        userGroupsToCheck.push(userGroup);
        while(!userGroupsToCheck.isEmpty()){
            UserGroup currentUserGroup = userGroupsToCheck.pop();
            for(UserComponent userComponent : currentUserGroup.getUsers()){
                if(userComponent instanceof UserGroup){
                    userGroupsToCheck.push((UserGroup) userComponent);
                    count++;
                }
            }
        }
        JOptionPane.showMessageDialog(currentFrame,
                "The current number groups in the selected directory is " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);

    }

    @Override
    public void visit(UserGroup userGroup) {
        int count = 1; //set to one to count the root group
        Stack<UserGroup> userGroupsToCheck = new Stack<>();
        userGroupsToCheck.push(userGroup);
        while(!userGroupsToCheck.isEmpty()){
            UserGroup currentUserGroup = userGroupsToCheck.pop();
            for(UserComponent user : currentUserGroup.getUsers()){
                if(user instanceof UserGroup){
                    userGroupsToCheck.push((UserGroup) user);
                    count++;
                }
            }
        }
        JOptionPane.showMessageDialog(currentFrame,
                "The current number groups in the selected directory is " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }
}
