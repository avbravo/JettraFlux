package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class CharsPie extends Widget {
    private final List<Widget> children;

    private CharsPie(List<Widget> children) {
        this.children = children;
    }

    public static CharsPie of(Widget... children) {
        return new CharsPie(Arrays.asList(children));
    }

    public static CharsPie of(String data) {
        return new CharsPie(Arrays.asList(Text.of(data)));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-charspie")).append(">\n");
        for (Widget child : children) {
            sb.append(child.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
