package io.jettra.flux.theme;

/**
 * ThemeData defines the visual properties for the application's components.
 */
public class ThemeData {
    public final String primaryColor;
    public final String secondaryColor;
    public final String backgroundColor;
    public final String surfaceColor;
    public final String onPrimaryColor;
    public final String onSurfaceColor;
    
    public final String buttonStyle;
    public final String cardStyle;
    public final String containerStyle;
    public final String textStyle;
    
    public ThemeData(
            String primaryColor, String secondaryColor, String backgroundColor, 
            String surfaceColor, String onPrimaryColor, String onSurfaceColor,
            String buttonStyle, String cardStyle, String containerStyle, String textStyle) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.backgroundColor = backgroundColor;
        this.surfaceColor = surfaceColor;
        this.onPrimaryColor = onPrimaryColor;
        this.onSurfaceColor = onSurfaceColor;
        this.buttonStyle = buttonStyle;
        this.cardStyle = cardStyle;
        this.containerStyle = containerStyle;
        this.textStyle = textStyle;
    }
    
    // Method to generate a base CSS for the page using this theme
    public String generateGlobalCss() {
        return "<style>\n" +
               ":root {\n" +
               "  --primary-color: " + primaryColor + ";\n" +
               "  --secondary-color: " + secondaryColor + ";\n" +
               "  --background-color: " + backgroundColor + ";\n" +
               "  --surface-color: " + surfaceColor + ";\n" +
               "  --on-primary-color: " + onPrimaryColor + ";\n" +
               "  --on-surface-color: " + onSurfaceColor + ";\n" +
               "}\n" +
               "body { background-color: var(--background-color); color: var(--on-surface-color); font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; margin: 0; padding: 0; }\n" +
               ".jettra-icon-svg { display: inline-flex; align-items: center; justify-content: center; }\n" +
               ".jettra-icon-svg svg { width: 100%; height: 100%; }\n" +
               "/* JettraFlux Professional Dashboard Layout */\n" +
               ".espresso-dashboard {\n" +
               "  display: grid;\n" +
               "  grid-template-areas: 'top top' 'left center' 'left footer';\n" +
               "  grid-template-columns: 280px 1fr;\n" +
               "  grid-template-rows: 70px minmax(0, 1fr) auto;\n" +
               "  height: 100vh;\n" +
               "  overflow: hidden;\n" +
               "}\n" +
               ".espresso-top { grid-area: top; width: 100%; box-sizing: border-box; background-color: var(--surface-color); box-shadow: 0 2px 10px rgba(0,0,0,0.05); z-index: 10; display: flex; align-items: center; padding: 0 1.5rem; }\n" +
               ".espresso-left { grid-area: left; height: 100%; box-sizing: border-box; background-color: var(--surface-color); border-right: 1px solid rgba(0,0,0,0.05); z-index: 5; overflow-y: auto; padding: 1.5rem 1rem; }\n" +
               ".espresso-center { grid-area: center; overflow-y: auto; width: 100%; box-sizing: border-box; padding: 2rem; background-color: var(--background-color); }\n" +
               ".espresso-footer { grid-area: footer; width: 100%; box-sizing: border-box; padding: 1rem 2rem; text-align: center; background-color: var(--background-color); font-size: 0.875rem; color: #64748b; }\n" +
               "@media (max-width: 992px) {\n" +
               "  .espresso-dashboard {\n" +
               "    grid-template-areas: 'top' 'center' 'footer';\n" +
               "    grid-template-columns: 1fr;\n" +
               "    grid-template-rows: 70px minmax(0, 1fr) auto;\n" +
               "  }\n" +
               "  .espresso-left {\n" +
               "    position: fixed;\n" +
               "    left: -280px;\n" +
               "    top: 70px;\n" +
               "    height: calc(100vh - 70px);\n" +
               "    width: 280px;\n" +
               "    z-index: 1000;\n" +
               "    box-shadow: 2px 0 10px rgba(0,0,0,0.5);\n" +
               "    transition: left 0.3s ease;\n" +
               "    display: block;\n" +
               "  }\n" +
               "  .espresso-left.open {\n" +
               "    left: 0;\n" +
               "  }\n" +
               "}\n" +
               "/* JettraAlert Styling */\n" +
               ".espresso-alert {\n" +
               "  padding: 14px 18px;\n" +
               "  border-radius: 8px;\n" +
               "  margin-bottom: 20px;\n" +
               "  font-weight: 500;\n" +
               "  display: flex;\n" +
               "  flex-direction: column;\n" +
               "  align-items: flex-start;\n" +
               "  gap: 4px;\n" +
               "  width: 100%;\n" +
               "  box-sizing: border-box;\n" +
               "}\n" +
               ".espresso-alert-danger {\n" +
               "  background-color: rgba(239, 68, 68, 0.15) !important;\n" +
               "  border: 1px solid rgba(239, 68, 68, 0.4) !important;\n" +
               "  color: #f87171 !important;\n" +
               "}\n" +
               ".espresso-alert-danger h1, .espresso-alert-danger h2, .espresso-alert-danger h3, .espresso-alert-danger h4, .espresso-alert-danger p, .espresso-alert-danger span, .espresso-alert-danger div {\n" +
               "  color: #f87171 !important;\n" +
               "}\n" +
               ".espresso-alert-success {\n" +
               "  background-color: rgba(16, 185, 129, 0.15) !important;\n" +
               "  border: 1px solid rgba(16, 185, 129, 0.4) !important;\n" +
               "  color: #34d399 !important;\n" +
               "}\n" +
               ".espresso-alert-success h1, .espresso-alert-success h2, .espresso-alert-success h3, .espresso-alert-success h4, .espresso-alert-success p, .espresso-alert-success span, .espresso-alert-success div {\n" +
               "  color: #34d399 !important;\n" +
               "}\n" +
               ".espresso-alert-info {\n" +
               "  background-color: rgba(59, 130, 246, 0.15) !important;\n" +
               "  border: 1px solid rgba(59, 130, 246, 0.4) !important;\n" +
               "  color: #60a5fa !important;\n" +
               "}\n" +
               ".espresso-alert-info h1, .espresso-alert-info h2, .espresso-alert-info h3, .espresso-alert-info h4, .espresso-alert-info p, .espresso-alert-info span, .espresso-alert-info div {\n" +
               "  color: #60a5fa !important;\n" +
               "}\n" +
               "</style>\n";
    }
}
