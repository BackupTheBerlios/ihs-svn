package com.foo_baz.v_q;


/**
* com/foo_baz/v_q/null_error.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/new/svn/berlios.de/ihs/trunk/logger.idl
* poniedziałek, 6 marzec 2006 19:31:22 CET
*/

public final class null_error extends org.omg.CORBA.UserException
{
  public String file = null;
  public int line = (int)0;

  public null_error ()
  {
    super(null_errorHelper.id());
  } // ctor

  public null_error (String _file, int _line)
  {
    super(null_errorHelper.id());
    file = _file;
    line = _line;
  } // ctor


  public null_error (String $reason, String _file, int _line)
  {
    super(null_errorHelper.id() + "  " + $reason);
    file = _file;
    line = _line;
  } // ctor

} // class null_error
