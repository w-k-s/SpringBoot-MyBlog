package com.tribalscale.wks.myblog.data.location;

import com.tribalscale.wks.myblog.data.location.Location;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import reactor.core.publisher.Mono;

public interface IpLocationService {

    @Nullable
    Location getLocation(@NonNull String ipAddress);

    @NonNull
    Mono<Location> getLocationNonBlocking(@NonNull String ipAddress);
}
