package lab03;

public class Hotel extends Location implements Payable, Classifiable{
    double rating, ticketPrice;

    @Override
    public double getRating() { return this.rating; }
    @Override
    public double getTicketPrice() { return this.ticketPrice; }

    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Hotel{" +
                "rating=" + rating +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
