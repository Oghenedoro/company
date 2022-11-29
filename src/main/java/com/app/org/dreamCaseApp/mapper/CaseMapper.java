package com.app.org.dreamCaseApp.mapper;

import com.app.org.dreamCaseApp.dao.CaseDTO;
import com.app.org.dreamCaseApp.entity.Case;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CaseMapper {

    Case mapFromCaseDtoToEntity(CaseDTO caseDTO);
    CaseDTO mapFromCaseEntityToDTO(Case aCase);

}
