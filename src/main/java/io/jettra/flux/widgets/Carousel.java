package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
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
        String id = "carousel_" + java.util.UUID.randomUUID().toString().replace("-", "");
        
        sb.append("<div style=\"position: relative; display: flex; align-items: center; width: 100%;\">\n");
        sb.append("<button onclick=\"document.getElementById('").append(id).append("').scrollBy({left: -250, behavior: 'smooth'})\" style=\"position: absolute; left: 10px; z-index: 10; background: rgba(0,0,0,0.5); color: white; border: none; border-radius: 50%; width: 40px; height: 40px; cursor: pointer; display: flex; align-items: center; justify-content: center;\"><i class=\"fas fa-chevron-left\"></i></button>\n");
        
        sb.append("<div id=\"").append(id).append("\" ").append(renderCommonAttributes(theme, "espresso-carousel"))
          .append(" style=\"display: flex; overflow-x: hidden; scroll-snap-type: x mandatory; gap: 16px; width: 100%; padding: 10px 40px; ").append(modifier.getStyles()).append("\">\n");
        
        for (Widget item : items) {
            sb.append("  <div style=\"scroll-snap-align: start; flex: 0 0 auto;\">\n");
            sb.append(item.render(theme));
            sb.append("  </div>\n");
        }
        sb.append("</div>\n");
        
        sb.append("<button onclick=\"document.getElementById('").append(id).append("').scrollBy({left: 250, behavior: 'smooth'})\" style=\"position: absolute; right: 10px; z-index: 10; background: rgba(0,0,0,0.5); color: white; border: none; border-radius: 50%; width: 40px; height: 40px; cursor: pointer; display: flex; align-items: center; justify-content: center;\"><i class=\"fas fa-chevron-right\"></i></button>\n");
        sb.append("</div>\n");
        return sb.toString();
    }
}
