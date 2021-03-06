package com.fantasticCode.controller.ManageAccountsControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fantasticCode.entities.Account;
import com.fantasticCode.service.AccountService;


@Controller
public class DeactivateAccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="account/disable/{id}")
	public ModelAndView disable(HttpSession session,@PathVariable(value="id") int id ,HttpServletRequest request) throws Exception{
		if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=1){
			return new ModelAndView("redirect:/logout");
		}
		Account account=accountService.findOne(id);
		if(account!=null) {
			account.setActivestate(0);
			accountService.save(account);
			}
		return new ModelAndView("redirect:/account/list");	
	}
	
	
}