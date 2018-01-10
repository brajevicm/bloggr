package com.brajevicm.repository;

import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.Role;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
public interface BloggerRepository {
  Blogger create(Blogger blogger, Role role);

  Blogger findByUsername(String username);
}
