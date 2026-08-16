package models;

public class Seat {
    private String seatNumber;
    private Show show;
    private boolean booked;
    private Theatre theatre;

    public Seat(String seatNumber, Show show, Theatre theatre) {
        this.seatNumber = seatNumber;
        this.show = show;
        this.theatre = theatre;
        this.booked = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", booked=" + booked +
                ", show=" + show +
                ", theatre=" + theatre +
                '}';
    }
}