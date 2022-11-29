package com.app.org.dreamCaseApp;

import com.app.org.dreamCaseApp.dao.CaseDTO;
import com.app.org.dreamCaseApp.entity.Case;
import com.app.org.dreamCaseApp.mapper.CaseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DreamCaseAppApplicationTests {

	@InjectMocks
	private CaseMapper caseMapper = Mappers.getMapper(CaseMapper.class);

	@Test
	void contextLoads() {
	}

	@Test
	void whenDtoToEntity_thenReturnEntity() {

		Case aCase = new Case();
		aCase.setCaseId(1L);
		aCase.setDescription("llllllllllllll");

		CaseDTO caseDTO = new CaseDTO();
		caseDTO.setCaseId(1L);
		caseDTO.setDescription("llllllllllllll");

		// when
		Case entity = this.caseMapper.mapFromCaseDtoToEntity(caseDTO);
		// then
		Assertions.assertNotNull(entity);
		Assertions.assertEquals(caseDTO.getCaseId(), entity.getCaseId());
		Assertions.assertEquals(caseDTO.getDescription(), entity.getDescription());
	}

}