package com.foo_baz.v_q;

/**
* com/foo_baz/v_q/db_errorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/SuSe/users/svn/codes/ihs/trunk/src/vq.idl
* niedziela, 20 listopad 2005 22:12:56 CET
*/

public final class db_errorHolder implements org.omg.CORBA.portable.Streamable
{
  public com.foo_baz.v_q.db_error value = null;

  public db_errorHolder ()
  {
  }

  public db_errorHolder (com.foo_baz.v_q.db_error initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.foo_baz.v_q.db_errorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.foo_baz.v_q.db_errorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.foo_baz.v_q.db_errorHelper.type ();
  }

}
