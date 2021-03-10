package lab03;

import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Classifiable {
    private String name;
    private LocalTime openTime, closeTime;
    private double rating;

    @Override
    public LocalTime getOpenTime() { return this.openTime; }
    @Override
    public LocalTime getCloseTime() { return this.closeTime; }
    @Override
    public double getRating() { return this.rating; }

    public void setOpenTime(LocalTime openTime) { this.openTime = openTime; }
    public void setCloseTime(LocalTime closeTime) { this.closeTime = closeTime; }
    public void setRating (double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", rating=" + rating +
                '}';
    }
}
