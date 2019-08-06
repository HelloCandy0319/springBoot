package com.example.demo.sercurity;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * 未登录成功，saveRequest类中保存请求URL
 * 登录成功后，从session中获取之前的请求URL，进行操作。
 * SavedRequestAwareAuthenticationSuccessHandler.onAuthenticationSuccess()方法
 */
public class UserLoginSaveRequestSessionSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//    protected final Log logger = LogFactory.getLog(UserLoginSaveRequestSessionSuccessHandler.class);
//    private RequestCache requestCache = new HttpSessionRequestCache();
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        SavedRequest savedRequest = this.requestCache.getRequest(request, response);
//        if (savedRequest == null) {
//            super.onAuthenticationSuccess(request, response, authentication);
//        } else {
//            String targetUrlParameter = this.getTargetUrlParameter();
//            if (!this.isAlwaysUseDefaultTargetUrl() && (targetUrlParameter == null || !StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
//                this.clearAuthenticationAttributes(request);
//                String targetUrl = savedRequest.getRedirectUrl();
//                this.logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
//                this.getRedirectStrategy().sendRedirect(request, response, targetUrl);
//            } else {
//                this.requestCache.removeRequest(request, response);
//                super.onAuthenticationSuccess(request, response, authentication);
//            }
//        }
//    }
}
