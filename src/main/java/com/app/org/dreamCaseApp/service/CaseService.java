package com.app.org.dreamCaseApp.service;

import com.app.org.dreamCaseApp.dao.CaseDTO;
import com.app.org.dreamCaseApp.entity.Case;
import com.app.org.dreamCaseApp.exception.ResourceIDNotFoundException;
import com.app.org.dreamCaseApp.mapper.CaseMapper;
import com.app.org.dreamCaseApp.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CaseService implements CaseInterface{

    private final CaseRepository caseRepository;
    private final CaseMapper caseMapper;

    @Override
    public CaseDTO create(CaseDTO caseDao) {
        Case aCase = caseMapper.mapFromCaseDtoToEntity(caseDao);
        aCase.setCreationDate(LocalDateTime.now());
        aCase = caseRepository.save(aCase);
        caseDao = caseMapper.mapFromCaseEntityToDTO(aCase);
        return caseDao;
    }

    @Override
    public CaseDTO findByCaseId(Long id) {
        Case aCase = caseRepository.findById(id).orElseThrow(() -> new ResourceIDNotFoundException("Resource not found"));
        return caseMapper.mapFromCaseEntityToDTO(aCase);
    }


    @Override
    public CaseDTO update(CaseDTO caseDao,Long id) {

        Case aCase = caseRepository.findById(id).orElseThrow(() -> new ResourceIDNotFoundException("Resource not found"));
        aCase = caseRepository.save(aCase);
        aCase.setDescription(caseDao.getDescription());
        caseRepository.save(aCase);
        return caseMapper.mapFromCaseEntityToDTO(aCase);
    }

    @Override
    public CaseDTO delet(Long id) {
        Case aCase = caseRepository.findById(id).orElseThrow(() -> new ResourceIDNotFoundException("Resource not found"));
        caseRepository.delete(aCase);
        return caseMapper.mapFromCaseEntityToDTO(aCase);
    }
}
