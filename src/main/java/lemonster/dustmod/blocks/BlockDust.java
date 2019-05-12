package lemonster.dustmod.blocks;

import lemonster.dustmod.DustMod;
import lemonster.dustmod.registries.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDust extends Block {
    public BlockDust() {
        super(Material.SNOW);
        setUnlocalizedName(DustMod.MODID + ".blockdust");
        setRegistryName("blockdust");
        setHardness(0.1f);
        setSoundType(SoundType.SNOW);
        setLightOpacity(2);
        setCreativeTab(CreativeTabs.MISC);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
