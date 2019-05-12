package lemonster.dustmod.blocks;

import lemonster.dustmod.DustMod;
import lemonster.dustmod.items.ItemDust;
import lemonster.dustmod.registries.ModBlocks;
import lemonster.dustmod.registries.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockDust extends Block {
    public BlockDust() {
        super(Material.WOOD);
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

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.itemDust;
    }
}
