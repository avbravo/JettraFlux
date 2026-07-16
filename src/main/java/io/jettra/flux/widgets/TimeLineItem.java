package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class TimeLineItem extends Widget {
    private Widget content;
    private Widget opposite;
    private String markerIcon;
    private String markerColor = "#3b82f6";
    private String connectorColor = "#e2e8f0";

    private TimeLineItem() {}

    public static TimeLineItem of() {
        return new TimeLineItem();
    }

    public TimeLineItem content(Widget content) {
        this.content = content;
        return this;
    }

    public TimeLineItem opposite(Widget opposite) {
        this.opposite = opposite;
        return this;
    }

    public TimeLineItem markerIcon(String icon) {
        this.markerIcon = icon;
        return this;
    }

    public TimeLineItem markerColor(String color) {
        this.markerColor = color;
        return this;
    }
    
    public TimeLineItem connectorColor(String color) {
        this.connectorColor = color;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<div class=\"jettra-timeline-event\" style=\"display: flex; min-height: 70px; position: relative;\">\n");
        
        // Opposite
        sb.append("<div class=\"jettra-timeline-event-opposite\" style=\"flex: 1; padding: 0 1rem; text-align: right; display: flex; align-items: center; justify-content: flex-end;\">\n");
        if (opposite != null) {
            sb.append(opposite.render(theme));
        }
        sb.append("</div>\n");

        // Separator
        sb.append("<div class=\"jettra-timeline-event-separator\" style=\"display: flex; flex-direction: column; align-items: center; z-index: 1;\">\n");
        sb.append("<div class=\"jettra-timeline-event-marker\" style=\"display: flex; align-items: center; justify-content: center; width: 2.5rem; height: 2.5rem; border-radius: 50%; border: 2px solid ").append(markerColor).append("; background-color: var(--surface-color, #ffffff); box-shadow: 0 2px 4px rgba(0,0,0,0.1);\">\n");
        if (markerIcon != null && !markerIcon.isEmpty()) {
            sb.append("<span style=\"display: flex; align-items: center; justify-content: center;\">").append(Icon.of(markerIcon).render(theme)).append("</span>\n");
        }
        sb.append("</div>\n");
        sb.append("<div class=\"jettra-timeline-event-connector\" style=\"flex-grow: 1; width: 2px; background-color: ").append(connectorColor).append("; margin: 4px 0;\"></div>\n");
        sb.append("</div>\n");

        // Content
        sb.append("<div class=\"jettra-timeline-event-content\" style=\"flex: 1; padding: 0 1rem; display: flex; align-items: center;\">\n");
        if (content != null) {
            sb.append(content.render(theme));
        }
        sb.append("</div>\n");
        
        sb.append("</div>\n");
        
        return sb.toString();
    }
}
