package com.capgemini.training.beneficiary.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.beneficiary.dto.BeneficiaryDto;
import com.capgemini.training.beneficiary.service.BeneficiaryGetService;
import com.capgemini.training.config.BeneficiaryMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Beneficiary", description = "API of BeneficiaryGetController")
@RequestMapping(path = "/beneficiaries")
@RestController
@RequiredArgsConstructor
@Transactional
public class BeneficiaryGetController {

    private final BeneficiaryGetService beneficiaryService;

    @Operation(summary = "Find all ", description = "Method that returns a List of Beneficiaries")
    @GetMapping("")
    public List<BeneficiaryDto> findAll() {
        return beneficiaryService.findAll().stream().map(BeneficiaryMapper::toDto).collect(Collectors.toList());

    }

    @Operation(summary = "Find one", description = "Method that returns a Beneficiary for the provided id")
    @GetMapping("/{beneficiaryId}")
    public BeneficiaryDto findById(@PathVariable("beneficiaryId") String id) {
        return BeneficiaryMapper.toDto(beneficiaryService.findById(id));

    }
}
