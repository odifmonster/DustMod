package lemonster.dustmod.blocks;

import lemonster.dustmod.DustMod;
import lemonster.dustmod.tileEntities.DustPanTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockDustPan extends Block implements ITileEntityProvider {
    public BlockDustPan() {
        super(Material.WOOD);
        setUnlocalizedName(DustMod.MODID + ".blockdustpan");
        setRegistryName("blockdustpan");
        setCreativeTab(CreativeTabs.MISC);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new DustPanTileEntity();
    }

    private DustPanTileEntity getTileEntity(World worldIn, BlockPos pos) {
        return (DustPanTileEntity) worldIn.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            boolean hasDust = getTileEntity(worldIn, pos).toggleContents();
            TextComponentTranslation component = new TextComponentTranslation("message.dustmod.hasdust_par", hasDust);
            component.getStyle().setColor(TextFormatting.GREEN);
            playerIn.sendStatusMessage(component, false);
        }
        return true;
    }
}
