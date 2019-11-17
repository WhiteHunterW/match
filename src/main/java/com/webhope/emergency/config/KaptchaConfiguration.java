package com.webhope.emergency.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.google.code.kaptcha.util.Config;

import java.util.Properties;

/**
 * 加密
 * @author w.z
 * @date 2019/11/17 21:49
 */
@Component
public class KaptchaConfiguration {

    @Value("${kaptcha.border}")
    private String border;

    @Value("${kaptcha.border.color}")
    private String borderColor;

    @Value("${kaptcha.textproducer.font.color}")
    private String textproducerFontColor;

    @Value("${kaptcha.textproducer.font.size}")
    private String textproducerFontSize;

    @Value("${kaptcha.textproducer.font.names}")
    private String textproducerFontNames;

    @Value("${kaptcha.textproducer.char.length}")
    private String textproducerCharLength;

    @Value("${kaptcha.image.width}")
    private String imageWidth;

    @Value("${kaptcha.image.height}")
    private String imageHeight;

    @Value("${kaptcha.session.key}")
    private String sessionKey;

    @Value("${kaptcha.session.date}")
    private String sessionDate;

    @Bean
    public DefaultKaptcha getDefaultKapcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", border);
        properties.setProperty("kaptcha.border.color", borderColor);
        properties.setProperty("kaptcha.textproducer.font.color", textproducerFontColor);
        properties.setProperty("kaptcha.textproducer.font.size", textproducerFontSize);
        properties.setProperty("kaptcha.textproducer.font.names", textproducerFontNames);
        properties.setProperty("kaptcha.textproducer.char.length", textproducerCharLength);
        properties.setProperty("kaptcha.image.width", imageWidth);
        properties.setProperty("kaptcha.image.height", imageHeight);
        properties.setProperty("kaptcha.session.key", sessionKey);
        properties.setProperty("kaptcha.session.date",sessionDate);

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
