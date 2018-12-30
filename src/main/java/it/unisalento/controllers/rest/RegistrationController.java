package it.unisalento.controllers.rest;

import com.google.gson.Gson;
import it.unisalento.model.UserEntity;
import it.unisalento.model.persistence.inter.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final static Logger log = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity test() {
        log.info("Test");
        return ResponseEntity.ok(new JSONObject().put("info", "Test is successful").toString());
    }

    @GetMapping(value = "/info/{info}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity user(@PathVariable String info) {
        log.debug("Path info: " + info);
        return ResponseEntity.ok(new JSONObject().put("info", "Received"));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity saveUser(@RequestBody String json) {
        log.info("String Json: " + json);
        Gson gson = new Gson();
        UserEntity u = gson.fromJson(json, UserEntity.class);
        log.debug("email: " + u.getEmail() + " username " + u.getUsername()
                + " password " + u.getPassword() + " lastname " + u.getLastname() + " firstname " + u.getFirstname());
        userService.save(u);
        return ResponseEntity.ok(new JSONObject().put("OK", "User saved"));
    }
}

