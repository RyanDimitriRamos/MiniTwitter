package MiniTwitter.GUI;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.Tweet.Tweet;

import javax.swing.*;
import java.util.List;

public class FeedListPanel {

    private JList followerList;
    private DefaultListModel displayData;
    private User user;

    public FeedListPanel(User user){
        this.user = user;
        initListView();
    }
    private void initListView(){
        displayData = new DefaultListModel();
        List<Tweet> newsFeed = user.getNewsFeed();
        followerList = new JList(displayData);
        int i = newsFeed.size() -1;
        // I want to display the users feed list starting at the most recently added value
        // similar to a real feed list.
        while( i >= 0){
            displayData.addElement(newsFeed.get(i));
            i--;
        }
    }
    public void sendTweet(Tweet tweet){
        user.sendTweet(tweet);
        refreshFeed();
    }
    public JList getJList(){
        return followerList;
    }

    public void refreshFeed(){
        List<Tweet> newsFeed = user.getNewsFeed();
        displayData.removeAllElements();
        followerList = new JList(displayData);
        int i = newsFeed.size() -1;
        // I want to display the users feed list starting at the most recently added value
        // similar to a real feed list.
        while( i >= 0){
            displayData.addElement(newsFeed.get(i));
            i--;
        }
    }

}
