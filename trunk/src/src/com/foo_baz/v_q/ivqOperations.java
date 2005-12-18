package com.foo_baz.v_q;


/**
* com/foo_baz/v_q/ivqOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Documents and Settings/pniewiad/Desktop/personal/projects/ihs/trunk/src/vq.idl
* Wednesday, December 14, 2005 10:15:21 PM CET
*/


/*@}*/
public interface ivqOperations 
{

  /// Add domain
  com.foo_baz.v_q.ivqPackage.error dom_add (String dom, org.omg.CORBA.IntHolder dom_id) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Removes domain
  com.foo_baz.v_q.ivqPackage.error dom_rm (int dom_id) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Validates domain name
  com.foo_baz.v_q.ivqPackage.error dom_val (String dom) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Gets ID of domain
  com.foo_baz.v_q.ivqPackage.error dom_id (String dom, org.omg.CORBA.IntHolder dom_id) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Gets name of a domain
  com.foo_baz.v_q.ivqPackage.error dom_name (int dom_id, org.omg.CORBA.StringHolder dom_name) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// List all domains
  com.foo_baz.v_q.ivqPackage.error dom_ls (com.foo_baz.v_q.ivqPackage.domain_info_listHolder dis) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// add alias for a domain
  com.foo_baz.v_q.ivqPackage.error da_add (int dom_id, String ali) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Removes alias
  com.foo_baz.v_q.ivqPackage.error da_rm (String ali) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Lists all aliases for a domain
  com.foo_baz.v_q.ivqPackage.error da_ls_by_dom (int dom_id, com.foo_baz.v_q.ivqPackage.string_listHolder alis) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// add IP address for a domain
  com.foo_baz.v_q.ivqPackage.error dip_add (int dom_id, String ip) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Removes IP address
  com.foo_baz.v_q.ivqPackage.error dip_rm (String ip) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Lists all IP addresses for a domain
  com.foo_baz.v_q.ivqPackage.error dip_ls_by_dom (int dom_id, com.foo_baz.v_q.ivqPackage.string_listHolder ips) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Adds user
  com.foo_baz.v_q.ivqPackage.error user_add (com.foo_baz.v_q.ivqPackage.user_info ai, boolean is_banned) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Removes user
  com.foo_baz.v_q.ivqPackage.error user_rm (int dom_id, String login) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Changes password
  com.foo_baz.v_q.ivqPackage.error user_pass (int dom_id, String login, String pass) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Checks if user name is valid (not if user exists)
  com.foo_baz.v_q.ivqPackage.error user_val (String user) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Gets informations about user
  com.foo_baz.v_q.ivqPackage.error user_get (com.foo_baz.v_q.ivqPackage.user_infoHolder ai) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// Checks whether user exists
  com.foo_baz.v_q.ivqPackage.error user_ex (int dom_id, String login) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.except, com.foo_baz.v_q.db_error;

  /// get all users in specified domain
  com.foo_baz.v_q.ivqPackage.error user_ls_by_dom (int dom_id, int start, int cnt, com.foo_baz.v_q.ivqPackage.user_info_listHolder uis) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// get number of users in specified domain
  com.foo_baz.v_q.ivqPackage.error user_cnt_by_dom (int dom_id, org.omg.CORBA.IntHolder cnt) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  //@{
  com.foo_baz.v_q.ivqPackage.error eb_add (String re_domain, String re_login) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;
  com.foo_baz.v_q.ivqPackage.error eb_rm (String re_domain, String re_login) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;
  com.foo_baz.v_q.ivqPackage.error eb_ls (com.foo_baz.v_q.ivqPackage.email_banned_listHolder ebs) throws com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Adds mailbox configuration
  com.foo_baz.v_q.ivqPackage.error user_conf_add (int dom_id, String user, String pfix, com.foo_baz.v_q.ivqPackage.user_conf_infoHolder ui) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Removes all mailbox configuration entries
  com.foo_baz.v_q.ivqPackage.error user_conf_rm_by_type (int dom_id, String user, String pfix, short ut) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Removes mailbox configuration entry
  com.foo_baz.v_q.ivqPackage.error user_conf_rm (int dom_id, String user, String pfix, int id) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Lists mailbox configuration
  com.foo_baz.v_q.ivqPackage.error user_conf_ls (int dom_id, String user, String pfix, com.foo_baz.v_q.ivqPackage.user_conf_info_listHolder uis) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Lists mailbox configuation of specified type
  com.foo_baz.v_q.ivqPackage.error user_conf_ls_by_type (int dom_id, String user, String pfix, short ut, com.foo_baz.v_q.ivqPackage.user_conf_info_listHolder uis) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Changes existing entry
  com.foo_baz.v_q.ivqPackage.error user_conf_rep (int dom_id, String user, String pfix, com.foo_baz.v_q.ivqPackage.user_conf_info ui) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Gets existing entry
  com.foo_baz.v_q.ivqPackage.error user_conf_get (com.foo_baz.v_q.ivqPackage.user_conf_infoHolder ui) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Checks whether mailbox has entry of specified type
  com.foo_baz.v_q.ivqPackage.error user_conf_type_has (int dom_id, String user, String pfix, short ut) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;

  /// Counts entries of specified type
  com.foo_baz.v_q.ivqPackage.error user_conf_type_cnt (int dom_id, String user, String pfix, short ut, org.omg.CORBA.IntHolder cnt) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except;
} // interface ivqOperations
