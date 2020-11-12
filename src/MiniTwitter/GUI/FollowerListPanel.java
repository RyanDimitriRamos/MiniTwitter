package MiniTwitter.GUI;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserComponent;
import MiniTwitter.ObserverPattern.Observer;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FollowerListPanel {
    private JList followerList;
    private DefaultListModel displayData;
    private User user;

    public FollowerListPanel(User user){
        this.user = user;
        initListView();
    }
    private void initListView(){
        displayData = new DefaultListModel();
        List<Observer> followingList = user.getFollowing();
        followerList = new JList(displayData);
        for(Observer user : followingList) {
            displayData.addElement(user);
        }
    }
    public void addFollower(User newFollower){
        if(user.addUser(newFollower)){
            displayData.addElement(newFollower);
        }
    }

    public JList getJList(){
        return followerList;
    }


}
