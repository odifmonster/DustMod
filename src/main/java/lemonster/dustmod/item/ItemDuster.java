package lemonster.dustmod.item;

import lemonster.dustmod.DustMod;
import lemonster.dustmod.registry.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDuster extends Item {
    public ItemDuster() {
        setUnlocalizedName(DustMod.MODID + ".itemduster");
        setRegistryName("itemduster");
        setCreativeTab(CreativeTabs.MISC);
        setMaxDamage(1);
        setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        return blockIn.getBlock() == ModBlocks.blockDust;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (state.getBlock() != ModBlocks.blockDust) {
            stack.damageItem(2, entityLiving);
        }
        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(2, attacker);
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        if (state.getBlock() == ModBlocks.blockDust) {
            return 10.0f;
        }
        return 0.0f;
    }


}
