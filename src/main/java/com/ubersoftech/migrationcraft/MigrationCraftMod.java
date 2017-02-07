package com.ubersoftech.migrationcraft;

import com.ubersoftech.migrationcraft.proxy.CommonProxy;
import com.ubersoftech.migrationcraft.tab.CreativeTabMigrationCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MigrationCraftMod.MODID, version = MigrationCraftMod.VERSION, name = MigrationCraftMod.NAME)
public class MigrationCraftMod
{
    public static final String MODID = "migrationcraft";
    public static final String VERSION = "0.1.0";
    public static final String NAME = "MigrationCraft";

    @SidedProxy(clientSide = "com.ubersoftech.migrationcraft.proxy.ClientProxy", serverSide = "com.ubersoftech.migrationcraft.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static MigrationCraftMod instance;

    public static CreativeTabMigrationCraft tabMigrationCraft;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // PreInit
        System.out.println("Starting Initialization");
        tabMigrationCraft = new CreativeTabMigrationCraft(CreativeTabs.getNextID(), "tab_migrationcraft");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("Initializing");
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // PostInit
        System.out.println("Initialized");
        proxy.postInit(event);
    }
}
