//this class will provide access to our Model data, but
//will not require accessing the ListProductsDao class directly
// instead , we wil reference the interface
public class DaoFactory {

    private static Products productsDao;

    public static Products getProductsDao(){
        if (productsDao == null) {
            productsDao = new ListProductsDao();//this is the only reference to the
            //ListsProductsDao
        }
        //if it is not null return the productsDao that already exists
        //thIs is an instance of the ListProductsDao class
        return productsDao;
    }
}
