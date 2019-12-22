package com.securepump.securepump.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securepump.securepump.bean.DailySaleRateBean;
import com.securepump.securepump.bean.PurchaceEntryRestVO;
import com.securepump.securepump.bean.PurchaseChaildRestVo;
import com.securepump.securepump.bean.ShiftDetailsChaildRestVO;
import com.securepump.securepump.bean.ShiftDetailsRestVO;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.PurchaseChaildEntity;
import com.securepump.securepump.model.PurchaseEntryEntity;
import com.securepump.securepump.model.ShiftDetailsChaildEntity;
import com.securepump.securepump.model.ShiftDetailsEntity;
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
	@RequestMapping("nozzleSalePrice")
	 public Double getSalePricce(@RequestParam("nozzleName") String nozzleName,@RequestParam("shiftDetailsDate") String shiftDetailsDate) throws RecordNotFoundException {	      
		 Double nozzleReading=shiftDetails.getSalePrice(nozzleName, shiftDetailsDate);    
	      return nozzleReading;
	   }
	@RequestMapping("shiftDatePriceDetails")
	 public DailySaleRateBean getshiftDatePriceDetails(@RequestParam("shiftDetailsDate") String shiftDetailsDate) throws RecordNotFoundException {	      
	      return shiftDetails.getshiftDatePriceDetails(shiftDetailsDate);
	   }

	@RequestMapping("/shiftDetailsEdit")
    public ShiftDetailsRestVO shiftDetailsEdit(@RequestParam("shiftDetailsId") Long shiftDetailsId) throws RecordNotFoundException {
        
        System.out.println("working--"+shiftDetailsId);
        ShiftDetailsEntity shiftDetailsData = shiftDetails.getShiftDetailsById(shiftDetailsId);
        //System.out.println(shiftDetailsData);
        //PurchaseEntryEntity purchaseEntryData = purchaceEntryService.getItemById();
        ShiftDetailsRestVO restVo=new ShiftDetailsRestVO();
        restVo.setShiftDetailsId(shiftDetailsData.getId());
        restVo.setBoyId(shiftDetailsData.getBoyCreation().getId());
        restVo.setMobileNo(shiftDetailsData.getBoyCreation().getMobileNo());
        restVo.setShiftDetailsDate(shiftDetailsData.getShiftDetailsDate());

        restVo.setShiftStatus(shiftDetailsData.isShiftStatus());
        restVo.setTotalAmount(shiftDetailsData.getTotalAmount());
        
        List<ShiftDetailsChaildEntity> shiftChaildEntity=shiftDetailsData.getShiftDetailsChaildEntity();
       // System.out.println(""+shiftChaildEntity.size());
        List<ShiftDetailsChaildRestVO> chaildListVo=new ArrayList<ShiftDetailsChaildRestVO>();
        for(ShiftDetailsChaildEntity shiftChaildEnt:shiftChaildEntity){
        	ShiftDetailsChaildRestVO shiftChaildVo=new ShiftDetailsChaildRestVO();
        	shiftChaildVo.setShiftChaildId(shiftChaildEnt.getId());
        	shiftChaildVo.setItemNature(shiftChaildEnt.getItemNature());
        	shiftChaildVo.setUnitId(shiftChaildEnt.getUnitCreation().getId());
        	shiftChaildVo.setUnitName(shiftChaildEnt.getUnitCreation().getUnitName());
        	shiftChaildVo.setNozzleName(shiftChaildEnt.getNozzleReadingName().getNozzleName());
        	shiftChaildVo.setNozzleReading(shiftChaildEnt.getNozzleReadingName().getNozzleReading());
        	shiftChaildVo.setStatus(shiftChaildEnt.getNozzleReadingName().getStatus());
        	
        	shiftChaildVo.setOpenReading(shiftChaildEnt.getOpenReading());
        	shiftChaildVo.setCloseReading(shiftChaildEnt.getCloseReading());
        	shiftChaildVo.setTestReading(shiftChaildEnt.getTestReading());
        	shiftChaildVo.setSaleStock(shiftChaildEnt.getSaleStock());
        	shiftChaildVo.setRate(shiftChaildEnt.getRate());
        	shiftChaildVo.setTotalAmt(shiftChaildEnt.getTotalAmt());
        	chaildListVo.add(shiftChaildVo);
        }
        restVo.setShiftDetailsChaildRestVO(chaildListVo);
        System.out.println("----chaildListVo--"+chaildListVo.size());
        return restVo;
    }

}
