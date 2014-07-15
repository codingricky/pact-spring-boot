package client;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.model.PactFragment;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OrderConsumerPactTest extends ConsumerPactTest {

    private static final String RESPONSE = "{\"id\":123,\"order\":\"Pair of Shoes\"}";

    @Override
    protected PactFragment createFragment(ConsumerPactBuilder.PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<String, String>();

        return builder.uponReceiving("java test interaction")
                .path("/orders")
                .method("GET")
                .willRespondWith().status(200)
                .headers(headers)
                .body(RESPONSE).toFragment();
    }

    @Override
    protected String providerName() {
        return "orderProvider";
    }

    @Override
    protected String consumerName() {
        return "orderConsumer";
    }

    @Override
    protected void runTest(String url) {
        try {
            assertEquals(new Client(url).getOrders("/orders"), RESPONSE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}