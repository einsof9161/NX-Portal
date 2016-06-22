package com.nx.kernel.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.nx.kernel.model.NxUserProfile;
import com.nx.kernel.service.NxUserProfileService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, NxUserProfile>{

	@Autowired
	NxUserProfileService<NxUserProfile> userProfileService;

	
	public NxUserProfile convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		NxUserProfile profile= userProfileService.findById(id);
		System.out.println("Profile ============ "+profile);
		return profile;
	}
	
	/*
	 * Gets UserProfile by type
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	/*
	public UserProfile convert(Object element) {
		String type = (String)element;
		UserProfile profile= userProfileService.findByType(type);
		System.out.println("Profile ... : "+profile);
		return profile;
	}
	*/

}