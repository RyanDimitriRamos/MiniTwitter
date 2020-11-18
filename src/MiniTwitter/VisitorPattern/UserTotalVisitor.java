package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserGroup;

public class UserTotalVisitor implements Visitor {

    private int count = 0;

    public void visit(User user) { count++; }

    public void visit(UserGroup userGroup) { }

    public int getCount() {
        return count;
    }
}
