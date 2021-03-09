package com.rupine.inst.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupine.inst.model.Profile;
import com.rupine.inst.repository.ProfileRepository;

@Service
@Transactional
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepo;
	
	public Profile getProfile(Long id){
		Profile p=profileRepo.findInstituteById(id);
		p.setInstitutionName("ABC");
		return p;
	}
}
