package com.securepump.securepump.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securepump.securepump.bean.PurchaceEntryRestVO;
import com.securepump.securepump.bean.PurchaseChaildRestVo;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.PurchaseChaildEntity;
import com.securepump.securepump.model.PurchaseEntryEntity;
import com.securepump.securepump.service.PurchaceEntryService;
import com.securepump.securepump.service.ShiftDetailsService;

@RestController
public class SecurepumpRestControler {
	@Autowired
	@Qualifier("purchaceservice")
	PurchaceEntryService purchaceEntryService;
	
	@Autowired
	@Qualifier("shiftDetails")
	ShiftDetailsService shiftDetails;
	
	@RequestMapping("/purchaceEntryEdit")
    public PurchaceEntryRestVO processAJAXRequest(@RequestParam("purchaceid") Long purchaceid) throws RecordNotFoundException {
        
        System.out.println("working--"+purchaceid);
        PurchaseEntryEntity purchaseEntryData = purchaceEntryService.getItemById(purchaceid);
        PurchaceEntryRestVO restVo=new PurchaceEntryRestVO();
        restVo.setId(purchaseEntryData.getId());
        restVo.setInvoiceDate(purchaseEntryData.getInvoiceDate());
        restVo.setBillMode(purchaseEntryData.getBillMode());
        restVo.setSupplierID(purchaseEntryData.getSupplierCreation().getId());
        restVo.setSupplierName(purchaseEntryData.getSupplierCreation().getSupplierName());
        restVo.setSupplierInvoiceNum(purchaseEntryData.getSupplierInvoiceNum());
        restVo.setInvoiceDate(purchaseEntryData.getInvoiceDate());
        List<PurchaseChaildEntity> purchaseChaildEntity=purchaseEntryData.getPurchaseChaildEntity();
        List<PurchaseChaildRestVo> chaildListVo=new ArrayList<PurchaseChaildRestVo>();
        for(PurchaseChaildEntity purChaildEnt:purchaseChaildEntity){
        	PurchaseChaildRestVo purChaildVo=new PurchaseChaildRestVo();
        	purChaildVo.setPurchaceChaildId(purChaildEnt.getId());
        	purChaildVo.setItemId(purChaildEnt.getItemCreation().getId());
        	purChaildVo.setItemName(purChaildEnt.getItemCreation().getItemName());
        	purChaildVo.setItemNature(purChaildEnt.getItemCreation().getItemNature());
        	purChaildVo.setQuantity(purChaildEnt.getQuantity());
        	purChaildVo.setRate(purChaildEnt.getRate());
        	purChaildVo.setAmount(purChaildEnt.getAmount());
        	purChaildVo.setCgst(purChaildEnt.getCgst());
        	purChaildVo.setIgst(purChaildEnt.getIgst());
        	purChaildVo.setSgst(purChaildEnt.getSgst());
        	purChaildVo.setNetAmt(purChaildEnt.getNetAmt());
        	chaildListVo.add(purChaildVo);
        }
        restVo.setPurchaseChaildRestVo(chaildListVo);
        System.out.println("----chaildListVo--"+chaildListVo.size());
        return restVo;
    }
	@RequestMapping("/unitNozzleList")
	 public List<String> getAllshiftDetails(@RequestParam("unitId") Long unitId) throws RecordNotFoundException {	      
		 List<String> listBoy=shiftDetails.findByNozzleName(unitId);    
	      return listBoy;
	   }
	@RequestMapping("nozzleOpenReading")
	 public int getNozzleOpenReading(@RequestParam("nozzleName") String nozzleName) throws RecordNotFoundException {	      
		 int nozzleReading=shiftDetails.findByNozzleReading(nozzleName);    
	      return nozzleReading;
	   }

}
