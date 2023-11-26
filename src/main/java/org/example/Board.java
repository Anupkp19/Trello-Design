package org.example;

import java.util.List;

public class Board {

public Integer id;
public String name;
public Integer privacy;
public Members member;
public List_some lista;


public Board(Integer id, String name, Integer privacy, Members member, List_some lista){
    this.id=id;
    this.name=name;
    this.privacy=privacy;
    this.member=member;
    this.lista=lista;
}

}
