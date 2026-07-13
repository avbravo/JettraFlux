package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;

public class Scaffold extends Widget {
    private Widget topBar;
    private Widget body;
    private Widget floatingActionButton;

    public Scaffold() {}

    public static Scaffold of() {
        return new Scaffold();
    }

    public Scaffold topBar(Widget topBar) {
        this.topBar = topBar;
        return this;
    }

    public Scaffold body(Widget body) {
        this.body = body;
        return this;
    }

    public Scaffold floatingActionButton(Widget fab) {
        this.floatingActionButton = fab;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append(theme.generateGlobalCss());
        
        String scaffoldStyle = "display: flex; flex-direction: column; min-height: 100vh; position: relative;";
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-scaffold")).append(" style=\"").append(scaffoldStyle).append(" ").append(modifier.getStyles()).append("\">\n");
        
        if (topBar != null) {
            sb.append("<header style=\"width: 100%; box-sizing: border-box;\">\n");
            sb.append(topBar.render(theme));
            sb.append("</header>\n");
        }
        
        if (body != null) {
            sb.append("<main style=\"flex: 1; overflow: auto; padding: 16px; box-sizing: border-box;\">\n");
            sb.append(body.render(theme));
            sb.append("</main>\n");
        }
        
        if (floatingActionButton != null) {
            sb.append("<div style=\"position: fixed; bottom: 24px; right: 24px; z-index: 1000;\">\n");
            sb.append(floatingActionButton.render(theme));
            sb.append("</div>\n");
        }
        
        sb.append("</div>\n");
        return sb.toString();
    }
}
