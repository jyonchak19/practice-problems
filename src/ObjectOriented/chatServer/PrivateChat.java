package ObjectOriented.chatServer;

public class PrivateChat extends Chat {

    public PrivateChat(User user1, User user2) {
        chatUsers.add(user1);
        chatUsers.add(user2);

    }

    public User getOtherUser(User currentUser) {
        if(currentUser == chatUsers.get(0))
            return chatUsers.get(1);
        else if(currentUser == chatUsers.get(1))
            return chatUsers.get(0);

        return null;
    }
}
