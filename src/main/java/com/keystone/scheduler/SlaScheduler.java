package com.keystone.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.keystone.entity.WorkOrder;
import com.keystone.enums.WorkOrderStatus;
import com.keystone.repository.WorkOrderRepository;

@Component
public class SlaScheduler {

    private final WorkOrderRepository workOrderRepository;

    public SlaScheduler(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void checkSlaBreaches() {

        List<WorkOrder> overdueOrders =
                workOrderRepository.findBySlaDeadlineBeforeAndSlaBreachedFalse(
                        LocalDateTime.now());

        for (WorkOrder workOrder : overdueOrders) {

            if (workOrder.getStatus() != WorkOrderStatus.COMPLETED
                    && workOrder.getStatus() != WorkOrderStatus.CLOSED) {

                workOrder.setSlaBreached(true);
                workOrderRepository.save(workOrder);
            }
        }
    }
}