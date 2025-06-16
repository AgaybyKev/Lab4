import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class WebServiceSend {
    public static void main(String[] args) throws Exception {
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
        URL url = new URL("http://localhost:8080");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = con.getOutputStream()) {
            os.write(json.getBytes());
            os.flush();
        }

        System.out.println("Sent order JSON to server.");
    }
}
