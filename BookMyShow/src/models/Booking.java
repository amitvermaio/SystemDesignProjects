package models;

public class Booking {
    private String seatNumber;
    private Show show;
    private Theatre theatre;
    private User user;

    public Booking(String seatNumber, Show show, Theatre theatre, User user) {
        this.seatNumber = seatNumber;
        this.show = show;
        this.theatre = theatre;
        this.user = user;
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

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "seatNumber='" + seatNumber + '\'' +
                ", show=" + show +
                ", theatre=" + theatre +
                ", user=" + user +
                '}';
    }
}