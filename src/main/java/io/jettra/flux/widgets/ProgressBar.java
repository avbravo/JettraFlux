package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class ProgressBar extends Widget {
    private double value = 0;
    private double max = 100;

    private ProgressBar() {}

    public static ProgressBar create() {
        return new ProgressBar();
    }

    public static ProgressBar of() {
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
        double percentage = max > 0 ? (value / max) * 100 : 0;
        
        String baseStyle = "position: relative; overflow: hidden; background-color: var(--surface-200, #e2e8f0); border-radius: 6px; height: 1.5rem; display: flex; align-items: center;";
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-progressbar"))
          .append(" style=\"").append(baseStyle).append(" ").append(modifier.getStyles()).append("\">");
          
        sb.append("<div style=\"height: 100%; width: ").append(percentage).append("%; background-color: var(--primary-color, #3b82f6); transition: width 0.3s ease; display: flex; align-items: center; justify-content: center; overflow: hidden; white-space: nowrap;\">");
        sb.append("<span style=\"color: white; font-size: 0.75rem; font-weight: bold; padding: 0 0.5rem;\">").append((int)value).append("%</span>");
        sb.append("</div>");
        
        sb.append("</div>");
        return sb.toString();
    }
}
