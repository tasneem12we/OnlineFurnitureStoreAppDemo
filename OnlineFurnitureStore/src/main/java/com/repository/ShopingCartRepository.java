package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Cart;

@Repository
public interface ShopingCartRepository extends JpaRepository<Cart,Integer>
{

}
