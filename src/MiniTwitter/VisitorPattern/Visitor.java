package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserGroup;
import MiniTwitter.GUI.ApplicationWindow;

public interface Visitor {


    public int visit(User user);

    public int visit(UserGroup userGroup);

}
