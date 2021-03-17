package cn.catgod.mvc.retry;

import org.springframework.aop.framework.AopContext;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * @author weiqiang.lin
 * @version 1.0
 * @date 2020/10/20
 */
@Component
public class WorkService {

    public static int workTime;

//    @Retryable(include = IllegalArgumentException.class
//            , maxAttempts = 2, backoff = @Backoff(delay = 100))
    public void fire(){
        doFire();
    }


    public void fire2(){
        ((WorkService)AopContext.currentProxy()).doFire();
    }

    @Retryable(include = IllegalArgumentException.class
            , maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression ="${retry.maxDelay}"))
    public void doFire(){
        workTime++;
        System.out.println("***************" + workTime + "***************");
        throw new IllegalArgumentException("参数不对");
    }

    public int fireByRetryTemplate(){
        workTime++;
        System.out.println("***************" + workTime + "***************");
        if(workTime == 3){
            return 1;
        }else {
            throw new IllegalArgumentException("参数不对");
        }
    }


}
