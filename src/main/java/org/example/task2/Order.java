package org.example.task2;

public class Order {

    private final long id;
    private final String customer;

    public Order(long id, String customer) {
        if (id <= 0) throw new IllegalArgumentException("ID замовлення повинен бути більшим за 0");
        if (customer == null || customer.isBlank())
            throw new IllegalArgumentException("Ім'я клієнта не може бути порожнім");
        this.id = id;
        this.customer = customer;
    }

    public long getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String formOrderBill(Cart cart) {
        if (cart == null || cart.getItemCount() == 0) {
            return "Кошик порожній.";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Замовлення №").append(this.id)
                .append(" для клієнта ").append(this.customer)
                .append("\n------------------\n");

        double sum = 0;
        for (Item item : cart.getItems()) {
            sum += item.getPrice();
            builder.append("Item id: ").append(item.getId())
                    .append(", name: ").append(item.getName())
                    .append(", price: ").append(item.getPrice())
                    .append(" грн\n");
        }

        builder.append("------------------\n");
        builder.append("Загальна сума: ").append(sum).append(" грн\n");

        return builder.toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + this.id +
                ", customer='" + this.customer + '\'' +
                '}';
    }
}
