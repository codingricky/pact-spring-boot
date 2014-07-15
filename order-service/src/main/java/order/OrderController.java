package order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/order")
    public Order order() {
        return new Order(123, "Pair of Shoes");
    }
}
