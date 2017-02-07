package com.ubersoftech.migrationcraft;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MigrationCraftMod.MODID, version = MigrationCraftMod.VERSION)
public class MigrationCraftMod
{
    public static final String MODID = "migrationcraft";
    public static final String VERSION = "0.1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}
