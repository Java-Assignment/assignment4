package com.abhi.assignment4.mapper;

import com.abhi.assignment4.entity.CustomerEnrichment;
import com.abhi.assignment4.entity.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEnrichmentMapper {
    CustomerResponse ConverCetoCr(CustomerEnrichment customerEnrichment);
}
