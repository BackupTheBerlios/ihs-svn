package com.foo_baz.v_q;


/**
* com/foo_baz/v_q/ivqHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/svn/codes/ihs/trunk/logger.idl
* piątek, 17 marzec 2006 20:56:39 CET
*/


/*@}*/
abstract public class ivqHelper
{
  private static String  _id = "IDL:vq/ivq:1.0";

  public static void insert (org.omg.CORBA.Any a, com.foo_baz.v_q.ivq that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.foo_baz.v_q.ivq extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (com.foo_baz.v_q.ivqHelper.id (), "ivq");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.foo_baz.v_q.ivq read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ivqStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.foo_baz.v_q.ivq value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static com.foo_baz.v_q.ivq narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.foo_baz.v_q.ivq)
      return (com.foo_baz.v_q.ivq)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.foo_baz.v_q._ivqStub stub = new com.foo_baz.v_q._ivqStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
