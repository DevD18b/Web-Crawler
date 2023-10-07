package com.company;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class howToExtractQueryParameterFromUrl {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        String url = "http://localhost:8010/index.html?search=My+name+is+dev+1+2+3+%25+%26++%24+%23+";

        String url2 = "";
        String decodeURL=URLDecoder.decode( url, "UTF-8" );
        System.out.println("Decoded URL: " + decodeURL);
        String encodeURL = encode(url2);
        System.out.println("Encoded URL2: " + encodeURL);
    }

    public static String decode(String url) {
        try {
            String prevURL = "";
            String decodeURL = url;
            while (!prevURL.equals(decodeURL)) {
                prevURL = decodeURL;
                decodeURL = URLDecoder.decode(decodeURL, "UTF-8");
            }
            return decodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Issue while decoding" + e.getMessage();
        }
    }

    public static String encode(String url) {

        try {
            String encodeURL = URLEncoder.encode(url, "UTF-8");
            return encodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Issue while encoding" + e.getMessage();
        }
    }
}