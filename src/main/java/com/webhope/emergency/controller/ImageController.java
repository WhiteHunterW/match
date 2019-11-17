package com.webhope.emergency.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 获取图形验证码
 * @author w.z
 * @date 2019/11/17 21:54
 */
@Slf4j
public class ImageController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /**
     * 获取图形验证码
     * @param request
     * @param response
     */
    @GetMapping(value = "/code",produces = "image/jpg")
    @ApiOperation("获取验证码")
    public void setDefaultKaptcha(HttpServletRequest request, HttpServletResponse response){
        // 定义字节数组
        byte[] captchaChallengeAsJpeg;
        // 定义字节输出流
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

        // 生成四位的验证码
        String codeText = defaultKaptcha.createText();
        HttpSession session = request.getSession();
        // 将验证码保存到session中
        session.setAttribute("image",codeText);
        // 生成图形验证码
        BufferedImage challenge = defaultKaptcha.createImage(codeText);
        // 转为byte并放在字节输出数组
        try {
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        } catch (IOException e){
            log.error("ImageController#setDefaultKaptcha: image create error.");
        }

        /**
         * 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
         */
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        try {
            ServletOutputStream servletOutputStream = response.getOutputStream();
            servletOutputStream.write(captchaChallengeAsJpeg);
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (IOException e) {
            log.error("ImageController#defaultKaptcha: 输出验证码失败， e={}. ", e);
        }
    }
}
