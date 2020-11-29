package MiniTwitter.GUI;
import MiniTwitter.CompositeUsers.User;
import MiniTwitter.CompositeUsers.UserComponent;
import MiniTwitter.CompositeUsers.UserGroup;
import MiniTwitter.VisitorPattern.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.InputMismatchException;

public class AdminControlPanel extends JPanel {
    //Singleton instance of the adminControlPanel
    private static AdminControlPanel adminControlPanel = null;
    private ApplicationWindow currentFrame = ApplicationWindow.getInstance();
    public AdminControlPanel() {
        super();
        initComponents();
    }
    public static AdminControlPanel getInstance(){
        /* Here we create an instance of the admin control panel using
         * double locked checking to make sure that there is only ever
         * one instance of the admin control panel created.
         */
        if(adminControlPanel == null){
            synchronized (AdminControlPanel.class){
                if(adminControlPanel == null){
                    adminControlPanel = new AdminControlPanel();
                }
            }
        }
        return adminControlPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * This is all of the GUI code. It initializes buttons and views and such
     */
    private void initComponents() {

        addUserButton = new JButton();
        addGroupButton = new JButton();
        openUserViewButton = new JButton();
        scrollPane = new JScrollPane();
        userTree = new TreeView();
        showUserTotalButton = new JButton();
        showGroupTotalButton = new JButton();
        showMessageTotalsButton = new JButton();
        showPositiveVibesTotal = new JButton();
        userTextField = new JTextField();
        groupTextField = new JTextField();
        findLastUpdatedUserButton = new JButton();
        verifyIDsButton = new JButton();

        setBorder(BorderFactory.createTitledBorder("Admin Control Panel"));

        addUserButton.setText("Add User");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        addGroupButton.setText("Add Group");
        addGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupButtonActionPerformed(evt);
            }
        });

        openUserViewButton.setText("Open User View");
        openUserViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openUserViewButtonActionPerformed(evt);
            }
        });

        scrollPane.setViewportView(userTree);

        showUserTotalButton.setText("Show User Total");
        showUserTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUserTotalButtonActionPerformed(evt);
            }
        });

        showGroupTotalButton.setText("Show Group Total");
        showGroupTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGroupTotalButtonActionPerformed(evt);
            }
        });

        showMessageTotalsButton.setText("Show Message Total");
        showMessageTotalsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMessageTotalsButtonActionPerformed(evt);
            }
        });

        showPositiveVibesTotal.setText("Show Positive Total");

        findLastUpdatedUserButton.setText("Last Updated User");
        findLastUpdatedUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findLastUpdatedUserButtonActionPerformed(evt);
            }
        });

        verifyIDsButton.setText("Verify IDs");
        verifyIDsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyIDsButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(groupTextField, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                                        .addComponent(userTextField))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(addGroupButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(addUserButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(openUserViewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(findLastUpdatedUserButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(showMessageTotalsButton, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                                        .addComponent(showUserTotalButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(showGroupTotalButton, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                                        .addComponent(showPositiveVibesTotal, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(verifyIDsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(userTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addUserButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(groupTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addGroupButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(openUserViewButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(findLastUpdatedUserButton)
                                        .addComponent(verifyIDsButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(showUserTotalButton)
                                        .addComponent(showGroupTotalButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(showMessageTotalsButton)
                                        .addComponent(showPositiveVibesTotal))
                                .addGap(11, 11, 11))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    private void addGroupButtonActionPerformed(ActionEvent evt) {
        String newUserID = groupTextField.getText();
        if(!newUserID.equals("")){
            UserComponent user = new UserGroup(newUserID);
            userTree.addUserComponent(user);
            groupTextField.setText("");
        }else{
            System.out.println("Cannot add empty group");
        }
    }

    private void showUserTotalButtonActionPerformed(ActionEvent evt) {
        UserComponent currentlySelected = userTree.getCurrentlySelected();
        Visitor userTotal = new UserTotalVisitor();
        int count;
        UserGroup selectedUserGroup;
        if(currentlySelected instanceof User){
            User selectedUser = (User)currentlySelected;
            selectedUserGroup = selectedUser.getParent();
        }else{
           selectedUserGroup = (UserGroup)currentlySelected;
        }
        selectedUserGroup.accept(userTotal);
        count = userTotal.getCount();
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of users in the directory " + selectedUserGroup + " is: " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void showGroupTotalButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UserComponent currentlySelected = userTree.getCurrentlySelected();
        Visitor groupTotal = new GroupTotalVisitor();
        int count;
        UserGroup selectedUserGroup;
        if(currentlySelected instanceof User){
            User selectedUser = (User)currentlySelected;
            selectedUserGroup = selectedUser.getParent();
        }else{
            selectedUserGroup = (UserGroup)currentlySelected;
        }
        selectedUserGroup.accept(groupTotal);
        count = groupTotal.getCount();
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of groups in the directory " + selectedUserGroup + " is: " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void showMessageTotalsButtonActionPerformed(ActionEvent evt) {
        UserComponent currentlySelected = userTree.getCurrentlySelected();
        Visitor messageTotal = new MessageTotalVisitor();
        int count;
        UserGroup selectedUserGroup;
        if(currentlySelected instanceof User){
            User selectedUser = (User)currentlySelected;
            selectedUserGroup = selectedUser.getParent();
        }else{
            selectedUserGroup = (UserGroup)currentlySelected;
        }
        selectedUserGroup.accept(messageTotal);
        count = messageTotal.getCount();
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of messages in the directory " + selectedUserGroup + " is: " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }
    private void showPositiveVibesTotalButtonActionPerformed(ActionEvent evt) {
        UserComponent currentlySelected = userTree.getCurrentlySelected();
        Visitor messageTotal = new MessageTotalVisitor();
        Visitor positiveMessageTotal = new PositivePercentageVisitor();
        int totalMessageCount;
        int positiveMessageCount;
        double percentage;
        UserGroup selectedUserGroup;
        if(currentlySelected instanceof User){
            User selectedUser = (User)currentlySelected;
            selectedUserGroup = selectedUser.getParent();
        }else{
            selectedUserGroup = (UserGroup)currentlySelected;
        }
        selectedUserGroup.accept(messageTotal);
        totalMessageCount = messageTotal.getCount();
        selectedUserGroup.accept(positiveMessageTotal);
        positiveMessageCount = positiveMessageTotal.getCount();
        percentage = Double.valueOf(positiveMessageCount) / Double.valueOf(totalMessageCount);
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setMinimumFractionDigits(1);
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of messages by users in the selected directory is " + defaultFormat.format(percentage),
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void addUserButtonActionPerformed(ActionEvent evt) {
        String newUserID = userTextField.getText();
        if(!newUserID.equals("")){
            UserComponent user = new User(newUserID);
            userTree.addUserComponent(user);
            userTextField.setText("");
        }else{
            System.out.println("Cannot add empty user");
        }
    }
    /**
     * Sometimes a null user can be returned if the
     */
    private void openUserViewButtonActionPerformed(ActionEvent evt) {
        UserComponent currentlySelected = userTree.getCurrentlySelected();
        try{
            if(currentlySelected instanceof User) {
                UserWindow userWindow = new UserWindow("User Window", (User)currentlySelected);
                userWindow.pack();
                userWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userWindow.setVisible(true);
            }
            else{
                throw new InputMismatchException();
            }
        }
        catch (Exception e){
            System.out.println("No user object selected");
        }

    }

    private void findLastUpdatedUserButtonActionPerformed(ActionEvent evt) {
        UserComponent currentlySelected = userTree.getCurrentlySelected();
        Visitor visitor = new LastUpdatedUserVisitor();
        User user;
        UserGroup selectedUserGroup;
        if(currentlySelected instanceof User){
            User selectedUser = (User)currentlySelected;
            selectedUserGroup = selectedUser.getParent();
        }else{
            selectedUserGroup = (UserGroup)currentlySelected;
        }
        selectedUserGroup.accept(visitor);
        user = visitor.getUser();
        JOptionPane.showMessageDialog(currentFrame,
                "The current most currently updated user in " + selectedUserGroup + " is: " + user,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void verifyIDsButtonActionPerformed(ActionEvent evt) {
        UserComponent currentlySelected = userTree.getCurrentlySelected();
        Visitor verifiedIdsTotal = new CheckValidIDVisitor();
        int count;
        UserGroup selectedUserGroup;
        if(currentlySelected instanceof User){
            User selectedUser = (User)currentlySelected;
            selectedUserGroup = selectedUser.getParent();
        }else{
            selectedUserGroup = (UserGroup)currentlySelected;
        }
        selectedUserGroup.accept(verifiedIdsTotal);
        count = verifiedIdsTotal.getCount();
        JOptionPane.showMessageDialog(currentFrame,
                "The current number of invalid IDs in the directory " + selectedUserGroup + " is: " + count,
                "Metrics",
                JOptionPane.PLAIN_MESSAGE);
    }


    // GUI Variables declaration
    private JButton addGroupButton;
    private JButton addUserButton;
    private JTextField groupTextField;
    private JButton findLastUpdatedUserButton;
    private JButton openUserViewButton;
    private JScrollPane scrollPane;
    private JButton showGroupTotalButton;
    private JButton showMessageTotalsButton;
    private JButton showPositiveVibesTotal;
    private JButton showUserTotalButton;
    private JTextField userTextField;
    private TreeView userTree;
    private JButton verifyIDsButton;
}