package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class CharsDoughnut extends Widget {
    private final List<Widget> children;

    private CharsDoughnut(List<Widget> children) {
        this.children = children;
    }

    public static CharsDoughnut of(Widget... children) {
        return new CharsDoughnut(Arrays.asList(children));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-charsdoughnut")).append(">\n");
        for (Widget child : children) {
            sb.append(child.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
