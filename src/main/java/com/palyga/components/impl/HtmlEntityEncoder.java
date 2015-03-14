package com.palyga.components.impl;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by Admin on 12.03.2015.
 */

public class HtmlEntityEncoder {

    public static String htmlEncode(String text){

        return StringEscapeUtils.escapeHtml4(text);
    }

}
