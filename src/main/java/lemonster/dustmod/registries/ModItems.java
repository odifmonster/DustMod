package lemonster.dustmod.registries;

import lemonster.dustmod.items.ItemDust;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    @GameRegistry.ObjectHolder("dustmod:itemdust")
    public static ItemDust itemDust;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemDust.initModel();
    }
}
