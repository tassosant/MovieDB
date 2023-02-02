package tasos.mdb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tasos.mdb.models.Test;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1")
public class BasicController {
    @GetMapping(path = "hello")
    public ResponseEntity test(){
        return ResponseEntity.ok(new Test("hiiiii"));
    }

    @PostMapping(path = "hello")
    public ResponseEntity add(@RequestBody Test test) throws URISyntaxException {
        return ResponseEntity.created(new URI("hello-From-Created-Object")).build();
    }
}
