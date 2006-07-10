package com.foo_baz.v_q;


/**
* com/foo_baz/v_q/iloggerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from /home/new/svn/codes/ihs/trunk/logger.idl
* piątek, 17 marzec 2006 20:56:40 CET
*/


/**
	 * Base class for subsystem responsible of storing informations about
	 * users' loggins.
	 */
public abstract class iloggerPOA extends org.omg.PortableServer.Servant
 implements com.foo_baz.v_q.iloggerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("clear", new java.lang.Integer (0));
    _methods.put ("ip_set", new java.lang.Integer (1));
    _methods.put ("service_set", new java.lang.Integer (2));
    _methods.put ("domain_set", new java.lang.Integer (3));
    _methods.put ("login_set", new java.lang.Integer (4));
    _methods.put ("write", new java.lang.Integer (5));
    _methods.put ("read", new java.lang.Integer (6));
    _methods.put ("count", new java.lang.Integer (7));
    _methods.put ("read_by_dom", new java.lang.Integer (8));
    _methods.put ("count_by_dom", new java.lang.Integer (9));
    _methods.put ("read_by_user", new java.lang.Integer (10));
    _methods.put ("count_by_user", new java.lang.Integer (11));
    _methods.put ("read_by_sql", new java.lang.Integer (12));
    _methods.put ("rm_all", new java.lang.Integer (13));
    _methods.put ("rm_by_dom", new java.lang.Integer (14));
    _methods.put ("rm_by_user", new java.lang.Integer (15));
    _methods.put ("rm_by_sql", new java.lang.Integer (16));
    _methods.put ("dom_ls", new java.lang.Integer (17));
    _methods.put ("user_ls_by_dom", new java.lang.Integer (18));
    _methods.put ("service_ls", new java.lang.Integer (19));
    _methods.put ("result_ls", new java.lang.Integer (20));
    _methods.put ("ip_ls", new java.lang.Integer (21));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  /// Clears all settings
       case 0:  // vq/ilogger/clear
       {
         try {
           this.clear ();
           out = $rh.createReply();
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /// sets client address
       case 1:  // vq/ilogger/ip_set
       {
         try {
           String ip = in.read_string ();
           this.ip_set (ip);
           out = $rh.createReply();
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /// set service type
       case 2:  // vq/ilogger/service_set
       {
         try {
           short ser = com.foo_baz.v_q.iloggerPackage.service_typeHelper.read (in);
           this.service_set (ser);
           out = $rh.createReply();
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /// set domain
       case 3:  // vq/ilogger/domain_set
       {
         try {
           String dom = in.read_string ();
           this.domain_set (dom);
           out = $rh.createReply();
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /// set user
       case 4:  // vq/ilogger/login_set
       {
         try {
           String log = in.read_string ();
           this.login_set (log);
           out = $rh.createReply();
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /// Write information
       case 5:  // vq/ilogger/write
       {
         try {
           short r = com.foo_baz.v_q.iloggerPackage.result_typeHelper.read (in);
           String msg = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.write (r, msg);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Read all entries from global log (log table)
  			 * \param start 0 means first entry
  			 * \param cnt number of rows that should be read (can be less returned)
  			 */
       case 6:  // vq/ilogger/read
       {
         try {
           int start = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read (in);
           int cnt = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read (in);
           com.foo_baz.v_q.iloggerPackage.log_entry_listHolder les = new com.foo_baz.v_q.iloggerPackage.log_entry_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.read (start, cnt, les);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.log_entry_listHelper.write (out, les.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Count all entries from global log table
  			 */
       case 7:  // vq/ilogger/count
       {
         try {
           org.omg.CORBA.IntHolder cnt = new org.omg.CORBA.IntHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.count (cnt);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.size_typeHelper.write (out, cnt.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Read all entries for domain. In this case res[i].domain will be
  			 * empty.
  			 */
       case 8:  // vq/ilogger/read_by_dom
       {
         try {
           int start = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read (in);
           int cnt = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read (in);
           com.foo_baz.v_q.iloggerPackage.log_entry_listHolder les = new com.foo_baz.v_q.iloggerPackage.log_entry_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.read_by_dom (start, cnt, les);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.log_entry_listHelper.write (out, les.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Count all entries for domain.
  			 */
       case 9:  // vq/ilogger/count_by_dom
       {
         try {
           org.omg.CORBA.IntHolder cnt = new org.omg.CORBA.IntHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.count_by_dom (cnt);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.size_typeHelper.write (out, cnt.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Read all entries for login@domain. In this case res[i].domain
  			 * and res[i].login will be empty.
  			 */
       case 10:  // vq/ilogger/read_by_user
       {
         try {
           int start = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read (in);
           int cnt = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read (in);
           com.foo_baz.v_q.iloggerPackage.log_entry_listHolder les = new com.foo_baz.v_q.iloggerPackage.log_entry_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.read_by_user (start, cnt, les);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.log_entry_listHelper.write (out, les.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Count all entries for login@domain
  			 */
       case 11:  // vq/ilogger/count_by_user
       {
         try {
           org.omg.CORBA.IntHolder cnt = new org.omg.CORBA.IntHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.count_by_user (cnt);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.size_typeHelper.write (out, cnt.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Execute sql query and return results.
  			 */
       case 12:  // vq/ilogger/read_by_sql
       {
         try {
           String sql = in.read_string ();
           int start = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read (in);
           int cnt = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read (in);
           com.foo_baz.v_q.iloggerPackage.string_list2Holder tuples = new com.foo_baz.v_q.iloggerPackage.string_list2Holder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.read_by_sql (sql, start, cnt, tuples);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.string_list2Helper.write (out, tuples.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Removes all entries from log table.
  			 */
       case 13:  // vq/ilogger/rm_all
       {
         try {
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.rm_all ();
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Removes all entries for a domain.
  			 */
       case 14:  // vq/ilogger/rm_by_dom
       {
         try {
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.rm_by_dom ();
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Removes all entries for a user.
  			 */
       case 15:  // vq/ilogger/rm_by_user
       {
         try {
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.rm_by_user ();
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * Removes all entries matching given where clause
  			 */
       case 16:  // vq/ilogger/rm_by_sql
       {
         try {
           String where = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.rm_by_sql (where);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * List of domains have any log entries
  			 */
       case 17:  // vq/ilogger/dom_ls
       {
         try {
           com.foo_baz.v_q.iloggerPackage.string_listHolder doms = new com.foo_baz.v_q.iloggerPackage.string_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dom_ls (doms);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.string_listHelper.write (out, doms.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * List of users in specified domain having any log entries.
  			 */
       case 18:  // vq/ilogger/user_ls_by_dom
       {
         try {
           com.foo_baz.v_q.iloggerPackage.string_listHolder user = new com.foo_baz.v_q.iloggerPackage.string_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_ls_by_dom (user);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.string_listHelper.write (out, user.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * List of all services having any log entries
  			 */
       case 19:  // vq/ilogger/service_ls
       {
         try {
           com.foo_baz.v_q.iloggerPackage.service_type_listHolder stl = new com.foo_baz.v_q.iloggerPackage.service_type_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.service_ls (stl);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.service_type_listHelper.write (out, stl.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * List of all results having any log entries
  			 */
       case 20:  // vq/ilogger/result_ls
       {
         try {
           com.foo_baz.v_q.iloggerPackage.result_type_listHolder rtl = new com.foo_baz.v_q.iloggerPackage.result_type_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.result_ls (rtl);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.result_type_listHelper.write (out, rtl.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /**
  			 * List of ip addresses having any log entries
  			 */
       case 21:  // vq/ilogger/ip_ls
       {
         try {
           com.foo_baz.v_q.iloggerPackage.string_listHolder ips = new com.foo_baz.v_q.iloggerPackage.string_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.ip_ls (ips);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.iloggerPackage.string_listHelper.write (out, ips.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:vq/ilogger:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ilogger _this() 
  {
    return iloggerHelper.narrow(
    super._this_object());
  }

  public ilogger _this(org.omg.CORBA.ORB orb) 
  {
    return iloggerHelper.narrow(
    super._this_object(orb));
  }


} // class iloggerPOA