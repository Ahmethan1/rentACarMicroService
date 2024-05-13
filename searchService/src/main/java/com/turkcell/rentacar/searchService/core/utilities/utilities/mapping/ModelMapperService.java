package com.turkcell.rentacar.searchService.core.utilities.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
   ModelMapper forResponse();
   ModelMapper forRequest();
}
