package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;

public class ProgressBar extends Widget {
    private double value = 0;
    private double max = 100;

    private ProgressBar() {}

    public static ProgressBar create() {
        return new ProgressBar();
    }
    
    public ProgressBar value(double value) {
        this.value = value;
        return this;
    }
    
    public ProgressBar max(double max) {
        this.max = max;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<progress ").append(renderCommonAttributes(theme, "espresso-progressbar"))
          .append(" value=\"").append(value).append("\" max=\"").append(max).append("\">")
          .append(value).append("%")
          .append("</progress>");
        return sb.toString();
    }
}
