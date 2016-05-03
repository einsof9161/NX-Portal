package com.nx.kernel.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * 將映射物件抽象出來
 * Table皆會有相同的屬性
 * 
 * 1.table uid
 * 2.creation date
 * 3.modified date
 * 4.delete flag
 * 5.object class
 * 6.enable
**/
public abstract class NxEntity {
	
}