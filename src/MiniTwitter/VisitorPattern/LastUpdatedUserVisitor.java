package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserGroup;

public class LastUpdatedUserVisitor implements Visitor {

    private int count = 0;
    private User lastUpdatedUser = null;
    public void visit(User user) {
        if (lastUpdatedUser == null) {
            lastUpdatedUser = user;
        }
        else {
            if (user.getLastUpdateTime() > lastUpdatedUser.getLastUpdateTime()) {
                lastUpdatedUser = user;
            }
        }
    }

    public void visit(UserGroup userGroup) {
        count++;
    }

    public int getCount() {
        return count;
    }

    public User getUser(){
        return lastUpdatedUser;
    }
}
