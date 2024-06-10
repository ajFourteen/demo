package explicit.code.demo03;

final class Rest {

    private Rest() {
    }

    public static Response<Void> post(String url, String body) {
        return new Response<>(200);
    }

    public static <BODY> Response<BODY> get(String url) {
        return new Response<>(200);
    }
}
