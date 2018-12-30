package it.unisalento.controllers.rest;

import com.google.gson.Gson;
import it.unisalento.model.BuyEntity;
import it.unisalento.model.ProductEntity;
import it.unisalento.model.UserEntity;
import it.unisalento.model.details.BuysData;
import it.unisalento.model.details.User;
import it.unisalento.model.persistence.inter.BuyService;
import it.unisalento.model.persistence.inter.ProductService;
import it.unisalento.model.persistence.inter.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/user")
public class UserRestController {
    private final static Logger log = LoggerFactory.getLogger(UserRestController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private BuyService buyService;
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity test() {
        log.info("Class: " + UserRestController.class);
        log.info("Test");
        return ResponseEntity.ok(new JSONObject().put("info", "Test is successful").toString());
    }

    @GetMapping(value = "/purchases", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getUserPurchases() {

        List<Object[]> buys = buyService.listBuyUser(User.getInstance().getEntity());
        Gson gson = new Gson();
        BuysData a = new BuysData();
        a.createObjectJson(buys);
        String json = gson.toJson(a);
        log.info("JSON: " + json);
        return ResponseEntity.ok(json);
    }

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getUserInfo() {
        Gson gson = new Gson();
        String json = gson.toJson(User.getInstance().getEntity());
        return ResponseEntity.ok(json);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity deleteBuy(@PathVariable String id) {

        log.debug("Id: " + id);

        BuyEntity b = buyService.buyFromTimeStamp(id);
        if (b == null) {
            log.warn("Buy is null. Check in db [" + id + "]");
            return ResponseEntity.ok(new JSONObject().put("ERROR", "Delete item failure"));
        }
        buyService.delete(b);
        return ResponseEntity.ok(new JSONObject().put("OK", "Delete item successfully"));
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity updateUser(@RequestBody String json) {
        log.info("String Json: " + json);
        Gson gson = new Gson();
        UserEntity u = gson.fromJson(json, UserEntity.class);
        u.setIdUser(User.getInstance().getEntity().getIdUser());
        log.debug("email: " + u.getEmail() + " username " + u.getUsername()
                + " password " + u.getPassword() + " lastname " + u.getLastname() + " firstname " + u.getFirstname()
                + " id: " + u.getIdUser());
        userService.update(u);
        return ResponseEntity.ok(new JSONObject().put("OK", "User saved"));
    }

    @GetMapping(value = "/getProducts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getProducts() {
        log.info("Get products");
        List<ProductEntity> e = productService.list();
        Gson gson = new Gson();
        String json = gson.toJson(e);
        return ResponseEntity.ok(json);
    }

    @PostMapping(value = "/addproduct", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity addProduct(@RequestBody String json) {
        log.info("String Json: " + json);
        Gson gson = new Gson();
        ProductEntity p = gson.fromJson(json, ProductEntity.class);
        log.debug("name " + p.getName() + " quantity: " + p.getQuantity() + " price: " + p.getPrice());
        productService.save(p);
        return ResponseEntity.ok(new JSONObject().put("OK", "Product saved"));
    }

    @GetMapping(value = "/buy/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity buyProduct(@PathVariable String id) {
        log.debug("Id: " + id);
        BuyEntity b = new BuyEntity();
        b.setUserIdUser(User.getInstance().getEntity().getIdUser());
        b.setProductIdProduct(Integer.parseInt(id));
        b.setDate(new Timestamp(System.currentTimeMillis()));
        buyService.save(b);
        return ResponseEntity.ok(new JSONObject().put("OK", "Add product successfully"));
    }
}
