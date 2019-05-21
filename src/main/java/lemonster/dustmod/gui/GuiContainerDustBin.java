package lemonster.dustmod.gui;

import lemonster.dustmod.DustMod;
import lemonster.dustmod.container.ContainerDustBin;
import lemonster.dustmod.tileentity.TileEntityDustBin;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiContainerDustBin extends GuiContainer {

    public static final int ID = 1;

    public static final int WIDTH = 7+9*18+7;
    public static final int HEIGHT = 7+16+4*18+16+3*18+4+18+7;

    private static final ResourceLocation background = new ResourceLocation(DustMod.MODID, "textures/guis/containerdustbin.png");

    public GuiContainerDustBin(TileEntityDustBin te, ContainerDustBin container) {
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
