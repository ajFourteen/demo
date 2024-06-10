package explicit.code.demo02;

public class NetworkException extends RuntimeException {

    public NetworkException(int code) {
        super(String.valueOf(code));
    }
}
