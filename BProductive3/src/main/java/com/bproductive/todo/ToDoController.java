package com.bproductive.todo;

import java.time.LocalDate;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/** 
 * @author Sebastiaan van den Berg
 * The Controller arranges the connection between the service and views, 
 * processing and sending user input and requests from the view to the service
 * for storage or query purposes and vice versa.
*/

@Controller
public class ToDoController {	
	
	private ToDoService toDoService;

	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	@GetMapping("/")
	public String getAllToDoModels(Model model){		
		
		List<ToDoModel> toDos = toDoService.getAllToDoModels();
		
		model.addAttribute("toDos", toDos);
		return "index";
	}
	
	@GetMapping("/get/{id}")
	public String getToDoModelById(@PathVariable("id")Long id, Model model){
		
		ToDoModel toDos =  toDoService.getToDoModelById(id);
		
		model.addAttribute("toDos", toDos);
		
		return "toDo";
	}
	
	@GetMapping("/create")
	public String createToDo(Model model) {	
		
		model.addAttribute("toDo", toDoService.readyNewToDoModel());		
		model.addAttribute("begin", LocalDate.now());

		return "/create";		
	}
	
	@PostMapping("/create")
	public String createToDO(@RequestParam(name="endDate") String endDate, 
			@Validated @ModelAttribute ToDoModel toDoModel, 
			BindingResult result, Model model
			){
		
		toDoModel.setEndDate(endDate);
		
		if(result.hasErrors()) {
			return "create";
		}
		
		toDoService.createToDo(toDoModel);	
		
		return "redirect:/get/" + toDoModel.getId();
	}
	
	@GetMapping("/update/{id}")
	public String getUpdatableToDo(@PathVariable("id") Long id, Model model) {
		
		ToDoModel toDoModel = toDoService.getToDoModelById(id);		
		
		model.addAttribute("toDo", toDoModel);
		model.addAttribute("begin", LocalDate.now());
		
		return "/update";		
	}
	
	@PostMapping("/modify/{id}")													
	public String updateToDo(@PathVariable("id") Long id, @RequestParam(name="endDate") String endDate, 
			@Validated @ModelAttribute ToDoModel toDoModel, BindingResult result, Model model
			) {
		toDoModel.setEndDate(endDate);
		toDoService.updateToDo(toDoModel);
		
		return "redirect:/get/{id}";
	}
	
	@RequestMapping(value="/delete/{id}", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteToDo(@PathVariable("id") Long id, Model model) {
		
		toDoService.deleteToDo(id);
		
		return "redirect:/"; 			
	}
}
