package main.java.ObjectOriented.chatServer;

import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class User {

    // user should be able to set a status
    // user should be able to send and recieve requests for "friends"/contacts

    private String username;
    private String displayName;
    private UserStatus status; // online, afk, etc... should be custom UserStatus class
    private int id;
    private HashMap<Integer, User> contacts = new HashMap<>();
    private HashMap<Integer, PrivateChat> privateChats = new HashMap<>();
    private HashMap<Integer, GroupChat> groupChats = new HashMap<>();
    private String ipAddress;

    public User(String username, String displayName, int id) {
        this.username = username;
        this.displayName = displayName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // user should be able to add contacts
    public boolean addContact(User contact) {
        if (contacts.containsKey(contact.getId()))
            return false;
        else {
            contacts.put(contact.getId(), contact);
            return true;
        }
    }

    public boolean sendToUser(String content, User userToSend) {
        PrivateChat chatToSend = privateChats.get(userToSend.getId());

        if (chatToSend == null) {
            chatToSend = new PrivateChat(this, userToSend);
            privateChats.put(userToSend.getId(), chatToSend);
        }
        Message messageToSend = new Message(content, new Date());
        return chatToSend.addMessage(messageToSend);
    }

    public boolean sendToGroup(String content, int groupId) {
        GroupChat chat = groupChats.get(groupId);

        if (chat != null) {
            Message messageToSend = new Message(content, new Date());
            return chat.addMessage(messageToSend);
        }
        return false;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserStatus getStatus() {
        return status;
    }

    // TODO STRING EXAMPLES
    // input (within the class) "9.399.100"
    // output: "9[.]399[.]100"
    public String defangIpAddress() {
        return ipAddress.replace(".", "[.]");
    }

    public String defangIpAddressRegex() {
        return ipAddress.replaceAll("\\.", "[.]");
    }

    public String defangIpAddressRegexJoinAndSplit() {
        return String.join("[.]", ipAddress.split("\\."));
    }

    // userPoints = = [2,3,5,1,3] extraPoints = 3
    // output = [true, true, true, false, true]
    // 2+3 >= all the others, true
    // 3+3 >= all the others, true ...
    public static List<Boolean> extraPointsWinner(int extraPoints, int[] userPoints) {
        List<Boolean> output = new ArrayList<>();
        int max = 0;
        //boolean[] output = new boolean[userPoints.length];
        for (int currUserPoints : userPoints) {
            max = Math.max(max, currUserPoints);
        }
        for (int currUserPoints : userPoints) {
            //output[i] = userPoints[i] + extraPoints >= max;
            output.add(currUserPoints + extraPoints >= max);
        }
        return output;
    }
}