package io.jettra.flux.theme;

public class TabViewCSS {
    public static String get() {
        return "<style>\n"
            + ".espresso-tabview { display: flex; flex-direction: column; width: 100%; }\n"
            + ".espresso-tabview-nav { list-style-type: none; margin: 0; padding: 0; display: flex; border-bottom: 2px solid #e2e8f0; }\n"
            + ".espresso-tabview-nav-item { margin-bottom: -2px; }\n"
            + ".espresso-tabview-nav-link { display: block; padding: 1rem 1.5rem; font-weight: 600; color: #64748b; cursor: pointer; border-bottom: 2px solid transparent; transition: color 0.2s, border-color 0.2s; }\n"
            + ".espresso-tabview-nav-link:hover { color: #334155; border-color: #cbd5e1; }\n"
            + ".espresso-tabview-nav-active .espresso-tabview-nav-link { color: #3b82f6; border-color: #3b82f6; }\n"
            + ".espresso-tabview-panels { padding: 1.5rem 0; }\n"
            + "</style>";
    }
}
