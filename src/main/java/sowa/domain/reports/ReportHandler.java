package sowa.domain.reports;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import sowa.domain.reports.vm.ReportVM;

import java.time.LocalDate;

@Component
public class ReportHandler {

    private final ReportQueryService queryService;

    public ReportHandler(ReportQueryService queryService) {
        this.queryService = queryService;
    }

    public Mono<ServerResponse> handleGetReport(ServerRequest request) {

        LocalDate orderDateFrom = LocalDate
                .parse(request.queryParam("orderDateFrom")
                        .orElseThrow(IllegalArgumentException::new));
        LocalDate orderDateTo = LocalDate
                .parse(request.queryParam("orderDateTo")
                        .orElseThrow(IllegalArgumentException::new));

        Mono<ReportVM> data = queryService
                .getReport(orderDateFrom, orderDateTo);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(data, ReportVM.class);
    }
}
