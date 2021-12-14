package com.codeimmig.yannick.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeimmig.yannick.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{

}
