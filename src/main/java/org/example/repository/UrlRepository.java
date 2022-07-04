package org.example.repository;


import org.example.entity.UrlEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends CrudRepository<UrlEntity, Long> {

    UrlEntity findUrlEntityByOriginalUrl(String originalUrl);

    UrlEntity findUrlEntityByAlias(String alias);
}
