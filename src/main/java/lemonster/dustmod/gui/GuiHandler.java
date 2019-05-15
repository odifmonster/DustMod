package lemonster.dustmod.gui;

import lemonster.dustmod.container.ContainerDustPan;
import lemonster.dustmod.tileentity.TileEntityDustPan;
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
        if (te instanceof TileEntityDustPan) {
            return new ContainerDustPan(player.inventory, (TileEntityDustPan) te);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityDustPan) {
            return new GuiContainerDustPan((TileEntityDustPan) te, new ContainerDustPan(player.inventory, (TileEntityDustPan) te));
        }
        return null;
    }
}
