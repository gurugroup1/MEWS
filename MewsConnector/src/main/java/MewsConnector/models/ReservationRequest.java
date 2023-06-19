package MewsConnector.models;

public class ReservationRequest {
    private int hotel_id;
    private int reservation_id;

    public ReservationRequest(int hotel_id, int reservation_id) {
        this.hotel_id = hotel_id;
        this.reservation_id = reservation_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }
}
