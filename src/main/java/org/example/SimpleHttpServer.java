package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class SimpleHttpServer {

    private static int nextId = 1;

    public static int generateId() {
        return nextId++;
    }

    public static void main(String[] args) throws IOException {
        // Create an HTTP server that listens on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Create a context for the root path "/"
        server.createContext("/", new MyHandler());
        server.createContext("/emp", new MyResponse());


        // Set the executor (null means the default executor)
        server.setExecutor(null);

        // Start the server
        server.start();
    }
static  class MyResponse implements HttpHandler{

    /**
     * Handle the given request and generate an appropriate response.
     * See {@link HttpExchange} for a description of the steps
     * involved in handling an exchange.
     *
     * @param exchange the exchange containing the request from the
     *                 client and used to send the response
     * @throws NullPointerException if exchange is {@code null}
     * @throws IOException          if an I/O error occurs
     */
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        List<User> pq= new ArrayList<>();
        User item = new User(generateId(), "some@gmail.com", "john");
        User user2 = new User(generateId(), "user2@gmail.com", "Bob");
        User user3 = new User(generateId(), "user3@gmail.com", "Boby");
        pq.add(item);
        pq.add(user2);
        pq.add(user3);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pq);

        // Print the JSON
        System.out.println("JSON representation: " + json);
        exchange.sendResponseHeaders(200, json.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(json.getBytes());
        }
    }
}
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Assuming you have an Employee class with a displayEmployee() method
            Employee employee1 = new Employee("John Doe", 101, 50000.0);
            String response = employee1.displayEmployee();

            // Send the response headers
            exchange.sendResponseHeaders(200, response.length());

            // Get the output stream and write the response
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
