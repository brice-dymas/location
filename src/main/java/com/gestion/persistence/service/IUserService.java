/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service;

import com.gestion.persistence.IOperations;
import com.gestion.persistence.model.User;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface IUserService extends IOperations<User>
{

    public User findByUsername(String username);

    public User findByUsernameAndPassword(String username, String password);

    public void disableEntity(User entity);
}
