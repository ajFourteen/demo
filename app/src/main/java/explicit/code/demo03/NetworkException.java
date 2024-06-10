package explicit.code.demo03;

final class NetworkException extends RuntimeException {

    public NetworkException(int code) {
        super(String.valueOf(code));
    }
}
