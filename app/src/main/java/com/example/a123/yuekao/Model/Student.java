package com.example.a123.yuekao.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 123 on 2017/4/19.
 */
@DatabaseTable(tableName = "car")
public class Student {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField(columnName = "name")
    String name;
    @DatabaseField(columnName = "price")
    int price;
    @DatabaseField(columnName = "content")
    String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", content='" + content + '\'' +
                '}';
    }
}
