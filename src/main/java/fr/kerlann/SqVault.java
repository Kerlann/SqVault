package fr.kerlann;

import fr.nico.sqript.ScriptManager;
import fr.nico.sqript.blocks.ScriptBlockCommand;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

/*
    Code Source de : https://github.com/abvadabra/forge-vault
 */
@Mod(modid = "sqvault", name = "SqVault", dependencies = "after:sqript", version = "1.0.0", acceptableRemoteVersions = "*")
public class SqVault {

    @SideOnly(Side.SERVER)
    private static Economy economy;
    @SideOnly(Side.SERVER)
    private static Permission permission;

    @SideOnly(Side.SERVER)
    public static Economy getEconomy(){
        return economy;
    }

    @SideOnly(Side.SERVER)
    public static Permission getPermission() {
        return permission;
    }

    @SideOnly(Side.SERVER)
    private static void setupEconomy() {
        if(Bukkit.getServer().getPluginManager().getPlugin("Vault") == null){
            ScriptManager.log.info("Cannot find Vault!");
            return;
        }
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(rsp == null){
            ScriptManager.log.info("Registered Service Provider for Economy.class not found");
            return;
        }
        economy = rsp.getProvider();
        ScriptManager.log.info("Economy successfully hooked up");
    }

    @SideOnly(Side.SERVER)
    public static void setupPermissions() {
        if(Bukkit.getServer().getPluginManager().getPlugin("Vault") == null){
            ScriptManager.log.info("Cannot find Vault!");
            return;
        }
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if(rsp == null){
            ScriptManager.log.info("Registered Service Provider for Permission.class not found");
            return;
        }
        permission = rsp.getProvider();
        ScriptManager.log.info("Permission successfully hooked up");

    }

    @SideOnly(Side.SERVER)
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event){
        try {
            setupEconomy();
            setupPermissions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void onScriptBlockCommandCheckPermission(ScriptBlockCommand.checkPermission event){
        if(event.getCommandSender() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getCommandSender();
            if (SqVault.getPermission() != null && SqVault.getPermission().isEnabled()) {
                if (permission.has(Bukkit.getPlayer(player.getUniqueID()), event.getPermission())) {
                    event.setCanceled(true);
                }
            } else {
                ScriptManager.log.info("Plugin Permission disable !");
            }
        } else {
            event.setCanceled(true);
        }
    }
}
