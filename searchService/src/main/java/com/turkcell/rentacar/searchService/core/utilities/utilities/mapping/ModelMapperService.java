package com.turkcell.rentacar.inventoryService.core.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

public interface ModelMapperService {
   ModelMapper forResponse();
   ModelMapper forRequest();
}
