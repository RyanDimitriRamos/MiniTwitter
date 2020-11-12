package MiniTwitter.CompositeUsers;

import MiniTwitter.VisitorPattern.Visitor;

import java.util.*;

/*
 * This class is a composite pattern.
 * It is a composite pattern because it has a
 * list of UserComponents, that means it can hold
 * other UserGroups. This is useful to define a
 * tree like structure that is used in the Tree View
 */

public class UserGroup implements UserComponent{
    private List<UserComponent> users = new LinkedList<>(); // This makes this a composite class.
    private String userID;
    private UserDataBase dataBase = UserDataBase.getInstance();
    private UserGroup parent; // This points to the parent node, or the folder the user is in.

    public UserGroup(String userID){
        this.userID = userID;
    }


    @Override
    public String toString() {
        return userID;
    }
    /* Adding a user to the the List of User Components this method makes this
     * a composite design pattern because an instance of the parent is holding
     * other instance of the object. This method will return true if successful
     * or it will return false if it not successful.
     */
    public boolean addUser(UserComponent user){
        if(!dataBase.containsKey(user.toString())){
            users.add(user);
            dataBase.put(user.toString(), user);
            user.setParent(this);
            System.out.println(user.toString() + " added to user group " + this);
            return true;
        }else{
            System.out.println("Users can only be added to one User group" + user + " already exists in the program.");
            return false;
        }
    }

    public void setParent(UserGroup parent){
        this.parent = parent;
    }

    public UserGroup getParent() {
        return parent;
    }

    public List<UserComponent> getUsers(){
        return users;
    }

    public void accept(Visitor visitor){ visitor.visit(this); }

}
