package api.models;

public class Room {

    private final String number;
    private final String type;
    private final boolean accessible;
    private final String price;
    private final String details;

    public Room build() {
        return new Room(number, type, accessible, price, details);
    }

    public String getNumber() { return number; }
    public String getType() { return type; }
    public boolean isAccessible() { return accessible; }
    public String getPrice() { return price; }
    public String getDetails() { return details; }

    public static class Builder {
        private String number;
        private String type;
        private boolean accessible;
        private String price;
        private String details;

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder accessible(boolean accessible) {
            this.accessible = accessible;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Room build() {
            return new Room(number, type, accessible, price, details);
        }
    }

    private Room(String number, String type, boolean accessible, String price, String details) {
        this.number = number;
        this.type = type;
        this.accessible = accessible;
        this.price = price;
        this.details = details;
    }
}
