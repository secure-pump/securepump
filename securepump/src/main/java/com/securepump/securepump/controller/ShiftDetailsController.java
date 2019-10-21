package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.BoyCreationEntity;
import com.securepump.securepump.model.NozzleReadingEntity;
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
	
	@RequestMapping("/shift-details")
	public String dayOpen()
	{
		return "shift-details";
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
