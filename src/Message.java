public class Message {
    private String text;
    private String id;
    private String senderId;
    private String receiverId;
    private boolean isRead;

    public Message(String text, String id, String senderId, String receiverId, boolean isRead) {
        this.text = text;
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.isRead = isRead;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", isRead=" + isRead +
                '}';
    }
}
