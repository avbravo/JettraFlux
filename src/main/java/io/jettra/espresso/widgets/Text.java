package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;

public class Text extends Widget {
    private final String text;

    private Text(String text) {
        this.text = text;
    }

    public static Text of(String text) {
        return new Text(text);
    }

    @Override
    public String render(ThemeData theme) {
        return "<span " + renderCommonAttributes(theme, "espresso-text") + " style=\"" + theme.textStyle + " " + modifier.getStyles() + "\">" + text + "</span>";
    }
}
