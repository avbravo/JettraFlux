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
               "/* JettraFlux Professional Dashboard Layout */\n" +
               ".espresso-dashboard {\n" +
               "  display: grid;\n" +
               "  grid-template-areas: 'top top' 'left center' 'left footer';\n" +
               "  grid-template-columns: 280px 1fr;\n" +
               "  grid-template-rows: 70px 1fr auto;\n" +
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
               "    grid-template-rows: 70px 1fr auto;\n" +
               "  }\n" +
               "  .espresso-left { display: none; /* Can be handled via a mobile menu toggle later */ }\n" +
               "  .espresso-left.open { display: block; position: fixed; left: 0; top: 70px; height: calc(100vh - 70px); width: 280px; z-index: 1000; box-shadow: 2px 0 10px rgba(0,0,0,0.5); }\n" +
               "}\n" +
               "</style>\n";
    }
}
