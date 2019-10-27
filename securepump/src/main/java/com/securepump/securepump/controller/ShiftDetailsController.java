package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.securepump.securepump.bean.ShiftDetailsBean;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.BoyCreationEntity;
import com.securepump.securepump.model.ShiftDetailsEntity;
import com.securepump.securepump.model.UnitCreationEntity;
import com.securepump.securepump.service.BoyCreationService;
import com.securepump.securepump.service.ShiftDetailsService;
import com.securepump.securepump.service.UnitCreationService;

@Controller
public class ShiftDetailsController {
	
	@Autowired
	@Qualifier("unitservice")
	UnitCreationService unitService;
	
	@Autowired
	@Qualifier("boyService")
	BoyCreationService boyService;
	
	@Autowired
	@Qualifier("shiftDetails")
	ShiftDetailsService shiftDetails;
	
	
	
	@RequestMapping("/shift-details")
	public String purchaseCreate(Model model,@RequestParam(name = "status") String status)
	{
		List<ShiftDetailsEntity> shiftDetailsList = shiftDetails.getAllShiftDetails();
	    model.addAttribute("shiftDetailsList", shiftDetailsList);
	   //model.addAttribute("status", status);
		return "shift-details";
	}
	@RequestMapping(value = "/saveShiftDetails", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute ShiftDetailsBean shiftDetailsBean,Model model) {
		System.out.println("account--"+shiftDetailsBean);
		String status="error";
		try {
			if(shiftDetailsBean.getShiftDetailsId()==null) {
				status="save";
			}else {
				status="update";
			}
			shiftDetails.createOrUpdateShiftDetails(shiftDetailsBean);									
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return "redirect:/shift-details?status="+status;
	}
	
	

	@RequestMapping("/shiftDetailsDelete/{id}")
	public String deleteShiftDetails(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		shiftDetails.deleteShiftDetailsById(id);
		 return "redirect:/shift-details?status=delete";
	}
	
	 @ModelAttribute("unitNameList")
	 public List<UnitCreationEntity> getAllUnitNames() throws RecordNotFoundException {	      
	      List<UnitCreationEntity> allIUnitNames=unitService.getAllUnits();     
	      return allIUnitNames;
	   }
	 @ModelAttribute("boysNameList")
	 public List<BoyCreationEntity> getAllBoyNames() throws RecordNotFoundException {	      
		 List<BoyCreationEntity> listBoy=boyService.getAllCutomer();    
	      return listBoy;
	   }
	 

}
