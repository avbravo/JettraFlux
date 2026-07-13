package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class Image extends Widget {
    private final String src;
    private String alt = "";

    private Image(String src) {
        this.src = src;
    }

    public static Image of(String src) {
        return new Image(src);
    }

    public Image alt(String alt) {
        this.alt = alt;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<img src=\"").append(src).append("\" ");
        if (!alt.isEmpty()) {
            sb.append("alt=\"").append(alt).append("\" ");
        }
        sb.append(renderCommonAttributes(theme, "espresso-image")).append("/>");
        return sb.toString();
    }
}
