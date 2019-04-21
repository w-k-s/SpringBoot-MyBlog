package com.tribalscale.wks.myblog.vlogs;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("com.tribalscale.wks.myvlog")
public interface VlogFeignClient {

    @RequestMapping("/api/vlogs")
    List<Vlog> getAllVlogs();
}
