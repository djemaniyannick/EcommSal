package com.codeimmig.yannick.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimmig.yannick.entity.AppUser;
import com.codeimmig.yannick.repo.AppUserRepository;
import com.codeimmig.yannick.service.IAppUserService;

@Service
public class AppUserServiceImpl implements IAppUserService{
	@Autowired
	AppUserRepository repo;


	@Override
	public Long saveAppUser(AppUser user) {
		return repo.save(user).getId();
	}

	@Override
	public List<AppUser> getAllAppUser() {
		return repo.findAll();
	}

}
