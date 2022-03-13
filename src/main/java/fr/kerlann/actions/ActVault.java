package fr.kerlann.actions;

import fr.kerlann.SqVault;
import fr.nico.sqript.ScriptManager;
import fr.nico.sqript.actions.ScriptAction;
import fr.nico.sqript.compiling.ScriptException;
import fr.nico.sqript.meta.Action;
import fr.nico.sqript.meta.Feature;
import fr.nico.sqript.structures.ScriptContext;
import net.milkbowl.vault.economy.EconomyResponse;
import net.minecraft.entity.player.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

@Action(name = "Vault",
        features = {
                @Feature(
                        name = "Deposit money",
                        description = "Deposit player's money.",
                        examples = "add 10 to player's money",
                        pattern = "add {number} to {player}['s] money"
                ),
                @Feature(
                        name = "Withdraw money",
                        description = "Withdraw money from the player.",
                        examples = "remove 10 to player's money",
                        pattern = "remove {number} to {player}['s] money"
                )
})
public class ActVault extends ScriptAction {

    @Override
    public void execute(ScriptContext context) throws ScriptException {
        switch (getMatchedIndex()){
            case 0:
                EntityPlayer player = (EntityPlayer) getParameter(2,context);
                int money = getParameterOrDefault(getParameter(1), 0, context);
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player.getUniqueID());
                EconomyResponse response = SqVault.getEconomy().depositPlayer(offlinePlayer, money);
                if(!response.transactionSuccess()){
                    ScriptManager.log.error("SqVault : Erreur avec la transaction - " + response.errorMessage);
                }
                break;
            case 1:
                player = (EntityPlayer) getParameter(2,context);
                money = getParameterOrDefault(getParameter(1), 0, context);
                offlinePlayer = Bukkit.getOfflinePlayer(player.getUniqueID());
                response = SqVault.getEconomy().withdrawPlayer(offlinePlayer, money);
                if(!response.transactionSuccess()){
                    ScriptManager.log.error("SqVault : Erreur avec la transaction - " + response.errorMessage);
                }
                break;
        }
    }
}