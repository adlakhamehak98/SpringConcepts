package com.thymeleaf.thymeleafDemo.controller;

import com.thymeleaf.thymeleafDemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//Question 3: Create an Employee registration form and bind it's requested values on the controller.

@Controller
public class EmployeeController {

    List<Employee> employees = new ArrayList<>();

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String showForm() {
        return "employeeHome";
    }

    //Question 4: Create a dynamic HTML page and render an Employee table with emp object return from the controller.
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        employees.add(employee);
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        System.out.println(employees);
        return "employeeView";
    }

/*    //also,
    @PostMapping("/employee")
    public String viewResult(Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("name",httpServletRequest.getParameter("name"));
        model.addAttribute("id",httpServletRequest.getParameter("id"));
        model.addAttribute("contactNumber",httpServletRequest.getParameter("contactNumber"));
        return "employeeView";
    }
*/

    //Question 8: Create a user listing table show alternate row color using a conditional tag.
    @GetMapping("/employeeList")
    public ModelAndView getEmp(Model model) {
        employees.add(new Employee("Mehak", 3301, "7088185972"));
        employees.add(new Employee("Sagar", 3330, "9812186191"));
        employees.add(new Employee("Vishakha", 3361, "7893746573"));
        employees.add(new Employee("Sidharth", 3311, "8273648547"));
        employees.add(new Employee("Yatin", 3327, "98274635344"));
        ModelAndView view = new ModelAndView("listUser");
        view.addObject("users", employees);
        return view;
    }

    @GetMapping("/getUserType")
    public String getEnum() {
        return "enum";
    }

//    @GetMapping("/exercise10")
//    public String getLoaderForm(Model model) {
//        model.addAttribute("employee", new Employee());
//        return "Exercise10";
//    }

}

