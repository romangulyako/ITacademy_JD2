package itacademy;

public class SenderService {
    private ISender sender;

    public SenderService() {}

    public SenderService(ISender sender) {
        this.sender = sender;
    }

    public void setSender(ISender sender) {
        this.sender = sender;
    }

    public void send(String message) {
        this.sender.send(message);
    }
}
