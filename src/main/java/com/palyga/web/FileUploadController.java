package com.palyga.web;


import com.palyga.components.impl.FileUpload;
import com.palyga.components.impl.ImageEncoderPath;
import com.palyga.service.FileManager;
import com.palyga.validation.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Admin on 06.03.2015.
 */

@Controller
public class FileUploadController {

    @Autowired
    FileManager fileManager;

    @Autowired
    ImageEncoderPath imageEncoderPath;

    @Autowired
    FileValidator fileValidation;

    @RequestMapping(value = "/addFile", method = RequestMethod.GET)
    public String displayForm() {
        return "file_upload_form";
    }


    @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void saveFile(
            @ModelAttribute("uploadForm") FileUpload uploadForm, @RequestParam("pname") String productName
            , Model map) {

        //Check FileValidator and add

        List<MultipartFile> files = uploadForm.getFiles();


        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                fileManager.createFile(fileName, multipartFile);
            }
        }
    }


}