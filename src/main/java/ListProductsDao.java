import java.util.ArrayList;
import java.util.List;

public class ListProductsDao implements Products {
    //list all the products, find a product by ID, create a product

    //this will list all the products in the database table
    private List<Product> products;

    //constructor for this DAO class
    public ListProductsDao() {
        this.products = new ArrayList<>();
        // add some dummy data
        Product hammer = new Product();
        hammer.setId(1);
        hammer.setTitle("A bad Hammer");
        hammer.setPriceInCents(3000);
        hammer.setDescription("A bad Hammer");
        products.add(hammer);

        Product xbox = new Product();
        hammer.setId(2);
        hammer.setTitle("Xbox series X");
        hammer.setPriceInCents(50000);
        hammer.setDescription("This will be more powerfull than a gaming PC LULz.");
        products.add(xbox);

        Product chiaPet = new Product();
        hammer.setId(3);
        hammer.setTitle("1999 vintage Chia Pet");
        hammer.setPriceInCents(100);
        hammer.setDescription("A useless product for ... something");
        products.add(chiaPet);


    }

    // TODO: 4/22/20  implements our interface requirements (from Products.java)
    @Override
    public Product findById(long id) {
        // we want to retrun the Product object for the ID passed in
        //this will return the full row in the database
        //ie id , title, priceInCents, description ( the full row) return products.get
        return products.get((int) id - 1);

    }

    @Override
    public long createProduct(Product product) {
        //create a product and insert to our ArrayList (eventually the DB
        //assign a ID
        product.setId(products.size() + 1); // same as auto_increment
        //this ID will always be unique

        //add product to the ArrayList
        products.add(product);//when we call the createProduct method,
        //we are sending in a 'Product' tyoe object
        //this will add that object to the ArrayList

        return product.getId();
    }
}
