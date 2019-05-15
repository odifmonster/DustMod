package lemonster.dustmod.registry;

import lemonster.dustmod.item.ItemDust;
import lemonster.dustmod.item.ItemDuster;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    @GameRegistry.ObjectHolder("dustmod:itemdust")
    public static ItemDust itemDust;

    @GameRegistry.ObjectHolder("dustmod:itemduster")
    public static ItemDuster itemDuster;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemDust.initModel();
        itemDuster.initModel();
    }
}
