package lemonster.dustmod.proxy;

import lemonster.dustmod.Config;
import lemonster.dustmod.DustMod;
import lemonster.dustmod.block.BlockDust;
import lemonster.dustmod.block.BlockDustPan;
import lemonster.dustmod.gui.GuiHandler;
import lemonster.dustmod.item.ItemDust;
import lemonster.dustmod.item.ItemDuster;
import lemonster.dustmod.registry.ModBlocks;
import lemonster.dustmod.tileentity.TileEntityDustPan;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    public static Configuration configuration;

    public void preInit(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        configuration = new Configuration(new File(directory.getPath(), "dustmod.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(DustMod.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent event) {
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockDust());
        event.getRegistry().register(new BlockDustPan());

        GameRegistry.registerTileEntity(TileEntityDustPan.class, DustMod.MODID + "_blockdustpan");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockDust).setRegistryName(ModBlocks.blockDust.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockDustPan).setRegistryName(ModBlocks.blockDustPan.getRegistryName()));

        event.getRegistry().register(new ItemDust());
        event.getRegistry().register(new ItemDuster());
    }
}
