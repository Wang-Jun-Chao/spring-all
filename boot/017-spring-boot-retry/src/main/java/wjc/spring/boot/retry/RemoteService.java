package wjc.spring.boot.retry;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-05-20 15:34
 **/
@Service
public class RemoteService {
    @Retryable(
            value = {RemoteAccessException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 5000L, multiplier = 1))
    public void call() {

        int i = 1 + (int) (Math.random() * 5);

        if (i % 3 != 0) {
            System.out.println("RPC调用异常");
            throw new RemoteAccessException("RPC调用异常");
        }

        System.out.println("方法成功调用");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println("重试都没有成功，在这里做数据还原");
        e.printStackTrace();
    }
}
