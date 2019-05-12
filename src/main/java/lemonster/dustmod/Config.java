package lemonster.dustmod;

import lemonster.dustmod.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";

    public static boolean doYouLikeDust = true;
    public static String theTrueReligion = "Religion of the Dust God";

    public static void readConfig() {
        Configuration cfg = CommonProxy.configuration;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e) {
            DustMod.logger.log(Level.ERROR, "Problem loading config file!", e);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        doYouLikeDust = cfg.getBoolean("likeDust", CATEGORY_GENERAL, doYouLikeDust, "Set this to false if you don't like dust (heathen)");
        theTrueReligion = cfg.getString("trueReligion", CATEGORY_GENERAL, theTrueReligion, "Edit the true religion here, but be wary of angering the Dust God");
    }

    private static void initDimensionConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
    }
}
