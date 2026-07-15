package io.jettra.flux.widgets;
import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
public class ImageCompare extends Widget {
    private final String img1, img2;
    private ImageCompare(String img1, String img2) { this.img1 = img1; this.img2 = img2; }
    public static ImageCompare of(String img1, String img2) { return new ImageCompare(img1, img2); }
    @Override public String render(ThemeData theme) {
        return "<div " + renderCommonAttributes(theme, "image-compare") + " style=\"display:flex; gap:10px;\"><img src=\"" + img1 + "\" style=\"width:200px; height:200px; object-fit:cover;\" /><img src=\"" + img2 + "\" style=\"width:200px; height:200px; object-fit:cover;\" /></div>";
    }
}
