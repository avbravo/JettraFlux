package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class Carousel extends Widget {
    private final List<Widget> items;

    private Carousel(List<Widget> items) {
        this.items = items;
    }

    public static Carousel of(Widget... items) {
        return new Carousel(Arrays.asList(items));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-carousel"))
          .append(" style=\"display: flex; overflow-x: auto; scroll-snap-type: x mandatory; gap: 16px; ").append(modifier.getStyles()).append("\">\n");
        
        for (Widget item : items) {
            sb.append("  <div style=\"scroll-snap-align: start; flex: 0 0 auto;\">\n");
            sb.append(item.render(theme));
            sb.append("  </div>\n");
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
