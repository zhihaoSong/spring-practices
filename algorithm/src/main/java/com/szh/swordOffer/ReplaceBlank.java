package com.szh.swordOffer;

/**
 * 2.替换空格
 */
public class ReplaceBlank {
    public String replaceBlank(String input) {
        if (null == input || input.length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public String replaceByRegex(String input) {
        if (null == input) {
            return null;
        }
        return input.replace(" ", "%20");
    }

    public String replaceSpace1(StringBuffer str) {
        if (str == null)
            return null;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
            }
        }
        return new String(str);
    }

    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        int containCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                containCount++;
        }
        if (containCount <= 0)
            return new String(str);
        int originLen = str.length();
        int afterLen = originLen + 2 * containCount;
        char[] afterArray = new char[afterLen];
        while (originLen > 0) {
            if (str.charAt(originLen - 1) == ' ') {
                afterArray[--afterLen] = '0';
                afterArray[--afterLen] = '2';
                afterArray[--afterLen] = '%';

            } else
                afterArray[--afterLen] = str.charAt(originLen - 1);
            originLen--;
        }
        return new String(afterArray);
    }

    public static void main(String[] args) {
        ReplaceBlank rb = new ReplaceBlank();
        String s = "";
        System.out.println(rb.replaceBlank(s));
        System.out.println(rb.replaceByRegex(s));
    }
}
