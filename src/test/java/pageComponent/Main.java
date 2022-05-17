package pageComponent;

public class Main {
    public static void main(String[] args) {
        System.out.println("PAGE COMPONENTS");
        System.out.println("===============");
        WebShopPage webshopPage = new WebShopPage();
        webshopPage.searchBar().search("T-Shirt");
        webshopPage.resultList().checkResultHeadline();
        webshopPage.resultList().checkResults();
    }
}
