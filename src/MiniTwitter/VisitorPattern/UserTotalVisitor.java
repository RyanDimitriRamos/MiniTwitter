package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserComponent;
import MiniTwitter.CompositeUsers.UserGroup;

import javax.swing.*;
import java.util.Stack;

public class UserTotalVisitor implements Visitor {

    public void visit(User user) {
        int count = 0; //set to one to count the root group
        UserGroup userGroup = user.getParent();
        Stack<UserGroup> userGroupsToCheck = new Stack<>();
        userGroupsToCheck.push(userGroup);
        while(!userGroupsToCheck.isEmpty()){
            UserGroup currentUserGroup = userGroupsToCheck.pop();
            for(UserComponent userComponent : currentUserGroup.getUsers()){
                if(userComponent instanceof UserGroup){
                    userGroupsToCheck.push((UserGroup) userComponent);

                }else {
                    count++;
                }
            }
        }
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of users in the selected subgroup is " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }


    public void visit(UserGroup userGroup) {
        int count = 0; //set to one to count the root group
        Stack<UserGroup> userGroupsToCheck = new Stack<>();
        userGroupsToCheck.push(userGroup);
        while(!userGroupsToCheck.isEmpty()){
            UserGroup currentUserGroup = userGroupsToCheck.pop();
            for(UserComponent user : currentUserGroup.getUsers()){
                if(user instanceof UserGroup){
                    userGroupsToCheck.push((UserGroup) user);

                }else {
                    count++;
                }
            }
        }
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of users in the selected subgroup is " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);

    }
}
