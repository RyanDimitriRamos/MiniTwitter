package MiniTwitter.GUI;
import MiniTwitter.CompositeUsers.*;
import javax.swing.*;;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;


public class TreeView extends JPanel {
    private  JTree tree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode rootNode;
    private DefaultMutableTreeNode selectedUser;
    private DefaultMutableTreeNode selectedUserGroup;
    private UserGroup rootGroup;

    public TreeView() {
        super();
        initTree();
    }

    private void initTree(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /* Creating a root and adding it to the treeview */
        rootGroup = new UserGroup("Root");
        rootNode = new DefaultMutableTreeNode(rootGroup);

        selectedUserGroup = rootNode; //make the default user group point to the root
        tree = new JTree(rootNode);
        //tree.setCellRenderer(new MyRenderer());
        treeModel = (DefaultTreeModel) tree.getModel();

        tree.setShowsRootHandles(true);

        // Creating test users to have default in the tree
        addUserComponent((new User("John")));
        addUserComponent((new User("Bob")));
        addUserComponent((new User("Steve")));
        UserComponent theGang = new UserGroup("The Gang");
        DefaultMutableTreeNode theGangNode = new DefaultMutableTreeNode(theGang);
        ((UserComponent) selectedUserGroup.getUserObject()).addUser(theGang);
        treeModel.insertNodeInto(theGangNode, selectedUserGroup, selectedUserGroup.getChildCount()); //adding test group

        selectedUserGroup = theGangNode; // changing the node to the gang to add users underneath this node. This simulates a

        UserComponent charlie = new User("Charlie");
        addUserComponent((UserComponent)charlie);
        UserComponent mac = new User("Mac");
        addUserComponent(mac);

        UserComponent dennis = new User("Dennis");
        addUserComponent(dennis);
        UserComponent dee = new User("Dee");
        addUserComponent(dee);

        //making charlie follow the rest of the gang
        charlie.addUser(mac);  charlie.addUser(dennis); charlie.addUser(dee);

        // end test data

        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new TreeListener());
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);
        selectedUserGroup = rootNode; //setting the default selected node back to the root
    }


    /** Add child to the currently selected node. */
    public void addUserComponent(UserComponent userComp) {
        TreePath parentPath = tree.getSelectionPath();
        DefaultMutableTreeNode userToAdd = new DefaultMutableTreeNode(userComp);
        /* This piece of code is important to determine whether the currently selected user component should be
         * the parent directory or if it should be the currently selected userComponent.
         * For example if the admin current was selecting a user object but wanted to add a new user group.
         * The program will create a group under the parent of the currently selected user.
         * If the admin is selecting a new group object it will allow nodes to be inserted underneath it.
         */
        if(selectedUserGroup.getUserObject() instanceof User){
            selectedUserGroup = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
        }
        // This means there is not already a user with the same username as the user trying ot be added
        if(((UserGroup) selectedUserGroup.getUserObject()).addUser(userComp)){
            treeModel.insertNodeInto(userToAdd, selectedUserGroup, selectedUserGroup.getChildCount());
            tree.expandPath(new TreePath(selectedUserGroup.getPath()));
            tree.scrollPathToVisible(new TreePath(userToAdd.getPath()));
        }

    }
    // The currently selected element in the tree node is returned to the user in the gui.
    public UserComponent getCurrentlySelected(){
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if(node != null){
            return (UserComponent) node.getUserObject();
        }
        return null;
    }


    private  class TreeListener implements TreeSelectionListener {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            if (node == null){
                return;
            }
            selectedUser = node;
            // Get the group
            if (node.getUserObject() instanceof User) {
                System.out.println(node.getUserObject() + " node selected." + "This node is a leaf.");
                selectedUserGroup = (DefaultMutableTreeNode) node.getParent();
            }
            else {
                selectedUser = null;
                System.out.println(node.getUserObject() + " node selected." + "This node is a branch.");
                selectedUserGroup = node;
            }
        }
    }
}
