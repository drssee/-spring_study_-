package hello.advanced.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class TraceStatus {

    //trace상태가 traceId(txId, depth)를 가진다
    private TraceId traceId;

    private Long startTimeMs;

    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }
}
