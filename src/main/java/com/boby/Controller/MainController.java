package com.boby.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boby.Model.User;
import com.boby.Service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public ModelAndView loadIndex(HttpServletRequest request, HttpServletResponse response) {
		List<User> allUser = userService.getAllUser();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("allUser",	allUser);
		return mv;
	}
	
	@RequestMapping("/AddUser")
	public ModelAndView loadAddUser(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEditPage");
		mv.addObject("user", user);
		return mv;
	}
	
	@PostMapping("/SaveOrUpdate")
	public ModelAndView SaveData(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		if(userService.saveOrUpdateUser(user)) {
			redirectAttributes.addFlashAttribute("SaveOrNot", "Save");
		} else {
			redirectAttributes.addFlashAttribute("SaveOrNot", "No");
		}
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/Edit")
	public ModelAndView EditData(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		int userId = Integer.parseInt(request.getParameter("userId").toString());
		User user = userService.findByUserId(userId);
		ModelAndView mv = new ModelAndView();
		if(user != null) {
			mv.setViewName("addEditPage");
			mv.addObject("user", user);
		} else {
			redirectAttributes.addFlashAttribute("SaveOrNot", "No");
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@PostMapping("/Delete")
	public ModelAndView DeleteData(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		int userId = Integer.parseInt(request.getParameter("userId").toString());
		if(userService.deleteUserById(userId)) {
			redirectAttributes.addFlashAttribute("SaveOrNot", "Delete");
		} else {
			redirectAttributes.addFlashAttribute("SaveOrNot", "No");
		}
		return new ModelAndView("redirect:/");
	}
	
}
