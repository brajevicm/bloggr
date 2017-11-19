package com.brajevicm.service;

import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.BloggerPrincipal;
import com.brajevicm.repository.BloggerRepository;
import com.brajevicm.repository.BloggerRepositoryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Service
public class BloggrUserDetailsService implements UserDetailsService {
  private BloggerRepository bloggerRepository = new BloggerRepositoryImpl();

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Blogger blogger = bloggerRepository.findByUsername(username);
    if (blogger == null) {
      throw new UsernameNotFoundException("No user found with username: " + username);
    }

    return new BloggerPrincipal(blogger);
  }
}
