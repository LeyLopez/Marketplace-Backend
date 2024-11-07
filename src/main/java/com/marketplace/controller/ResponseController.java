package com.marketplace.controller;

import com.marketplace.dto.ResponseDTO;
import com.marketplace.exceptions.NotFoundException;
import com.marketplace.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getResponseById(@PathVariable Long id) {
        return responseService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Response with id " + id + " not found"));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createResponse(@RequestBody ResponseDTO responseDTO) {
        ResponseDTO createdResponse = responseService.save(responseDTO);
        return ResponseEntity.ok(createdResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateResponse(@PathVariable Long id, @RequestBody ResponseDTO responseDTO) {
        return responseService.update(id, responseDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Response with id " + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long id) {
        if (!responseService.existsById(id)) {
            throw new NotFoundException("Response with id " + id + " not found");
        }
        responseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<ResponseDTO> getAllResponses() {
        return responseService.findAll();
    }
}
