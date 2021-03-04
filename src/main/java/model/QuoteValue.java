package model;


import java.math.BigDecimal;

public class QuoteValue {

    private Double netVolume;
    private BigDecimal price;
    private Integer hour;


    public Double getNetVolume() {
        return netVolume;
    }

    public void setNetVolume(Double netVolume) {
        this.netVolume = netVolume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "QuoteValue{" +
                "netVolume=" + netVolume +
                ", price=" + price +
                ", hour=" + hour +
                '}';
    }
}
