package cn.catgod.mvc.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.support.RetryTemplate;

@PropertySource("classpath:retry.properties")
@EnableRetry
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class RetryApplication implements CommandLineRunner {

	@Autowired
	private WorkService workService;
	@Autowired
	RetryTemplate retryTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RetryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		workService.fire();
//		workService.fire2();

		try {
			Object result = retryTemplate.execute(new RetryCallback<Object, Throwable>() {
				@Override
				public Object doWithRetry(RetryContext context) throws Throwable {
					return workService.fireByRetryTemplate();
				}
			});
			System.out.println(result);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

	}
}
