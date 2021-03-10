package lab03;

import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable{
    LocalTime openTime, closeTime;
    double ticketPrice;

    @Override
    public LocalTime getOpenTime() { return this.openTime; }
    @Override
    public LocalTime getCloseTime() { return this.closeTime; }
    @Override
    public double getTicketPrice() { return ticketPrice; }

    public void setOpenTime(LocalTime openTime) { this.openTime = openTime; }
    public void setCloseTime(LocalTime closeTime) { this.closeTime = closeTime; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }

    @Override
    public String toString() {
        return "Museum{" +
                "openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
