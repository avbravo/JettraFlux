package io.jettra.espresso.widgets;

import io.jettra.espresso.core.Widget;
import io.jettra.espresso.theme.ThemeData;

public class Login extends Widget {
    private String action = "/login";
    private String title = "Login";

    private Login() {}

    public static Login create() {
        return new Login();
    }
    
    public Login action(String action) {
        this.action = action;
        return this;
    }
    
    public Login title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        // Pre-compose a typical login form using existing widgets internally
        Widget formContent = Card.of(
            Column.of(
                Header.of(2, title),
                Label.of("Username").forId("username"),
                TextField.of("username", "Enter username"),
                Label.of("Password").forId("password"),
                TextField.of("password", "Enter password"),
                ElevatedButton.of("Sign In")
            )
        );

        Widget form = Form.of(formContent).action(action).method("POST");

        return form.render(theme);
    }
}
