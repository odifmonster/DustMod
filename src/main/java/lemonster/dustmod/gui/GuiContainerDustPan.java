package lemonster.dustmod.gui;

import lemonster.dustmod.DustMod;
import lemonster.dustmod.container.ContainerDustPan;
import lemonster.dustmod.tileentity.TileEntityDustPan;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiContainerDustPan extends GuiContainer {

    public static final int ID = 1;

    public static final int WIDTH = 176;
    public static final int HEIGHT = 154;

    private static final ResourceLocation background = new ResourceLocation(DustMod.MODID, "textures/guis/containerdustpan.png");

    public GuiContainerDustPan(TileEntityDustPan te, ContainerDustPan container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
