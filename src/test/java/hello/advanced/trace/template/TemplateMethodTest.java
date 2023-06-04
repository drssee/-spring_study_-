package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    public static class AbstractTemplateLogic1 extends AbstractTemplate {
        @Override
        protected void call() {
            log.info("비즈니스 로직1 실행");
        }
    }

    public static class AbstractTemplateLogic2 extends AbstractTemplate {
        @Override
        protected void call() {
            log.info("비즈니스 로직2 실행");
        }
    }

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    @Test
    void templateMethodV1() {
        AbstractTemplateLogic1 template1 = new AbstractTemplateLogic1();
        template1.excute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplateLogic2 template2 = new AbstractTemplateLogic2();
        template2.excute();
    }

    @Test
    void templateMethodV3() {
        AbstractTemplate template = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 실행");
            }
        };
        template.excute();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
