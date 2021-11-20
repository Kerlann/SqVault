package fr.kerlann.events;

import fr.nico.sqript.events.ScriptEvent;
import fr.nico.sqript.meta.Event;
import fr.nico.sqript.meta.Feature;
import fr.nico.sqript.structures.ScriptTypeAccessor;
import fr.nico.sqript.structures.Side;
import fr.nico.sqript.types.primitive.TypeBoolean;
import fr.nico.sqript.types.primitive.TypeNumber;
import fr.nico.sqript.types.primitive.TypeString;
import net.montoyo.mcef.api.IBrowser;

public class EvtMCEF {
    @Event(
            feature = @Feature(name = "MCEF handleQuery",
                    description = "Called when mcef handleQuery",
                    examples = "mcef handle query:",
                    pattern = "cef handle query",
                    side = Side.CLIENT
            ),
            accessors = {
                    @Feature(name = "Query ID", description = "Returns query id", pattern = "query_id", type = "number"),
                    @Feature(name = "Query", description = "Returns query", pattern = "query", type = "string"),
                    @Feature(name = "Persistent", description = "Returns if is persistent", pattern = "persistent", type = "boolean"),
                    @Feature(name = "Url", description = "Returns url", pattern = "url", type = "string"),
                    @Feature(name = "Success", description = "Returns success", pattern = "success", type = "string"),
            }
    )
    public static class EvtHandleQuery extends ScriptEvent {

        public EvtHandleQuery(IBrowser b, long queryId, String query, boolean persistent) {
            super(new ScriptTypeAccessor(new TypeNumber(queryId),"query_id"),
                    new ScriptTypeAccessor(new TypeString(query),"query"),
                    new ScriptTypeAccessor(new TypeBoolean(persistent),"persistent"),
                    new ScriptTypeAccessor(new TypeString(b.getURL()),"url"),
                    new ScriptTypeAccessor(new TypeString("null"),"success"));
        }

    }
}
