package MiniTwitter.GUI;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.Tweet.Tweet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dimitri
 */
public class UserWindow extends JFrame {
    private User user;

    public UserWindow(String title, User user) {
        super(title);
        this.user = user;
        initComponents();
    }
    // format the date before printing it.
    public String formatDate(long time){
        String pattern = "yyyy-MM-dd hh:mm:ss aa";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        mainPanel = new JPanel();
        followUserButton = new JButton();
        jScrollPane1 = new JScrollPane();
        followerListPanel = new FollowerListPanel(user);
        followersListView = followerListPanel.getJList();
        postTweetButton = new JButton();
        userIdTextField = new JTextField();
        postTweetTextField = new JTextField();
        jScrollPane2 = new JScrollPane();
        feedListPanel = new FeedListPanel(user);
        feedListView = feedListPanel.getJList();
        lastUpdatedTime = new JLabel();
        newsLabel = new JLabel();
        refreshFeedButton = new JButton();
        followingLabel = new JLabel();
        userCreationTime = new JLabel();
        userName = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBorder(BorderFactory.createTitledBorder("User View"));

        followUserButton.setText("Follow User");
        followUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                followUserButtonActionPerformed(evt);
            }
        });

        followersListView.setModel(followersListView.getModel()
        );
        jScrollPane1.setViewportView(followersListView);

        refreshFeedButton.setText("Refresh Feed");
        refreshFeedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                refreshFeedButtonActionPerformed(evt);
            }
        });

        postTweetButton.setText("Post Tweet");
        postTweetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                postTweetButtonActionPerformed(evt);
            }
        });

        feedListView.setModel(feedListView.getModel());
        jScrollPane2.setViewportView(feedListView);

        newsLabel.setText("Current Following");

        followingLabel.setText("News Feed");

        userName.setText("User ID: " + user);

        userCreationTime.setText("Created: " + formatDate(user.getCreationTime()));

        lastUpdatedTime.setText("Last Updated: " + formatDate(user.getLastUpdateTime()));

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(userIdTextField, GroupLayout.Alignment.LEADING)
                                                        .addComponent(userName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(followUserButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25))
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addComponent(newsLabel)
                                                                .addGap(87, 87, 87)
                                                                .addComponent(userCreationTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(followingLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(postTweetTextField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(postTweetButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(refreshFeedButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(lastUpdatedTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(27, 27, 27))))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(userName, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                                .addGap(28, 28, 28))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(followUserButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(userIdTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(newsLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userCreationTime))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(postTweetButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(postTweetTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(refreshFeedButton)
                                .addGap(9, 9, 9)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastUpdatedTime)
                                        .addComponent(followingLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }//

    private void followUserButtonActionPerformed(ActionEvent evt) {
        String newUserID = userIdTextField.getText();
        if(!newUserID.equals("")){
            User user = new User(newUserID);
            followerListPanel.addFollower(user);
            userIdTextField.setText("");
        }else{
            System.out.println("Cannot follow empty user.");
        }

    }

    private void postTweetButtonActionPerformed(ActionEvent evt) {
        String tweetText = postTweetTextField.getText();
        if(!tweetText.equals("")){
            Tweet tweet = new Tweet(tweetText, user);
            feedListPanel.sendTweet(tweet);
            lastUpdatedTime.setText("Last Updated: " + formatDate(user.getLastUpdateTime()));
            postTweetTextField.setText("");
        }else{
            System.out.println("Cannot post empty tweet.");
        }

    }
    // added refresh to the most recent update
    private void refreshFeedButtonActionPerformed(ActionEvent evt) {
        feedListPanel.refreshFeed();
        lastUpdatedTime.setText("Last Updated: " + formatDate(user.getLastUpdateTime()));
    }


    // Variables declaration
    private FeedListPanel feedListPanel;
    private JList<String> feedListView;
    private FollowerListPanel followerListPanel;
    private JButton followUserButton;
    private JList<String> followersListView;
    private JLabel followingLabel;
    private JButton postTweetButton;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField postTweetTextField;
    private JLabel lastUpdatedTime;
    private JPanel mainPanel;
    private JLabel newsLabel;
    private JButton refreshFeedButton;
    private JTextField userIdTextField;
    private JLabel userCreationTime;
    private JLabel userName;
    // End of variables declaration
}
