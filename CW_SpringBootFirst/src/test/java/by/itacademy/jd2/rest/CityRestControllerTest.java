package by.itacademy.jd2.rest;

import by.itacademy.jd2.MockUtils;
import by.itacademy.jd2.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMocks;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class CityRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CityService cityService;

    @BeforeEach
    public void setUp() {
        Mockito.doAnswer(new ReturnsMocks() {
            public Object answer(InvocationOnMock invocation) {
                return MockUtils.createCities();
            }
        }).when(cityService).getCities();
    }

    @Test
    void checkCities() throws Exception {
        Map<String, Object> params = new HashMap<>();
        checkPerform(params, "/cities-rest");
    }

    private void checkPerform(Map<String, Object> params, String url) throws Exception {
        mockMvc.perform(get(getUri(params, url))
                .headers(getHttpHeaders())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private HttpHeaders getHttpHeaders() {
        return new HttpHeaders();
    }

    private URI getUri(Map<String, Object> params, String url) {
        return new UriTemplate(url).expand(params);
    }
}