package order;

public class Order {
    private final long id;
    private final String order;

    public Order(long id, String order) {
        this.id = id;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public String getOrder() {
        return order;
    }
}
