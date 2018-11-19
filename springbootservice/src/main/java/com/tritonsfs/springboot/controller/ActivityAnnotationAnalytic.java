//package com.tritonsfs.springboot.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.tritonsfs.cac.depository.core.dto.ResultBean;
//import com.tritonsfs.cac.depository.entity.vo.act.ActivityVO;
//import com.tritonsfs.cac.depository.util.constant.BizPrompt;
//import com.tritonsfs.cac.tools.LogTrace;
//import com.tritonsfs.springboot.annot.ActivityAnnotation;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @author 2018/11/16 15:27 by 刘赵强
// **/
//@Aspect
//@Component
//public class ActivityAnnotationAnalytic extends ActivityBaseController {
//
//    private static final LogTrace LOGGER = new LogTrace(ActivityAnnotationAnalytic.class);
//
//    @Around(value = "@annotation(ActivityAnnotation)")
//    public String interceptor(ProceedingJoinPoint pjp) throws Throwable {
//        ActivityAnnotation activityAnnotation = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(ActivityAnnotation.class);
//        String activityId = activityAnnotation.activityId();
//        if (StringUtils.isEmpty(activityId)) {
//            LOGGER.errorApp("activityId is null");
//            throw new IllegalArgumentException("activityId must not null");
//        }
//        //是否验证活动结束
//        boolean validActivityEnd = activityAnnotation.validActivityEnd();
//        //获取请求参数
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String userId = request.getParameter("userId");
//        String loginToken = request.getParameter("loginToken");
//        String callBackFunc = request.getParameter("callBackFunc");
//        //活动实体
//        ResultBean<ActivityVO> activityBean;
//        try {
//            activityBean = (ResultBean<ActivityVO>) sendActivity("activityServiceImpl", "getActivityVOById", activityId);
//        } catch (Exception e) {
//            LOGGER.errorApp("查询活动信息异常 activityId={},errorMsg={}", activityId, e.getMessage(), e);
//            return returnString(callBackFunc, new ResultBean<>(BizPrompt.SYSERR));
//        }
//        ResultBean<?> resultBean = validateLoginAndActivity(userId, loginToken, activityBean.getModel(), validActivityEnd);
//        if (BizPrompt.SUCCESS.getCode().equals(resultBean.getReturnCode())) {
//            try {
//                //返回的model
//                Object proceed = pjp.proceed();
//                if (!validActivityEnd && activityEnd(activityBean.getModel())) {
//                    // 活动已结束
//                    resultBean = new ResultBean(BizPrompt.ACTIVITY_ALREADY_END, proceed);
//                } else {
//                    resultBean = new ResultBean(BizPrompt.SUCCESS, proceed);
//                }
//            } catch (Exception e) {
//                LOGGER.errorApp("异常errorMsg={}", e.getMessage());
//                resultBean = new ResultBean<>(BizPrompt.SYSERR);
//            }
//        }
//        return returnString(callBackFunc, resultBean);
//    }
//
//    /**
//     * 返回json格式数据或者jsonp格式数据
//     *
//     * @param callBackFunc jsonp回调方法
//     * @param resultBean   结果集
//     * @return 返回字符串
//     */
//    private String returnString(String callBackFunc, ResultBean<?> resultBean) {
//        if (StringUtils.isNotEmpty(callBackFunc)) {
//            return callBackFunc + "(" + JSON.toJSONString(resultBean) + ")";
//        } else {
//            return JSON.toJSONString(resultBean);
//        }
//    }
//}
//
//
