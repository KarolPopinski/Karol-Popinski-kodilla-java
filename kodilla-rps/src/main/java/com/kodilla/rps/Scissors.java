package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class Scissors implements Item {

    public final String itemName;
    private final List<String> beats = new ArrayList<>();

    public Scissors(final String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public List<String> beats() {
        beats.add(GameItems.paper);
        return beats;
    }
}
