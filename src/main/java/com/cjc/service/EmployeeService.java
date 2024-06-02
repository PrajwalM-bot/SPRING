 package com.cjc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.model.Employee;
import com.cjc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public void check() {
	getAllRecords();
	}

	public void existIf() {
		boolean flag = repo.existsById(10);
		System.out.println(flag);
		boolean flag2 = repo.existsById(20);
		System.out.println(flag2);
	}

	public void getCount() {
		long l = repo.count();
		System.out.println(l);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

	public void deleteByID() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(13);
		list.add(14);
		repo.deleteAllById(list);
	}

	public void deleteSingle() {
		repo.deleteById(11);
	}

	public void getAllByID() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(12);
		list.add(14);

		Iterable<Employee> itr = repo.findAllById(list);
		itr.forEach((emp) -> System.out.println(emp));
	}

	public void getSingleDataByID() {
		Optional<Employee> opt = repo.findById(10);
		if (opt.isPresent()) {
			Employee emp = opt.get();
			System.out.println(emp);
		} else {
			System.out.println("no record found");
		}
	}

	public void getAllRecords() {
		Iterable<Employee> itr = repo.findAll();
		itr.forEach((emp) -> System.out.println(emp));
	}

	public void saveAll() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(11, "shubham", "pimpri", "MD", 20000));
		list.add(new Employee(12, "nitesh", "jodhpur", "manager", 30000));
		list.add(new Employee(13, "rohan", "nanded", "intern", 5000));
		list.add(new Employee(14, "atul", "pune", "tester", 20000));
		list.add(new Employee(15, "ayush", "pune", "helper", 150));
		repo.saveAll(list);
	}

	public void saveSingleData() {
		Employee emp = new Employee(10, "prajwal", "pune", "developer", 10000);
		repo.save(emp);
	}
}
