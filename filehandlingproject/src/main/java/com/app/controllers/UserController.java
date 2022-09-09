package com.app.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.entity.User;
import com.app.entity.UserAuth;
import com.app.repositories.UserAuthRepository;
import com.app.repositories.UserRepository;
import com.app.services.AuthenticationUserService;
import com.app.uitls.FileUploadUtil;

@Controller
public class UserController {
	@Autowired
	private UserRepository repo;

	@Autowired
	private UserAuthRepository userAuthRepo;

	@Autowired
	AuthenticationUserService userAuthService;

	@RequestMapping("/users/loginform")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginform");
		return mv;
	}

	@RequestMapping("/users/createUser")
	public ModelAndView createAcc() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createAccount");
		return mv;
	}

	@RequestMapping("/users/savefile")
	public ModelAndView View() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uploadForm");
		return mv;
	}

	@RequestMapping("/users/success")
	public ModelAndView uploadSuccess() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}

	@RequestMapping("/users/usersnotfound")
	public ModelAndView UsersNotFound() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userNotFound");
		return mv;
	}

	@RequestMapping(value = "/users/loginform", method = RequestMethod.POST)
	public ModelAndView authenticateUser(@ModelAttribute("userauth") UserAuth userauth,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uploadForm");

		ModelAndView userNotFound = new ModelAndView();
		userNotFound.setViewName("userNotFound");

		UserAuth user1 = userAuthService.GetUserByName(username);
		if (userAuthService.isValidPassword(password, user1.getPassword())) {
			return mv;
		} else {
			return userNotFound;
		}

	}

	@RequestMapping(value = "/users/createUser", method = RequestMethod.POST)
	public RedirectView createUserAccount(@ModelAttribute("userauth") UserAuth userauth, ModelMap model) {
		userAuthRepo.save(userauth);
		return new RedirectView("/users/loginform", true);
	}

	@RequestMapping(value="/users/savefile", method=RequestMethod.POST)
	    public RedirectView handleFormSubmit(User user, @RequestParam("profilePictureFile") MultipartFile multipartFile1,
	    	@RequestParam("photoIdFile") MultipartFile multipartFile2) throws IOException {
	    	
    	String profilePictureFileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
    	String photoIdFileName = StringUtils.cleanPath(multipartFile2.getOriginalFilename());
    	
    	user.setProfilePicture(profilePictureFileName);
    	user.setPhotoId(photoIdFileName);
    	User savedCandidate = repo.save(user);
    	
    	String uploadDir = "users/" + savedCandidate.getId();
    	
    	FileUploadUtil.saveFile(uploadDir, profilePictureFileName, multipartFile1);
    	FileUploadUtil.saveFile(uploadDir, photoIdFileName, multipartFile2);	        
      
    	return new RedirectView("/users/success", true);
	    }

	@PostMapping("/users/showfiles")
	public String showFiles(User user, @RequestParam("profilePictureFile") MultipartFile multipartFile1,
	    	@RequestParam("photoIdFile") MultipartFile multipartFile2) {
		repo.findAll();
		return "showfiles";

	}
}