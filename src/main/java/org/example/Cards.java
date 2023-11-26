package org.example;

public class Cards {
    public Integer id;
    public String name;
    public String description;
    public User user;

    public Cards(Integer id, String name, String description, User user){
        this.id=id;
        this.name=name;
        this.description=description;
        this.user=user;
    }
}
