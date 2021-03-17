package cn.catgod.mvc.retry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author weiqiang.lin
 * @version 1.0
 * @date 2020/10/20
 */
@Configuration
public class RetryAopConfig {

    @Bean
    public RetryTemplate retryTemplate(){

        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(300);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(2);
        retryTemplate.setRetryPolicy(retryPolicy);

        retryTemplate.registerListener(new DefaultListenerSupport());
        return retryTemplate;
    }

    class DefaultListenerSupport extends RetryListenerSupport{
        public DefaultListenerSupport() {
            super();
        }

        @Override
        public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
            System.out.println("close");
            super.close(context, callback, throwable);
        }

        @Override
        public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
            System.out.println("error");

            super.onError(context, callback, throwable);
        }

        @Override
        public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
            System.out.println("open");
            return super.open(context, callback);
        }
    }
}
