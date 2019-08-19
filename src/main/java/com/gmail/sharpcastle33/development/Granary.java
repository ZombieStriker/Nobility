package com.gmail.sharpcastle33.development;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;

import com.gmail.sharpcastle33.estate.Estate;

public class Granary extends Development {

    static {
        name = "Granary";
        cost = new HashMap<>();
        icon = Material.BREAD;
        prerequisites = new ArrayList<>();
    }

    @Override
    public void init(Estate estate) {
        // TODO
    }

    @Override
    public void activate() {
		//Temporary Code
    	Location loc = estate.getBlock().getLocation().add(0, 0, 1);
		loc.getBlock().setType(Material.HAY_BLOCK);
    }

    @Override
    public void deactivate() {
        // TODO
    }
}
