package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class ThemeChanged extends Widget {
    
    private String currentTheme = "Ast"; // default

    private ThemeChanged() {}

    public static ThemeChanged of() {
        return new ThemeChanged();
    }
    
    public ThemeChanged current(String theme) {
        this.currentTheme = theme;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<div class=\"espresso-theme-changed\" style=\"display: inline-flex; align-items: center; gap: 10px;\">\n");
        sb.append("  <label style=\"").append(theme.textStyle).append("\">Tema:</label>\n");
        sb.append("  <select onchange=\"changeJettraTheme(this.value)\" style=\"padding: 6px; border-radius: 4px; background: ").append(theme.surfaceColor).append("; color: ").append(theme.onSurfaceColor).append("; border: 1px solid ").append(theme.primaryColor).append(";\">\n");
        
        String[] themes = {"Ast", "FlatTheme", "Theme3D", "FuturisticTheme"};
        for (String t : themes) {
            sb.append("    <option value=\"").append(t).append("\"");
            if (t.equals(currentTheme)) {
                sb.append(" selected");
            }
            sb.append(">").append(t).append("</option>\n");
        }
        
        sb.append("  </select>\n");
        
        sb.append("  <script>\n");
        sb.append("    function changeJettraTheme(themeName) {\n");
        sb.append("      document.cookie = 'jettra_theme=' + themeName + '; path=/';\n");
        sb.append("      window.location.reload();\n");
        sb.append("    }\n");
        sb.append("  </script>\n");
        sb.append("</div>\n");
        
        return sb.toString();
    }
}
