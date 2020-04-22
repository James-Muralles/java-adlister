import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//this servlet will be used to listen for users trying to view all the Products - likely by going to a page like
// "/products"
// "/products/index.jsp"
// "/"
    @WebServlet(name = "ShowProductsServlet", urlPatterns = "/products/show")
    public class ShowProductServlet extends HttpServlet {
        //this will require a doGet()

        //this method assumes that there is a product id in the URL parameters
        //ie http://localhost:8080/products/show?id=27

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // check to see if there id is passed in url parameters
            // ie http://localhost:8080/products/show?id=27
            long productId = Long.parseLong(req.getParameter("id"));// checking for "id" in url parameters

            //create the connection the DaoFactory
            Products productDao = DaoFactory.getProductsDao();
            //this will give us access to all the Products Interface methods

            //Get the product by its ID from ListProductDao
            Product product = productDao.findById(productId);

            //set the attribute "product" to the object we just created
            req.setAttribute("product", product);
            req.getRequestDispatcher("/products/product-show.jsp").forward(req,resp);

        }
    }

