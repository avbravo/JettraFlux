package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class Dashboard extends Widget {
    private final List<Widget> children;

    private Dashboard(List<Widget> children) {
        this.children = children;
    }

    public static Dashboard of(Widget... children) {
        return new Dashboard(Arrays.asList(children));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-dashboard")).append(">\n");
        for (Widget child : children) {
            sb.append(child.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
