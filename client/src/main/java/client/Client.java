package client;

import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.response.JsonResponse;

import javax.json.JsonObject;
import java.io.IOException;

public class Client {

    private final String url;

    public Client(String url) {
        this.url = url;
    }

    public String getOrders(String uri) throws IOException {;
        final JsonObject jsonObject = new JdkRequest(url + uri)
                .fetch()
                .as(JsonResponse.class)
                .json().readObject();

        return jsonObject.toString();
    }
}
