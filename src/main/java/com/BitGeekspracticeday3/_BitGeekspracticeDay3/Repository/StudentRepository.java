package com.BitGeekspracticeday3._BitGeekspracticeDay3.Repository;



import com.BitGeekspracticeday3._BitGeekspracticeDay3.models.Studentmodel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Studentmodel, Long> {
}