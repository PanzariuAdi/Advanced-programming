package lab03;

import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Classifiable{
    private LocalTime openingTime, closingTime;
    private double rating;

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public double getRating() {
        return this.rating;
    }
}
