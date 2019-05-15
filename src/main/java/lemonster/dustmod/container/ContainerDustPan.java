package lemonster.dustmod.container;

import lemonster.dustmod.registry.ModItems;
import lemonster.dustmod.tileentity.TileEntityDustPan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerDustPan extends Container {

    private TileEntityDustPan te;

    private final int CONTAINER_COLS = 9;
    private final int HOTBAR_ROWS = 1;
    private final int PLAYER_INVENTORY_ROWS = 3;
    private final int TE_ROWS = 2;

    private final int PLAYER_INVENTORY_SLOTS = PLAYER_INVENTORY_ROWS*CONTAINER_COLS;
    private final int VANILLA_SLOTS = (PLAYER_INVENTORY_ROWS+HOTBAR_ROWS)*CONTAINER_COLS;
    private final int TE_SLOTS = TE_ROWS*CONTAINER_COLS;

    private final int VANILLA_FIRST_SLOT = 0;
    private final int TE_FIRST_SLOT = VANILLA_FIRST_SLOT+VANILLA_SLOTS;

    public ContainerDustPan(IInventory playerInventory, TileEntityDustPan te) {
        this.te = te;

        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory) {
        for (int row = 0; row < PLAYER_INVENTORY_ROWS; row++) {
            for (int col = 0; col < CONTAINER_COLS; col++) {
                int x = 8+col*18;
                int y = 72+row*18;
                addSlotToContainer(new Slot(playerInventory, col+row*9+9, x, y));
            }
        }

        for (int col = 0; col < CONTAINER_COLS; col++) {
            int x = 8+col*18;
            int y = 130;
            addSlotToContainer(new Slot(playerInventory, col, x, y));
        }
    }

    private void addOwnSlots() {
        IItemHandler itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        for (int row = 0; row < TE_ROWS; row++) {
            for (int col = 0; col < CONTAINER_COLS; col++) {
                int x = 8 + col * 18;
                int y = 20 + row * 18;
                addSlotToContainer(new SlotItemHandler(itemHandler, col+row*9, x, y));
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        Slot slot = inventorySlots.get(index);

        if (slot == null || !slot.getHasStack()) return ItemStack.EMPTY;

        ItemStack itemStack = slot.getStack();
        ItemStack itemStackCopy = itemStack.copy();

        if (index >= VANILLA_FIRST_SLOT && index < TE_FIRST_SLOT) {
            if (itemStack.getItem() == ModItems.itemDust) {
                return itemStackCopy;
            } else if (!mergeItemStack(itemStack, TE_FIRST_SLOT, TE_FIRST_SLOT+TE_SLOTS, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index >= TE_FIRST_SLOT && index < TE_FIRST_SLOT+TE_SLOTS) {
            if (!mergeItemStack(itemStack, VANILLA_FIRST_SLOT, TE_FIRST_SLOT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.err.println("Invalid slot index: " + index);
            return ItemStack.EMPTY;
        }

        if (itemStack.getCount() == 0) {
            slot.putStack(ItemStack.EMPTY);
        } else {
            slot.onSlotChanged();
        }

        return itemStackCopy;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.canInteractWith(playerIn);
    }
}
