package ObjectOriented.chatServer;

public class GroupChat extends Chat {
    public void addUser(User user){
        chatUsers.add(user);
    }

    public void removeUser(User user){
        chatUsers.remove(user);
    }
}
