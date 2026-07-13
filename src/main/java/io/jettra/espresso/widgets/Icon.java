package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;

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
