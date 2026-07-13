package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class Dialog extends Widget {
    private final List<Widget> children;
    private boolean open = false;

    private Dialog(List<Widget> children) {
        this.children = children;
    }

    public static Dialog of(Widget... children) {
        return new Dialog(Arrays.asList(children));
    }
    
    public Dialog open(boolean open) {
        this.open = open;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<dialog ").append(renderCommonAttributes(theme, "espresso-dialog"));
        if (open) {
            sb.append(" open");
        }
        sb.append(" style=\"").append(modifier.getStyles()).append("\">\n");
        
        for (Widget child : children) {
            sb.append(child.render(theme));
        }
        sb.append("</dialog>\n");
        return sb.toString();
    }
}
