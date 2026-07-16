package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class ChartsLine extends Widget {
    private final List<Widget> children;

    private ChartsLine(List<Widget> children) {
        this.children = children;
    }

    public static ChartsLine of(Widget... children) {
        return new ChartsLine(Arrays.asList(children));
    }

    public static ChartsLine of(String data) {
        return new ChartsLine(Arrays.asList(Text.of(data)));
    }

    @Override
    public String render(ThemeData theme) {
        String id = "chart_" + java.util.UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-chartsline")).append(" style=\"width: 100%; height: 300px; position: relative;\">\n");
        sb.append("<canvas id=\"").append(id).append("\"></canvas>\n");
        sb.append("<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
        sb.append("<script>\n");
        sb.append("setTimeout(function() {\n");
        sb.append("  var ctx = document.getElementById('").append(id).append("').getContext('2d');\n");
        sb.append("  new Chart(ctx, {\n");
        sb.append("    type: 'line',\n");
        sb.append("    data: {\n");
        sb.append("      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],\n");
        sb.append("      datasets: [{ label: 'First Dataset', data: [65, 59, 80, 81, 56, 55, 40], fill: false, borderColor: '#3b82f6', tension: 0.4 },\n");
        sb.append("                 { label: 'Second Dataset', data: [28, 48, 40, 19, 86, 27, 90], fill: false, borderColor: '#f59e0b', tension: 0.4 }]\n");
        sb.append("    },\n");
        sb.append("    options: { responsive: true, maintainAspectRatio: false }\n");
        sb.append("  });\n");
        sb.append("}, 100);\n");
        sb.append("</script>\n");
        sb.append("</div>\n");
        return sb.toString();
    }
}
