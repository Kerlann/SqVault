package fr.kerlann;

import fr.kerlann.gui.BrowserHud;
import fr.kerlann.gui.BrowserScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;


@Mod(modid = "sqmcef", name = "SqMCEF", dependencies = "required-before:sqript@${version}", version = "1.0.0", acceptableRemoteVersions = "*")
public class SqMCEF {

    public static BrowserScreen browserScreen;

    public static BrowserHud browserHud;

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(BrowserHud.class);
        //browserHud = new BrowserHud("mod://darkrp/index.html");
       // BrowserHud.addHud(browserHud);
        System.out.println("register mod");
    }
}
