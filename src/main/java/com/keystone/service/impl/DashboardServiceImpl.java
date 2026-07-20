package com.keystone.service.impl;

import org.springframework.stereotype.Service;

import com.keystone.dto.DashboardResponse;
import com.keystone.enums.Role;
import com.keystone.enums.WorkOrderStatus;
import com.keystone.repository.CustomerRepository;
import com.keystone.repository.SiteRepository;
import com.keystone.repository.UserRepository;
import com.keystone.repository.WorkOrderRepository;
import com.keystone.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final CustomerRepository customerRepository;
    private final SiteRepository siteRepository;
    private final WorkOrderRepository workOrderRepository;
    private final UserRepository userRepository;

    public DashboardServiceImpl(
            CustomerRepository customerRepository,
            SiteRepository siteRepository,
            WorkOrderRepository workOrderRepository,
            UserRepository userRepository) {

        this.customerRepository = customerRepository;
        this.siteRepository = siteRepository;
        this.workOrderRepository = workOrderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DashboardResponse getDashboardSummary() {

        long totalCustomers = customerRepository.count();
        long totalSites = siteRepository.count();
        long totalWorkOrders = workOrderRepository.count();

        long newWorkOrders =
                workOrderRepository.findByStatus(WorkOrderStatus.NEW).size();

        long assignedWorkOrders =
                workOrderRepository.findByStatus(WorkOrderStatus.ASSIGNED).size();

        long inProgressWorkOrders =
                workOrderRepository.findByStatus(WorkOrderStatus.IN_PROGRESS).size();

        long completedWorkOrders =
                workOrderRepository.findByStatus(WorkOrderStatus.COMPLETED).size();

        long closedWorkOrders =
                workOrderRepository.findByStatus(WorkOrderStatus.CLOSED).size();

        long cancelledWorkOrders =
                workOrderRepository.findByStatus(WorkOrderStatus.CANCELLED).size();

        long totalTechnicians =
                userRepository.findByRole(Role.TECHNICIAN).size();

        DashboardResponse response = new DashboardResponse(
                totalCustomers,
                totalSites,
                totalWorkOrders,
                newWorkOrders,
                assignedWorkOrders,
                inProgressWorkOrders,
                completedWorkOrders,
                closedWorkOrders,
                cancelledWorkOrders,
                totalTechnicians
        );

        response.setSlaBreachedWorkOrders(
                workOrderRepository.countBySlaBreachedTrue());

        return response;
    }
}