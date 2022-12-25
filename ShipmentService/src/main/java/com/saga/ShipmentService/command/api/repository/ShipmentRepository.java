package com.saga.ShipmentService.command.api.repository;

import com.saga.ShipmentService.command.api.data.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment,String > {
}
