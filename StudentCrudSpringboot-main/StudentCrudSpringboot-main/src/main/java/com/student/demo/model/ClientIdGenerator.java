package com.student.demo.model;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ClientIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Student s = (Student) object;
		Calendar calendar = Calendar.getInstance();
		String id = s.getFirstName().substring(0, 3).toUpperCase() + s.getLastName().substring(0, 3).toUpperCase() + s.getMobileNumber()
				+ calendar.get(Calendar.YEAR);
		return id;
	}

}
