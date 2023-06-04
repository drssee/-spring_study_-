package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");

        //람다식을 이용한 함수형 인터페이스에 구현체 할당
        //어떤 Runnable 추상메서드 조건을 만족하는, 람다식 () -> return void 함수를 넣어주면
        //그 함수를 추상메서드의 구현으로 보는 구현체가 함수형 인터페이스에 할당된다

        //함수형 인터페이스라는 말에 속지말자
        //결국 인터페이스 나부랭이임
        //인터페이스는 구현체를 위해 존재한다
        //람다식도 객체이므로 인터페이스의 구현체가 될수있다
        //그러므로 유일한 추상메서드를 가진 함수형 인터페이스의 구현체로 람다식을 사용할수있다

        Runnable userA = () -> {
            threadLocalService.logic("userA");
        };
        Runnable userB = () -> {
            threadLocalService.logic("userB");
        };
        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); // main 쓰레드가 threadA의 종료를 기다려 동시성문제 x
        sleep(100); // threadA의 실행중에 threadB가 실행되어 동시성문제 o (임계구역인데 여러쓰레드가 동시에 접근)
        threadB.start();

        sleep(3000); // main 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
