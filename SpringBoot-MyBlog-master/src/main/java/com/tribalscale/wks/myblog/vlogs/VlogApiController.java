package com.tribalscale.wks.myblog.vlogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class VlogApiController {

    private final VlogFeignClient vlogFeignClient;

    @Autowired
    public VlogApiController(VlogFeignClient vlogFeignClient) {
        this.vlogFeignClient = vlogFeignClient;
    }

    @GetMapping(value = "/vlogs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vlog> getAllVlogs() {
        return this.vlogFeignClient.getAllVlogs();
    }
}
