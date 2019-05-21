package lemonster.dustmod.block;

import lemonster.dustmod.DustMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class BlockDustCompressed1 extends Block {

    public BlockDustCompressed1() {
        super(Material.GROUND);
        setUnlocalizedName(DustMod.MODID + ".blockdustcompressed1");
        setRegistryName("blockdustcompressed1");
        setHardness(0.1f);
        setSoundType(SoundType.SNOW);
        setCreativeTab(CreativeTabs.MISC);
    }

    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
