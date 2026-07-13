package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;

public class ElevatedButton extends Widget {
    private final Widget child;

    private ElevatedButton(Widget child) {
        this.child = child;
    }

    public static ElevatedButton of(String text) {
        return new ElevatedButton(Text.of(text));
    }
    
    public static ElevatedButton of(Widget child) {
        return new ElevatedButton(child);
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<button ").append(renderCommonAttributes(theme, "espresso-button"))
          .append(" style=\"").append(theme.buttonStyle).append(" ").append(modifier.getStyles()).append("\">\n");
        if (child != null) {
            sb.append(child.render(theme));
        }
        sb.append("</button>\n");
        return sb.toString();
    }
}
