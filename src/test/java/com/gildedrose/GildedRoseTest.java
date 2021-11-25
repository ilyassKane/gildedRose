package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void first_elementary_test() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertTrue(Arrays.stream(app.items).filter(item -> item.name.equals(items[0].name)).findFirst().isPresent());
    }

    @Test
    void RefactoredGildedRose_should_always_have_the_same_output_as_GildedRose() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};

        Item[] refactoredItems = Arrays.stream(items).map(item -> new Item(item.name, item.sellIn, item.quality)).toArray(Item[]::new);
        GildedRose gildedRose = new GildedRose(items);
        RefactoredGildedRose refactoredGildedRose = new RefactoredGildedRose(refactoredItems);
        for (int i = 0; i < 16; i++) {
            gildedRose.updateQuality();
            refactoredGildedRose.updateQuality();
            for (Item item : gildedRose.items) {
                Assertions.assertTrue(isInItems(item, refactoredGildedRose.items));
            }
        }
    }

    private boolean isInItems(Item item, Item[] arrayItems) {
        return Arrays.stream(arrayItems).filter(arrayitem -> arrayitem.name.equals(item.name) &&
            arrayitem.sellIn == item.sellIn && arrayitem.quality == item.quality).findFirst().isPresent();
    }

}
