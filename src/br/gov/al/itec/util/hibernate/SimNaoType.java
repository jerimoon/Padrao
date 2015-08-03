package br.gov.al.itec.util.hibernate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
public class SimNaoType implements UserType{

	private static final String NAO = "N";
	private static final String SIM = "S";

	public int[] sqlTypes() {
        return new int[]{Types.CHAR};
    }

    @SuppressWarnings("rawtypes")
	public Class returnedClass() {
        return Boolean.class;
    }
    
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
        return (SIM.equals(rs.getString(names[0])));
    }
	
    public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
    	st.setObject(index, Boolean.TRUE.equals(value) ?  SIM :  NAO);
    }

    /* boilerplate... */
    public boolean isMutable() {
        return false;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == null || y == null) {
            return false;
        } else {
            return x.equals(y);
        }
    }

    public int hashCode(Object x) throws HibernateException {
        assert (x != null);
        return x.hashCode();
    }

    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }




	
}
