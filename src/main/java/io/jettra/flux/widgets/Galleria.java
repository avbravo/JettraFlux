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
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "galleria-container")).append(" style=\"display:flex; flex-wrap:wrap; gap:10px;\">");
        for (String img : images) sb.append("<img src=\"").append(img).append("\" style=\"width:100px; height:100px; object-fit:cover; border-radius:4px;\" />");
        sb.append("</div>");
        return sb.toString();
    }
}
