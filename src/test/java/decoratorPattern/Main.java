package decoratorPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("DECORATOR PATTERN");
        System.out.println("=================");
        // Это основной компонент логина
        LoginComponent loginComponent = new BasicLoginComponent();
        loginComponent.login("User", "PW");
        // Превратим его в мобильный компонент
        loginComponent = new MobileLoginDecorator(loginComponent);
        loginComponent.login("User", "PW");
        // И, наконец, добавим отмену
        loginComponent = new CancelButtonDecorator(loginComponent);
        ((CancelButtonDecorator) loginComponent).cancel();
    }
}
