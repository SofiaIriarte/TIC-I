import com.javatpoint.mypackage.Stores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class StoresData {

    private int numArt;
    private String name;
    private int stock;
    private String type;
    private Stores local;

    public int getNumArt() {
        return numArt;
    }

    public void setNumArt(int numArt) {
        this.numArt = numArt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Stores getLocal() {
        return local;
    }

    public void setLocal(Stores local) {
        this.local = local;
    }

    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Stores s1=new Stores();
        s1.setNumRef(123);
        s1.setName("Punta Carretas");
        s1.setAddress("");
        StoresData sD1= new StoresData();
        sD1.setLocal(s1);
        sD1.setName("");
        sD1.setNumArt(1234);
        sD1.setStock(45);
        sD1.setType("");

        session.save(e1);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();

    }
}