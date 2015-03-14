package com.palyga.web;


import com.palyga.components.impl.Cart;
import com.palyga.components.impl.JsonMapper;
import com.palyga.model.Order;
import com.palyga.model.Products;
import com.palyga.service.CartManager;
import com.palyga.service.OrderManager;
import com.palyga.service.ProductsManager;
import com.palyga.service.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Василь on 28.02.2015.
 */

@Controller
@Scope("request")
public class CartController {

    @Autowired
    private Cart cart;

    @Autowired
    ProductsManager productsManager;

    @Autowired
    CartManager cartManager;

    @Autowired
    JsonMapper jsonMapper;

    @Autowired
    OrderManager orderManager;

    @Autowired
    UsersManager usersManager;

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String getOrder(Model map){
        if(cart.getProductsCart().isEmpty()){
            return "redirect:/";
        }
        map.addAttribute("newOrder",new Order());
        map.addAttribute("productsMap", cartManager.getProductsFromCart(cart));
        map.addAttribute("totalPrice",cartManager.getTotalPrise(cart));

        return "order";
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String getFrom(@ModelAttribute("newOrder")Order order,Model map){

        //Make order validation
        ///Зроблено дуже погано, переробити
        //Дуже тупо!
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        order.setOrderStatus("unchecked");
        order.setSoldDate(new Date());
        order.setProductsQuantityMap(cart.getProductsCart());
        order.setUser(usersManager.findByEmail(auth.getName()));
        System.out.println(order.getId());
        orderManager.saveOrder(order);
        cart.clear();

        return "redirect:/";
    }


    @RequestMapping(value = "/projson", method = RequestMethod.GET)
    public
    @ResponseBody
    Products a(@RequestParam("id") int id) {
        cart.addProduct(id, 1);
        System.out.println("in a" + id);
        return productsManager.findProductById(id);
    }


    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.POST)
    public String addProductToCartPost(@PathVariable("id") int id) {
        cart.addProduct(id, 1);
        return "redirect:/main";
    }

    @RequestMapping(value = "/removeFromCart/{id}", method = RequestMethod.POST)
    public String removeFromCartREST(@PathVariable("id") int id) {
        cart.removeProduct(id);
        System.out.println(cart.getProductsCart());
        return "redirect:/cart";
    }



    @RequestMapping(value = "/cartJson", method = RequestMethod.GET)
    public
    @ResponseBody
    Cart getCartJson() {
        return cart;
    }


    /*
    * Тимчасові методи для провірки роботоспособності корзини
    *
    *
    * */
    @RequestMapping(value = "/removeFromCart", method = RequestMethod.POST)
    public @ResponseBody int removeFromCart(@RequestParam("id") int id) {
        System.out.println("in a add to cart" + id);
        cart.removeProduct(id);
        System.out.println(cartManager.getTotalPrise(cart));
        return  cartManager.getTotalPrise(cart);
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public @ResponseBody
    Products addToCart(@RequestParam("id") int id) {
        // /Переробити
        System.out.println("in add to cart");
        cart.addProduct(id, 1);
        return productsManager.findProductById(id);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(@RequestHeader("Referer") String from, Model map) {
        /*if (cart.getProductsCart().isEmpty()){
            return "redirect:/";
        }*/

        map.addAttribute("price", cartManager.getTotalPrise(cart));
        map.addAttribute("from", from);
        map.addAttribute("productsMap", cartManager.getProductsFromCart(cart));
        return "cart";
    }

    @RequestMapping(value = "/plusProductCart", method = RequestMethod.POST)
    public @ResponseBody String plusToCart(@RequestParam("id")int id) {
        cartManager.plusProducts(cart,id);

        Map<String,Integer> map= new HashMap<String, Integer>();
        map.put("total",cartManager.getTotalPrise(cart));
        map.put("amount",cartManager.getProductAmount(cart,id));
        map.put("pprice",cartManager.getProductsPrice(cart,id));
        map.put("id",id);

        return jsonMapper.getJson(map);
    }

    @RequestMapping(value = "/minusProductCart", method = RequestMethod.POST)
    public @ResponseBody String minusFromCart(@RequestParam("id")int id) {
        cartManager.minusProducts(cart, id);

        Map<String,Integer> map= new HashMap<String, Integer>();
        map.put("total",cartManager.getTotalPrise(cart));
        map.put("amount",cartManager.getProductAmount(cart,id));
        map.put("pprice",cartManager.getProductsPrice(cart,id));
        map.put("id",id);

        return jsonMapper.getJson(map);
    }








}
