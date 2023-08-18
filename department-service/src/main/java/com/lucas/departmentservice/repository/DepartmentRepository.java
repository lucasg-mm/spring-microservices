package com.lucas.departmentservice.repository;

import com.lucas.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
