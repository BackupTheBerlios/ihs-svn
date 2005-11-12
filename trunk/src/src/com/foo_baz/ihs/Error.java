package com.foo_baz.ihs;

public class Error
{
  public java.lang.String what;

  public com.foo_baz.ihs.ErrorCode errorCode;
  
  public Error()
  {
  }

  public Error( ErrorCode errCode, String w ) {
    this.errorCode = new ErrorCode(errCode.value);
    this.what = w;
  }
  
  public Error( java.lang.Integer errCode, String w ) {
    this( errCode.intValue(), w );
  }
  
  public Error( int errCode, String w ) {
    this.errorCode = new ErrorCode( errCode );
    this.what = w;
  }
}

