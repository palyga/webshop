package com.palyga.validation;

import com.palyga.model.Products;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Admin on 09.03.2015.
 */
@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Products.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }

    public void validateName(String name,Errors errors){
        if(name==null || name.isEmpty()){
            errors.rejectValue("name", "product.Name.emptyName","Enter a Product Name");
        }
    }

    public void validatePrice(int price,Errors errors){
        if(price<0 | price >9999 ){
            errors.rejectValue("price", "product.Price.lessThan0","Enter a Correct Price");
        }
    }

    public void validateCategory(String category,Errors errors){
        if(category==null || category.isEmpty()){
            errors.rejectValue("category", "product.Category.emptyName","Enter a Category");
        }
    }


}
