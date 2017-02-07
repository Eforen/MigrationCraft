package com.ubersoftech.migrationcraft;

import com.ubersoftech.migrationcraft.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Ariel Lothlorien on 2/7/2017.
 */
public class Config {

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_GLOBALNET = "global";

    // General Config Values:
    public static boolean isActive = true;
    public static boolean ongoing = false;
    public static boolean theEnd = false;

    // GlobalServerNet Config Values:
    public static boolean globalServerActive = false;
    public static String globalServerNetKey = "none";

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initGlobalServerNetConfig(cfg);
        } catch (Exception e1) {
            //ModTut.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
        isActive = cfg.getBoolean("isActive", CATEGORY_GENERAL, isActive, "Set to false to only allow ops to export and import characters.");
        ongoing = cfg.getBoolean("ongoing", CATEGORY_GENERAL, ongoing, "Set to true to allow players to continually import their character on their own.");
        theEnd = cfg.getBoolean("theEndIsNigh", CATEGORY_GENERAL, theEnd, "Set to true to display a THE END IS NIGH msg to the players.");
    }

    private static void initGlobalServerNetConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GLOBALNET, "Functionality for connecting servers through 'GlobalServerNet'");
        globalServerActive = cfg.getBoolean("isEnabled", CATEGORY_GLOBALNET, globalServerActive, "should GlobalServerNet service be used.");
        globalServerNetKey = cfg.getString("ongoing", CATEGORY_GLOBALNET, globalServerNetKey, "key used to authenticate server with GlobalServerNet.");
    }
}