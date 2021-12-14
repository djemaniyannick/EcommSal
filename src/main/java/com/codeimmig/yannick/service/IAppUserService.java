package com.codeimmig.yannick.service;

import java.util.List;

import com.codeimmig.yannick.entity.AppUser;

public interface IAppUserService {
	Long saveAppUser(AppUser user);
	List<AppUser> getAllAppUser();
}
