package com.webhope.emergency.controller;

import com.webhope.emergency.enums.ErrorCodeEnum;
import com.webhope.emergency.util.ResultUtil;
import com.webhope.emergency.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author w.z
 * @date 2019/11/17 21:55
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 学生用户登录
     * @param stname
     * @param studentno
     * @return
     */
    @GetMapping(value = "/login")
    public ResultVo login(String stname, String studentno, String imageCode, HttpServletRequest request){
        if (StringUtils.isEmpty(studentno) || StringUtils.isEmpty(imageCode) || StringUtils.isEmpty(stname)){
            log.error("登录参数不能为空");
        }
        HttpSession session = request.getSession();
        String image = (String)session.getAttribute("image");
        return ResultUtil.error(ErrorCodeEnum.DATA_ERROR);
    }
}
