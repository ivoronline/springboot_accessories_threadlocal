package com.ivoronline.springboot_accessories_threadlocal.interceptor;

import com.ivoronline.springboot_accessories_threadlocal.context.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserInterceptor implements HandlerInterceptor {

  //=========================================================================================================
  // PRE HANDLE
  //=========================================================================================================
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String user = request.getParameter("user");
    UserContext.setUser(user);
    return true;
  }

  //=========================================================================================================
  // AFTER COMPLETION
  //=========================================================================================================
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    UserContext.clear();
  }
  
}