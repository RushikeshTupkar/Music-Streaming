package com.MCT_Rushi.Music.streaming.service.api.repository;

import com.MCT_Rushi.Music.streaming.service.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface IUsersRepository extends JpaRepository<Users,Integer> {

    @Query(value = "Select * from tbl_users where userName = :userName And status_statusId = 1",countQuery = "SELECT count(*) from tbl_users", nativeQuery = true)
    public List<Users> FindByUserName(String userName);

    @Query(value = "Select * from tbl_users where userName = :userName And password = :password And status_statusId = 1",countQuery = "SELECT count(*) from tbl_users", nativeQuery = true)
    public List<Users> findByUP(String userName, String password);

//    @Modifying
//    @Transactional
//    @Query(value = "Update tbl_users set status_statusId = 2 where userId = :userId", countQuery = "Select count(*) From tbl_users", nativeQuery = true)
//    public void deleteUser(Integer userId);

    @Modifying
    @Transactional
    @Query(value = "Update tbl_users set status_statusId = 2 where userName = :userName And password = :password And status_statusId = 1", countQuery = "Select count(*) From tbl_users", nativeQuery = true)
    public Integer deleteUserByUP(String userName, String password);


}
