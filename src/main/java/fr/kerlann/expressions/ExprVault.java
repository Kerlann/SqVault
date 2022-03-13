package fr.kerlann.expressions;

import fr.kerlann.SqVault;
import fr.nico.sqript.expressions.ScriptExpression;
import fr.nico.sqript.meta.Expression;
import fr.nico.sqript.meta.Feature;
import fr.nico.sqript.structures.ScriptContext;
import fr.nico.sqript.types.ScriptType;
import fr.nico.sqript.types.TypeNull;
import fr.nico.sqript.types.primitive.TypeNumber;
import net.minecraft.entity.player.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

@Expression(name = "Vault Expressions",
        features = {
                @Feature(name = "Player Money", description = "Returns Player money of player with the plugin \"vault\".", examples = "player's money", pattern = "{player}['s] money", type = "number"),
        }
)
public class ExprVault extends ScriptExpression {

    @Override
    public ScriptType get(ScriptContext context, ScriptType[] parameters) {
        switch(getMatchedName()) {
            case "Player Money":
                EntityPlayer player = (EntityPlayer) parameters[0].getObject();
                if(SqVault.getEconomy().isEnabled()){
                    OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player.getUniqueID());
                    Player player1 = offlinePlayer.getPlayer();
                    double money = SqVault.getEconomy().getBalance(player1);
                    return new TypeNumber(money);
                } else {
                    return new TypeNull();
                }
        }
        return null;
    }

    @Override
    public boolean set(ScriptContext context, ScriptType to, ScriptType[] parameters) {
        return false;
    }
}
