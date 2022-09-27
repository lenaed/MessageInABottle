import java.util.List;

public interface MessageService {

    public void showAll();
    public List<Message> getUnread(String receiverId);
    public Message getById(String id);


    public void send(String text, String senderID, String receiverId);
    public void markAsRead(String id);

}
