package com.foo_baz.v_q.ivqPackage;


/**
* com/foo_baz/v_q/ivqPackage/error.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/SuSe/users/svn/codes/ihs/trunk/src/vq.idl
* wtorek, 15 listopad 2005 00:04:08 CET
*/


/// errors
public final class error implements org.omg.CORBA.portable.IDLEntity
{
  public com.foo_baz.v_q.ivqPackage.err_code ec = null;

  //!< code
  public String what = null;

  //!< description
  public String file = null;

  //!< source file
  public int line = (int)0;

  //!< line number
  public boolean auth = false;

  public error ()
  {
  } // ctor

  public error (com.foo_baz.v_q.ivqPackage.err_code _ec, String _what, String _file, int _line, boolean _auth)
  {
    ec = _ec;
    what = _what;
    file = _file;
    line = _line;
    auth = _auth;
  } // ctor

} // class error
