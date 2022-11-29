package com.app.org.dreamCaseApp.service;

import com.app.org.dreamCaseApp.dao.CaseDTO;

public interface CaseInterface {
    public CaseDTO create(CaseDTO caseDao);
    public CaseDTO findByCaseId(Long id);
    public CaseDTO update(CaseDTO caseDao, Long id);
    public CaseDTO delet(Long id);

}
