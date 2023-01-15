package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public final class Rock implements Item {

    public final String itemName;
    private final List<String> beats = new ArrayList<>();

    public Rock(final String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public List<String> beats() {
        beats.add(GameItems.scissors);
        return beats;
    }
}
