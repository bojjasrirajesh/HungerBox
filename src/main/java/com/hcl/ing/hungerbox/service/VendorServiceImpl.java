package com.hcl.ing.hungerbox.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ing.hungerbox.dto.VendorRequestDto;
import com.hcl.ing.hungerbox.dto.VendorResponseDto;
import com.hcl.ing.hungerbox.entity.Vendors;
import com.hcl.ing.hungerbox.exception.AddVendorException;
import com.hcl.ing.hungerbox.exception.DeleteVendorException;
import com.hcl.ing.hungerbox.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	VendorRepository vendorRepository;
	
	
	VendorResponseDto vendorResponseDto=new VendorResponseDto();
	
	@Override
	public VendorResponseDto getAllVendorsByUserId() {
		
		List<Vendors> vendors = vendorRepository.findAll();
		vendorResponseDto.setMessage("success");
		vendorResponseDto.setStatusCode(HttpStatus.OK.value());
		vendorResponseDto.setVendors(vendors);
		return vendorResponseDto;
	}

	@Override
	public VendorResponseDto addVenders(VendorRequestDto vendorRequestDto) {
		String vendorName = vendorRequestDto.getVendorName();
		if(Objects.isNull(vendorName)) {
			throw new AddVendorException("please provide vendorName");
		}
		Vendors vendor=new Vendors();
		BeanUtils.copyProperties(vendorRequestDto, vendor);
		
		vendorRepository.save(vendor);
		vendorResponseDto.setMessage("success");
		vendorResponseDto.setStatusCode(HttpStatus.CREATED.value());
		return vendorResponseDto;
	}

	@Override
	public VendorResponseDto deleteVendor(Long vendorId) {
		List<Vendors> vendors = vendorRepository.findAll();
		for (Vendors vendors2 : vendors) {
			if(!(vendors2.getVendorId()==vendorId)) {
				throw new DeleteVendorException("please provide the valide vendor id");
			}else {
				vendorRepository.deleteById(vendorId);
				vendorRepository.findAll();
				vendorResponseDto.setMessage("success");
				vendorResponseDto.setStatusCode(HttpStatus.OK.value());
				vendorResponseDto.setVendors(vendorRepository.findAll());
			}
		}
		return vendorResponseDto;
	}

}
