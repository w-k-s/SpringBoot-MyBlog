package com.tribalscale.wks.myblog.location.controllers.api;

import com.tribalscale.wks.myblog.data.location.Location;
import com.tribalscale.wks.myblog.data.location.IpLocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LocationApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IpLocationService ipLocationService;

    @Test
    public void getLocationReturnsLocation() throws Exception {
        Location location = new Location(10.0,20.0,"Johannesberg","South Africa");
        when(ipLocationService.getLocation("")).thenReturn(location);

        mockMvc.perform(get("/api/location").with(user("waqqas").password("password")))
                .andExpect(status().isOk())
                .andExpect(content().string(contains("South Africa")));

    }
}
