package hello.advanced;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    //동일 인터페이스 타입의 구현체가 여러개라 구체적으로 사용할 구현체를 선택
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
