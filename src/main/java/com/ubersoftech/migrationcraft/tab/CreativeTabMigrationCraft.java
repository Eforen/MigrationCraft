package com.ubersoftech.migrationcraft.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Admin on 2/7/2017.
 */
public class CreativeTabMigrationCraft extends CreativeTabs {

    public CreativeTabMigrationCraft(int index, String label) {
        super(index, label);
    }

    @Override
    public Item getTabIconItem() {
        return Items.PAPER; //TODO: Change to custom icon for mod
    }
}
