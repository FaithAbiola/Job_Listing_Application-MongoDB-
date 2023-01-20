package com.faithabiola.Joblisting.repositories;

import com.faithabiola.Joblisting.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
