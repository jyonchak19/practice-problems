package ObjectOriented.chatServer;

import java.util.ArrayList;

public abstract class Chat {
    protected ArrayList<User> chatUsers = new ArrayList<>();
    protected int id;
    protected ArrayList<Message> messages = new ArrayList<>();

    public boolean addMessage(Message message){
        messages.add(message);
        return true;
    }

    public ArrayList getAllMessages(){
        return messages;
    }

    public int getId(){
        return id;
    }
}
