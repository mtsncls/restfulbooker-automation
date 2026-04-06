package api.models;

public class Room {
    private String roomNumber;
    private String roomType;
    private boolean accessible;
    private String roomPrice;
    private String roomDetails;

    public Room() {}

    public Room(String roomNumber, String roomType, boolean accessible, String roomPrice, String roomDetails) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.accessible = accessible;
        this.roomPrice = roomPrice;
        this.roomDetails = roomDetails;
    }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public boolean isAccessible() { return accessible; }
    public void setAccessible(boolean accessible) { this.accessible = accessible; }

    public String getRoomPrice() { return roomPrice; }
    public void setRoomPrice(String roomPrice) { this.roomPrice = roomPrice; }

    public String getRoomDetails() { return roomDetails; }
    public void setRoomDetails(String roomDetails) { this.roomDetails = roomDetails; }

    public static RoomBuilder builder() {
        return new RoomBuilder();
    }

    public static class RoomBuilder {
        private String roomNumber;
        private String roomType;
        private boolean accessible;
        private String roomPrice;
        private String roomDetails;

        public RoomBuilder roomNumber(String roomNumber) { this.roomNumber = roomNumber; return this; }
        public RoomBuilder roomType(String roomType) { this.roomType = roomType; return this; }
        public RoomBuilder accessible(boolean accessible) { this.accessible = accessible; return this; }
        public RoomBuilder roomPrice(String roomPrice) { this.roomPrice = roomPrice; return this; }
        public RoomBuilder roomDetails(String roomDetails) { this.roomDetails = roomDetails; return this; }

        public Room build() {
            return new Room(roomNumber, roomType, accessible, roomPrice, roomDetails);
        }
    }
}
