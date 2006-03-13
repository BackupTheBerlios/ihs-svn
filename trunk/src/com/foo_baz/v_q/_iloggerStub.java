package com.foo_baz.v_q;


/**
* com/foo_baz/v_q/_iloggerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/new/svn/berlios.de/ihs/trunk/logger.idl
* poniedziałek, 6 marzec 2006 19:31:24 CET
*/


/**
	 * Base class for subsystem responsible of storing informations about
	 * users' loggins.
	 */
public class _iloggerStub extends org.omg.CORBA.portable.ObjectImpl implements com.foo_baz.v_q.ilogger
{


  /// Clears all settings
  public void clear () throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("clear", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                clear (        );
            } finally {
                _releaseReply ($in);
            }
  } // clear


  /// sets client address
  public void ip_set (String ip) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ip_set", true);
                $out.write_string (ip);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                ip_set (ip        );
            } finally {
                _releaseReply ($in);
            }
  } // ip_set


  /// set service type
  public void service_set (short ser) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("service_set", true);
                com.foo_baz.v_q.iloggerPackage.service_typeHelper.write ($out, ser);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                service_set (ser        );
            } finally {
                _releaseReply ($in);
            }
  } // service_set


  /// set domain
  public void domain_set (String dom) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("domain_set", true);
                $out.write_string (dom);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                domain_set (dom        );
            } finally {
                _releaseReply ($in);
            }
  } // domain_set


  /// set user
  public void login_set (String log) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("login_set", true);
                $out.write_string (log);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                login_set (log        );
            } finally {
                _releaseReply ($in);
            }
  } // login_set


  /// Write information
  public com.foo_baz.v_q.ivqPackage.error write (short r, String msg) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("write", true);
                com.foo_baz.v_q.iloggerPackage.result_typeHelper.write ($out, r);
                $out.write_string (msg);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return write (r, msg        );
            } finally {
                _releaseReply ($in);
            }
  } // write


  /**
  			 * Read all entries from global log (log table)
  			 * \param start 0 means first entry
  			 * \param cnt number of rows that should be read (can be less returned)
  			 */
  public com.foo_baz.v_q.ivqPackage.error read (int start, int cnt, com.foo_baz.v_q.iloggerPackage.log_entry_listHolder les) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("read", true);
                com.foo_baz.v_q.iloggerPackage.size_typeHelper.write ($out, start);
                com.foo_baz.v_q.iloggerPackage.size_typeHelper.write ($out, cnt);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                les.value = com.foo_baz.v_q.iloggerPackage.log_entry_listHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return read (start, cnt, les        );
            } finally {
                _releaseReply ($in);
            }
  } // read


  /**
  			 * Count all entries from global log table
  			 */
  public com.foo_baz.v_q.ivqPackage.error count (org.omg.CORBA.IntHolder cnt) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("count", true);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                cnt.value = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return count (cnt        );
            } finally {
                _releaseReply ($in);
            }
  } // count


  /**
  			 * Read all entries for domain. In this case res[i].domain will be
  			 * empty.
  			 */
  public com.foo_baz.v_q.ivqPackage.error read_by_dom (int start, int cnt, com.foo_baz.v_q.iloggerPackage.log_entry_listHolder les) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("read_by_dom", true);
                com.foo_baz.v_q.iloggerPackage.size_typeHelper.write ($out, start);
                com.foo_baz.v_q.iloggerPackage.size_typeHelper.write ($out, cnt);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                les.value = com.foo_baz.v_q.iloggerPackage.log_entry_listHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return read_by_dom (start, cnt, les        );
            } finally {
                _releaseReply ($in);
            }
  } // read_by_dom


  /**
  			 * Count all entries for domain.
  			 */
  public com.foo_baz.v_q.ivqPackage.error count_by_dom (org.omg.CORBA.IntHolder cnt) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("count_by_dom", true);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                cnt.value = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return count_by_dom (cnt        );
            } finally {
                _releaseReply ($in);
            }
  } // count_by_dom


  /**
  			 * Read all entries for login@domain. In this case res[i].domain
  			 * and res[i].login will be empty.
  			 */
  public com.foo_baz.v_q.ivqPackage.error read_by_user (int start, int cnt, com.foo_baz.v_q.iloggerPackage.log_entry_listHolder les) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("read_by_user", true);
                com.foo_baz.v_q.iloggerPackage.size_typeHelper.write ($out, start);
                com.foo_baz.v_q.iloggerPackage.size_typeHelper.write ($out, cnt);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                les.value = com.foo_baz.v_q.iloggerPackage.log_entry_listHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return read_by_user (start, cnt, les        );
            } finally {
                _releaseReply ($in);
            }
  } // read_by_user


  /**
  			 * Count all entries for login@domain
  			 */
  public com.foo_baz.v_q.ivqPackage.error count_by_user (org.omg.CORBA.IntHolder cnt) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("count_by_user", true);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                cnt.value = com.foo_baz.v_q.iloggerPackage.size_typeHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return count_by_user (cnt        );
            } finally {
                _releaseReply ($in);
            }
  } // count_by_user


  /**
  			 * Execute sql query and return results.
  			 */
  public com.foo_baz.v_q.ivqPackage.error read_by_sql (String sql, int start, int cnt, com.foo_baz.v_q.iloggerPackage.string_list2Holder tuples) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("read_by_sql", true);
                $out.write_string (sql);
                com.foo_baz.v_q.iloggerPackage.size_typeHelper.write ($out, start);
                com.foo_baz.v_q.iloggerPackage.size_typeHelper.write ($out, cnt);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                tuples.value = com.foo_baz.v_q.iloggerPackage.string_list2Helper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return read_by_sql (sql, start, cnt, tuples        );
            } finally {
                _releaseReply ($in);
            }
  } // read_by_sql


  /**
  			 * Removes all entries from log table.
  			 */
  public com.foo_baz.v_q.ivqPackage.error rm_all () throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("rm_all", true);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rm_all (        );
            } finally {
                _releaseReply ($in);
            }
  } // rm_all


  /**
  			 * Removes all entries for a domain.
  			 */
  public com.foo_baz.v_q.ivqPackage.error rm_by_dom () throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("rm_by_dom", true);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rm_by_dom (        );
            } finally {
                _releaseReply ($in);
            }
  } // rm_by_dom


  /**
  			 * Removes all entries for a user.
  			 */
  public com.foo_baz.v_q.ivqPackage.error rm_by_user () throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("rm_by_user", true);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rm_by_user (        );
            } finally {
                _releaseReply ($in);
            }
  } // rm_by_user


  /**
  			 * Removes all entries matching given where clause
  			 */
  public com.foo_baz.v_q.ivqPackage.error rm_by_sql (String where) throws com.foo_baz.v_q.null_error, com.foo_baz.v_q.db_error, com.foo_baz.v_q.except
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("rm_by_sql", true);
                $out.write_string (where);
                $in = _invoke ($out);
                com.foo_baz.v_q.ivqPackage.error $result = com.foo_baz.v_q.iloggerPackage.errorHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:vq/null_error:1.0"))
                    throw com.foo_baz.v_q.null_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/db_error:1.0"))
                    throw com.foo_baz.v_q.db_errorHelper.read ($in);
                else if (_id.equals ("IDL:vq/except:1.0"))
                    throw com.foo_baz.v_q.exceptHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rm_by_sql (where        );
            } finally {
                _releaseReply ($in);
            }
  } // rm_by_sql

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:vq/ilogger:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _iloggerStub
