package com.nx.kernel.utils;
 
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;
 
public class NxIdGenerator implements IdentifierGenerator ,Configurable{
 
    public int generateCustId() {
        Random random = new Random();
        return random.nextInt(100);
    }

	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
        Date date = new Date();
      
        Calendar calendar = Calendar.getInstance();
        return "Cust_" + this.generateCustId() + "_" + calendar.get(Calendar.YEAR);

	}

	public void configure(Type type, Properties params, Dialect d) throws MappingException {
		// TODO Auto-generated method stub
		
	}
 
}