package ui.pages;

import api.models.Room;
import org.openqa.selenium.By;

public class AdminDashboardPage extends BasePage {

    private final By dashboardHeader = By.cssSelector("h2");
    private final By addRoomButton = By.id("addRoom");
    private final By roomNumberField = By.id("roomNumber");
    private final By roomTypeField = By.id("type");
    private final By accessibleCheckbox = By.id("accessible");
    private final By roomPriceField = By.id("roomPrice");
    private final By roomDetailsField = By.id("roomDetails");
    private final By createRoomButton = By.id("createRoom");

    public AdminDashboardPage() {
        super();
    }

    public boolean isLoaded() {
        return isDisplayed(dashboardHeader);
    }

    public AdminDashboardPage clickAddRoom() {
        click(addRoomButton);
        return this;
    }

    public AdminDashboardPage enterRoomNumber(String number) {
        type(roomNumberField, number);
        return this;
    }

    public AdminDashboardPage selectRoomType(String type) {
        type(roomTypeField, type);
        return this;
    }

    public AdminDashboardPage setAccessible(boolean value) {
        boolean isChecked = driver.findElement(accessibleCheckbox).isSelected();
        if (value != isChecked) {
            click(accessibleCheckbox);
        }
        return this;
    }

    public AdminDashboardPage enterPrice(String price) {
        type(roomPriceField, price);
        return this;
    }

    public AdminDashboardPage enterDetails(String details) {
        type(roomDetailsField, details);
        return this;
    }

    public AdminDashboardPage createRoom(Room room) {
        clickAddRoom();
        enterRoomNumber(room.getNumber());
        selectRoomType(room.getType());
        setAccessible(room.isAccessible());
        enterPrice(room.getPrice());
        enterDetails(room.getDetails());
        click(createRoomButton);
        return this;
    }


    public void clickCreateRoom() {
        click(createRoomButton);
    }
}
