package com.palyga.service.impl;


import com.palyga.service.FileManager;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Василь on 25.02.2015.
 */

@Service
public class FileManagerImpl implements FileManager {

    private OutputStream outputStream;
    private InputStream inputStream;

    @Override
    public void createFile(String fileName, MultipartFile file) {
        try {
            File newFile = new File("C:/picture/" + fileName);
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            byte[] bytes = file.getBytes();
            outputStream = new FileOutputStream(newFile);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFile(String fileName) {
        try {
            File file = new File(fileName);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] getFile(String fileName) {
        String location = "C:/picture/";
        String file = fileName + ".jpg";
        String fileLocation = location + file;
        byte[] array;

        if (isFileExist(fileLocation)) {
            try {
                InputStream is = new FileInputStream(fileLocation);
                array = IOUtils.toByteArray(is);
                return array;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public boolean isFileExist(String fileName) {
        File file = new File(fileName);
        return (file.exists() && !file.isDirectory());
    }
}
