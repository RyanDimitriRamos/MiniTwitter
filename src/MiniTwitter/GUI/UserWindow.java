package MiniTwitter.GUI;

import MiniTwitter.CompositeUsers.User;
import MiniTwitter.Tweet.Tweet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        newsLabel = new JLabel();
        refreshFeedButton = new JButton();
        followingLabel = new JLabel();
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

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(newsLabel)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addComponent(followingLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(refreshFeedButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addComponent(userName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(168, 168, 168))
                                                        .addComponent(jScrollPane2)
                                                        .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                                                .addComponent(postTweetTextField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(postTweetButton, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addComponent(userIdTextField)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(followUserButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(27, 27, 27))))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(userName, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(followUserButton, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                        .addComponent(userIdTextField))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newsLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(postTweetTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(postTweetButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(followingLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(refreshFeedButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
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

    }// </editor-fold>

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
            postTweetTextField.setText("");
        }else{
            System.out.println("Cannot post empty tweet.");
        }
    }

    private void refreshFeedButtonActionPerformed(ActionEvent evt) {
        feedListPanel.refreshFeed();
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
    private JPanel mainPanel;
    private JLabel newsLabel;
    private JButton refreshFeedButton;
    private JTextField userIdTextField;
    private JLabel userName;
    // End of variables declaration
}
