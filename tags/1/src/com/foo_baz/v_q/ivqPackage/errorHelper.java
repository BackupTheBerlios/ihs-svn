package com.foo_baz.v_q.ivqPackage;


/**
* com/foo_baz/v_q/ivqPackage/errorHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /export/home/new/svn/berlios.de/ihs/trunk/vq.idl
* sobota, 24 grudzie� 2005 13:57:44 CET
*/

abstract public class errorHelper
{
  private static String  _id = "IDL:vq/ivq/error/error:1.0";

  public static void insert (org.omg.CORBA.Any a, com.foo_baz.v_q.ivqPackage.error that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.foo_baz.v_q.ivqPackage.error extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [5];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = com.foo_baz.v_q.ivqPackage.err_codeHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "ec",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "what",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "file",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_ulong);
          _members0[3] = new org.omg.CORBA.StructMember (
            "line",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[4] = new org.omg.CORBA.StructMember (
            "auth",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (com.foo_baz.v_q.ivqPackage.errorHelper.id (), "error", _members0);
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

  public static com.foo_baz.v_q.ivqPackage.error read (org.omg.CORBA.portable.InputStream istream)
  {
    com.foo_baz.v_q.ivqPackage.error value = new com.foo_baz.v_q.ivqPackage.error ();
    value.ec = com.foo_baz.v_q.ivqPackage.err_codeHelper.read (istream);
    value.what = istream.read_string ();
    value.file = istream.read_string ();
    value.line = istream.read_ulong ();
    value.auth = istream.read_boolean ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.foo_baz.v_q.ivqPackage.error value)
  {
    com.foo_baz.v_q.ivqPackage.err_codeHelper.write (ostream, value.ec);
    ostream.write_string (value.what);
    ostream.write_string (value.file);
    ostream.write_ulong (value.line);
    ostream.write_boolean (value.auth);
  }

}