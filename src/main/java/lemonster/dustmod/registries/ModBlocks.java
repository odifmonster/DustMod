package lemonster.dustmod.registries;

import lemonster.dustmod.blocks.BlockDust;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    @GameRegistry.ObjectHolder("dustmod:blockdust")
    public static BlockDust blockDust;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockDust.initModel();
    }
}