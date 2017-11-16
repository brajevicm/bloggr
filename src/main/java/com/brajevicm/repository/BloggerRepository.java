package com.brajevicm.repository;

import com.brajevicm.entity.Blogger;

import java.util.List;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
public interface BloggerRepository {
  Blogger save(Blogger blogger);

  List<Blogger> getUsers();


}
