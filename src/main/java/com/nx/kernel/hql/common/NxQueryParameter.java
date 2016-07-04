/**
 * 
 */
package com.nx.kernel.hql.common;

import java.util.HashMap;

/**
 * @author edward
 *
 */
public class NxQueryParameter extends HashMap{


	public NxQueryParameter(Object... values) {
		if (values != null){
			for (int i=0; i<values.length; i++){
				int index = i;
				put(index, values[i]);
			}
		}
	}
	
	
}
