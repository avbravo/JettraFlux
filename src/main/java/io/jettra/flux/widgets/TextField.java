package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class TextField extends Widget {
    private final String placeholder;
    private final String name;

    private TextField(String name, String placeholder) {
        this.name = name;
        this.placeholder = placeholder;
    }

    public static TextField of(String name, String placeholder) {
        return new TextField(name, placeholder);
    }

    @Override
    public String render(ThemeData theme) {
        String inputStyle = "padding: 12px; border: 1px solid " + theme.primaryColor + "; border-radius: 4px; outline: none; background: transparent; color: " + theme.onSurfaceColor + "; font-size: 16px; width: 100%; box-sizing: border-box;";
        return "<input type=\"text\" name=\"" + name + "\" placeholder=\"" + placeholder + "\" " + renderCommonAttributes(theme, "espresso-textfield") + " style=\"" + inputStyle + " " + modifier.getStyles() + "\" />";
    }
}
