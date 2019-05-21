package lemonster.dustmod.registry;

import lemonster.dustmod.block.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    @GameRegistry.ObjectHolder("dustmod:blockdust")
    public static BlockDust blockDust;

    @GameRegistry.ObjectHolder("dustmod:blockdustbin")
    public static BlockDustBin blockDustBin;

    @GameRegistry.ObjectHolder("dustmod:blockdustcompressed1")
    public static BlockDustCompressed1 blockDustCompressed1;
    @GameRegistry.ObjectHolder("dustmod:blockdustcompressed2")
    public static BlockDustCompressed2 blockDustCompressed2;
    @GameRegistry.ObjectHolder("dustmod:blockdustcompressed3")
    public static BlockDustCompressed3 blockDustCompressed3;
    @GameRegistry.ObjectHolder("dustmod:blockdustcompressed4")
    public static BlockDustCompressed4 blockDustCompressed4;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockDust.initModel();
        blockDustBin.initModel();
        blockDustCompressed1.initModel();
        blockDustCompressed2.initModel();
        blockDustCompressed3.initModel();
        blockDustCompressed4.initModel();
    }
}