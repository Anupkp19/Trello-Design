package org.example;

import java.util.List;
import java.util.Map;

public class Members {

    public Map<Integer, List_some> pq;

    public Members(Map<Integer, List_some> pq) {
        this.pq = pq;
    }

    public Map<Integer, List_some> getPq() {
        return pq;
    }

    public void setPq(Map<Integer, List_some> pq) {
        this.pq = pq;
    }

    public void add(Integer id, List_some userList) {
        pq.put(id, userList);
    }
}