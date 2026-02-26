package tech.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import tech.code.model.BookingForm;
import tech.code.model.ContactForm;
import tech.code.model.ServiceForm;
import tech.code.service.BookingFormService;
import tech.code.service.ContactFormService;
import tech.code.service.ContactFormServiceImpl;
import tech.code.service.ServiceFormService;

@Controller
public class MyController {
	
	private ContactFormService contactFormService;
	private BookingFormService bookingFormService;
	
	private ServiceFormService serviceFormService;
	
	@Autowired
	public void setServiceFormService(ServiceFormService serviceFormService) {
		this.serviceFormService = serviceFormService;
	}

	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}

	@GetMapping(path = {"/", "home", "welcome", "index"})
	public String welcomeView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		m.addAttribute("bookingForm", new BookingForm());
		return "index";
	}
	
	@GetMapping("about")
	public String aboutView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		return "about";
	}
	
	@GetMapping("cars")
	public String carsView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		return "cars";
	}
	
	@GetMapping("services")
	public String servicesView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		
		// Data collection from database
		List<ServiceForm> allServices = serviceFormService.readAllServices();
		m.addAttribute("allservices", allServices);
		
		return "services";
	}
	
	@GetMapping("contacts")
	public String contactsView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		m.addAttribute("contactForm", new ContactForm());
		return "contacts";
	}
	
	@PostMapping("contactform")
	public String contactForm(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult,
			Model m, RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult", bindingResult);
			return "contacts";
		}
		
		// Service
	 	ContactForm saveContactFormService = contactFormService.saveContactFormService(contactForm);
	 	if(saveContactFormService != null) {
	 		redirectAttributes.addFlashAttribute("message", "Message sent successfully.");
	 	}else {
	 		redirectAttributes.addFlashAttribute("message", "Something went wrong.");
	 	}
		
		return "redirect:/contacts";
	}
	
	@PostMapping("bookingform")
	public String bookingForm(@Valid @ModelAttribute BookingForm bookingForm, BindingResult bindingResult,
			Model m, RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult", bindingResult);
			return "index";
		}else if(bookingForm.getAdult()+bookingForm.getChildren() > 4) {
			m.addAttribute("message", "Total number of adult amd children cannot exceed 4");
			return "index";
		}
		
		// Service
		BookingForm saveBookingFormService = bookingFormService.savebBookingFormService(bookingForm);
		if(saveBookingFormService != null) {
	 		redirectAttributes.addFlashAttribute("message", "Booking successful.");
	 	}else {
	 		redirectAttributes.addFlashAttribute("message", "Something went wrong.");
	 	}
		
		return "redirect:/index";
	}
	
	
//  calling the login page from securityConfig
	@GetMapping("/login")
	public String adminLoginView(HttpServletRequest request, Model model) {
		
		ServletContext servletContext = request.getServletContext();
		Object attribute = servletContext.getAttribute("logout");
		
		if(attribute instanceof Boolean) {
			model.addAttribute("logout", attribute);
			servletContext.removeAttribute("logout");
		}
		
		return "adminlogin";
	}
	
	
}
