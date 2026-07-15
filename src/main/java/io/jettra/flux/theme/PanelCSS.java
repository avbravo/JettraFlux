package io.jettra.flux.theme;

public class PanelCSS {
    public static String get() {
        return "<style>\n"
            + ".espresso-panel { border: 1px solid #e2e8f0; border-radius: 6px; margin-bottom: 1rem; background-color: #ffffff; }\n"
            + ".espresso-panel-header { padding: 1.25rem; background-color: #f8fafc; border-bottom: 1px solid #e2e8f0; border-radius: 6px 6px 0 0; display: flex; justify-content: space-between; align-items: center; font-weight: 700; color: #334155; }\n"
            + ".espresso-panel-content { padding: 1.25rem; color: #475569; line-height: 1.5; }\n"
            + ".espresso-panel-icons { color: #64748b; cursor: pointer; transition: color 0.2s; }\n"
            + ".espresso-panel-icons:hover { color: #3b82f6; }\n"
            + "</style>";
    }
}
