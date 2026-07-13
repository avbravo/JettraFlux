package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;

public class Card extends Widget {
    private final Widget child;

    private Card(Widget child) {
        this.child = child;
    }

    public static Card of(Widget child) {
        return new Card(child);
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-card"))
          .append(" style=\"").append(theme.cardStyle).append(" ").append(modifier.getStyles()).append("\">\n");
        if (child != null) {
            sb.append(child.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
