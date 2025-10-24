package org.example.task2;

public class Item {

    private final long id;
    private String name;
    private double price;

    public Item(long id, String name, double price) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID товару повинен бути більшим за 0.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва товару не може бути порожньою.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна товару повинна бути додатною.");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", price=" + this.price +
                '}';
    }
}
