package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class Icon extends Widget {
    private final String iconClass;

    private Icon(String iconClass) {
        this.iconClass = iconClass;
    }

    public static Icon of(String iconClass) {
        return new Icon(iconClass);
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        // Defaults to 'i' tag for icons like FontAwesome or similar
        sb.append("<i ").append(renderCommonAttributes(theme, iconClass)).append("></i>");
        return sb.toString();
    }
}
