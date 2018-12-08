/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import entity.Customer;
import entity.CustomerOrder;
import entity.OrderedProduct;
import entity.OrderedProductPK;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author USER
 */
@Stateless
public class OrderManager {

    public int placeOrder(String name, String email, String phone, String address, String cityRegion, String ccNumber, ShoppingCart cart) {

    Customer customer = addCustomer(name, email, phone, address, cityRegion, ccNumber);
    CustomerOrder order = addOrder(customer, cart);
    addOrderedItems(order, cart);
    return order.getId();
}

    private CustomerOrder addOrder(Customer customer, ShoppingCart cart) {

    // set up customer order
    CustomerOrder order = new CustomerOrder();
    order.setCustomerId(customer);
    order.setCantidad(BigDecimal.valueOf(cart.getTotal()));

    // create confirmation number
    Random random = new Random();
    int i = random.nextInt(999999999);
    order.setNumeroConfirmacion(i);

    return order;
}
    private Customer addCustomer(String name, String email, String phone, String address, String cityRegion, String ccNumber) {

    Customer customer = new Customer();
    customer.setNombre(name);
    customer.setCorreo(email);
    customer.setTelefono(phone);
    customer.setDireccion(address);
    customer.setCiudadRegion(cityRegion);
    customer.setNumeroCc(ccNumber);

    return customer;
}

   private void addOrderedItems(CustomerOrder order, ShoppingCart cart) {

    List<ShoppingCartItem> items = cart.getItems();

    // iterate through shopping cart and create OrderedProducts
    for (ShoppingCartItem scItem : items) {

        int productId = scItem.getProduct().getId();

        // set up primary key object
        OrderedProductPK orderedProductPK = new OrderedProductPK();
        orderedProductPK.setCustomerOrderId(order.getId());
        orderedProductPK.setProductId(productId);

        // create ordered item using PK object
        OrderedProduct orderedItem = new OrderedProduct(orderedProductPK);

        // set quantity
        orderedItem.setCantidad(scItem.getQuantity());
    }
}
}
