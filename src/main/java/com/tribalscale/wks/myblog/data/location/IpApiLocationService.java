package com.tribalscale.wks.myblog.data.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class IpApiLocationService implements IpLocationService {

    private final Logger logger = LoggerFactory.getLogger(IpApiLocationService.class);

    private final String IP_API_URL = "http://ip-api.com/json/";

    @Override
    public Location getLocation(@NonNull final String ipAddress) {

        Location location = null;

        try {
            RestTemplate template = new RestTemplate();
            location = template.getForObject(createRequestUrl(ipAddress), Location.class);
        } catch (RestClientException e) {
            logger.error(e.getMessage(), e);
        }

        return location;
    }

    @Override
    public Mono<Location> getLocationNonBlocking(@NonNull String ipAddress) {
        return WebClient.create(createRequestUrl(ipAddress))
                .get()
                .retrieve()
                .bodyToMono(Location.class);
    }

    @NonNull
    private String createRequestUrl(@NonNull String ipAddress) {
        Assert.notNull(ipAddress, "ipAddress");

        String resolvedIp = ipAddress;

        if (ipAddress.equals("0:0:0:0:0:0:0:1")) {
            resolvedIp = "";
        }

        return IP_API_URL.concat(resolvedIp);
    }
}
