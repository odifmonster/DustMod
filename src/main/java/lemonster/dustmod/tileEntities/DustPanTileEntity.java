package lemonster.dustmod.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class DustPanTileEntity extends TileEntity {
    private boolean hasDust = false;

    public boolean toggleContents() {
        hasDust = !hasDust;
        markDirty();
        return hasDust;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        hasDust = compound.getBoolean("hasdust");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setBoolean("hasdust", hasDust);
        return compound;
    }
}
