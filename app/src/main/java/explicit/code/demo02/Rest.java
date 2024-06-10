package explicit.code.demo02;

public class Rest {

    public Response<Void> post(String url, String body) {
        return new Response<>(200);
    }

    @SuppressWarnings("unchecked")
    public <R extends Response<?>> R get(String url) {
        return (R) new Response<>(200);
    }
}
