package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserGroup;

public class UserTotalVisitor implements Visitor {
    @Override
    public int visit(User user) {
        return 1;
    }

    @Override
    public int visit(UserGroup userGroup) {
        return 0;
    }
}
