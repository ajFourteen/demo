package explicit.code.demo02;

public class Response<BODY> {

    private final int code;

    public Response(int code) {
        this.code = code;
    }

    public BODY body() {
        return null;
    }

    public boolean isSuccessfull() {
        return this.code() == 200;
    }

    public boolean isFailed() {
        return !this.isSuccessfull();
    }

    public int code() {
        return this.code;
    }
}
