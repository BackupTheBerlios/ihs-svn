package com.foo_baz.v_q.ivqPackage;


/**
* com/foo_baz/v_q/ivqPackage/email_banned_listHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/svn/codes/ihs/trunk/logger.idl
* piątek, 17 marzec 2006 20:56:40 CET
*/

public final class email_banned_listHolder implements org.omg.CORBA.portable.Streamable
{
  public com.foo_baz.v_q.ivqPackage.email_banned value[] = null;

  public email_banned_listHolder ()
  {
  }

  public email_banned_listHolder (com.foo_baz.v_q.ivqPackage.email_banned[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.foo_baz.v_q.ivqPackage.email_banned_listHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.foo_baz.v_q.ivqPackage.email_banned_listHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.foo_baz.v_q.ivqPackage.email_banned_listHelper.type ();
  }

}
