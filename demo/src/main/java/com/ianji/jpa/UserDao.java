package com.ianji.jpa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, String> {
    List<User> findUsersByNameAndEmail(String name, String email);
    List<User> findAllByNameContainingAndEmail(String name, String email);
    @Query("select u from User u where u.name like %?1%")
    List<User> getByNameFuzzy(String name);
    @Query(value="select u from User u where u.name like %?1%",
            countQuery = "select count(u) from User u where u.name like %?1%")
    Page<User> getByNameFuzzy(String name, Pageable pageable);

    @Query(value = "select * from tb_user u where u.sys_name like %?1%", nativeQuery = true)
    List<User> getByNameFuzzyOrg(String name);

    @Query(value = "select * from tb_user u where u.sys_name like %?1%",
            countQuery = "select count(1) from tb_user u where u.sys_name like %?1%",
            nativeQuery = true)
    Page<User> queryByUsernameLike(String name, Pageable pageable) ;

}
