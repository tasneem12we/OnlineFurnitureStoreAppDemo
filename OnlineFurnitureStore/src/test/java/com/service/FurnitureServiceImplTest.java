package com.service;

import static org.junit.Assert.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.Furniture;
import com.exception.FurnitureServiceException;
import com.service.IFurnitureManagementService;

@SpringBootTest
class FurnitureServiceImplTest {


	@Autowired
	private IFurnitureManagementService furnitureService;

	@Test
	void testAddFurniture() throws FurnitureServiceException {
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(4);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("Wingback Chair");
		furniture.setFurnitureName("Chair");
		furniture.setPrice(123.0);
		assertEquals(furniture.getFurnitureModel(), furnitureService.registerFurniture(furniture).getFurnitureModel());
	}

	@Test
	void testGetFurniture() throws FurnitureServiceException {
		assertEquals("Chair", furnitureService.getFurnitureById(4).getFurnitureName());
	}

	

	@Test
	void testDeleteById() throws FurnitureServiceException {
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(1);
		furniture.setFurnitureColor("Red");
		furniture.setFurnitureModel("Wingback Chair");
		furniture.setFurnitureName("Chair");
		assertEquals(furniture.getFurnitureModel(), furnitureService.deleteFurnitureById(4).getFurnitureModel());
	}

	@Test
	void testupdateFurniture() throws FurnitureServiceException{
		Furniture furniture=new Furniture();
		furniture.setFurnitureId(2);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
		assertEquals("Black", furnitureService.updateFurnitureById(2, furniture).getFurnitureColor());
		
	}
	
	@Test
	void geAllFurniture() throws FurnitureServiceException{
		assertNotNull(furnitureService.getAllFurnitures());
	}
}
