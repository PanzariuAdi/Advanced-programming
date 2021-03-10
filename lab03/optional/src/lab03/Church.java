package lab03;

import java.time.LocalTime;

public class Church extends Location implements Visitable{
    private LocalTime openTime, closeTime;

    @Override
    public LocalTime getOpenTime() { return this.openTime; }
    @Override
    public LocalTime getCloseTime() { return this.closeTime; }

    public void setOpenTime(LocalTime openTime) { this.openTime = openTime; }
    public void setCloseTime(LocalTime closeTime) { this.closeTime = closeTime; }


    @Override
    public String toString() {
        return "Church{" +
                "openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}