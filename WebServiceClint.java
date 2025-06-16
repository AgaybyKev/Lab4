import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//Client

class WebServiceClient {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        URL url = new URL("http://localhost:8080/pizza");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        // Read the response from the web service
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();



        PizzaOrder order = mapper.readValue(response.toString(), PizzaOrder.class);

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

    }
}
