package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.*;

import javax.swing.*;
import java.util.Stack;

public class MessageTotalVisitor implements Visitor{
    @Override
    public int visit(User user) {
        return user.getTweets().size();
    }

    @Override
    public int visit(UserGroup userGroup) {

        return 0;
    }
}
