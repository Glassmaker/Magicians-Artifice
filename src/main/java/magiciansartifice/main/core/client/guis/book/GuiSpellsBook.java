package magiciansartifice.main.core.client.guis.book;

import magiciansartifice.main.core.client.guis.book.spells.GuiTabIntro;
import magiciansartifice.main.core.client.guis.book.spells.GuiTabSpells;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class GuiSpellsBook extends GuiMagicBook{

    public int page, rot, del;
    public boolean prevHover, nextHover;
    World world;
    private final GuiTab[] tabs;
    private GuiTab activeTab;

    public GuiSpellsBook(Container container, World world)
    {
        super(container,world);
        page = 1;
        rot = 0;
        del = 0;
        this.world = world;

        tabs = new GuiTab[] {
                new GuiTabIntro(0),
                new GuiTabSpells(1)
        };

        activeTab = tabs[0];
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        nextHover = false;
        prevHover = false;
        if(del == 0) rot++;
        del++;
        if(del >= 2) del = 0;
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("magiciansartifice", "textures/guis/guidePage.png"));
        drawTexturedModalRect(guiLeft + 147/2 + 20, guiTop - 10, 0, 0, 145, 180);
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("magiciansartifice", "textures/guis/guidePageFlip.png"));
        drawTexturedModalRect(guiLeft - 147/2 + 21, guiTop - 10, 0, 0, 145, 180);

        for (GuiRectangle tab : tabs) {
            int srcX = 24;
            int sizeX = 19;

            if (tab == activeTab) {
                srcX += 38;
                sizeX +=3;
            }else if(tab.inRect(this, i, j)) {
                srcX += 19;
            }

            tab.draw(this, srcX, 180, sizeX, 18);
        }

        if(i >= guiLeft + 195 + 20 && i <= guiLeft + 195 + 20 + 11 && j >= guiTop + 127 + 20 && j <= guiTop + 127 + 20 + 14 && page + 2 <= activeTab.getMaxPages())
        {
            drawTexturedModalRect(guiLeft + 195 + 20, guiTop + 127 + 20, 0, 180, 11, 14);
            nextHover = true;
        }

        if(i >= guiLeft + 20 - 61 && i <= guiLeft - 61 + 20 + 11 && j >= guiTop + 127 + 20 && j <= guiTop + 127 + 20 + 14 && page - 2 > 0)
        {
            drawTexturedModalRect(guiLeft - 61 + 20, guiTop + 127 + 20, 11, 180, 11, 14);
            prevHover = true;
        }

        activeTab.drawBackground(this, i, j, page);
        activeTab.drawBackground(this, i, j, page + 1);

        ArrayList<String> text = new ArrayList<String>();
        text.add(Integer.toString(page));
        this.drawHoveringText(text, guiLeft - 10 + 20 - text.get(0).length(), guiTop + 150 + 20, fontRendererObj);
        text.remove(Integer.toString(page));
        text.add(Integer.toString(page + 1));
        this.drawHoveringText(text, guiLeft - 10 + 20 + 147 - text.get(0).length(), guiTop + 150 + 20, fontRendererObj);

        for(int tab = 0; tab < tabs.length; tab++)
            renderItem(tabs[tab].getIcon(), guiLeft - 52, guiTop + 26 + tab*19, activeTab.getIcon());

    }

    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        activeTab.drawForeground(this, x, y, page);
        activeTab.drawForeground(this, x, y, page + 1);

        for (GuiTab tab : tabs) {
            tab.drawString(this, x, y, tab.getName());
        }
    }

    @Override
    protected void mouseClicked(int x, int y, int button) {
        if (nextHover && page + 2 <= activeTab.getMaxPages()) {
            page += 2;
        } else if (prevHover && page > 1) {
            page -= 2;
        }

        activeTab.mouseClick(this, x, y, button);

        for (GuiTab tab : tabs) {
            if (activeTab != tab) {
                if (tab.inRect(this, x, y)) {
                    activeTab = tab;
                    page = 1;
                    if (activeTab.getName().equalsIgnoreCase("Spells")) {
                        try {
                            Desktop.getDesktop().browse(new URL("http://i.imgur.com/kxDGGxf/").toURI());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void renderItem(ItemStack item, float x, float y, ItemStack activeIcon)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        EntityItem entityitem = new EntityItem(world, 0.0D, 0.0D, 0.0D, item);
        entityitem.hoverStart = 0.0F;
        GL11.glTranslatef(x, y, 100);

        float scale = 30F;
        GL11.glScalef(-scale, scale, scale);

        if(activeIcon != null && item.isItemEqual(activeIcon)) GL11.glRotatef(rot, 0, 1, 0);GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

        if(RenderManager.instance.options.fancyGraphics)
            RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
        else
        {
            GL11.glRotatef(180F, 0F, 1F, 0F);
            RenderManager.instance.options.fancyGraphics = true;
            RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            RenderManager.instance.options.fancyGraphics = false;
        }
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();

    }

    public void renderItem(ItemStack item, float x, float y, float scale)
    {
        GL11.glPushMatrix();
        EntityItem entityitem = new EntityItem(world, 0.0D, 0.0D, 0.0D, item);
        entityitem.hoverStart = 0.0F;
        GL11.glTranslatef(x, y, 100);
        GL11.glScalef(-scale, scale, scale);
        GL11.glRotatef(160.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(rot, 0.0F, 1.0F, 0.0F);
        if(RenderManager.instance.options.fancyGraphics)
            RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
        else
        {
            RenderManager.instance.options.fancyGraphics = true;
            RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            RenderManager.instance.options.fancyGraphics = false;
        }
        GL11.glPopMatrix();
    }

    public int getLeft()
    {
        return guiLeft;
    }

    public int getTop()
    {
        return guiTop;
    }

    public FontRenderer getFont()
    {
        return fontRendererObj;
    }

    @SuppressWarnings("rawtypes")
    public void drawHoverString(List lst, int x, int y)
    {
        drawHoveringText(lst, x, y, fontRendererObj);
    }

}
