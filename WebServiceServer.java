import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Arrays;

public class WebServiceServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/pizza", new MyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080...");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            InputStream is = t.getRequestBody();
            ObjectMapper mapper = new ObjectMapper();

            PizzaOrder order = new PizzaOrder(
                    "12345",
                    new Customer("Kevin Agayby", "000-000000", new Address("123 Main St", "Philadelphia", "NY", "00000")),
                    Arrays.asList(
                            new OrderItem("pizza", "large", "thin", Arrays.asList("pepperoni", "mushrooms", "extra cheese"), 1),
                            new OrderItem("pizza", "medium", "stuffed", Arrays.asList("bacon", "onions", "green peppers"), 2)
                    ),
                    new Payment("credit_card", "4242", 39.98),
                    new Delivery("delivery", "2025-06-09T18:30:00")
            );

            String json = mapper.writeValueAsString(order);

            t.sendResponseHeaders(200, json.length());
            OutputStream os = t.getResponseBody();
            os.write(json.getBytes());
            os.close();
        }
    }
}
