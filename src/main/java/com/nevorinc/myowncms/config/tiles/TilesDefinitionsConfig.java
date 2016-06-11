package com.nevorinc.myowncms.config.tiles;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

import java.util.HashMap;
import java.util.Map;

public final class TilesDefinitionsConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/pages/main.jsp");

    public Definition getDefinition(String name, Request rqst) {
        return tilesDefinitions.get(name);
    }

    /**
     * @param name <code>Name of the view jsp</code>
     * @param body <code>Body JSP file path</code>
     *
     * <code>Adds default layout definitions</code>
     */
    private static void addDefaultLayoutDef(String name, String body) {
        Map<String, Attribute> attributes = new HashMap<String, Attribute>();
        attributes.put("admin_panel", new Attribute("/WEB-INF/pages/admin_panel/admin_panel.jsp"));
        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    /**
     * <code>Add Apache tiles definitions</code>
     * @param jspName jsp view name for applying default tiles
     * @param jspPath path to jsp view
     */
    public static void addDefinitions(String jspName, String jspPath) {
        addDefaultLayoutDef(jspName, jspPath);
    }

}
