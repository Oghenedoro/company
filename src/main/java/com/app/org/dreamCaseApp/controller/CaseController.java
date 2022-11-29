package com.app.org.dreamCaseApp.controller;

import com.app.org.dreamCaseApp.dao.CaseDTO;
import com.app.org.dreamCaseApp.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CaseController {

    private final CaseService caseService;

    @ResponseStatus(code = HttpStatus.CREATED)
   @PostMapping(path = {"/cases" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // @RequestMapping(value ="/cases", method = RequestMethod.POST)
    public CaseDTO create(@RequestBody CaseDTO caseDao) {
       return caseService.create(caseDao);
    }

    @GetMapping(path = { "/cases/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public CaseDTO findByCaseId(@PathVariable("id")Long id) {
        return this.caseService.findByCaseId(id);
    }

    @PutMapping(path = { "/cases/{id}" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CaseDTO update(@RequestBody CaseDTO caseDao, @PathVariable Long id) {
        return this.caseService.update(caseDao,id);
    }

    @DeleteMapping(path = { "/cases/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public CaseDTO delet(@PathVariable("id")Long id) {
        return this.caseService.delet(id);
    }
}
