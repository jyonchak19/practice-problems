package ObjectOriented.chatServer;

import java.util.HashMap;
import java.util.ArrayList;


// Singleton pattern example
public class UserManager {
    // some way to track users that are online
    // some way to find users quickly by displayname / id
    // will store the static instance
    // each user will have a lucky number

    private HashMap<String, User> usersByDisplayName = new HashMap<>();
    private HashMap<Integer, User> usersById = new HashMap<>();
    private HashMap<Integer, User> onlineUsers = new HashMap<>();
    private ArrayList<Integer> userSums = new ArrayList<>();
    private static UserManager instance;

    public static UserManager getInstance(){
        if(instance == null)
            instance = new UserManager();
        return instance;
    }

    public User getUserByDisplayName(String displayName) {
        return usersByDisplayName.get(displayName);
    }

    public User getUserById(int id){
        return usersById.get(id);
    }

    // should set the user's status to online
    // and put the user in the online users hashmap
    public boolean signOn(String displayName) {
        User user = getUserByDisplayName(displayName);
        if(user != null){
            user.setStatus(UserStatus.Online);
            onlineUsers.put(user.getId(), user);
            return true;
        }
        return false;
    }

    // [1, 2, 3, 4]
    // [1, 3, 6, 10]
    //  |  |  |
    //(i-1) i (i+1)
    public int[] runningSum() {
        int[] returnSum = new int[userSums.size()];
        for(int i = 0; i < userSums.size(); i++){
            returnSum[i] = userSums.get(i);
        }
        for(int i = 1; i < userSums.size(); i++){
            returnSum[i] += returnSum[i-1];
        }
        return returnSum;
    }
}


//UserManager myChatAppInstance = UserManager.getInstance();
//myChatAppInstance.addUser();
////myChatAppInstance.approveAddRequest();
//myChatAppInstance.userSignedOn();

// Singleton pattern
//class Singleton {
//    private static Singleton instance;
//    public static Singleton getInstance();
//}