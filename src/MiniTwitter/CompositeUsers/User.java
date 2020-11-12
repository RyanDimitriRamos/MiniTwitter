package MiniTwitter.CompositeUsers;

import MiniTwitter.ObserverPattern.Observer;
import MiniTwitter.ObserverPattern.Subject;
import MiniTwitter.Tweet.Tweet;
import MiniTwitter.VisitorPattern.Visitor;

import java.util.*;


/*
 * Here is the user class. This class extends three different
 * classes. These three classes are needed to implement a couple
 * of different design patterns. The first design pattern is the
 * composite design pattern. To implement a composite design
 * pattern, the class User extends the interface UserComponent.
 * This makes the class User a leaf node in the "tree" that is the
 * composite class.
 *
 * Next the class User implements Subject and Observer. The reason
 * the class implements these is to implement the observer pattern.
 * Since a user can both follow and be followed, the user class
 * must implement both observer and subject.
 */
public class User implements UserComponent,Subject, Observer {
    private String userID;
    private List<Observer> following = new ArrayList<>(); // the users that this.user is following.
    private List<Observer> followers = new ArrayList<>(); // this.users followers
    private UserDataBase<String, UserComponent> dataBase = UserDataBase.getInstance(); // singleton instance
    private UserGroup parent; // This points to the parent node, or the folder the user is in.
    private List<Tweet> tweets = new ArrayList<>(); // tweets made by the user
    private List<Tweet> newsFeed = new ArrayList<>(); // List of tweets posted by users the current user is observing.


    public User(String userID) {
        this.userID = userID;
        followers.add(this);
    }

    public List<Observer> getFollowing(){
        return following;
    }

    public UserGroup getParent() {
        return parent;
    }

    public void setParent(UserGroup parent){
        this.parent = parent;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    // Receives tweet from the user interface.
    public void sendTweet(Tweet tweet){
        System.out.println("Posting tweet: " + tweet);
        tweets.add(tweet);
        notifyObservers();
    }

    // tweets made by users that the current user is observing
    public List<Tweet> getNewsFeed(){
        return newsFeed;
    }

    // tweets made by the user
    public List<Tweet> getTweets(){
        return tweets;
    }
    /*
     * This method adds users to its the current user's following list
     * It checks if the user is trying to follow themself, then if the
     * database contains this person then they are trying to find a
     * valid user.
     * This also makes sure that the user isn't trying to follow a usergroup
     * as that is not required.
     */
    @Override
    public boolean addUser(UserComponent user) {
        if(this.userID.equals(user.toString())) {
            return false;
        }
        else if(following.contains(user)){
            System.out.println(this.userID + " is already following " + user);
            return false;
        }
        else if(dataBase.containsKey(user.toString()) && !(user instanceof  UserGroup)){
            User personToFollow = (User) dataBase.get(user.toString());
            System.out.println(this.userID + " is now following " + user);
            following.add((Observer) user);
            personToFollow.addFollower(this);
            return true;
        }
        else{
            System.out.println("The user you are trying to follow does not exist.");
            return false;
        }
    }
    /*
     * wrapper class to make it easier to call to register
     * this makes the code easier to read when adding a follower
     */
    public void addFollower(User user){
        register(user);
    }

    @Override
    public String toString() {
        return userID;
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof User){
            User user = (User) subject;
            List<Tweet> tweets = user.tweets;
            newsFeed.add(tweets.get(tweets.size() -1));
        }

    }

    @Override
    public void register(Observer observer) {
        if(!followers.contains(observer)) {
            followers.add(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : followers){
            observer.update(this);
        }
    }
}
