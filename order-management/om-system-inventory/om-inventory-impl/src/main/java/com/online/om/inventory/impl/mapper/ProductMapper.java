package com.online.om.inventory.impl.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.online.om.inventory.dataaccess.ProductEntity;
import com.online.om.inventory.model.ProductBo;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    List<ProductEntity> mapProductBosToProductEntitys(List<ProductBo> productBos);
    
    List<ProductBo> mapProductEntitysToProductBos(List<ProductEntity> productEntites);

}
