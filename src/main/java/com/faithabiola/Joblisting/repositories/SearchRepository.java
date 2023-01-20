package com.faithabiola.Joblisting.repositories;

import com.faithabiola.Joblisting.models.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
