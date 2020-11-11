package com.studio.youtubcom.models;

public class Bonus {

    private String text;

    Bonus(String text) {
        this.text = text;
    }
    public  static  Bonus DISCOUNT1 = new Bonus("1%");
    public  static  Bonus DISCOUNT3 = new Bonus("3%");
    public  static  Bonus DISCOUNT5 = new Bonus("5%");
    public  static  Bonus DISCOUNT10 = new Bonus("10%");

    @Override
    public String toString() {
        return "Bonus{" +
                "text='" + text + '\'' +
                '}';
    }
}
