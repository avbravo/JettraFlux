package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class CharsDoughnut extends Widget {
    private final List<Widget> children;

    private CharsDoughnut(List<Widget> children) {
        this.children = children;
    }

    public static CharsDoughnut of(Widget... children) {
        return new CharsDoughnut(Arrays.asList(children));
    }

    public static CharsDoughnut of(String data) {
        return new CharsDoughnut(Arrays.asList(Text.of(data)));
    }

    @Override
    public String render(ThemeData theme) {
        String id = "chart_" + java.util.UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-charsdoughnut")).append(" style=\"width: 100%; height: 300px; position: relative;\">\n");
        sb.append("<canvas id=\"").append(id).append("\"></canvas>\n");
        sb.append("<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
        sb.append("<script>\n");
        sb.append("setTimeout(function() {\n");
        sb.append("  var ctx = document.getElementById('").append(id).append("').getContext('2d');\n");
        sb.append("  new Chart(ctx, {\n");
        sb.append("    type: 'doughnut',\n");
        sb.append("    data: {\n");
        sb.append("      labels: ['A', 'B', 'C'],\n");
        sb.append("      datasets: [{\n");
        sb.append("          data: [300, 50, 100],\n");
        sb.append("          backgroundColor: ['#EC407A', '#AB47BC', '#42A5F5'],\n");
        sb.append("          hoverBackgroundColor: ['#F06292', '#BA68C8', '#64B5F6']\n");
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
