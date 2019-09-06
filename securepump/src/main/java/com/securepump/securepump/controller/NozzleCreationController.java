package com.securepump.securepump.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.securepump.securepump.bean.NozzleCreationBean;
import com.securepump.securepump.bean.TankCreationBean;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.model.NozzleCreationEntity;
import com.securepump.securepump.model.TankCreationEntity;
import com.securepump.securepump.model.UnitCreationEntity;
import com.securepump.securepump.service.NozzleCreationService;
import com.securepump.securepump.service.TankCreationService;
import com.securepump.securepump.service.UnitCreationService;

@Controller
public class NozzleCreationController {

	@Autowired
	@Qualifier("tankservice")
	TankCreationService tankService;
	@Autowired
	@Qualifier("unitservice")
	UnitCreationService unitService;
	@Autowired
	@Qualifier("nozzleservice")
	NozzleCreationService nozzleService;
	
	@RequestMapping("/nozzle-creation")
	public String nozzleCreate(Model model,@RequestParam(name = "status") String status,@ModelAttribute NozzleCreationBean nozzleBean) throws RecordNotFoundException
	{
		List<NozzleCreationEntity> listAccounts = nozzleService.getAllNozzles();
		List<NozzleCreationBean> addNozzleList=new ArrayList<NozzleCreationBean>();
		for(NozzleCreationEntity nozzleList:listAccounts) {
			System.out.println("---"+listAccounts);
			NozzleCreationBean nozzle=new NozzleCreationBean();
			nozzle.setId(nozzleList.getId());
			nozzle.setNozzleName(nozzleList.getNozzleName());
			nozzle.setOpeningMeterDate(nozzleList.getOpeningMeterDate());
			nozzle.setOpeningMeterReading(nozzleList.getOpeningMeterReading());
			nozzle.setTankId(nozzleList.getTankCreation().getId());
			nozzle.setTankName(nozzleList.getTankCreation().getTankName());
			nozzle.setUnitId(nozzleList.getUnitCreation().getId());
			nozzle.setUnitName(nozzleList.getUnitCreation().getUnitName());
			addNozzleList.add(nozzle);
			
			
		}
		model.addAttribute("listNozzle", addNozzleList);
		   // model.addAttribute("itemNameList",allItemNames);
		    //System.out.println("status--"+status);
		model.addAttribute("status", status);
		return "nozzle-creation";
	}
	
	@RequestMapping(value = "/saveNozzle", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute NozzleCreationBean nozzleBean,Model model) {
		System.out.println("account--"+nozzleBean);
		String status="error";
		try {
			if(nozzleBean.getId()==null) {
				status="save";
			}else {
				status="update";
			}
			
			TankCreationEntity tankCre=new TankCreationEntity();
			tankCre.setId(nozzleBean.getTankId());
			//itemCre.setItemName(tankBean.getItemNature());
			UnitCreationEntity unitcre=new UnitCreationEntity();
			unitcre.setId(nozzleBean.getUnitId());
			
				NozzleCreationEntity nozzle=new NozzleCreationEntity();
				nozzle.setId(nozzleBean.getId());
				nozzle.setNozzleName(nozzleBean.getNozzleName());
				nozzle.setOpeningMeterReading(nozzleBean.getOpeningMeterReading());
				nozzle.setOpeningMeterDate(nozzleBean.getOpeningMeterDate());
				nozzle.setUnitCreation(unitcre);
				nozzle.setTankCreation(tankCre);
				
			
				nozzleService.createorUpdateNozzle(nozzle);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return "redirect:/nozzle-creation?status="+status;
	}
	 @ModelAttribute("tankNameList")
	 public List<TankCreationEntity> getAllItemNames() throws RecordNotFoundException {	      
	      List<TankCreationEntity> allItemNames=tankService.getAllItems();     
	      return allItemNames;
	   }
	 @ModelAttribute("unitNameList")
	 public List<UnitCreationEntity> getAllUnitNames() throws RecordNotFoundException {	      
	      List<UnitCreationEntity> allIUnitNames=unitService.getAllUnits();     
	      return allIUnitNames;
	   }
}
