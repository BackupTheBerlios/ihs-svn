package com.foo_baz.v_q;


/**
* com/foo_baz/v_q/ivqPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /export/home/new/svn/berlios.de/ihs/trunk/vq.idl
* sobota, 24 grudzie� 2005 13:57:44 CET
*/


/*@}*/
public abstract class ivqPOA extends org.omg.PortableServer.Servant
 implements com.foo_baz.v_q.ivqOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("dom_add", new java.lang.Integer (0));
    _methods.put ("dom_rm", new java.lang.Integer (1));
    _methods.put ("dom_val", new java.lang.Integer (2));
    _methods.put ("dom_id", new java.lang.Integer (3));
    _methods.put ("dom_name", new java.lang.Integer (4));
    _methods.put ("dom_ls", new java.lang.Integer (5));
    _methods.put ("da_add", new java.lang.Integer (6));
    _methods.put ("da_rm", new java.lang.Integer (7));
    _methods.put ("da_ls_by_dom", new java.lang.Integer (8));
    _methods.put ("dip_add", new java.lang.Integer (9));
    _methods.put ("dip_rm", new java.lang.Integer (10));
    _methods.put ("dip_ls_by_dom", new java.lang.Integer (11));
    _methods.put ("user_add", new java.lang.Integer (12));
    _methods.put ("user_rep", new java.lang.Integer (13));
    _methods.put ("user_rm", new java.lang.Integer (14));
    _methods.put ("user_pass", new java.lang.Integer (15));
    _methods.put ("user_val", new java.lang.Integer (16));
    _methods.put ("user_get", new java.lang.Integer (17));
    _methods.put ("user_ex", new java.lang.Integer (18));
    _methods.put ("user_ls_by_dom", new java.lang.Integer (19));
    _methods.put ("user_cnt_by_dom", new java.lang.Integer (20));
    _methods.put ("eb_add", new java.lang.Integer (21));
    _methods.put ("eb_rm", new java.lang.Integer (22));
    _methods.put ("eb_ls", new java.lang.Integer (23));
    _methods.put ("user_conf_add", new java.lang.Integer (24));
    _methods.put ("user_conf_rm_by_type", new java.lang.Integer (25));
    _methods.put ("user_conf_rm", new java.lang.Integer (26));
    _methods.put ("user_conf_ls", new java.lang.Integer (27));
    _methods.put ("user_conf_ls_by_type", new java.lang.Integer (28));
    _methods.put ("user_conf_rep", new java.lang.Integer (29));
    _methods.put ("user_conf_get", new java.lang.Integer (30));
    _methods.put ("user_conf_type_has", new java.lang.Integer (31));
    _methods.put ("user_conf_type_cnt", new java.lang.Integer (32));
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

  /// Add domain
       case 0:  // vq/ivq/dom_add
       {
         try {
           String dom = in.read_string ();
           org.omg.CORBA.IntHolder dom_id = new org.omg.CORBA.IntHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dom_add (dom, dom_id);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.id_typeHelper.write (out, dom_id.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Removes domain
       case 1:  // vq/ivq/dom_rm
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dom_rm (dom_id);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Validates domain name
       case 2:  // vq/ivq/dom_val
       {
         try {
           String dom = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dom_val (dom);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Gets ID of domain
       case 3:  // vq/ivq/dom_id
       {
         try {
           String dom = in.read_string ();
           org.omg.CORBA.IntHolder dom_id = new org.omg.CORBA.IntHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dom_id (dom, dom_id);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.id_typeHelper.write (out, dom_id.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Gets name of a domain
       case 4:  // vq/ivq/dom_name
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           org.omg.CORBA.StringHolder dom_name = new org.omg.CORBA.StringHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dom_name (dom_id, dom_name);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           out.write_string (dom_name.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// List all domains
       case 5:  // vq/ivq/dom_ls
       {
         try {
           com.foo_baz.v_q.ivqPackage.domain_info_listHolder dis = new com.foo_baz.v_q.ivqPackage.domain_info_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dom_ls (dis);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.domain_info_listHelper.write (out, dis.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// add alias for a domain
       case 6:  // vq/ivq/da_add
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String ali = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.da_add (dom_id, ali);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Removes alias
       case 7:  // vq/ivq/da_rm
       {
         try {
           String ali = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.da_rm (ali);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Lists all aliases for a domain
       case 8:  // vq/ivq/da_ls_by_dom
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           com.foo_baz.v_q.ivqPackage.string_listHolder alis = new com.foo_baz.v_q.ivqPackage.string_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.da_ls_by_dom (dom_id, alis);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.string_listHelper.write (out, alis.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// add IP address for a domain
       case 9:  // vq/ivq/dip_add
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String ip = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dip_add (dom_id, ip);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Removes IP address
       case 10:  // vq/ivq/dip_rm
       {
         try {
           String ip = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dip_rm (ip);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Lists all IP addresses for a domain
       case 11:  // vq/ivq/dip_ls_by_dom
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           com.foo_baz.v_q.ivqPackage.string_listHolder ips = new com.foo_baz.v_q.ivqPackage.string_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.dip_ls_by_dom (dom_id, ips);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.string_listHelper.write (out, ips.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Adds user
       case 12:  // vq/ivq/user_add
       {
         try {
           com.foo_baz.v_q.ivqPackage.user_info ai = com.foo_baz.v_q.ivqPackage.user_infoHelper.read (in);
           boolean is_banned = in.read_boolean ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_add (ai, is_banned);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Modify user
       case 13:  // vq/ivq/user_rep
       {
         try {
           com.foo_baz.v_q.ivqPackage.user_info ui = com.foo_baz.v_q.ivqPackage.user_infoHelper.read (in);
           boolean password = in.read_boolean ();
           boolean dir = in.read_boolean ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_rep (ui, password, dir);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Removes user
       case 14:  // vq/ivq/user_rm
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String login = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_rm (dom_id, login);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Changes password
       case 15:  // vq/ivq/user_pass
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String login = in.read_string ();
           String pass = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_pass (dom_id, login, pass);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Checks if user name is valid (not if user exists)
       case 16:  // vq/ivq/user_val
       {
         try {
           String user = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_val (user);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Gets informations about user
       case 17:  // vq/ivq/user_get
       {
         try {
           com.foo_baz.v_q.ivqPackage.user_infoHolder ai = new com.foo_baz.v_q.ivqPackage.user_infoHolder ();
           ai.value = com.foo_baz.v_q.ivqPackage.user_infoHelper.read (in);
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_get (ai);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.user_infoHelper.write (out, ai.value);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// Checks whether user exists
       case 18:  // vq/ivq/user_ex
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String login = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_ex (dom_id, login);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
         } catch (com.foo_baz.v_q.null_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.null_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         }
         break;
       }


  /// get all users in specified domain
       case 19:  // vq/ivq/user_ls_by_dom
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           int start = com.foo_baz.v_q.ivqPackage.size_typeHelper.read (in);
           int cnt = com.foo_baz.v_q.ivqPackage.size_typeHelper.read (in);
           com.foo_baz.v_q.ivqPackage.user_info_listHolder uis = new com.foo_baz.v_q.ivqPackage.user_info_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_ls_by_dom (dom_id, start, cnt, uis);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.user_info_listHelper.write (out, uis.value);
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


  /// get number of users in specified domain
       case 20:  // vq/ivq/user_cnt_by_dom
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           org.omg.CORBA.IntHolder cnt = new org.omg.CORBA.IntHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_cnt_by_dom (dom_id, cnt);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.size_typeHelper.write (out, cnt.value);
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


  //@{
       case 21:  // vq/ivq/eb_add
       {
         try {
           String re_domain = in.read_string ();
           String re_login = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.eb_add (re_domain, re_login);
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

       case 22:  // vq/ivq/eb_rm
       {
         try {
           String re_domain = in.read_string ();
           String re_login = in.read_string ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.eb_rm (re_domain, re_login);
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

       case 23:  // vq/ivq/eb_ls
       {
         try {
           com.foo_baz.v_q.ivqPackage.email_banned_listHolder ebs = new com.foo_baz.v_q.ivqPackage.email_banned_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.eb_ls (ebs);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.email_banned_listHelper.write (out, ebs.value);
         } catch (com.foo_baz.v_q.db_error $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.db_errorHelper.write (out, $ex);
         } catch (com.foo_baz.v_q.except $ex) {
           out = $rh.createExceptionReply ();
           com.foo_baz.v_q.exceptHelper.write (out, $ex);
         }
         break;
       }


  /// Adds mailbox configuration
       case 24:  // vq/ivq/user_conf_add
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String user = in.read_string ();
           String pfix = in.read_string ();
           com.foo_baz.v_q.ivqPackage.user_conf_infoHolder ui = new com.foo_baz.v_q.ivqPackage.user_conf_infoHolder ();
           ui.value = com.foo_baz.v_q.ivqPackage.user_conf_infoHelper.read (in);
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_add (dom_id, user, pfix, ui);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.user_conf_infoHelper.write (out, ui.value);
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


  /// Removes all mailbox configuration entries
       case 25:  // vq/ivq/user_conf_rm_by_type
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String user = in.read_string ();
           String pfix = in.read_string ();
           short ut = com.foo_baz.v_q.ivqPackage.user_conf_typeHelper.read (in);
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_rm_by_type (dom_id, user, pfix, ut);
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


  /// Removes mailbox configuration entry
       case 26:  // vq/ivq/user_conf_rm
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String user = in.read_string ();
           String pfix = in.read_string ();
           int id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_rm (dom_id, user, pfix, id);
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


  /// Lists mailbox configuration
       case 27:  // vq/ivq/user_conf_ls
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String user = in.read_string ();
           String pfix = in.read_string ();
           com.foo_baz.v_q.ivqPackage.user_conf_info_listHolder uis = new com.foo_baz.v_q.ivqPackage.user_conf_info_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_ls (dom_id, user, pfix, uis);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.user_conf_info_listHelper.write (out, uis.value);
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


  /// Lists mailbox configuation of specified type
       case 28:  // vq/ivq/user_conf_ls_by_type
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String user = in.read_string ();
           String pfix = in.read_string ();
           short ut = com.foo_baz.v_q.ivqPackage.user_conf_typeHelper.read (in);
           com.foo_baz.v_q.ivqPackage.user_conf_info_listHolder uis = new com.foo_baz.v_q.ivqPackage.user_conf_info_listHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_ls_by_type (dom_id, user, pfix, ut, uis);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.user_conf_info_listHelper.write (out, uis.value);
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


  /// Changes existing entry
       case 29:  // vq/ivq/user_conf_rep
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String user = in.read_string ();
           String pfix = in.read_string ();
           com.foo_baz.v_q.ivqPackage.user_conf_info ui = com.foo_baz.v_q.ivqPackage.user_conf_infoHelper.read (in);
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_rep (dom_id, user, pfix, ui);
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


  /// Gets existing entry
       case 30:  // vq/ivq/user_conf_get
       {
         try {
           com.foo_baz.v_q.ivqPackage.user_conf_infoHolder ui = new com.foo_baz.v_q.ivqPackage.user_conf_infoHolder ();
           ui.value = com.foo_baz.v_q.ivqPackage.user_conf_infoHelper.read (in);
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_get (ui);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.user_conf_infoHelper.write (out, ui.value);
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


  /// Checks whether mailbox has entry of specified type
       case 31:  // vq/ivq/user_conf_type_has
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String user = in.read_string ();
           String pfix = in.read_string ();
           short ut = com.foo_baz.v_q.ivqPackage.user_conf_typeHelper.read (in);
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_type_has (dom_id, user, pfix, ut);
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


  /// Counts entries of specified type
       case 32:  // vq/ivq/user_conf_type_cnt
       {
         try {
           int dom_id = com.foo_baz.v_q.ivqPackage.id_typeHelper.read (in);
           String user = in.read_string ();
           String pfix = in.read_string ();
           short ut = com.foo_baz.v_q.ivqPackage.user_conf_typeHelper.read (in);
           org.omg.CORBA.IntHolder cnt = new org.omg.CORBA.IntHolder ();
           com.foo_baz.v_q.ivqPackage.error $result = null;
           $result = this.user_conf_type_cnt (dom_id, user, pfix, ut, cnt);
           out = $rh.createReply();
           com.foo_baz.v_q.ivqPackage.errorHelper.write (out, $result);
           com.foo_baz.v_q.ivqPackage.size_typeHelper.write (out, cnt.value);
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
    "IDL:vq/ivq:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ivq _this() 
  {
    return ivqHelper.narrow(
    super._this_object());
  }

  public ivq _this(org.omg.CORBA.ORB orb) 
  {
    return ivqHelper.narrow(
    super._this_object(orb));
  }


} // class ivqPOA
