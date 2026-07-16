package io.jettra.flux.widgets;
import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;
public class Galleria extends Widget {
    private final List<String> images;
    private Galleria(List<String> images) { this.images = images; }
    public static Galleria of(String... images) { return new Galleria(Arrays.asList(images)); }
    @Override public String render(ThemeData theme) {
        String id = "galleria_" + java.util.UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "galleria-container")).append(" style=\"display:flex; flex-direction:column; gap:10px; width: 100%; max-width: 600px;\">\n");
        
        if (!images.isEmpty()) {
            sb.append("<div style=\"width: 100%; height: 400px; overflow: hidden; border-radius: 8px; box-shadow: 0 4px 6px -1px rgba(0,0,0,0.1);\">\n");
            sb.append("  <img id=\"").append(id).append("_main\" src=\"").append(images.get(0)).append("\" style=\"width: 100%; height: 100%; object-fit: cover; transition: opacity 0.3s;\" />\n");
            sb.append("</div>\n");
            
            sb.append("<div style=\"display:flex; gap:10px; overflow-x: auto; padding-bottom: 5px;\">\n");
            for (String img : images) {
                sb.append("  <img src=\"").append(img).append("\" onclick=\"document.getElementById('").append(id).append("_main').src = this.src;\" style=\"width:80px; height:60px; object-fit:cover; border-radius:4px; cursor:pointer; border: 2px solid transparent;\" onmouseover=\"this.style.opacity='0.8'\" onmouseout=\"this.style.opacity='1'\" />\n");
            }
            sb.append("</div>\n");
        }
        
        sb.append("</div>\n");
        return sb.toString();
    }
}
