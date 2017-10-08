package com.yma.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.yma.app.model.Employee;


@Controller
public class MainController {

	@GetMapping("/")
	public String mainView() {
		return "index";
	}
	
	@GetMapping("/printEmployee")
	public String handleForexRequest(Model model) {
		model.addAttribute("employeeList", getEmployeetDetails());
		return "employeeDetails";
	}
	
	 private List<Employee> getEmployeetDetails() {
		 List<Employee> studentList = new ArrayList<>();
		 studentList.add(new Employee(new Long(1001), "John", "UK", "0874578945", new Double(50000)));
		 studentList.add(new Employee(new Long(1002), "Kate", "Rusia", "76545446", new Double(25000)));
		 studentList.add(new Employee(new Long(1003), "Sailaja", "India", "0556812584", new Double(78000)));
		 studentList.add(new Employee(new Long(1004), "Dasun", "SriLanka", "0575155581", new Double(96000)));
		 studentList.add(new Employee(new Long(1005), "Chamara", "SriLanka", "0987455211", new Double(12000)));
		 studentList.add(new Employee(new Long(1006), "Selwam", "India", "5869712258", new Double(98000)));
		 studentList.add(new Employee(new Long(1007), "Masur", "Pakistan", "4561316448", new Double(30000)));
		 studentList.add(new Employee(new Long(1008), "Jane", "USA", "3256977415", new Double(45000)));
		 studentList.add(new Employee(new Long(1009), "Kasuni", "SriLaka", "7830258419", new Double(89000)));
		 studentList.add(new Employee(new Long(1010), "Nail", "UK", "4646825254", new Double(65000)));
		 return studentList;
	 }
}
