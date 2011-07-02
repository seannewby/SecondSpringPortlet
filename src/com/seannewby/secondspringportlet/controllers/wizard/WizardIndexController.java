package com.seannewby.secondspringportlet.controllers.wizard;

import javax.portlet.ActionResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.seannewby.secondspringportlet.common.beans.User;
import com.seannewby.secondspringportlet.common.service.AddressUtilsService;


@Controller
@RequestMapping("VIEW")
@SessionAttributes("user")
public class WizardIndexController {
	
	private AddressUtilsService addressUtils;
	
	private Validator basicInfoValidator;
	private Validator contactInfoValidator;
	private Validator billingInfoValidator;
	
	@RequestMapping
	public String showWizardPage(Model model){
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());			
		}
		model.addAttribute("page", 0);
		return "wizardBasicInfo";
	}

	@RequestMapping(params="page=0")
	public String showWizardPage0(Model model){
		return showWizardPage(model);
	}
	
	@RequestMapping(params="page=1")
	public String showWizardPage1(Model model){
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());			
		}
		model.addAttribute("states", addressUtils.getStates());
		model.addAttribute("page", 1);
		return "wizardContactInfo";
	}
	
	@RequestMapping(params="page=2")
	public String showWizardPage2(Model model){
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());			
		}
		model.addAttribute("page", 2);
		return "wizardBillingInfo";
	}	
	
	@RequestMapping(params="page=finish")
	public String showWizardPageFinish(Model model){
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());			
		}

		return "wizardFinish";
	}
	
	@RequestMapping(params="page=cancel")
	public String showWizardPageCancel(Model model){
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());			
		}

		return "wizardCancel";
	}
	
	@ActionMapping(params="next")
	public void wizardNext(@ModelAttribute("user")User user, BindingResult result, @RequestParam("currentPage") int currentPage, ActionResponse response ){
		System.out.println("callled next");
		
		switch (currentPage) {
		
			case 0: basicInfoValidator.validate(user, result);	break;
			case 1: contactInfoValidator.validate(user, result); break;

		}

		if(!result.hasErrors()){
			currentPage = currentPage + 1;
		}
	
		response.setRenderParameter("page", Integer.toString(currentPage));
	}
	
	@ActionMapping(params="previous")
	public void wizardPrevious(@ModelAttribute("user")User user, BindingResult result, @RequestParam("currentPage") int currentPage, ActionResponse response ){
		System.out.println("callled previous");
		
		int page = currentPage - 1;
		response.setRenderParameter("page", Integer.toString(page));
	}
	
	@ActionMapping
	public void wizardAction(@ModelAttribute("user")User user, BindingResult result, @RequestParam("currentPage") int currentPage, @RequestParam("requestedPage") String requestedPage, ActionResponse response ){
		int page = currentPage;
		if(StringUtils.equals("Next", requestedPage)){
			page = page + 1;
		}
		if(StringUtils.equals("Previous", requestedPage)){
			page = page - 1;
		}
		
		response.setRenderParameter("page", Integer.toString(page));
		
		System.out.println(currentPage);
	}

	@ActionMapping(params="finish")
	public void wizardFinish(@ModelAttribute("user")User user, BindingResult result, @RequestParam("currentPage") int currentPage, ActionResponse response, SessionStatus status){
		
		System.out.println("SAVING USER: " + user);
		
		billingInfoValidator.validate(user, result);
		
		if(!result.hasErrors()){
			currentPage = currentPage + 1;
			status.setComplete();		
			response.setRenderParameter("page", "finish");			
		}
		else{
			response.setRenderParameter("page", Integer.toString(currentPage));
		}
		
		

		
	}
	
	@ActionMapping(params="cancel")
	public void wizardCancel(@ModelAttribute("user")User user, ActionResponse response, SessionStatus status){
		
		
		status.setComplete();
		
		response.setRenderParameter("page", "cancel");
		
		
	}


	/*
	 * Setters for Spring Injection
	 * 
	 */
	@Autowired
	public void setAddressUtils(AddressUtilsService addressUtils) {
		this.addressUtils = addressUtils;
	}
	@Autowired
	@Qualifier("userBasicInfoValidator")
	public void setBasicInfoValidator(Validator basicInfoValidator) {
		this.basicInfoValidator = basicInfoValidator;
	}
	@Autowired
	@Qualifier("userBillingInfoValidator")
	public void setBillingInfoValidator(Validator billingInfoValidator) {
		this.billingInfoValidator = billingInfoValidator;
	}
	@Autowired
	@Qualifier("userContactInfoValidator")
	public void setContactInfoValidator(Validator contactInfoValidator) {
		this.contactInfoValidator = contactInfoValidator;
	}
	


}
