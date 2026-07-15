package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;

public class Accordion extends Widget {
    private final List<AccordionTab> tabs;

    private Accordion(List<AccordionTab> tabs) {
        this.tabs = tabs;
    }

    public static Accordion of(AccordionTab... tabs) {
        return new Accordion(Arrays.asList(tabs));
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-accordion")).append(">\n");
        for (AccordionTab tab : tabs) {
            sb.append(tab.render(theme));
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
