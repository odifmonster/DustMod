package lemonster.dustmod.proxy;

import lemonster.dustmod.Config;
import lemonster.dustmod.DustMod;
import lemonster.dustmod.blocks.BlockDust;
import lemonster.dustmod.blocks.BlockDustPan;
import lemonster.dustmod.items.ItemDust;
import lemonster.dustmod.items.ItemDuster;
import lemonster.dustmod.registries.ModBlocks;
import lemonster.dustmod.tileEntities.DustPanTileEntity;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
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

        GameRegistry.registerTileEntity(DustPanTileEntity.class, DustMod.MODID + "_blockdustpan");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockDust).setRegistryName(ModBlocks.blockDust.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockDustPan).setRegistryName(ModBlocks.blockDustPan.getRegistryName()));

        event.getRegistry().register(new ItemDust());
        event.getRegistry().register(new ItemDuster());
    }
}
