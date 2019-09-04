package com.securepump.securepump.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.securepump.securepump.bean.TankCreationBean;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.model.TankCreationEntity;
import com.securepump.securepump.service.ItemCreationService;
import com.securepump.securepump.service.TankCreationService;

@Controller
public class TankCreationController {
	
	@Autowired
	ItemCreationService itemService;
	@Autowired
	@Qualifier("tankservice")
	TankCreationService tankService;
	
	@RequestMapping("/tank-creation")
	public String itemCreate(Model model,@RequestParam(name = "status") String status,@ModelAttribute TankCreationBean tankBean) throws RecordNotFoundException {
		List<TankCreationEntity> listAccounts = tankService.getAllItems();
		
		List<TankCreationBean> addTankList=new ArrayList<TankCreationBean>();
		
		/*List<ItemCreationEntity> allItemNames=itemService.getAllItemNature("Fuel");
		Map<Long,String> itemMap=new HashMap<Long,String>();
		for(ItemCreationEntity itemEnt:allItemNames) {
			itemMap.put(itemEnt.getId(), itemEnt.getItemName());
		}*/
		
		for(TankCreationEntity tanklist:listAccounts) {
			System.out.println("---"+tanklist);
			TankCreationBean tank=new TankCreationBean();
			tank.setId(tanklist.getId());
			tank.setTankName(tanklist.getTankName());
			tank.setCapacity(tanklist.getCapacity());
			
			tank.setItemId(tanklist.getItemCreation().getId());
			tank.setItemName(tanklist.getItemCreation().getItemName());
			tank.setOpeningStock(tanklist.getOpeningStock());
			addTankList.add(tank);
			
		}
	    model.addAttribute("listTanks", addTankList);
	   // model.addAttribute("itemNameList",allItemNames);
	    //System.out.println("status--"+status);
	    model.addAttribute("status", status);
		return "tank-creation";
	}
	@RequestMapping(value = "/saveTank", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute TankCreationBean tankBean,Model model) {
		System.out.println("account--"+tankBean);
		String status="error";
		try {
			if(tankBean.getId()==null) {
				status="save";
			}else {
				status="update";
			}
			
			ItemCreationEntity itemCre=new ItemCreationEntity();
			itemCre.setId(tankBean.getItemId());
			//itemCre.setItemName(tankBean.getItemNature());
			
				TankCreationEntity tank=new TankCreationEntity();
				tank.setId(tankBean.getId());
				tank.setTankName(tankBean.getTankName());
				tank.setCapacity(tankBean.getCapacity());				
				tank.setItemCreation(itemCre);
				tank.setOpeningStock(tankBean.getOpeningStock());
				
			
			tankService.createorUpdateItem(tank);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return "redirect:/tank-creation?status="+status;
	}
	@RequestMapping("/tankEdit/{id}")
	public ModelAndView showEditItemPage(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
	    ModelAndView mav = new ModelAndView("tank-creation");
	    TankCreationEntity item = tankService.getItemById(id);
	    mav.addObject("tankEditData", item);
	    return mav;
	}
	@RequestMapping("/tankDelete/{id}")
	public String deleteItem(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		tankService.deleteItemById(id);
		 return "redirect:/tank-creation?status=delete";
	}
	 @ModelAttribute("itemNameList")
	   public List<ItemCreationEntity> getAllItemNames() throws RecordNotFoundException {	      
	      List<ItemCreationEntity> allItemNames=itemService.getAllItemNature("Fuel");	      
	      return allItemNames;
	   }

}
