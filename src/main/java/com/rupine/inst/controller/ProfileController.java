package com.rupine.inst.controller;

import java.lang.reflect.InvocationTargetException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rupine.inst.model.Profile;
import com.rupine.inst.repository.ProfileRepo;
import com.rupine.inst.repository.ProfileRepository;
import com.rupine.inst.service.ProfileService;
import com.rupine.inst.util.NullAwareBeanUtilsBean;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/profile/{id}")
	public Profile getProfile(@PathVariable("id") Long id){
		
		Profile p=profileService.getProfile(id);
		return p;
	}
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	ProfileRepo profileRepo;
	@GetMapping("/profileV1/{id}")
	public Profile getProfileV1(@PathVariable("id") Long id){
		
		Profile p=profileService.getProfile(id);
		return p;
	}
	
	@PostMapping ("/profile")
	public Profile createProfile(@RequestBody Profile profile){
		return profileRepo.save(profile);
	}

	@Transactional
	@PutMapping ("/profile/{id}")
	public Profile updateProfile(@RequestBody Profile profile,@PathVariable("id") Long id) throws IllegalAccessException, InvocationTargetException{
		Profile profile1= profileRepository.findInstituteById(id);
		
//		profile1.setInstitutionName(profile.getInstitutionName());
//		return profileRepository.updateProfile(profile1);
		
		NullAwareBeanUtilsBean nullAwareBeanUtilsBean = new NullAwareBeanUtilsBean();
		 nullAwareBeanUtilsBean.copyProperties(profile1, profile);
//		return profileRepo.save(profile);
		 return profileRepository.updateProfile(profile1);
	}
	
	

	@DeleteMapping ("/profile/{id}")
	public void deleteProfile(@PathVariable("id") Long id){
		profileRepo.deleteById(id);
	}

}
