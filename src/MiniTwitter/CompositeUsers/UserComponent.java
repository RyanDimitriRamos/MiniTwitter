package MiniTwitter.CompositeUsers;

import MiniTwitter.VisitorPattern.Visitor;

public interface UserComponent {
    /* Used in the tree interface so that I can polymorphically add stuff
     * regardless if the instance is of user or usergroup.
     */
    public boolean addUser(UserComponent user);

    //to make this part of the visitor pattern
    public void accept(Visitor visitor);

    //both the User and UserGroup have parents (outer folders)
    public void setParent(UserGroup user);

    public UserGroup getParent();

    public String getUserID();
}
