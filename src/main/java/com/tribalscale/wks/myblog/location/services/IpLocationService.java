package com.tribalscale.wks.myblog.location.services;

import com.tribalscale.wks.myblog.location.models.Location;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface IpLocationService {
    @Nullable
    Location getLocation(@NonNull String ipAddress);
}
