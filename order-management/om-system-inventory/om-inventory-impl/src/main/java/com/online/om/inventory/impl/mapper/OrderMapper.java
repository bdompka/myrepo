package com.online.om.inventory.impl.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.online.om.inventory.dataaccess.OrderEntity;
import com.online.om.inventory.model.OrderBo;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    List<OrderEntity> mapOrderBosToOrderEntitys(List<OrderBo> OrderBos);
    
    List<OrderBo> mapOrderEntitysToOrderBos(List<OrderEntity> OrderEntites);

}
