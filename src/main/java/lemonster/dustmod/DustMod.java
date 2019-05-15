package lemonster.dustmod;

import lemonster.dustmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = DustMod.MODID, useMetadata = true)
public class DustMod {
    public static final String MODID = "dustmod";

    @SidedProxy(clientSide = "lemonster.dustmod.proxy.ClientProxy", serverSide = "lemonster.dustmod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static DustMod instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
