package io.jettra.flux.theme;

public class AccordionCSS {
    public static String get() {
        return "<style>\n"
            + ".espresso-accordion { width: 100%; display: flex; flex-direction: column; gap: 0; }\n"
            + ".espresso-accordion-tab { border: 1px solid #e2e8f0; margin-bottom: -1px; background-color: #ffffff; }\n"
            + ".espresso-accordion-tab:first-child { border-top-left-radius: 6px; border-top-right-radius: 6px; }\n"
            + ".espresso-accordion-tab:last-child { border-bottom-left-radius: 6px; border-bottom-right-radius: 6px; margin-bottom: 0; }\n"
            + ".espresso-accordion-header { padding: 1.25rem; background-color: #f8fafc; cursor: pointer; display: flex; align-items: center; color: #475569; font-weight: 600; transition: background-color 0.2s, color 0.2s; }\n"
            + ".espresso-accordion-header:hover { background-color: #f1f5f9; color: #334155; }\n"
            + ".espresso-accordion-tab-active .espresso-accordion-header { color: #3b82f6; }\n"
            + ".espresso-accordion-header-icon { margin-right: 0.5rem; transition: transform 0.2s; }\n"
            + ".espresso-accordion-content { padding: 1.25rem; color: #475569; border-top: 1px solid #e2e8f0; }\n"
            + "</style>";
    }
}
