package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class Avatar extends Widget {
    private final List<Widget> children;

    private Avatar(List<Widget> children) {
        this.children = children;
    }

    public static Avatar of(Widget... children) {
        return new Avatar(Arrays.asList(children));
    }

    public static Avatar of(String src) {
        if (src != null && (src.startsWith("http") || src.startsWith("data:"))) {
            return new Avatar(Arrays.asList(Image.of(src)));
        } else {
            return new Avatar(Arrays.asList(Text.of(src)));
        }
    }

    public Avatar shape(String shape) {
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-avatar")).append(">\n");
        for (Widget child : children) {
            sb.append(child.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
