package com.myjava.pattern.multiton;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

//多例模式    参考 《java设计与模式》
public class LingualResource {

    private String language = "en";
    private String region = "US";
    private String localeCode = "en_US";
    private static final String FILE_NAME = "res";
    private static HashMap instances = new HashMap();
    private Locale locale = null;
    private ResourceBundle resourceBundle = null;
    private LingualResource lnkLingualResource;

    private LingualResource(String language, String region) {
        this.localeCode = language;
        this.region = region;
        localeCode = makeLocaleCode(language, region);
        locale = new Locale(language, region);
        resourceBundle = ResourceBundle.getBundle(FILE_NAME, locale);
        instances.put(makeLocaleCode(language, region), resourceBundle);

    }

    private LingualResource() {
    }

    /**
     * 工厂方法，返回一个具有指定的内部状态的实例
     * */
    public synchronized static LingualResource getInstance(String language, String region) {
        // if (makeLocaleCode(language, region)) {
        // return (LingualResource) makeLocaleCode(language, region);
        // } else {
        return new LingualResource(language, region);
        // }
    }

    public String getLocaleString(String code) {
        return resourceBundle.getString(code);
    }

    private static String makeLocaleCode(String language, String region) {
        return language + "_" + region;
    }
}
