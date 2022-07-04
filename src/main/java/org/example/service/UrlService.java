package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.UrlEntity;
import org.example.model.Url;
import org.example.repository.UrlRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepo;
    public Url shortenUrl(Url url) {
        UrlEntity urlEntity = urlRepo.findUrlEntityByOriginalUrl(url.getOriginalUrl());

        if(urlEntity == null) {
            urlEntity = new UrlEntity();
            urlEntity.setOriginalUrl(url.getOriginalUrl());
        }
        urlEntity.setAlias(url.getAlias());
        urlRepo.save(urlEntity);

        return mapEntityToModel(urlEntity);
    }

    public String getShortenUrl(String alias) {
        UrlEntity urlEntity = urlRepo.findUrlEntityByAlias(alias);
        return urlEntity.getAlias();
    }

    private Url mapEntityToModel(UrlEntity urlEntity) {
        Url url = new Url();
        url.setOriginalUrl(urlEntity.getOriginalUrl());
        url.setAlias(urlEntity.getAlias());
        return url;
    }
}
