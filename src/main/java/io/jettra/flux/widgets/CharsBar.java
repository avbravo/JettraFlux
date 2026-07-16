package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class CharsBar extends Widget {
    private final List<Widget> children;

    private CharsBar(List<Widget> children) {
        this.children = children;
    }

    public static CharsBar of(Widget... children) {
        return new CharsBar(Arrays.asList(children));
    }

    public static CharsBar of(String data) {
        return new CharsBar(Arrays.asList(Text.of(data)));
    }

    @Override
    public String render(ThemeData theme) {
        String id = "chart_" + java.util.UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-charsbar")).append(" style=\"width: 100%; height: 300px; position: relative;\">\n");
        sb.append("<canvas id=\"").append(id).append("\"></canvas>\n");
        sb.append("<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
        sb.append("<script>\n");
        sb.append("setTimeout(function() {\n");
        sb.append("  var ctx = document.getElementById('").append(id).append("').getContext('2d');\n");
        sb.append("  new Chart(ctx, {\n");
        sb.append("    type: 'bar',\n");
        sb.append("    data: {\n");
        sb.append("      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],\n");
        sb.append("      datasets: [{ label: 'My First dataset', backgroundColor: '#3b82f6', data: [65, 59, 80, 81, 56, 55, 40] },\n");
        sb.append("                 { label: 'My Second dataset', backgroundColor: '#f59e0b', data: [28, 48, 40, 19, 86, 27, 90] }]\n");
        sb.append("    },\n");
        sb.append("    options: { responsive: true, maintainAspectRatio: false }\n");
        sb.append("  });\n");
        sb.append("}, 100);\n");
        sb.append("</script>\n");
        sb.append("</div>\n");
        return sb.toString();
    }
}
