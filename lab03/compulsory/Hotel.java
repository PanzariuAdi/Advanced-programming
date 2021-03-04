package lab03;

public class Hotel extends Location implements Payable, Classifiable{
    private double ticketPrice;
    private double rating;

    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
