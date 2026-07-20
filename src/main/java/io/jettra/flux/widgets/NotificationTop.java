package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.ArrayList;
import java.util.List;

/**
 * NotificationTop Component.
 * Muestra una campana o ícono personalizado y un badge con la cantidad.
 * Al hacer clic, despliega un menú con las últimas notificaciones.
 */
public class NotificationTop extends Widget {
    public enum NotificationTopType {
        GLOBAL, PERSONAL, CHANNEL
    }

    public Integer value = 0;
    public String label = "";
    private String icon = "fas fa-bell";
    private Icon iconWidget = null;
    public List<String> messages = new ArrayList<>();
    
    private NotificationTopType type = NotificationTopType.GLOBAL;
    private String channel = "";

    private NotificationTop() {}

    public static NotificationTop of() {
        return new NotificationTop();
    }

    public NotificationTop value(Integer value) {
        this.value = value;
        return this;
    }

    public NotificationTop label(String label) {
        this.label = label;
        return this;
    }

    public NotificationTop icon(String icon) {
        this.icon = icon;
        return this;
    }

    public NotificationTop icon(Icon iconWidget) {
        this.iconWidget = iconWidget;
        return this;
    }
    
    public NotificationTop type(NotificationTopType type) {
        this.type = type;
        return this;
    }
    
    public NotificationTop channel(String channel) {
        this.channel = channel;
        return this;
    }
    
    public NotificationTopType getType() {
        return this.type;
    }
    
    public String getChannel() {
        return this.channel;
    }
    
    public NotificationTop addMessage(String msg) {
        this.label = msg;
        messages.add(0, msg);
        if (messages.size() > 5) {
            messages.remove(messages.size() - 1);
        }
        return this;
    }

    @Override
    public NotificationTop binding(String property) {
        super.binding(property);
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        String tooltip = (label != null && !label.isEmpty()) ? "title=\"" + label + "\"" : "";
        
        Widget badge = null;
        if (value != null && value > 0) {
            badge = Badge.of(String.valueOf(value)).severity("danger");
        }
        
        StringBuilder triggerHtml = new StringBuilder();
        triggerHtml.append("<div id=\"").append(id).append("_trigger\" style=\"position: relative; display: inline-flex; align-items: center; justify-content: center; width: 2.5rem; height: 2.5rem; border-radius: 50%; background-color: var(--surface-200, rgba(128,128,128,0.2)); color: var(--text-color); font-size: 1.2rem; cursor: pointer;\" ").append(tooltip).append(">");
        
        if (iconWidget != null) {
            triggerHtml.append(iconWidget.render(theme));
        } else {
            triggerHtml.append(io.jettra.flux.widgets.Icon.of(icon).render(theme));
        }
        
        if (badge != null) {
            String badgeStr = badge.render(theme).replace("style=\"", "style=\"position: absolute; top: -5px; right: -5px; z-index: 10; ");
            triggerHtml.append(badgeStr);
        }
        triggerHtml.append("</div>");
        
        Widget trigger = RawHtml.of(triggerHtml.toString());
        
        WidgetLet[] items = new WidgetLet[messages.isEmpty() ? 1 : messages.size()];
        if (messages.isEmpty()) {
            items[0] = WidgetLet.of("No hay notificaciones").icon("fas fa-info-circle");
        } else {
            for (int i = 0; i < messages.size(); i++) {
                items[i] = WidgetLet.of(messages.get(i)).icon("fas fa-envelope");
            }
        }
        
        // Alineación a la izquierda explícita
        Widget menu = OverlayMenu.of(items).trigger(trigger).modifier(new io.jettra.flux.core.Modifier().style("text-align: left;"));
        
        String bindAttr = modifier.getAttributes().get("data-bind");
        String bindId = (bindAttr != null && !bindAttr.isEmpty()) ? bindAttr : id;

        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-notification-top")).append(" ")
          .append("data-nt-value=\"").append(value != null ? value : 0).append("\" ")
          .append("data-nt-type=\"").append(type.name()).append("\" ")
          .append("data-nt-channel=\"").append(channel).append("\" ")
          .append("data-nt-label=\"").append(label != null ? label : "").append("\" ")
          .append(">");
          
        sb.append(menu.render(theme));
        
        // Auto-refresh mechanism
        sb.append("<script>")
          .append("if(!window.nt_intervals) window.nt_intervals = {};")
          .append("if(!window.nt_intervals['").append(bindId).append("']) {")
          .append("  window.nt_intervals['").append(bindId).append("'] = setInterval(function() {")
          .append("    // Logic to auto-refresh NotificationTop without full page reload")
          .append("    if(typeof jettraSync !== 'undefined' && jettraSync.pollComponent) {")
          .append("      jettraSync.pollComponent('").append(bindId).append("');")
          .append("    }")
          .append("  }, 3000);")
          .append("}")
          .append("</script>");
        
        sb.append("</div>");
        return sb.toString();
    }
}
