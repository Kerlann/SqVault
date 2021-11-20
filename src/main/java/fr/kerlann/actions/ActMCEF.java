package fr.kerlann.actions;


import fr.kerlann.SqMCEF;
import fr.kerlann.gui.BrowserScreen;
import fr.nico.sqript.actions.ScriptAction;
import fr.nico.sqript.compiling.ScriptException;
import fr.nico.sqript.meta.Action;
import fr.nico.sqript.meta.Feature;
import fr.nico.sqript.structures.ScriptContext;

@Action(name = "Mcef Actions",
        features = {
                @Feature(name = "Open Gui", description = "test", examples = "open mcef with url \"mod:site\"", pattern = "cef open gui with url {string}"),
                @Feature(name = "Run Javascript", description = "run javascript in html menu", examples = "cef execute js \"test();\"", pattern = "cef execute js {string}"),
        },
        priority=1
)
public class ActMCEF extends ScriptAction {

    @Override
    public void execute(ScriptContext context) throws ScriptException {
        switch (getMatchedIndex()) {
            case 0:
                SqMCEF.browserScreen = new BrowserScreen((String) getParameters().get(0).get(context).getObject());
                SqMCEF.browserScreen.openMenu();
                break;
            case 1:
                SqMCEF.browserScreen.executeJS((String) getParameters().get(0).get(context).getObject());
                break;
        }
    }
}
