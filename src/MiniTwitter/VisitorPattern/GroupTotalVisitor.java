package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserComponent;
import MiniTwitter.CompositeUsers.UserGroup;


public class GroupTotalVisitor implements Visitor{

    @Override
    public int visit(User user) {
        return 0;
    }

    @Override
    public int visit(UserGroup userGroup) {
        return 1;
    }
}
