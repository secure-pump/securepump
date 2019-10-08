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

import com.securepump.securepump.bean.PurchaceEntryBean;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.model.PurchaseEntryEntity;
import com.securepump.securepump.model.SupplierCreationEntity;
import com.securepump.securepump.service.ItemCreationService;
import com.securepump.securepump.service.PurchaceEntryService;
import com.securepump.securepump.service.SupplierCreationService;

@Controller
public class PurchaseEntryController {
	
	@Autowired
	ItemCreationService itemService;
	
	/*@Autowired
	@Qualifier("tankservice")
	TankCreationService tankService;*/
	
	@Autowired
	@Qualifier("purchaceservice")
	PurchaceEntryService purchaceEntryService;
	
    @Autowired
	@Qualifier("supplierService")
	SupplierCreationService supplierService;

	@RequestMapping("/purchase-entry")
	public String purchaseCreate(Model model,@RequestParam(name = "status") String status)
	{
		List<PurchaseEntryEntity> purchaceList = purchaceEntryService.getAllItems();
	    /*System.out.println("size-----"+purchaceList.size());
		for(PurchaseEntryEntity pur:purchaceList) {
			System.out.println(pur.getPurchaseChaildEntity().size());
		}*/
	    model.addAttribute("purchaceEntryList", purchaceList);
	   //model.addAttribute("status", status);
		return "purchase-entry";
	}
	@RequestMapping(value = "/savePurchaceEntry", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute PurchaceEntryBean purchaceBean,Model model) {
		System.out.println("account--"+purchaceBean);
		String status="error";
		try {
			if(purchaceBean.getPurchaceid()==null) {
				status="save";
			}else {
				status="update";
			}
			purchaceEntryService.createorUpdateItem(purchaceBean);									
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return "redirect:/purchase-entry?status="+status;
	}
	
	/*@RequestMapping("/purchaceEntryEdit/{id}")
	public ModelAndView showEditItemPage(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
	    ModelAndView mav = new ModelAndView("purchase-entry");
	    PurchaseEntryEntity item = purchaceEntryService.getItemById(id);
	    mav.addObject("purchaceEditData", item);
	    return mav;
	}*/

	@RequestMapping("/purchaceEntryDelete/{id}")
	public String deleteItem(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		purchaceEntryService.deleteItemById(id);
		 return "redirect:/purchase-entry?status=delete";
	}
	
	@ModelAttribute("itemNameList")
	public List<ItemCreationEntity> getAllItemNames() throws RecordNotFoundException {
		List<ItemCreationEntity> allItemNames=itemService.getAllItems();		
		return allItemNames;
	}
	@ModelAttribute("supplierList")
	public List<SupplierCreationEntity> getSupplierNames() throws RecordNotFoundException {
		List<SupplierCreationEntity> allItemNames=supplierService.getAllSuppliers();
		return allItemNames;
	}
	
	
}
