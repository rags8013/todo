package com.raghu.todoapp.controller;


import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.raghu.todoapp.dto.UserDTO;
import com.raghu.todoapp.entity.TodoTask;
import com.raghu.todoapp.service.TaskService;
import com.raghu.todoapp.service.UserService;


@Controller
public class BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = {"/" , "/home"})
	public String showHome(HttpServletRequest request, Model model) {
		Principal principal = request.getUserPrincipal();
		model.addAttribute("useremail",principal.getName());
		return "home";
	}
	
	//Login and registration mappings
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/register")
	public String showRegistrationPage(Model model) {
		
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/register")
	private String checkDetails(@Valid @ModelAttribute("user") UserDTO registerUser, BindingResult br) {
		if (br.hasErrors())
			return "register";
		else {
			userService.saveUser(registerUser);
			return "success";
		}

	}
	
	
	//Add, Edit, Delete and Finish tasks
	@RequestMapping("/task")
	public String showTasks(HttpServletRequest request, Model model) {
		List<TodoTask> tasks = userService.getUserTasks(request.getUserPrincipal().getName());
		Map<Boolean, List<TodoTask>> sublists = tasks.stream().collect(Collectors.groupingBy(TodoTask::isTaskStatus));
		model.addAttribute("finishedTasks", sublists.get(true));
		model.addAttribute("pendingTasks", sublists.get(false));
		return "tasks";
	}
	
	@RequestMapping("/addTask")
	private String addTask(@RequestParam("task") String task, HttpServletRequest request) {
		taskService.addTask(task, request.getUserPrincipal().getName());
		return "redirect:/task";
	}
	
	@RequestMapping(value="/finish/{taskID}",method=RequestMethod.GET)
	private String finishTask(@PathVariable("taskID") String taskID, HttpServletRequest request) {
		taskService.finishTask(taskID, request.getUserPrincipal().getName());
		return "redirect:/task";
	}
	
	@RequestMapping(value="/unfinish/{taskID}",method=RequestMethod.GET)
	private String unfinishTask(@PathVariable("taskID") String taskID, HttpServletRequest request) {
		taskService.unfinishTask(taskID, request.getUserPrincipal().getName());
		return "redirect:/task";
	}
	
	@RequestMapping(value="/delete/{taskID}",method=RequestMethod.GET)
	private String deleteTask(@PathVariable("taskID") String taskID, HttpServletRequest request) {
		taskService.deleteTask(taskID, request.getUserPrincipal().getName());
		return "redirect:/task";
	}
	
	@RequestMapping("/edit")
	private String editTask(@RequestParam("taskname") String taskName, @RequestParam("taskid") String taskID, HttpServletRequest request){
		System.out.println(taskName);
		System.out.println(taskID);
		taskService.editTask(taskID, taskName, request.getUserPrincipal().getName());
		return "redirect:/task";
	}

	
	@RequestMapping("/about")
	private String aboutPage() {
		return "about";
	}
	
}
