package MiniTwitter.CompositeUsers;

import java.util.HashMap;
import java.util.HashSet;

/* UsedIDs is a singleton class used to hold the user IDs that
 * that have already been used. The reason I implemented this
 * as a singleton class is that for the whole User file tree
 * a UserComponent is only allowed to be added to one subgroup.
 * Now this UsedIDs instance acts similarly to a global variable
 * that all instances of UserComponent have access to.
 * The object is set as Package-Private to prevent those outside
 * of the composite pattern from accessing it.
 */
class UserDataBase<String, UserComponent> extends HashMap {
    private static UserDataBase instance = null;
    private UserDataBase(){ }
    public static UserDataBase getInstance(){
        if(instance == null){
            synchronized (UserDataBase.class){
                if(instance == null){
                    instance = new UserDataBase();
                }
            }
        }
        return instance;
    }
}
