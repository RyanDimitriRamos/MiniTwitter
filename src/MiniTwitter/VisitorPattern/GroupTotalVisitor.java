package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserComponent;
import MiniTwitter.CompositeUsers.UserGroup;


public class GroupTotalVisitor implements Visitor{
    private int count = 0;

    public void visit(User user) {
    }

    public void visit(UserGroup userGroup) {
        count++;
    }

    public int getCount() {
        return count;
    }

    public User getUser(){return null;}
}
