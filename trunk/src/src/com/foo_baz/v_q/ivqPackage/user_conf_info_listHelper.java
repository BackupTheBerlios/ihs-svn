package com.foo_baz.v_q.ivqPackage;


/**
* com/foo_baz/v_q/ivqPackage/user_conf_info_listHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/SuSe/ihs/vq.idl
* niedziela, 30 październik 2005 11:30:52 CET
*/

abstract public class user_conf_info_listHelper
{
  private static String  _id = "IDL:vq/ivq/user_conf_info_list:1.0";

  public static void insert (org.omg.CORBA.Any a, com.foo_baz.v_q.ivqPackage.user_conf_info[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.foo_baz.v_q.ivqPackage.user_conf_info[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = com.foo_baz.v_q.ivqPackage.user_conf_infoHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (com.foo_baz.v_q.ivqPackage.user_conf_info_listHelper.id (), "user_conf_info_list", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.foo_baz.v_q.ivqPackage.user_conf_info[] read (org.omg.CORBA.portable.InputStream istream)
  {
    com.foo_baz.v_q.ivqPackage.user_conf_info value[] = null;
    int _len0 = istream.read_long ();
    value = new com.foo_baz.v_q.ivqPackage.user_conf_info[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = com.foo_baz.v_q.ivqPackage.user_conf_infoHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.foo_baz.v_q.ivqPackage.user_conf_info[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      com.foo_baz.v_q.ivqPackage.user_conf_infoHelper.write (ostream, value[_i0]);
  }

}
