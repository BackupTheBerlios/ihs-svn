package com.foo_baz.v_q.ivqPackage;


/**
* com/foo_baz/v_q/ivqPackage/email_banned.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/svn/codes/ihs/trunk/logger.idl
* piątek, 17 marzec 2006 20:56:40 CET
*/


/// banned emails
public final class email_banned implements org.omg.CORBA.portable.IDLEntity
{
  public String re_domain = null;

  //!< POSIX regular exp.
  public String re_login = null;

  public email_banned ()
  {
  } // ctor

  public email_banned (String _re_domain, String _re_login)
  {
    re_domain = _re_domain;
    re_login = _re_login;
  } // ctor

} // class email_banned
