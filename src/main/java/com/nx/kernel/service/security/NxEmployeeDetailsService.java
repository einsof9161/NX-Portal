package com.nx.kernel.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.model.NxUserProfile;
import com.nx.kernel.model.privilege.NxDepartment;
import com.nx.kernel.model.user.NxEmployee;
import com.nx.kernel.model.user.NxUser;
import com.nx.kernel.service.NxEmployeeService;


@Service("nxEmpDetailServices")
public class NxEmployeeDetailsService implements UserDetailsService{

	@Autowired
	private NxEmployeeService<NxEmployee> empServices;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		NxEmployee emp = empServices.findByAccount(userName);
		System.out.println("In NxEmployeeDetailsService NxEmployee : "+emp);
		if(emp==null){
			System.out.println("Employee not found");
			throw new UsernameNotFoundException("Employee not found"); 
		}
		System.out.println("emp.getUsername()"+emp.getUsername());
		System.out.println("emp.getPassword()"+emp.getPassword());
		return new org.springframework.security.core.userdetails.User(emp.getUsername(), emp.getPassword(), 
				 emp.getVisible(), true, true, true, getGrantedAuthorities(emp));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(NxEmployee emp){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		/*
		for(NxDepartment dept : emp.getDepartment()){
			System.out.println("UserProfile : "+userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
		}*/
		System.out.print("authorities :"+authorities);
		return authorities;
	}
	
}
