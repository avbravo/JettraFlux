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
               "body { background-color: " + backgroundColor + "; color: " + onSurfaceColor + "; font-family: sans-serif; margin: 0; padding: 0; }\n" +
               "/* JettraFlux Responsive Grid Layout */\n" +
               ".espresso-dashboard {\n" +
               "  display: grid;\n" +
               "  grid-template-areas: 'top top' 'left center' 'left footer';\n" +
               "  grid-template-columns: 250px 1fr;\n" +
               "  grid-template-rows: auto 1fr auto;\n" +
               "  min-height: 100vh;\n" +
               "}\n" +
               ".espresso-top { grid-area: top; width: 100%; box-sizing: border-box; }\n" +
               ".espresso-left { grid-area: left; height: 100%; box-sizing: border-box; }\n" +
               ".espresso-center { grid-area: center; overflow: auto; width: 100%; box-sizing: border-box; }\n" +
               ".espresso-footer { grid-area: footer; width: 100%; box-sizing: border-box; }\n" +
               "@media (max-width: 768px) {\n" +
               "  .espresso-dashboard {\n" +
               "    grid-template-areas: 'top' 'left' 'center' 'footer';\n" +
               "    grid-template-columns: 1fr;\n" +
               "    grid-template-rows: auto auto 1fr auto;\n" +
               "  }\n" +
               "  .espresso-left { height: auto; }\n" +
               "}\n" +
               "</style>\n";
    }
}
