package io.helidon.examples.quickstart.mp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.util.List;

@Path("/product")
public class Product {

    public static class ProductItem {
        private Integer id;
        private String name;
        private String description;
        private BigDecimal price;

        public ProductItem() {
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public ProductItem(Integer id, String name, String description, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }

    private static final List<ProductItem> products;

    static {
        ProductItem p1 = new ProductItem(1, "Water", "Mineral Water", new BigDecimal(1.75));
        ProductItem p2 = new ProductItem(2, "French Fries", "Medium French Fries", new BigDecimal(3.55));
        ProductItem p3 = new ProductItem(3, "Onion", "Onion Rings", new BigDecimal(5.25));
        ProductItem p4 = new ProductItem(4, "Egg", "Fresh eggs", new BigDecimal(2.75));
        ProductItem p5 = new ProductItem(5, "Coffee", "Black Coffee", new BigDecimal(3.20));

        products = List.of(p1, p2, p3, p4, p5);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductItem> get(@QueryParam("delay") long delay) throws InterruptedException {
        Thread.sleep(delay);
        return products;
    }
}
