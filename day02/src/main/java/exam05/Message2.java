package exam05;

public class Message2 { // 외부에서 제공받은걸로 가정

    public void send(String message) {
        System.out.printf("전송 메시지 : %s%n", message);
    }

    public void init() {
        System.out.println("init!!");
    }

    public void close() {
        System.out.println("close!!");
    }
}
