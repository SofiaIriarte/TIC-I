public class Cart {

    private Customer customer;
    private StoresData[] articles;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StoresData[] getArticles() {
        return articles;
    }

    public void setArticles(StoresData[] articles) {
        this.articles = articles;
    }
}
