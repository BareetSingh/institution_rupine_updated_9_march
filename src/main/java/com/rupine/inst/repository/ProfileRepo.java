package com.rupine.inst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rupine.inst.model.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
	
}
