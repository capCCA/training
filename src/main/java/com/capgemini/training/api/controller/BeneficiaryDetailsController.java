package com.capgemini.training.api.controller;

import com.capgemini.training.api.service.mapper.BeneficiaryMapper;
import com.capgemini.training.api.model.BeneficiaryDetails;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import com.capgemini.training.api.service.BeneficiaryDetailsService;
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

@Tag(name = "BeneficiaryEntity", description = "API of BeneficiaryGetController")
@RestController
@RequestMapping(path = "/beneficiaries")
@RequiredArgsConstructor

public class BeneficiaryDetailsController {

  private final BeneficiaryDetailsService beneficiaryService;

  @Operation(
      summary = "Find all ",
      description = "Method that returns a List of Beneficiaries with status OK 200")
  @GetMapping("")
  public ResponseEntity<List<BeneficiaryDetails>> findAll() {
    return ResponseEntity.ok(
        beneficiaryService.findAll().stream()
            .map(BeneficiaryMapper::toDto)
            .collect(Collectors.toList()));
  }

  @Operation(
      summary = "Find one",
      description =
          "Method that returns a BeneficiaryEntity for the provided id with status Ok 200 or NOT_FOUND 404")
  @GetMapping("/{beneficiaryId}")
  public ResponseEntity<BeneficiaryDetails> findById(@PathVariable("beneficiaryId") String id) {
    BeneficiaryEntity beneficiary = beneficiaryService.findById(id);
    if (beneficiary != null) return ResponseEntity.ok(BeneficiaryMapper.toDto(beneficiary));
    else return ResponseEntity.notFound().build();
   
  }
}

// Notas: antes
//    public BeneficiaryDetails findById(@PathVariable("beneficiaryId") String id) {
//        return BeneficiaryMapper.toDto(beneficiaryService.findById(id));
//
//    }
