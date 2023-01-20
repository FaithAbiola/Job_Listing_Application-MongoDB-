package com.faithabiola.Joblisting.controller;

import com.faithabiola.Joblisting.models.Post;
import com.faithabiola.Joblisting.repositories.PostRepository;
import com.faithabiola.Joblisting.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository srepo;
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/posts") // To fetch data
    public List<Post> getAllPosts() {

        return repo.findAll();
    }
    // posts/java
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) { //what the user is passing

        return srepo.findByText(text);
    }

    @PostMapping("/posts") //To submit data
    public Post addPost(@RequestBody Post post){ //RequestBody is used to accept the data, Post is the object where it will receive the data, any data receive from the client side will be accepted in the post object
        return repo.save(post); // The save method will accept the post object, and return the object of post
    }
}
