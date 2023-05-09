package com.capgemini.training.controller;

import com.capgemini.training.config.BeneficiaryMapper;
import com.capgemini.training.dto.BeneficiaryDto;
import com.capgemini.training.entity.Beneficiary;
import com.capgemini.training.service.BeneficiaryGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Beneficiary", description = "API of BeneficiaryGetController")
@RestController
@RequestMapping(path = "/beneficiaries")
@RequiredArgsConstructor

public class BeneficiaryGetController {

  private final BeneficiaryGetService beneficiaryService;

  @Operation(
      summary = "Find all ",
      description = "Method that returns a List of Beneficiaries with status OK 200")
  @GetMapping("")
  public ResponseEntity<List<BeneficiaryDto>> findAll() {
    return ResponseEntity.ok(
        beneficiaryService.findAll().stream()
            .map(BeneficiaryMapper::toDto)
            .collect(Collectors.toList()));
  }

  @Operation(
      summary = "Find one",
      description =
          "Method that returns a Beneficiary for the provided id with status Ok 200 or NOT_FOUND 400")
  @GetMapping("/{beneficiaryId}")
  public ResponseEntity<BeneficiaryDto> findById(@PathVariable("beneficiaryId") String id) {
    Beneficiary beneficiary = beneficiaryService.findById(id);
    if (beneficiary != null) return ResponseEntity.ok(BeneficiaryMapper.toDto(beneficiary));
    else return ResponseEntity.notFound().build();
  }
}

// Notas: antes
//    public BeneficiaryDto findById(@PathVariable("beneficiaryId") String id) {
//        return BeneficiaryMapper.toDto(beneficiaryService.findById(id));
//
//    }
