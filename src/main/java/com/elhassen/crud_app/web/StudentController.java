package com.ouhamza.crud_app.web;

import java.lang.ProcessBuilder.Redirect;

import com.ouhamza.crud_app.dao.StudentRepo;
import com.ouhamza.crud_app.model.Student;
import com.ouhamza.crud_app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepo studentRepo;

    // @RequestMapping("/")
    // public String index(Model model){
    //     model.addAttribute("students", studentService.getAll());
    //     return "index";
    // }

    @RequestMapping("/")
    public String findAllPage( 
        @RequestParam(value="page", required = false, defaultValue = "1") int page,
        @RequestParam(value ="size", required = false, defaultValue = "5" ) int size,
        Model model
    ){
       Page<Student> studentPage = studentRepo.findAll(PageRequest.of(page, size));
       model.addAttribute("students", studentPage.getContent());
       model.addAttribute("pages", new int [studentPage.getTotalPages()]);
       model.addAttribute("currentPage", page);
        return "index";
    }


    @RequestMapping("/new")
    public String newStudent(Model model){
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "student-form";
    }

    // @GetMapping("/edit/{id}")
    // public String edit(long id, Model model){
    //     Student student = studentService.get(id); 
    //     model.addAttribute("student", student);
    //     return  "dep-form";
          
    // }


}