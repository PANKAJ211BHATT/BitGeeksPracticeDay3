package com.BitGeekspracticeday3._BitGeekspracticeDay3.Controller;

import com.BitGeekspracticeday3._BitGeekspracticeDay3.models.Studentmodel;
import com.BitGeekspracticeday3._BitGeekspracticeDay3.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/greering")
    public String greeting(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping("/student")
    public ResponseEntity<List<Studentmodel>> getAllStudent(){
        List<Studentmodel> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Studentmodel> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/student")
    public ResponseEntity<Studentmodel> createStudent(@RequestBody Studentmodel student) {
        Studentmodel savedStudent = studentRepository.save(student);
        return ResponseEntity.status(200).body(savedStudent);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {

            Optional<Studentmodel> studentOptional = studentRepository.findById(id);

            if (studentOptional.isPresent()) {
                studentRepository.delete(studentOptional.get());
                return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student with ID " + id + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting student: " + e.getMessage());
        }
    }

}
