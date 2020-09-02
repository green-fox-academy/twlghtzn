package com.twlghtzn.greenfoxclassapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreenFoxClassController {
  StudentService studentService;

  @Autowired
  public GreenFoxClassController(StudentService studentService) {
    this.studentService = studentService;
  }

  @RequestMapping(path = "/gfa", method = RequestMethod.GET)
  public String showIndex(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "index";
  }

  @RequestMapping(path = "/gfa/list", method = RequestMethod.GET)
  public String showListOfStudents(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "list";
  }

  @RequestMapping(path = "/gfa/add", method = RequestMethod.GET)
  public String addStudent() {
    return "addstudent";
  }

  @RequestMapping(path = "/gfa/save", method = RequestMethod.POST)
  public String addStudent(@RequestParam(name = "newStudent") String newStudent) {
    studentService.save(newStudent);
    return "redirect:/gfa/list";
  }

  @RequestMapping(path = "/gfa/check", method = RequestMethod.GET)
  public String checkIfAlreadyInList(Model model,
                                     @RequestParam(name = "newStudent", required = false)
                                         String newStudent) {
    if (newStudent == null) {
      model.addAttribute("nameStatus", "Enter a name");
    } else if (studentService.isNameAlreadyInNames(newStudent)) {
      model.addAttribute("nameStatus", newStudent +
          " is already in the student's list.");
    } else {
      model.addAttribute("nameStatus", newStudent +
          " is not in the student's list.");
    }
    return "/check";
  }
}
