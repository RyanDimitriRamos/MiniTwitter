package MiniTwitter.VisitorPattern;

import MiniTwitter.CompositeUsers.*;

import javax.swing.*;
import java.util.Stack;

public class MessageTotalVisitor implements Visitor{
    private int count = 0;
    public void visit(User user) {
        count+= user.getTweets().size();
    }

    public void visit(UserGroup userGroup) {
    }

    public int getCount() {
        return count;
    }

    public User getUser(){return null;}
}
