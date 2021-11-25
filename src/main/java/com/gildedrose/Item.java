package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void addQualityIfQualityInferiorTo50() {
        if (quality < 50) {
            quality++;
        }
    }

    public void addQualityForBackstagePasses() {
        if (sellIn < 11 && quality < 50) {
            quality++;
        }
        if (sellIn < 6 && quality < 50) {
            quality++;
        }
        sellIn--;
        if (sellIn < 0)
            quality = 0;
    }

    public void ReduceSelIn() {
        if (!name.equals(Constantes.SULFURAS)
            && !name.equals(Constantes.BACKSTAGE)) {
            sellIn--;
        }
    }

    public void addQualityForAgeBrieIfSelInIsNegatif() {
        if (quality < 50 && sellIn < 0) {
            quality++;
        }
    }

    public void reduceQuality() {
        if (quality > 0 && !name.equals(Constantes.SULFURAS)
            && !name.equals(Constantes.AGEDBRIE)
            && !name.equals(Constantes.BACKSTAGE)) {
            quality--;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
