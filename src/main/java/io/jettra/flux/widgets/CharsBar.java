package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class CharsBar extends Widget {
    private final List<Widget> children;

    private CharsBar(List<Widget> children) {
        this.children = children;
    }

    public static CharsBar of(Widget... children) {
        return new CharsBar(Arrays.asList(children));
    }

    public static CharsBar of(String data) {
        return new CharsBar(Arrays.asList(Text.of(data)));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-charsbar")).append(">\n");
        for (Widget child : children) {
            sb.append(child.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
