package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class Icon extends Widget {
    public static final String CHECK = "fas fa-check";
    public static final String REDO = "fas fa-redo";
    public static final String PLUS = "fas fa-plus";
    public static final String SEARCH = "fas fa-search";
    public static final String BELL = "fas fa-bell";
    public static final String COMMENT_ALT = "fas fa-comment-alt";
    public static final String BARS = "fas fa-bars";
    public static final String CALENDAR = "fas fa-calendar";
    public static final String HOME = "fas fa-home";
    public static final String TH_LARGE = "fas fa-th-large";
    public static final String COMMENTS = "fas fa-comments";
    public static final String CUBE = "fas fa-cube";
    public static final String MOUSE_POINTER = "fas fa-mouse-pointer";
    public static final String WINDOW_MAXIMIZE = "fas fa-window-maximize";
    public static final String LAYER_GROUP = "fas fa-layer-group";
    public static final String SIGN_OUT_ALT = "fas fa-sign-out-alt";
    public static final String SYNC = "fas fa-sync";
    public static final String FILTER = "fas fa-filter";
    public static final String USER = "fas fa-user";
    public static final String USERS = "fas fa-users";
    public static final String COG = "fas fa-cog";
    public static final String ENVELOPE = "fas fa-envelope";
    public static final String CHART_BAR = "fas fa-chart-bar";
    public static final String TRASH = "fas fa-trash";
    public static final String EDIT = "fas fa-edit";
    public static final String SAVE = "fas fa-save";
    public static final String TIMES = "fas fa-times";
    public static final String INFO_CIRCLE = "fas fa-info-circle";
    public static final String EXCLAMATION_TRIANGLE = "fas fa-exclamation-triangle";
    public static final String EXCLAMATION_CIRCLE = "fas fa-exclamation-circle";
    public static final String CHECK_CIRCLE = "fas fa-check-circle";

    public static class Bootstrap {
        public static final String CHECK = "bi bi-check";
        public static final String ALARM = "bi bi-alarm";
        public static final String ARROW_RIGHT = "bi bi-arrow-right";
        public static final String ARROW_LEFT = "bi bi-arrow-left";
        public static final String ARROW_UP = "bi bi-arrow-up";
        public static final String ARROW_DOWN = "bi bi-arrow-down";
        public static final String INFO_CIRCLE = "bi bi-info-circle";
        public static final String EXCLAMATION_TRIANGLE = "bi bi-exclamation-triangle";
        public static final String GEAR = "bi bi-gear";
        public static final String PERSON = "bi bi-person";
        public static final String SEARCH = "bi bi-search";
        public static final String HEART = "bi bi-heart";
        public static final String STAR = "bi bi-star";
        public static final String LIST = "bi bi-list";
        public static final String ENVELOPE = "bi bi-envelope";
        public static final String HOUSE = "bi bi-house";
        public static final String DOWNLOAD = "bi bi-download";
        public static final String UPLOAD = "bi bi-upload";
        public static final String TRASH = "bi bi-trash";
        public static final String PENCIL = "bi bi-pencil";
        public static final String BELL = "bi bi-bell";
        public static final String CALENDAR = "bi bi-calendar";
        public static final String CHAT = "bi bi-chat";
        public static final String CAMERA = "bi bi-camera";
        public static final String CLOUD = "bi bi-cloud";
    }

    public static class Flowbite {
        public static final String HOME = "<svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"currentColor\" viewBox=\"0 0 20 20\"><path d=\"m19.707 9.293-2-2-7-7a1 1 0 0 0-1.414 0l-7 7-2 2a1 1 0 0 0 1.414 1.414L2 10.414V18a2 2 0 0 0 2 2h3a1 1 0 0 0 1-1v-4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v4a1 1 0 0 0 1 1h3a2 2 0 0 0 2-2v-7.586l.293.293a1 1 0 0 0 1.414-1.414Z\"/></svg>";
        public static final String SEARCH = "<svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 20 20\"><path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z\"/></svg>";
        public static final String USER = "<svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"currentColor\" viewBox=\"0 0 20 18\"><path d=\"M14 2a3.963 3.963 0 0 0-1.4.267 6.439 6.439 0 0 1-1.331 6.638A4 4 0 1 0 14 2Zm1 9h-1.264A6.957 6.957 0 0 1 15 15v2a2.97 2.97 0 0 1-.184 1H19a1 1 0 0 0 1-1v-1a5.006 5.006 0 0 0-5-5ZM6.5 9a4.5 4.5 0 1 0 0-9 4.5 4.5 0 0 0 0 9ZM8 10H5a5.006 5.006 0 0 0-5 5v2a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-2a5.006 5.006 0 0 0-5-5Z\"/></svg>";
        public static final String SETTINGS = "<svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 20 20\"><path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M5 4.5V1m0 18v-3.5M15 4.5V1m0 18v-3.5M10 9.5V1m0 18v-8.5M5 4.5a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Zm10 0a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Zm-5 5a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z\"/></svg>";
        public static final String BELL = "<svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"currentColor\" viewBox=\"0 0 14 20\"><path d=\"M12.133 10.632v-1.8A5.006 5.006 0 0 0 7.5 3.965V2a1.5 1.5 0 0 0-3 0v1.965a5.006 5.006 0 0 0-4.633 4.867v1.8c0 1.412-.496 2.766-1.393 3.86a1 1 0 0 0 .762 1.63h13.528a1 1 0 0 0 .762-1.63c-.897-1.094-1.393-2.448-1.393-3.86Z\"/><path d=\"M7 20a3 3 0 0 1-3-3h6a3 3 0 0 1-3 3Z\"/></svg>";
    }

    public static class Heroicons {
        public static final String HOME = "<svg fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"m2.25 12 8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25\" /></svg>";
        public static final String USER = "<svg fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z\" /></svg>";
        public static final String SEARCH = "<svg fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z\" /></svg>";
        public static final String COG = "<svg fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M9.594 3.94c.09-.542.56-.94 1.11-.94h2.593c.55 0 1.02.398 1.11.94l.213 1.281c.063.374.313.686.645.87.074.04.147.083.22.127.325.196.72.257 1.075.124l1.217-.456a1.125 1.125 0 0 1 1.37.49l1.296 2.247a1.125 1.125 0 0 1-.26 1.431l-1.003.827c-.293.241-.438.613-.43.992a7.723 7.723 0 0 1 0 .255c-.008.378.137.75.43.99l1.004.828c.424.35.534.955.26 1.43l-1.298 2.247a1.125 1.125 0 0 1-1.369.491l-1.217-.456c-.355-.133-.75-.072-1.076.124a6.47 6.47 0 0 1-.22.128c-.331.183-.581.495-.644.869l-.213 1.281c-.09.543-.56.94-1.11.94h-2.594c-.55 0-1.019-.398-1.11-.94l-.213-1.281c-.062-.374-.312-.686-.644-.87a6.52 6.52 0 0 1-.22-.127c-.325-.196-.72-.257-1.076-.124l-1.217.456a1.125 1.125 0 0 1-1.369-.49l-1.297-2.247a1.125 1.125 0 0 1 .26-1.431l1.004-.827c.292-.24.437-.613.43-.991a6.932 6.932 0 0 1 0-.255c.007-.38-.138-.751-.43-.992l-1.004-.827a1.125 1.125 0 0 1-.26-1.43l1.297-2.247a1.125 1.125 0 0 1 1.37-.491l1.216.456c.356.133.751.072 1.076-.124.072-.044.146-.086.22-.128.332-.183.582-.495.644-.869l.214-1.28Z\" /><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M15 12a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z\" /></svg>";
        public static final String CHECK = "<svg fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"m4.5 12.75 6 6 9-13.5\" /></svg>";
    }

    private final String iconClass;

    private Icon(String iconClass) {
        this.iconClass = iconClass;
    }

    public static Icon of(String iconClass) {
        return new Icon(iconClass);
    }

    @Override
    public String render(ThemeData theme) {
        if (iconClass != null && iconClass.trim().startsWith("<svg")) {
             return iconClass; // Render SVG directly
        }
        StringBuilder sb = new StringBuilder();
        // Defaults to 'i' tag for icons like FontAwesome or Bootstrap
        sb.append("<i ").append(renderCommonAttributes(theme, iconClass)).append("></i>");
        return sb.toString();
    }
}
