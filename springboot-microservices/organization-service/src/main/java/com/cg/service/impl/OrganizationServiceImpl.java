package com.cg.service.impl;

import com.cg.dto.OrganizationDto;
import com.cg.entity.Organization;
import com.cg.mapper.OrganizationMapper;
import com.cg.repository.OrganizationRepository;
import com.cg.service.OrganizationService;

public class OrganizationServiceImpl implements OrganizationService {
	

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }

}
