package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.BlogPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogPostDAO extends CrudRepository<BlogPost, Integer> {


    List<BlogPost> findBySubCategoryAndPublishEquals(String subCategory, int publish);
    List<BlogPost> findTop3ByLabelContainingAndPublishEquals(String label, int publish);

    BlogPost findByShortUrl(String shortUrl);

    BlogPost findByShortUrlAndPublishEquals(String shortUrl,int publish);

    List<BlogPost> findByCategoryAndPublishLessThan(String cat, int publish);

    List<BlogPost> findBySiteAndPublishEquals(String site, int publish);


}
