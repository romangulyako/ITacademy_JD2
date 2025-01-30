package itacademy.proxy;

import java.util.Random;

public class TransferService {
    public int transfer(TransferData data) {
        int code = new Random().nextInt(3);
        System.out.println(data);
        return code;
    }
}
