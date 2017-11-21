package com.brajevicm.repository;

import com.brajevicm.entity.Blogger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
public interface BloggerRepository {
  Blogger create(Blogger blogger);

  Blogger findByUsername(String username);
}
