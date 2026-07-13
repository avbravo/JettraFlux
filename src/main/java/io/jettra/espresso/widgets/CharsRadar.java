package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class CharsRadar extends Widget {
    private final List<Widget> children;

    private CharsRadar(List<Widget> children) {
        this.children = children;
    }

    public static CharsRadar of(Widget... children) {
        return new CharsRadar(Arrays.asList(children));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-charsradar")).append(">\n");
        for (Widget child : children) {
            sb.append(child.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
