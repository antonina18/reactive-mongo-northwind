package sowa.domain.reports.vm;

import reactor.core.publisher.Flux;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReportVM {

    private LocalDateTime createTime = LocalDateTime.now();

    @NotNull
    private LocalDate orderDateFrom;
    @NotNull
    private LocalDate orderDateTo;

    private int totalOrders;

    private List<OrderVM> orders;

    public ReportVM(@NotNull LocalDate orderDateFrom, @NotNull LocalDate orderDateTo, @NotNull Flux<OrderVM> orderVMFlux) {
        this.orderDateFrom = orderDateFrom;
        this.orderDateTo = orderDateTo;

        List<OrderVM> orders = orderVMFlux.toStream().collect(toList());
        this.orders = orders;
        this.totalOrders = orders.size();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDate getOrderDateFrom() {
        return orderDateFrom;
    }

    public LocalDate getOrderDateTo() {
        return orderDateTo;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public List<OrderVM> getOrders() {
        return orders;
    }
}
