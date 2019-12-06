package com.jiabiango.hr.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.jiabiango.hr.config.bean.JsonResponseWrapper;
import com.jiabiango.hr.config.security.UserHelper;
import com.jiabiango.hr.constant.ApiResultCode;
import com.jiabiango.hr.dto.UserMenuDto;
import com.jiabiango.hr.exception.CaptchaIncorrectException;
import com.jiabiango.hr.service.UserRoleService;
import com.jiabiango.hr.util.JsonUtil;
import com.jiabiango.hr.util.RequestUtil;

@Controller
@RequestMapping("/admin")
public class PlatformController {
    @Autowired
    private UserRoleService userRoleService;
    
    @Autowired
    private UserHelper userHelper;

    @SuppressWarnings("unchecked")
    @RequestMapping({"/","/index.html"})
    public ModelAndView index(HttpSession session, HttpServletRequest request, Model model) {
        if (RequestUtil.isAjax(request)) {
            JsonResponseWrapper jsonWrapper = new JsonResponseWrapper();
            jsonWrapper.setResCode(ApiResultCode.API_SUCCESS_CODE);
            String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath() + request.getServletPath();  
            jsonWrapper.setData(url);
            View view = createJsonView(jsonWrapper);
            return new ModelAndView(view);
        } else {
            String attributeName = "USER_MENU";
            List<UserMenuDto> userMenus = (List<UserMenuDto>)session.getAttribute(attributeName);
            if(userMenus == null) {
                userMenus = userRoleService.getUserMenu(userHelper.getCurrentUser().getId());
                session.setAttribute("USER_MENU", userMenus);
            }
            model.addAttribute("menus",userMenus);
            return new ModelAndView("index");
        }
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/home.html")
    public String platform() {
        return "home";
    }
    
    @RequestMapping("/login/failure")
    public ModelAndView loginFailure(HttpServletRequest request) {
        if (RequestUtil.isAjax(request)) {
            String resInfo = "登录失败";
            AuthenticationException ex = (AuthenticationException)request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if(ex instanceof CaptchaIncorrectException) {
                return createJsonView(ApiResultCode.CAPTCHA_ERR_CODE, ex.getMessage());
            } else if(ex instanceof DisabledException) {
                resInfo = "用户已被禁用，请与管理员联系！";
            } else if(ex instanceof AccountExpiredException) {
                resInfo = "用户已过期，请与管理员联系！";
            } else if(ex instanceof LockedException) {
                resInfo = "用户已被锁定，请与管理员联系！";
            } else if(ex instanceof BadCredentialsException) {
                resInfo = "用户名或密码错误";
            } else if(ex instanceof UsernameNotFoundException) {
                resInfo = "用户名或密码错误";
            }
            return createJsonView(ApiResultCode.API_ERR_CODE, resInfo);
        } else {
            return new ModelAndView("/login");
        }
    }
    
    @GetMapping("/logout/success")
    public ModelAndView logout(HttpServletRequest request) {
        if (RequestUtil.isAjax(request)) {
            return createJsonView(ApiResultCode.API_SUCCESS_CODE, null);
        } else {
            return new ModelAndView("forward:/login");
        }
    }
    
    @RequestMapping("/access/denied")
    public ModelAndView accessDenied(HttpServletRequest request) {
        if (RequestUtil.isAjax(request)) {
            return createJsonView(ApiResultCode.API_ACCESS_DENIED_CODE, ApiResultCode.API_ACCESS_DENIED_CODE_MSG);
        } else {
            return new ModelAndView("access_denied");
        }
    }

    private ModelAndView createJsonView(String resCode, String resInfo) {
        JsonResponseWrapper jsonWrapper = new JsonResponseWrapper();
        jsonWrapper.setResCode(resCode);
        jsonWrapper.setResInfo(resInfo);
        View view = createJsonView(jsonWrapper);
        return new ModelAndView(view);
    }

    @SuppressWarnings("unchecked")
    private View createJsonView(JsonResponseWrapper jsonWrapper) {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        String json = JsonUtil.toJson(jsonWrapper);
        view.setAttributesMap(JsonUtil.parse(json, HashMap.class));
        return view;
    }
}