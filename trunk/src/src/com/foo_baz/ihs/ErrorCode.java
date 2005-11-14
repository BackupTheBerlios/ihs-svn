package com.foo_baz.ihs;

/**
 * Simple class to store information about error which is not critical.
 * @author Pawe³ Niewiadomski
 */
public class ErrorCode
{
  /**
   * Error code
   */
  public int value;

  /**
   * Following is a list of allowed codes.
   * @{
   */
  /**
   * No error, success.
   */
  public final static int ERR_NO = 0;
  /**
   * Entry not found.
   */
  public final static int ERR_NOENT = 1;
  /**
   * Entry exists, can't be replaced.
   */
  public final static int ERR_EXISTS = 2;
  /**
   * Function returned unexcpected value.
   */
  public final static int ERR_FUNC_RES = 3;
  /**
   * Unknown error in service
   */
  public final static int ERR_SERVICE_UNKNOWN = 4; 
  /**
   * Service has problems with database
   */
  public final static int ERR_SERVICE_DB = 5;
  /**
   * Service has problems with its internal logic
   */
  public final static int ERR_SERVICE_INTERNAL = 6;
  /**
   * Function not implemented
   */
  public final static int ERR_FUNC_NI = 7;
  /**
   * Unknown error, description included 
   */
  public final static int ERR_DESC = 8;
  /**
   * Invalid value
   */
  public final static int ERR_INV = 9;
  /**@}*/

  /**
   * Default if you want to initialize attributes by hand.
   */
  public ErrorCode()
  {
  }

  /**
   * Init with value.
   * @param val Error code, use contants from this class
   */
  public ErrorCode(int val)
  {
    this.value = val;
  }

  /**
   * Init with value. For simplier use.
   * @param val Init with value
   */
  public ErrorCode( java.lang.Integer val ) {
    this.value = val.intValue();
  }
}

