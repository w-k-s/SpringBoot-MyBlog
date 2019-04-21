package com.tribalscale.wks.myvlog;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/api")
@RestController
public class MyVlogApiController {

    @GetMapping("/vlogs")
    public ResponseEntity<List<Vlog>> listAllVlogs() {
        final List<Vlog> vlogs = Collections.singletonList(
                new Vlog(1, "Unboxing a box of matches", "https://youtube.com", 3600)
        );

        return ResponseEntity.ok(vlogs);
    }
}
