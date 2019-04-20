package com.tribalscale.wks.myblog.location.controllers.api;

import com.tribalscale.wks.myblog.location.models.Location;
import com.tribalscale.wks.myblog.location.services.IpLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class IpApiController {

    private final IpLocationService ipLocationService;

    public IpApiController(IpLocationService ipLocationService) {
        this.ipLocationService = ipLocationService;
    }

    @GetMapping("/location")
    public ResponseEntity<Location> getLocation(HttpServletRequest request) {
        Location location = this.ipLocationService.getLocation(request.getRemoteAddr());

        if (location == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(location);
    }
}
