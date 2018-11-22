package com.mhp.coding.challenges.mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListWith1001OnFirstPosition() throws Exception {
        this.mockMvc.perform(get("/article"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("[{\"id\":1001,\"title\":\"Article Nr.: 1001\",\"description\":\"Article Description 1001\",\"author\":\"Max Mustermann\",\"blocks\":[{\"sortIndex\":0,\"text\":\"Some Text for 1001\"},{\"sortIndex\":1,\"image\":{\"id\":1,\"url\":\"https://someurl.com/image/1\",\"imageSize\":\"LARGE\"}},{\"sortIndex\":2,\"text\":\"Second Text for 1001\"},{\"sortIndex\":3,\"images\":[{\"id\":2,\"url\":\"https://someurl.com/image/2\",\"imageSize\":\"LARGE\"},{\"id\":3,\"url\":\"https://someurl.com/image/3\",\"imageSize\":\"LARGE\"}]}")));
    }

    @Test
    public void testDetailsFor3003() throws Exception {
        this.mockMvc.perform(get("/article/3003"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"id\":3003,\"title\":\"Article Nr.: 3003\",\"description\":\"Article Description 3003\",\"author\":\"Max Mustermann\",\"blocks\":[{\"sortIndex\":0,\"text\":\"Some Text for 3003\"},{\"sortIndex\":1,\"image\":{\"id\":1,\"url\":\"https://someurl.com/image/1\",\"imageSize\":\"LARGE\"}},{\"sortIndex\":2,\"text\":\"Second Text for 3003\"},{\"sortIndex\":3,\"images\":[{\"id\":2,\"url\":\"https://someurl.com/image/2\",\"imageSize\":\"LARGE\"},{\"id\":3,\"url\":\"https://someurl.com/image/3\",\"imageSize\":\"LARGE\"}]},{\"sortIndex\":4,\"text\":\"Third Text for 3003\"},{\"sortIndex\":5,\"url\":\"https://youtu.be/myvideo\",\"type\":\"YOUTUBE\"}]}")));
    }

    @Test
    public void testDetailsFor3004Should404() throws Exception {
        this.mockMvc.perform(get("/article/3004"))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
    }
}
