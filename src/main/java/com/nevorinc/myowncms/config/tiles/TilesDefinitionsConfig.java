package com.nevorinc.myowncms.config.tiles;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

import java.util.HashMap;
import java.util.Map;

public final class TilesDefinitionsConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();

    public Definition getDefinition(String name, Request rqst) {
        return tilesDefinitions.get(name);
    }

    /**
     * @param name <code>Name of the view jsp</code>
     * @param body <code>Body JSP file path</code>
     *
     * <code>Adds default layout definitions</code>
     */
    private static void addDefaultLayoutDef(String definitionName, String trmplateName) {
        Map<String, Attribute> attributes = new HashMap<String, Attribute>();
        attributes.put("admin_panel", new Attribute("/WEB-INF/pages/jsp_fragments/admin_panel.jsp"));
        attributes.put("user_panel", new Attribute("/WEB-INF/pages/jsp_fragments/user_panel.jsp"));
        tilesDefinitions.put(definitionName, new Definition(definitionName, new Attribute(trmplateName), attributes));
    }

    /**
     * <code>Add Apache tiles definitions</code>
     * @param definitionName jsp view name for applying default tiles
     * @param templateName path to jsp
     */
    public static void addDefinitions(String definitionName, String templateName) {
        addDefaultLayoutDef(definitionName,templateName);
    }

}
