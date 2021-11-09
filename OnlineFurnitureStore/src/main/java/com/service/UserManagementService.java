package com.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FurnitureUser;
import com.exception.UserNotFoundException;
import com.repository.UserManagementRepository;

@Service
public class UserManagementService implements IUserManagementService {
	
	@Autowired
	UserManagementRepository umd;
	
	//To Check the login username and password 
	public FurnitureUser loginUser(FurnitureUser user) throws UserNotFoundException  {
		Optional<FurnitureUser> optionalUser=umd.findById(user.getUId());
		if(!optionalUser.isEmpty())
		{
			if(optionalUser.get().getPassword().equals(user.getPassword()))
			{
				return user;
			}
			else
			{
				throw new UserNotFoundException("Wrong Password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}
	

	//To add user to the database 
	public FurnitureUser registerNewUser(FurnitureUser user) throws UserNotFoundException 
	{
		Optional<FurnitureUser> userTemp = umd.findById(user.getUId());
		try 
		{
				if (userTemp != null) {
				user = umd.save(user);
				return user;

			} 
			else 
			{

				throw new UserNotFoundException("The given User already exist");
			}
		} 
		catch (Exception e)
		{
			throw new UserNotFoundException("The given User is  already exist");
		}

	}
	
	//To update User details to the database
	public FurnitureUser updateUser(FurnitureUser user) throws UserNotFoundException
	{
		Optional<FurnitureUser> resultUser = umd.findById(user.getUId());
		try 
		{
			if ((resultUser != null)) 
			{
				FurnitureUser updateUser = umd.save(user);
				return updateUser;

			} 
			else
			{
				throw new UserNotFoundException("The User is already exist");

			}
		}
		catch (Exception e)
		{
			throw new UserNotFoundException("User already exist");
		}

	}
	
	//To delete user from the database 
	public String deleteUser() throws UserNotFoundException
	{
		List<FurnitureUser> resultUser = new ArrayList<FurnitureUser>();
		try 
		{
			resultUser = umd.findAll();
			if (resultUser != null)
			{
				umd.deleteAll();
				return "Deleted successfully";
			}
			else
			{
				throw new UserNotFoundException("There is no values in user table");
			}

		} 
		catch (Exception e)
		{
			throw new UserNotFoundException("There is no values in the user table");
		}
	}
	
	//To delete user by Id from the database 
	public FurnitureUser deleteUserById(int uid) throws UserNotFoundException
	{
		Optional<FurnitureUser> del = umd.findById(uid);
		if (del == null) 
		{
			throw new UserNotFoundException("No user found");
		}

		else 
		{
			umd.deleteById(uid);
			if (del.isPresent()) 
			{
				return del.get();
			} 
			else 
			{
				throw new UserNotFoundException("Not Present");
			}

		}
	}

	//To fetch User details from the database 
	public FurnitureUser getId(int uid) throws UserNotFoundException 
	{
		Optional<FurnitureUser> getUser = umd.findById(uid);
		if (getUser == null)
		{
			throw new UserNotFoundException("User not found");
		} 
		else 
		{
			FurnitureUser getUserId = umd.findById(uid).orElse(null);
			return getUserId;
		}
	}

	
}
