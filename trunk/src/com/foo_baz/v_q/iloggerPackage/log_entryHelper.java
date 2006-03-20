package com.foo_baz.v_q.iloggerPackage;


/**
* com/foo_baz/v_q/iloggerPackage/log_entryHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/svn/codes/ihs/trunk/logger.idl
* piątek, 17 marzec 2006 20:56:40 CET
*/


/// information stored in log db
abstract public class log_entryHelper
{
  private static String  _id = "IDL:vq/ilogger/log_entry:1.0";

  public static void insert (org.omg.CORBA.Any a, com.foo_baz.v_q.iloggerPackage.log_entry that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.foo_baz.v_q.iloggerPackage.log_entry extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [8];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id_log",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "time",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_ushort);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (com.foo_baz.v_q.iloggerPackage.service_typeHelper.id (), "service_type", _tcOf_members0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "ser",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "msg",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "login",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "domain",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "ip",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_ushort);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (com.foo_baz.v_q.iloggerPackage.result_typeHelper.id (), "result_type", _tcOf_members0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "res",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (com.foo_baz.v_q.iloggerPackage.log_entryHelper.id (), "log_entry", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.foo_baz.v_q.iloggerPackage.log_entry read (org.omg.CORBA.portable.InputStream istream)
  {
    com.foo_baz.v_q.iloggerPackage.log_entry value = new com.foo_baz.v_q.iloggerPackage.log_entry ();
    value.id_log = istream.read_string ();
    value.time = istream.read_string ();
    value.ser = istream.read_ushort ();
    value.msg = istream.read_string ();
    value.login = istream.read_string ();
    value.domain = istream.read_string ();
    value.ip = istream.read_string ();
    value.res = istream.read_ushort ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.foo_baz.v_q.iloggerPackage.log_entry value)
  {
    ostream.write_string (value.id_log);
    ostream.write_string (value.time);
    ostream.write_ushort (value.ser);
    ostream.write_string (value.msg);
    ostream.write_string (value.login);
    ostream.write_string (value.domain);
    ostream.write_string (value.ip);
    ostream.write_ushort (value.res);
  }

}
