package in.ineuron.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomGenerator implements IdentifierGenerator {
	
	static {
		System.out.println("RandomGenerator.class file is loading...");
	}
	
	public RandomGenerator() {
		System.out.println("RandomGenerator.class object is created...");
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		System.out.println("RandomGenerator.generate()");
		int idValue=0;
		idValue=new Random().nextInt(1000);
		return idValue;
	}

}
