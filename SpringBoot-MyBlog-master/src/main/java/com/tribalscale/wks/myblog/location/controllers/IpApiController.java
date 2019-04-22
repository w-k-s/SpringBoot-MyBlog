package com.tribalscale.wks.myblog.location.controllers;

import com.tribalscale.wks.myblog.data.location.IpLocationService;
import com.tribalscale.wks.myblog.data.location.Location;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class IpApiController {

    private final IpLocationService ipLocationService;

    public IpApiController(IpLocationService ipLocationService) {
        this.ipLocationService = ipLocationService;
    }

    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getLocation(HttpServletRequest request) {
        Location location = this.ipLocationService.getLocation(request.getRemoteAddr());

        if (location == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(location);
    }

    @GetMapping(value = "/v2/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Location> getLocationNonBlocking(HttpServletRequest request) {
        return ipLocationService.getLocationNonBlocking(request.getRemoteAddr());
    }
}
