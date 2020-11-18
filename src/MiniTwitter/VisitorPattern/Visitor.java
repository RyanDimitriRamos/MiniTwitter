package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserGroup;
import MiniTwitter.GUI.ApplicationWindow;

public interface Visitor {


    public void visit(User user);

    public void visit(UserGroup userGroup);

    public int getCount();

}
