package fr.kerlann.gui;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.montoyo.mcef.api.API;
import net.montoyo.mcef.api.IBrowser;
import net.montoyo.mcef.api.MCEFApi;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class BrowserHud
{
    private static final List<BrowserHud> huds;
    private String url;
    private API api;
    private IBrowser browser;
    private Minecraft mc;

    public BrowserHud(String url) {
        this.url = url;
        this.api = MCEFApi.getAPI();
        this.browser = this.api.createBrowser(url, true);
        this.mc = Minecraft.getMinecraft();
    }

    public void drawScreen() {
        if (this.browser != null) {
            this.browser.resize(this.mc.displayWidth, this.mc.displayHeight);
            GlStateManager.disableDepth();
            GlStateManager.enableTexture2D();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final ScaledResolution scaledResolution = new ScaledResolution(this.mc);
            this.browser.draw(0.0, (double)scaledResolution.getScaledHeight(), (double)scaledResolution.getScaledWidth(), 0.0);
            GL11.glDisable(3042);
            GlStateManager.enableDepth();
        }
    }

    public static void addHud(final BrowserHud browserHud) {
        BrowserHud.huds.add(browserHud);
    }

    public static void removeHud(final BrowserHud browserHud) {
        BrowserHud.huds.remove(browserHud);
    }

    @SubscribeEvent
    public static void on(final RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            for (final BrowserHud browserHud : BrowserHud.huds) {
                browserHud.drawScreen();
            }
        }
    }

    public void runJS(final String js) {
        this.browser.runJS(js, "");
    }

    static {
        huds = new ArrayList<BrowserHud>();
    }
}
