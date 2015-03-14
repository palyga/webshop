package com.palyga.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Василь on 25.02.2015.
 */
public interface FileManager {

    public void createFile(String fileName, MultipartFile file);

    public void deleteFile(String fileName);

    public byte[] getFile(String fileName);
}
