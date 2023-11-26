package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
public class Main {
        private static int nextId = 1;

        public static int generateId() {
            return nextId++;
        }


    public static  void main(String[] args) {


        User item = new User(generateId(), "some@gmail.com", "john");
        ObjectMapper objectMapper = new ObjectMapper();
        Cards first = new Cards(generateId(), "projects", "Details about currnet project", item);
        List_some some = new List_some(generateId(), "Team", first);


        Map<Integer, List_some> userMap = new HashMap<>();
        userMap.put(1, some);
        //userMap.put(2, new User(21,"john@mddail.com","John Dssoe"));
       // userMap.put(2, item);
        Members obj = new Members(userMap);
      //  obj.setPq(userMap);

Board object = new Board(generateId(),"Finance", 0, obj, some);

        try {
            String json = objectMapper.writeValueAsString(object);
            System.out.println(json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    SimpleHttpServer obj =  new SimpleHttpServer();
    public String displayEmployee() {
        // Assuming you have an Employee class with a displayEmployee() method
        Employee employee1 = new Employee("John Doe", 101, 50000.0);
        return employee1.displayEmployee();
    }

    public SimpleHttpServer getObj() {
        return obj;
    }
}