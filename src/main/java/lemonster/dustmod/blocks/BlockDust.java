package lemonster.dustmod.blocks;

import lemonster.dustmod.DustMod;
import lemonster.dustmod.items.ItemDust;
import lemonster.dustmod.registries.ModBlocks;
import lemonster.dustmod.registries.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockDust extends Block {
    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);

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

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.itemDust;
    }
}
