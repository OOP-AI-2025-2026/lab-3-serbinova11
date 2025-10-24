package org.example.task2;

import java.util.Arrays;

public class Cart {

    private final Item[] items;
    private int count;

    public Cart(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Розмір кошика повинен бути більшим за 0.");
        this.items = new Item[capacity];
        this.count = 0;
    }

    public void add(Item item) {
        if (item == null) return;
        if (this.count < this.items.length) {
            this.items[this.count++] = item;
        } else {
            System.out.println("Кошик повний, не можна додати товар!");
        }
    }

    public void removeById(long id) {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Товар з id " + id + " не знайдено");
            return;
        }
        for (int i = index; i < this.count - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.items[--this.count] = null;
    }

    private int findIndexById(long id) {
        for (int i = 0; i < this.count; i++) {
            if (this.items[i].getId() == id) return i;
        }
        return -1;
    }

    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < this.count; i++) {
            total += this.items[i].getPrice();
        }
        return total;
    }

    public Item[] getItems() {
        return Arrays.copyOf(this.items, this.count);
    }

    public int getItemCount() {
        return this.count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + Arrays.toString(Arrays.copyOf(this.items, this.count)) +
                '}';
    }
}
