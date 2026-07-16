package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class CharsPie extends Widget {
    private final List<Widget> children;

    private CharsPie(List<Widget> children) {
        this.children = children;
    }

    public static CharsPie of(Widget... children) {
        return new CharsPie(Arrays.asList(children));
    }

    public static CharsPie of(String data) {
        return new CharsPie(Arrays.asList(Text.of(data)));
    }

    @Override
    public String render(ThemeData theme) {
        String id = "chart_" + java.util.UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-charspie")).append(" style=\"width: 100%; height: 300px; position: relative;\">\n");
        sb.append("<canvas id=\"").append(id).append("\"></canvas>\n");
        sb.append("<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
        sb.append("<script>\n");
        sb.append("setTimeout(function() {\n");
        sb.append("  var ctx = document.getElementById('").append(id).append("').getContext('2d');\n");
        sb.append("  new Chart(ctx, {\n");
        sb.append("    type: 'pie',\n");
        sb.append("    data: {\n");
        sb.append("      labels: ['A', 'B', 'C'],\n");
        sb.append("      datasets: [{\n");
        sb.append("          data: [300, 50, 100],\n");
        sb.append("          backgroundColor: ['#42A5F5', '#66BB6A', '#FFA726'],\n");
        sb.append("          hoverBackgroundColor: ['#64B5F6', '#81C784', '#FFB74D']\n");
        sb.append("      }]\n");
        sb.append("    },\n");
        sb.append("    options: { responsive: true, maintainAspectRatio: false }\n");
        sb.append("  });\n");
        sb.append("}, 100);\n");
        sb.append("</script>\n");
        sb.append("</div>\n");
        return sb.toString();
    }
}
