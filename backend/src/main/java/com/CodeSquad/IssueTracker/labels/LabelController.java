package com.CodeSquad.IssueTracker.labels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/labels")
    public ResponseEntity<List<Label>> getAllLabels() {
        List<Label> labels = labelService.getAllLabels();
        return ResponseEntity.ok(labels);
    }

    @PostMapping("/label")
    public ResponseEntity<Label> createLabel(@RequestBody Label label) {
        Label createdLabel = labelService.createLabel(label);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLabel);
    }

    @GetMapping("/label/{id}")
    public ResponseEntity<Label> getLabelById(@PathVariable Long id) {
        Optional<Label> label = labelService.getLabelById(id);
        return label.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/label/{id}")
    public ResponseEntity<Label> updateLabel(@PathVariable Long id, @RequestBody Label updatedLabel) {
        Label updatedLabelResponse = labelService.updateLabel(id, updatedLabel);
        return updatedLabelResponse != null ? ResponseEntity.ok(updatedLabelResponse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/label/{id}")
    public ResponseEntity<Void> deleteLabel(@PathVariable Long id) {
        labelService.deleteLabel(id);
        return ResponseEntity.noContent().build();
    }

}