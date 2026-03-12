package api;

import api.client.BookingClient;
import org.testng.annotations.BeforeClass;

public abstract class ApiBaseTest {

    protected BookingClient bookingClient;

    @BeforeClass
    public void apiSetup() {
        bookingClient = new BookingClient();
    }
}
