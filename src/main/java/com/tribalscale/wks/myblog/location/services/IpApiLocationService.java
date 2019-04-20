package com.tribalscale.wks.myblog.location.services;

import com.tribalscale.wks.myblog.location.models.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class IpApiLocationService implements IpLocationService {

    private final Logger logger = LoggerFactory.getLogger(IpApiLocationService.class);

    private final String IP_API_URL = "http://ip-api.com/json/";

    @Override
    public Location getLocation(@NonNull final String ipAddress) {
        String resolvedIp = ipAddress;

        if (ipAddress.equals("0.0.0.0.0.0.1")){
            resolvedIp = null;
        }

        final String templateUrl = IP_API_URL.concat(resolvedIp);
        Location location = null;

        try {
            RestTemplate template = new RestTemplate();
            location = template.getForObject(templateUrl, Location.class);
        } catch (RestClientException e) {
            logger.error(e.getMessage(), e);
        }

        return location;
    }
}
