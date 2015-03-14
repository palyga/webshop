package com.palyga.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Admin on 10.03.2015.
 */

@Component
public class FileValidator implements Validator {


    //Need to add checking
    //Only JPG,PNG,GIF
    //DO later
    @Override
    public boolean supports(Class<?> aClass) {
        return MultipartFile.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        MultipartFile file = (MultipartFile) object;
        validateSize(file, errors);
    }



    public void validateSize(MultipartFile file, Errors errors) {
        if ( file != null) {
            errors.rejectValue("file", "file.Size.NullFile", "Add File");
        }
        if (file.getSize() > 1048576) {
            errors.rejectValue("file", "file.Size.TooBigFile", "Add file with less size");
        }

    }

    public void validateType(MultipartFile file, Errors errors){
        if (!file.getContentType().equals("image/png") | !file.getContentType().equals("image/jpg")) {
            errors.rejectValue("file", "file.Size.TooBigFile", "Add file with less size");
        }
    }


}
