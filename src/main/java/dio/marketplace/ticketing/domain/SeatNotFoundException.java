package dio.marketplace.ticketing.domain;

public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(EventId eventId, SeatId seatId) {
        super("Seat not found for event: " + eventId + " and seat: " + seatId);
    }
}
