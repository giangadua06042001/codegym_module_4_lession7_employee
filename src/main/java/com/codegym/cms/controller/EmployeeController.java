package com.codegym.cms.controller;

import com.codegym.cms.model.Employee;
import com.codegym.cms.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("test")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("")
    public ModelAndView formCreate(){
        ModelAndView modelAndView=new ModelAndView("/formCreate");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(Employee employee){
        employeeService.save(employee);
        ModelAndView modelAndView=new ModelAndView("/formCreate");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message","New employee created successfully");
        return modelAndView;

    }
    @GetMapping("/list")
    public ModelAndView showList(){
        employeeService.findAll();
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("listEmployee", employeeService.findAll());
        return modelAndView;
    }
}
