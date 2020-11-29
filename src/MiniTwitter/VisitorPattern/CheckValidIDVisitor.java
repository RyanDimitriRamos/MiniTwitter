package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserGroup;


/**
 * This visitor will check how many invalid visitors there
 * are. I use a hashset to prevent users from having the same
 * id. So this validID visitor only checks and counts
 * how many invalid user names there are. Invalid user names
 * are defined as names with spaces.
 */
public class CheckValidIDVisitor implements Visitor {

    private int count = 0;

    public void visit(User user) {
        if(user.getUserID().matches(".*\\s.*")){
            count++;
        }
    }

    public void visit(UserGroup userGroup) {
        if(userGroup.getUserID().matches(".*\\s.*")){
            count++;
        }

    }

    @Override
    public int getCount() {
        return count;
    }

    public User getUser(){return null;}

}
