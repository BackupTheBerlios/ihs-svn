package com.foo_baz.v_q.ivqPackage;

/**
* com/foo_baz/v_q/ivqPackage/user_infoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/new/svn/berlios.de/ihs/trunk/logger.idl
* poniedziałek, 6 marzec 2006 19:31:23 CET
*/

public final class user_infoHolder implements org.omg.CORBA.portable.Streamable
{
  public com.foo_baz.v_q.ivqPackage.user_info value = null;

  public user_infoHolder ()
  {
  }

  public user_infoHolder (com.foo_baz.v_q.ivqPackage.user_info initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.foo_baz.v_q.ivqPackage.user_infoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.foo_baz.v_q.ivqPackage.user_infoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.foo_baz.v_q.ivqPackage.user_infoHelper.type ();
  }

}
