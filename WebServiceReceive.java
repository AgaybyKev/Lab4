import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.*;

import java.io.*;
import java.net.InetSocketAddress;

public class WebServiceReceive {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080...");
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            InputStream is = t.getRequestBody();
            ObjectMapper mapper = new ObjectMapper();
            PizzaOrder order = mapper.readValue(is, PizzaOrder.class);

            System.out.println("Received order:");
            if (order.getCustomer() != null) {
                System.out.println("Customer: " + order.getCustomer().getName());
                System.out.println("Phone: " + order.getCustomer().getPhone());
                if (order.getCustomer().getAddress() != null) {
                    System.out.println("Address: " + order.getCustomer().getAddress());
                }
            }
            if (order.getPayment() != null) {
                System.out.println("Payment Total: " + order.getPayment().getTotalAmount());
            }

            String response = "Order received.";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}