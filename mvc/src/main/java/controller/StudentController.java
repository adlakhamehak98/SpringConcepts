package controller;

import co.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

////Question 1: Implement AbstractController in StudentController.create a mapping index.html for it and render index.jsp view from it which displays messages "Hello from index.gsp"
//public class StudentController extends AbstractController {
//    @Override
//    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return new ModelAndView("index");
//    }
//}


////Question 2: Now remove AbstractController and useMultiActionController for StudentController which contains 2 actions one action renders a jsp view and another action uses HttpServletResponse to show the output on the Web browser.
//public class StudentController extends MultiActionController {
//
//    public ModelAndView index(HttpServletRequest httpServletRequest,
//                              HttpServletResponse httpServletResponse) throws Exception {
//        return new ModelAndView("index");
//    }
//
//    public void hello(HttpServletRequest httpServletRequest,
//                      HttpServletResponse httpServletResponse) throws Exception {
//        httpServletResponse.setContentType("text/html");
//        httpServletResponse.getWriter().println("Exercise 2");
//    }
//}

@Controller
public class StudentController {
    //Question 3: Use annotation in StudentController to define a default action index which renders a jsp page.
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    //Question 4: Create one more annotation based action hello inside the StudentController which and use @ResponseBody annotation from it to display Hello world.
    @RequestMapping("hello")
    @ResponseBody
    public String getHello() {
        return "Hello World";
    }

    //Question 5: Create one more action which sends Model HelloWorld to the jsp file.
    @RequestMapping("hello2")
    public ModelAndView getHello2() {
        ModelAndView index = new ModelAndView("index");
        index.addObject("hello", "Hello World.");
        return index;
    }

    //Question 6: Use @PathVariable annotation to access firstname and lastname in an action inside StudentController place both the parameters in different arguments and access them.
    //Question 7: Now place both the arguments inside a Map and access the Map instead.
    @RequestMapping("name/{firstname}/{lastname}")
    @ResponseBody
    public String getName(@PathVariable Map<String, String> name) {
        return name.get("firstname") + name.get("lastname");
    }

    //Question 8: Use @RequestParam annotation to access the firstname and lastname in formData action of StudentController.
    @RequestMapping("form")
    public String getForm() {
        return "form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    @ResponseBody
    public String formData(@RequestParam Map<String, String> name) {
        return name.get("firstname") + name.get("lastname");
    }

    //Question 9: Create a StudentCO and bind firstname and lastname with instance variable of StudentCO.
    @RequestMapping(value = "newStudent", method = RequestMethod.POST)
    @ResponseBody
    public String submitStudent(Student student) {
        return student.toString();
    }

    //Question 10: Use @ModelAttribute annotation to add Heading "Spring MVC Demo" in every model.
    @ModelAttribute
    public void addHeading(Model model) {
        model.addAttribute("heading", "Spring MVC Demo");
    }
}
