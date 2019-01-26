package model;

public class TwoVector {
    private Double vertical;
    private Double horizontal;



    public TwoVector(Double vertical, Double horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }


    //Getters:
    public Double getVertical() {
        return vertical;
    }
    public Double getHorizontal() {
        return horizontal;
    }



    //Setters:
    public void setVertical(Double vertical) {
        this.vertical = vertical;
    }
    public void setHorizontal(Double horizontal) {
        this.horizontal = horizontal;
    }
}