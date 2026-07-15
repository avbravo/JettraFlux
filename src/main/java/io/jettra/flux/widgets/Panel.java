package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class Panel extends Widget {
    private final Widget child;
    private final String header;
    private boolean toggleable = false;

    private Panel(String header, Widget child) {
        this.header = header;
        this.child = child;
    }

    public static Panel of(String header, Widget child) {
        return new Panel(header, child);
    }
    
    public Panel toggleable(boolean toggleable) {
        this.toggleable = toggleable;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-panel")).append(">\n");
        
        // Header
        sb.append("  <div class=\"espresso-panel-header\">\n");
        sb.append("    <span>").append(header).append("</span>\n");
        if (toggleable) {
            sb.append("    <span class=\"espresso-panel-icons\"><i class=\"fas fa-chevron-down\"></i></span>\n");
        }
        sb.append("  </div>\n");
        
        // Content
        sb.append("  <div class=\"espresso-panel-content\">\n");
        if (child != null) {
            sb.append(child.render(theme));
        }
        sb.append("  </div>\n");
        
        sb.append("</div>\n");
        return sb.toString();
    }
}
