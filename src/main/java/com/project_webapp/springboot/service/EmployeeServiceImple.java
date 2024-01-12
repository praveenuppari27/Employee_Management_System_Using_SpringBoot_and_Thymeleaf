package com.project_webapp.springboot.service;

import java.util.List;
import java.util.Optional; // Correct import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project_webapp.springboot.model.Employee;
import com.project_webapp.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImple implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        repo.save(employee);
    }

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> opt=repo.findById(id);
		Employee emp=null;
		if(opt.isPresent())
			emp=opt.get();
		else
			throw new RuntimeException("Employee not Found By "+id);
		return emp;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		repo.deleteById(id);
		
	}

	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        
        return repo.findAll(pageable);
    }
	
	

    
}
