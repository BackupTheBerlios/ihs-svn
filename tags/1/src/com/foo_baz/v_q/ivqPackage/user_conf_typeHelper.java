package com.foo_baz.v_q.ivqPackage;


/**
* com/foo_baz/v_q/ivqPackage/user_conf_typeHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /export/home/new/svn/berlios.de/ihs/trunk/vq.idl
* sobota, 24 grudzie� 2005 13:57:44 CET
*/

abstract public class user_conf_typeHelper
{
  private static String  _id = "IDL:vq/ivq/user_conf_type:1.0";

  public static void insert (org.omg.CORBA.Any a, short that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static short extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_ushort);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (com.foo_baz.v_q.ivqPackage.user_conf_typeHelper.id (), "user_conf_type", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static short read (org.omg.CORBA.portable.InputStream istream)
  {
    short value = (short)0;
    value = istream.read_ushort ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, short value)
  {
    ostream.write_ushort (value);
  }

}
