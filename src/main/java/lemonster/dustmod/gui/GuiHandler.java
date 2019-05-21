package lemonster.dustmod.gui;

import lemonster.dustmod.container.ContainerDustBin;
import lemonster.dustmod.tileentity.TileEntityDustBin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityDustBin) {
            return new ContainerDustBin(player.inventory, (TileEntityDustBin) te);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityDustBin) {
            return new GuiContainerDustBin((TileEntityDustBin) te, new ContainerDustBin(player.inventory, (TileEntityDustBin) te));
        }
        return null;
    }
}
