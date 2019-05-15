package lemonster.dustmod.registry;

import lemonster.dustmod.block.BlockDust;
import lemonster.dustmod.block.BlockDustPan;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    @GameRegistry.ObjectHolder("dustmod:blockdust")
    public static BlockDust blockDust;

    @GameRegistry.ObjectHolder("dustmod:blockdustpan")
    public static BlockDustPan blockDustPan;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockDust.initModel();
        blockDustPan.initModel();
    }
}