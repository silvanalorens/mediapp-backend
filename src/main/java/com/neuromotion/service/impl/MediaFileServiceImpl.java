package com.neuromotion.service.impl;

import com.neuromotion.model.MediaFile;
import com.neuromotion.repo.IGenericRepo;
import com.neuromotion.repo.IMediaFileRepo;
import com.neuromotion.service.IMediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaFileServiceImpl extends CRUDImpl<MediaFile, Integer> implements IMediaFileService {

    @Autowired
    private IMediaFileRepo repo;

    @Override
    protected IGenericRepo<MediaFile, Integer> getRepo() {
        return repo;
    }
}
