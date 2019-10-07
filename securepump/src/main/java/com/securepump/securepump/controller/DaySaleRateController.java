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

import com.securepump.securepump.bean.DailySaleRateBean;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.DailySaleRateEntity;
import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.model.TankCreationEntity;
import com.securepump.securepump.service.DailySaleRateService;
import com.securepump.securepump.service.ItemCreationService;
import com.securepump.securepump.service.TankCreationService;

@Controller

public class DaySaleRateController {
	@Autowired
	ItemCreationService itemService;
	@Autowired
	@Qualifier("dailyRateService")
	DailySaleRateService dailyRateService;
	@RequestMapping("/day-sale-price")
	public String daySaleRate(Model model,@RequestParam(name = "status") String status) throws RecordNotFoundException  {
		List<DailySaleRateEntity> listRates=dailyRateService.getAllRates();
		model.addAttribute("listRates",listRates);
		model.addAttribute("status", status);
		return "day-sale-price";
	}
	@RequestMapping(value = "/saveDailyPrice", method = RequestMethod.POST)
	public String saveDailyRate(@ModelAttribute DailySaleRateBean rateBean,Model model) {
		System.out.println("account--"+rateBean);
		String status="error";
		try {
			if(rateBean.getId()==null) {
				status="save";
			}else {
				status="update";
			}
			
			ItemCreationEntity itemCre=new ItemCreationEntity();
			itemCre.setId(rateBean.getItemId());
			DailySaleRateEntity dailyRate= new DailySaleRateEntity();
			dailyRate.setDailySaleRate(rateBean.getDailySaleRate());
			dailyRate.setDate(rateBean.getDate());
			dailyRate.setItemCreation(itemCre);
			dailyRateService.createorUpdateRate(dailyRate);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/day-sale-price?status="+status;
	}
	@RequestMapping("/dailyRateDelete/{id}")
	public String deleteItem(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		dailyRateService.deleteRateById(id);
		 return "redirect:/day-sale-price?status=delete";
	}
	 @ModelAttribute("itemNameList")
	 public List<ItemCreationEntity> getAllItemNames() throws RecordNotFoundException {	      
	      List<ItemCreationEntity> allItemNames=itemService.getAllItemNature("Fuel");	      
	      return allItemNames;
	   }
}
