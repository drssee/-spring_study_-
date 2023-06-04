package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 템플릿 메서드 패턴
 * 변하는 부분과, 변하지 않는 부분을 분리
 * 상속받은 자식클래스에서 변하는 부분을 구현
 */
@Slf4j
public abstract class AbstractTemplate {

    public void excute() {
        long startTime = System.currentTimeMillis();
        call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    protected abstract void call();
}
