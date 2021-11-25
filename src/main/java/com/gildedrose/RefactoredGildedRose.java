package com.gildedrose;

class RefactoredGildedRose {
    Item[] items;

    public RefactoredGildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(Constantes.BACKSTAGE)) {
                items[i].addQualityIfQualityInferiorTo50();
                items[i].addQualityForBackstagePasses();
            }
            items[i].ReduceSelIn();
            if (items[i].name.equals(Constantes.AGEDBRIE)) {
                items[i].addQualityIfQualityInferiorTo50();
                items[i].addQualityForAgeBrieIfSelInIsNegatif();
            }
            items[i].reduceQuality();
            if (items[i].sellIn < 0) {
                items[i].reduceQuality();
            }
        }
    }
}
