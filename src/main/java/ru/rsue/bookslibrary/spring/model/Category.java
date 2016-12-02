package ru.rsue.bookslibrary.spring.model;

import javax.persistence.*;

/**
 * Created by zaur on 02.12.16.
 */
@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
