package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.entity.FurnitureOrder;

@Repository
public interface OrderCancellationRepository extends JpaRepository<FurnitureOrder, String> {

}
