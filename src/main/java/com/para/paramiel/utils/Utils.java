package com.para.paramiel.utils;

import java.util.Random;

public class Utils {

    public final static String  ALPHA_NUM = "AZERTYUIOPMLKJHQSDFGWNBXVCabcdefghijklmnopqrstuvwxyz0123456789";
    public final static String  ALPHA = "AZERTYUIOPMLKJHQSDFGWNBXVC";
    public final static String  NUM = "0123456789";

    public static final String generateId(){
        Random random = new Random();
        StringBuilder value = new StringBuilder();

        for(int i=0; i<8 ;i++){
      value.append(ALPHA_NUM.charAt(random.nextInt(ALPHA_NUM.length())));
        }

        return new String(value);
    }

    public static final String generateOrderRef(){
        Random random = new Random();
        StringBuilder value = new StringBuilder();

        for(int i=0; i<4 ;i++){
            value.append(ALPHA.charAt(random.nextInt(ALPHA.length())));
        }
        for(int i=0; i<8 ;i++){
            value.append(NUM.charAt(random.nextInt(NUM.length())));
        }

        return new String(value);
    }
}
