package org.mybatis.spring.day01.common;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @className Logs
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/318:15
 * @Version: 1.0
 *
 */
public class Logs {
    private  static Logger logger=Logger.getLogger(Logs.class);
    String logs="";

    /**
     *前置通知
     * @param joinPoint
     */
    public void before(JoinPoint joinPoint){
        logs="-----前置通知----------------类:"+joinPoint.getTarget().getClass().getName()+"\r\b方法:"+
                joinPoint.getSignature().getName()+"参数:"+joinPoint.getArgs().toString()+"开始执行-------------Start---------------------";
        logger.info(logs);
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    public  void after(JoinPoint joinPoint){
        logs="-----后置通知----------------"+"类"+joinPoint.getTarget().getClass().getName()+"\r\b方法:" +
                joinPoint.getSignature().getName()+"参数"+joinPoint.getArgs().toString()+"执行结束-------------------End-----------------";
        logger.info(logs);
    }

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     */
    public  Object around(ProceedingJoinPoint joinPoint){
        Object result=null;
        try{
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logs="-----环绕通知----------------"+"类:"+joinPoint.getTarget().getClass().getName()+"的方法:"+
                    joinPoint.getSignature().getName()+"执行出错"+
                    "出错信息:"+throwable.getMessage();
            logger.info(logs);
        }
        return result;
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param e
     */
    public  void afterThrowing(JoinPoint joinPoint,Exception e){
        logs="-----异常通知----------------"+"类:"+joinPoint.getTarget().getClass().getName()+"！方法:"+
                joinPoint.getSignature().getName()+"参数"+joinPoint.getArgs().toString()+
                "报错详情:"+e.getMessage()+"---------------------ERROR-----------------------";
        logger.info(logs);
    }
    //在方法正常结束后要执行的代码
    //返回通知是可以访问到方法的返回值的
    public void afterReturning(JoinPoint joinPoint,Object result)
    {
        logs="-----返回通知----------------"+joinPoint.getTarget().getClass().getName()+"类的"
                +joinPoint.getSignature().getName()+"方法返回的"+result.getClass().getName();
        logger.info(logs);
    }
}
