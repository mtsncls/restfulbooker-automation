package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    @JsonProperty("bookingid")
    private int bookingId;

    @JsonProperty("booking")
    private BookingPayload booking;
}
