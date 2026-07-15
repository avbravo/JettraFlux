package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class Button extends Widget {
    private final List<Widget> children;

    private Button(List<Widget> children) {
        this.children = children;
    }

    public static Button of(Widget... children) {
        return new Button(Arrays.asList(children));
    }

    public static Button of(String label) {
        return new Button(Arrays.asList(Text.of(label)));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-button")).append(">\n");
        for (Widget child : children) {
            sb.append(child.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
