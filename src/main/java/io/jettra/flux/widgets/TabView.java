package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class TabView extends Widget {
    private final List<TabPanel> tabs;

    private TabView(List<TabPanel> tabs) {
        this.tabs = tabs;
    }

    public static TabView of(TabPanel... tabs) {
        return new TabView(Arrays.asList(tabs));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-tabview")).append(">\n");
        
        // Render Nav Headers
        sb.append("  <ul class=\"espresso-tabview-nav\">\n");
        for (TabPanel tab : tabs) {
            String activeClass = tab.isActive() ? " espresso-tabview-nav-active" : "";
            sb.append("    <li class=\"espresso-tabview-nav-item").append(activeClass).append("\">");
            sb.append("<a class=\"espresso-tabview-nav-link\">").append(tab.getHeader()).append("</a>");
            sb.append("</li>\n");
        }
        sb.append("  </ul>\n");
        
        // Render Panels
        sb.append("  <div class=\"espresso-tabview-panels\">\n");
        for (TabPanel tab : tabs) {
            sb.append(tab.render(theme));
        }
        sb.append("  </div>\n");
        
        sb.append("</div>\n");
        return sb.toString();
    }
}
