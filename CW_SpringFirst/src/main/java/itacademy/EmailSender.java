package itacademy;

public class EmailSender implements ISender{
    private String address;

    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
