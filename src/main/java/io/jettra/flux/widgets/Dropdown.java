package io.jettra.flux.widgets;
import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;
public class Dropdown extends Widget {
    private final List<String> options;
    private String placeholder = "Select";
    private Dropdown(List<String> options) { this.options = options; }
    public static Dropdown of(String... options) { return new Dropdown(Arrays.asList(options)); }
    public Dropdown placeholder(String placeholder) { this.placeholder = placeholder; return this; }
    @Override public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<select ").append(renderCommonAttributes(theme, "espresso-dropdown")).append(" style=\"padding:10px; border-radius:6px; border:1px solid rgba(128,128,128,0.2); background:var(--surface-color); color:var(--text-color); cursor:pointer; outline:none; font-family:inherit; font-size:1rem; appearance:none; background-image: url('data:image/svg+xml;utf8,<svg fill=\\\"none\\\" stroke=\\\"gray\\\" viewBox=\\\"0 0 24 24\\\" xmlns=\\\"http://www.w3.org/2000/svg\\\"><path stroke-linecap=\\\"round\\\" stroke-linejoin=\\\"round\\\" stroke-width=\\\"2\\\" d=\\\"M19 9l-7 7-7-7\\\"></path></svg>'); background-repeat:no-repeat; background-position:right 10px center; background-size:1em; padding-right:30px;\">");
        if (placeholder != null && !placeholder.isEmpty()) {
            sb.append("<option value=\"\" disabled selected>").append(placeholder).append("</option>");
        }
        for (String opt : options) {
            sb.append("<option value=\"").append(opt).append("\">").append(opt).append("</option>");
        }
        sb.append("</select>");
        return sb.toString();
    }
}
