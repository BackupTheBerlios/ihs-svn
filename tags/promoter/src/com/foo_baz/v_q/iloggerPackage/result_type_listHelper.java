package com.foo_baz.v_q.iloggerPackage;


/**
* com/foo_baz/v_q/iloggerPackage/result_type_listHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/svn/codes/ihs/trunk/logger.idl
* piątek, 17 marzec 2006 20:56:40 CET
*/

abstract public class result_type_listHelper
{
  private static String  _id = "IDL:vq/ilogger/result_type_list:1.0";

  public static void insert (org.omg.CORBA.Any a, short[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static short[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_ushort);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (com.foo_baz.v_q.iloggerPackage.result_typeHelper.id (), "result_type", __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (com.foo_baz.v_q.iloggerPackage.result_type_listHelper.id (), "result_type_list", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static short[] read (org.omg.CORBA.portable.InputStream istream)
  {
    short value[] = null;
    int _len0 = istream.read_long ();
    value = new short[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = com.foo_baz.v_q.iloggerPackage.result_typeHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, short[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      com.foo_baz.v_q.iloggerPackage.result_typeHelper.write (ostream, value[_i0]);
  }

}
