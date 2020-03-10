package com.fatihmayuk.gridfs.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    @Autowired
    private GridFsTemplate gridFsTemplate;


    public void uploadFile(MultipartFile file) throws IOException {

        DBObject dbObject = new BasicDBObject();
        dbObject.put("fileName", file.getOriginalFilename());
        dbObject.put("contentType", file.getContentType());
        dbObject.put("size", file.getSize());
        dbObject.put("userId", "12345");
        ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(),dbObject);
        System.out.println(id.toString());

    }

}
