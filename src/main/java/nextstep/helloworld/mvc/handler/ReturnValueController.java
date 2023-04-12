package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @GetMapping(path = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String string() {
        return "message";
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User responseBodyForUser() {
        return new User("name", "email");
    }


    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> responseEntity(@PathVariable Long id) {
        return ResponseEntity.ok(new User(id, "name", "email"));
    }

    @GetMapping(path = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "/thymeleaf", produces = MediaType.TEXT_HTML_VALUE)
    public String thymeleaf() {
        return "sample";
    }
}
