package util;

public class BreadcrumbPrompt extends Prompt {

    private Stack breadcrumbs = new Stack();

    public void appendBreadcrumb(String title) {
        breadcrumbs.push(title);
    }

    public void removeBreadcrumb() {
        breadcrumbs.pop();
    }

    public String inputMenu() {
        StringBuilder titleBuilder = new StringBuilder(); // 예) 메인/회원>
        for (int i = 0; i < breadcrumbs.size(); i++) {
            if (titleBuilder.length() > 0) {
                titleBuilder.append("/");
            }
            titleBuilder.append(breadcrumbs.get(i));
        }
        titleBuilder.append("> ");
        return this.inputString(titleBuilder.toString());
    }
}