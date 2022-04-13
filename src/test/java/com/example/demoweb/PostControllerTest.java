package com.example.demoweb;

import com.example.demoweb.model.Post;
import com.example.demoweb.repository.PostRepository;
import com.example.demoweb.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @MockBean
    private PostRepository postRepository;

    @Autowired
    PostService postService;

    @Test
    public void createPostTest(){
        Post post =  postService.create("test-post");
        Mockito.verify(postRepository, Mockito.times(1)).save(post);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postRedirectTest() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/new");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }
}