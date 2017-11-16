package com.brajevicm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Blogger Not Found")
public class BloggerNotFoundException extends RuntimeException {
}
